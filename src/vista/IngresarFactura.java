package vista;

import controlador.ConColores;
import controlador.ConDocumento;
import controlador.ConProducto;
import controlador.ConProveedor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleDocumento;
import modelo.Documento;
import modelo.PaletaColor;
import modelo.Producto;
import modelo.Proveedor;

public class IngresarFactura extends javax.swing.JFrame {
    ConProducto CON_PRODUCTO = new ConProducto();
    ArrayList<String> listaNoSeMuestra = CON_PRODUCTO.listarDescartados();
    

    ArrayList<Producto> productos = CON_PRODUCTO.listarProductos();
    private boolean actualizarListado;
    
    
    String global_dia,global_mes,global_anio;    
    private static final ConColores cColor = new ConColores();  
    JFrame mainWindow;
    int xMouse, yMouse; 
    
    PaletaColor paleta = cColor.paletaActiva();   
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick();
    Color textColor = mouseEnterPanelColor;      
    Color verde = new Color(3, 166, 45);
    Color verdeMouseEnter = new Color(2, 115, 31);
    Color verdeClick = new Color(3, 84, 23);
    Color rojo = new Color(201, 0, 37);
    Color rojoMouseEnter = new Color(240, 36, 15);
    Color rojoClick = new Color(255, 116, 0);


    public IngresarFactura() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Ingresar documento de compra");
        
        
        Background.setBackground(BackgroundColor);
        txt_tituloVentana.setForeground(textColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);
        lbl_mensajeProveedorNoExiste.setVisible(false);
        lbl_razonSocial.setForeground(textColor);
        lbl_rutProveedor.setForeground(textColor);
        PanelProveedor.setBackground(BackgroundColor);
        lbl_guion.setForeground(textColor);
        PanelPaso1.setBackground(PanelColor);
        lbl_1.setForeground(mouseEnterPanelColor);
        PanelIdFactura.setBackground(BackgroundColor);
        PanelPaso2.setBackground(PanelColor);
        lbl_2.setForeground(mouseEnterPanelColor);
        rb_boleta.setBackground(BackgroundColor);
        rb_factura.setBackground(BackgroundColor);
        rb_boleta.setForeground(textColor);
        rb_factura.setForeground(textColor);
        PanelPaso3.setBackground(PanelColor);
        lbl_3.setForeground(textColor);
        PanelProducto.setBackground(BackgroundColor);
        lbl_buscarManual.setForeground(textColor);
        lbl_escanearCodigo.setForeground(textColor);
        btn_anadir1.setBackground(verde);
        btn_restar1.setBackground(rojo);
        btn_eliminar1.setBackground(rojo);
        PanelPaso4.setBackground(PanelColor);
        lbl_4.setForeground(textColor);
        PanelDetalleFinal.setBackground(BackgroundColor);
        lbl_totalFactura.setForeground(textColor);
        lbl_docPorPagar.setForeground(textColor);
        btn_ingresarDocumento.setBackground(verde);
        btn_salir.setBackground(rojo);
        
        
        actualizarProductos();
        
        Date date = Calendar.getInstance().getTime();

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(date);
        String dia = today.split("-")[0];
        String mes = today.split("-")[1];
        String anio = today.split("-")[2];
        
        global_dia = dia;
        global_mes = mes;
        global_anio = anio;   
        
        txt_dia.setText(dia);
        txt_anio.setText(anio);
        asignar_mes(mes);

        rb_factura.setSelected(true);
        
        tbl_detalleVenta.getTableHeader().setReorderingAllowed(false);
        tbl_detalleVenta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //829
        tbl_detalleVenta.getColumnModel().getColumn(0).setPreferredWidth(255);
        tbl_detalleVenta.getColumnModel().getColumn(0).setMinWidth(255);
        tbl_detalleVenta.getColumnModel().getColumn(0).setMaxWidth(255);
        tbl_detalleVenta.getColumnModel().getColumn(1).setPreferredWidth(475);
        tbl_detalleVenta.getColumnModel().getColumn(1).setMinWidth(475);
        tbl_detalleVenta.getColumnModel().getColumn(1).setMaxWidth(475);
        tbl_detalleVenta.getColumnModel().getColumn(2).setPreferredWidth(97);
        tbl_detalleVenta.getColumnModel().getColumn(2).setMinWidth(97);
        tbl_detalleVenta.getColumnModel().getColumn(2).setMaxWidth(97);          
        
        tbl_detalleVenta.setRowHeight(35);
        tbl_detalleVenta.setFont(new Font("Roboto", Font.PLAIN, 20));
        tbl_detalleVenta.setBackground(BackgroundColor);
        tbl_detalleVenta.setForeground(textColor);
        tbl_detalleVenta.setOpaque(true);
        tbl_detalleVenta.setFillsViewportHeight(true);
        
        tbl_detalleVenta.getTableHeader().setOpaque(false);
        tbl_detalleVenta.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tbl_detalleVenta.getTableHeader().setBackground(PanelColor);
        tbl_detalleVenta.getTableHeader().setForeground(Color.WHITE);
        
        tbl_detalleVenta.setSelectionBackground(mouseEnterPanelColor);
        tbl_detalleVenta.setSelectionForeground(Color.WHITE);            
        
        listaNoSeMuestra.add("CODIGOPAN");
        listaNoSeMuestra.add("NN0000");
        
    }

    public void actualizarProductos(){
        String palabraClave = txt_nombreProducto.getText();
        ArrayList<Producto> listadoFinal = new ArrayList<>();
        DefaultListModel dl = new DefaultListModel();
        
        if(productos.isEmpty()){
            productos = CON_PRODUCTO.listarProductos();
        }
        
        productos.stream().filter((p) -> (!listaNoSeMuestra.contains(p.getCodigo_barra()))).forEachOrdered((p) -> {
            listadoFinal.add(p);
        });
        
        productos = listadoFinal;
        
        if(!palabraClave.equals("")){
            
            dl.clear();
            
            productos.forEach((p) -> {
                String nombre = p.getNombre().toLowerCase().replace("á","a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
                if (nombre.contains(palabraClave.toLowerCase())) {
                    dl.addElement(p.getNombre()+" ("+p.getCodigo_barra()+")");
                }
            });
            
            
        }
        else{
            dl.clear();
            
        }
        listaFiltrada.setModel(dl);
    }
    
    private void asignar_mes(String mes){
        switch(mes){
            case "01":
                cb_mes.setSelectedIndex(0);
                break;
            case "02":
                cb_mes.setSelectedIndex(1);
                break;
            case "03":
                cb_mes.setSelectedIndex(2);
                break;
            case "04":
                cb_mes.setSelectedIndex(3);
                break;
            case "05":
                cb_mes.setSelectedIndex(4);
                break;
            case "06":
                cb_mes.setSelectedIndex(5);
                break;
            case "07":
                cb_mes.setSelectedIndex(6);
                break;
            case "08":
                cb_mes.setSelectedIndex(7);
                break;
            case "09":
                cb_mes.setSelectedIndex(8);
                break;
            case "10":
                cb_mes.setSelectedIndex(9);
                break;
            case "11":
                cb_mes.setSelectedIndex(10);
                break;
            case "12":
                cb_mes.setSelectedIndex(11);                
                break;
        }
    }
    
    
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) evt.consume();        
    }
    
    private void maxCharactersTyped(JTextField textField, int maxCharacters, java.awt.event.KeyEvent evt){
        if(textField.getText().replace(".", "").length() == maxCharacters) evt.consume();

    }
    
    private void formatearRut(JTextField textField){
        try{
            String texto = textField.getText().replace(".", "");            
            if(texto.length() >= 2){
                int rutInt = Integer.parseInt(texto);
                String rut = NumberFormat.getNumberInstance(Locale.US).format(rutInt).replace(",", ".");
                textField.setText(rut);       
            }             
        }
        catch(Exception e){
        }
    }
    
    private void validarVerificador(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();        
        if(!(Character.isDigit(enter)) && Character.compare(enter, 'k') != 0 && Character.compare(enter,'K') !=0) evt.consume(); 
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupTipoDoc = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        PanelProveedor = new javax.swing.JPanel();
        txt_rutProveedor = new javax.swing.JTextField();
        lbl_rutProveedor = new javax.swing.JLabel();
        lbl_razonSocial = new javax.swing.JLabel();
        txt_razonSocial = new javax.swing.JTextField();
        lbl_mensajeProveedorNoExiste = new javax.swing.JLabel();
        txt_digitoVerificador = new javax.swing.JTextField();
        lbl_guion = new javax.swing.JLabel();
        PanelPaso1 = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        PanelIdFactura = new javax.swing.JPanel();
        PanelPaso2 = new javax.swing.JPanel();
        lbl_2 = new javax.swing.JLabel();
        lbl_folioDoc = new javax.swing.JLabel();
        lbl_fechaEmision = new javax.swing.JLabel();
        txt_folioDoc = new javax.swing.JTextField();
        lbl_tipoDocumento = new javax.swing.JLabel();
        rb_factura = new javax.swing.JRadioButton();
        rb_boleta = new javax.swing.JRadioButton();
        txt_dia = new javax.swing.JTextField();
        slash1 = new javax.swing.JLabel();
        cb_mes = new javax.swing.JComboBox<>();
        slash2 = new javax.swing.JLabel();
        txt_anio = new javax.swing.JTextField();
        PanelProducto = new javax.swing.JPanel();
        txt_codigoBarra = new javax.swing.JTextField();
        lbl_escanearCodigo = new javax.swing.JLabel();
        lbl_buscarManual = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        txt_nombreProducto = new javax.swing.JTextField();
        scrollPanelDetalleVenta = new javax.swing.JScrollPane();
        tbl_detalleVenta = new javax.swing.JTable();
        PanelPaso3 = new javax.swing.JPanel();
        lbl_3 = new javax.swing.JLabel();
        btn_anadir1 = new javax.swing.JPanel();
        txt_anadir1 = new javax.swing.JLabel();
        btn_restar1 = new javax.swing.JPanel();
        txt_restar1 = new javax.swing.JLabel();
        btn_eliminar1 = new javax.swing.JPanel();
        txt_eliminar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaFiltrada = new javax.swing.JList<>();
        PanelDetalleFinal = new javax.swing.JPanel();
        PanelPaso4 = new javax.swing.JPanel();
        lbl_4 = new javax.swing.JLabel();
        lbl_totalFactura = new javax.swing.JLabel();
        txt_totalFactura = new javax.swing.JTextField();
        lbl_docPorPagar = new javax.swing.JLabel();
        ChkFondo = new javax.swing.JPanel();
        chk_porPagar = new javax.swing.JPanel();
        btn_ingresarDocumento = new javax.swing.JPanel();
        txt_ingresarDocumento = new javax.swing.JLabel();
        btn_salir = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Background.setPreferredSize(new java.awt.Dimension(1840, 970));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MinPanel.setBackground(new java.awt.Color(255, 255, 153));
        MinPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MinPanel.setPreferredSize(new java.awt.Dimension(35, 35));

        txt_minimize.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txt_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_minimize.setText("_");
        txt_minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_minimizeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_minimizeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_minimizeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout MinPanelLayout = new javax.swing.GroupLayout(MinPanel);
        MinPanel.setLayout(MinPanelLayout);
        MinPanelLayout.setHorizontalGroup(
            MinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );
        MinPanelLayout.setVerticalGroup(
            MinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 0, 40, 40));

        ClosePanel.setBackground(new java.awt.Color(255, 255, 153));
        ClosePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ClosePanel.setPreferredSize(new java.awt.Dimension(35, 35));

        txt_close.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txt_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_close.setText("X");
        txt_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_closeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_closeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ClosePanelLayout = new javax.swing.GroupLayout(ClosePanel);
        ClosePanel.setLayout(ClosePanelLayout);
        ClosePanelLayout.setHorizontalGroup(
            ClosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClosePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_close, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ClosePanelLayout.setVerticalGroup(
            ClosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClosePanelLayout.createSequentialGroup()
                .addComponent(txt_close, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 0, 40, 40));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  INGRESAR FACTURA DE COMPRA");
        txt_tituloVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txt_tituloVentanaMouseDragged(evt);
            }
        });
        txt_tituloVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_tituloVentanaMousePressed(evt);
            }
        });
        Background.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1756, 40));

        PanelProveedor.setBackground(new java.awt.Color(220, 220, 220));
        PanelProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelProveedor.setPreferredSize(new java.awt.Dimension(910, 225));
        PanelProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_rutProveedor.setFont(new java.awt.Font("Roboto Thin", 1, 20)); // NOI18N
        txt_rutProveedor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_rutProveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_rutProveedor.setNextFocusableComponent(txt_digitoVerificador);
        txt_rutProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_rutProveedorFocusLost(evt);
            }
        });
        txt_rutProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rutProveedorKeyTyped(evt);
            }
        });
        PanelProveedor.add(txt_rutProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 140, 40));

        lbl_rutProveedor.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_rutProveedor.setText("RUT PROVEEDOR:");
        lbl_rutProveedor.setPreferredSize(new java.awt.Dimension(190, 24));
        PanelProveedor.add(lbl_rutProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 40));

        lbl_razonSocial.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_razonSocial.setText("RAZÓN SOCIAL:");
        lbl_razonSocial.setPreferredSize(new java.awt.Dimension(190, 40));
        PanelProveedor.add(lbl_razonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        txt_razonSocial.setFont(new java.awt.Font("Roboto Thin", 1, 20)); // NOI18N
        txt_razonSocial.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_razonSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_razonSocial.setNextFocusableComponent(rb_factura);
        txt_razonSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_razonSocialFocusLost(evt);
            }
        });
        PanelProveedor.add(txt_razonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 610, 40));

        lbl_mensajeProveedorNoExiste.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbl_mensajeProveedorNoExiste.setForeground(new java.awt.Color(255, 0, 0));
        lbl_mensajeProveedorNoExiste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mensajeProveedorNoExiste.setText("PROVEEDOR NO EXISTE EN EL SISTEMA. UNA VEZ FINALIZADA LA FACTURA SE INGRESARÁ PARA FUTURAS FACTURAS");
        lbl_mensajeProveedorNoExiste.setPreferredSize(new java.awt.Dimension(34, 40));
        PanelProveedor.add(lbl_mensajeProveedorNoExiste, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 800, -1));

        txt_digitoVerificador.setFont(new java.awt.Font("Roboto Thin", 1, 20)); // NOI18N
        txt_digitoVerificador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_digitoVerificador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_digitoVerificador.setNextFocusableComponent(txt_razonSocial);
        txt_digitoVerificador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_digitoVerificadorFocusLost(evt);
            }
        });
        txt_digitoVerificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_digitoVerificadorKeyTyped(evt);
            }
        });
        PanelProveedor.add(txt_digitoVerificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 50, 40));

        lbl_guion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lbl_guion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_guion.setText("-");
        lbl_guion.setPreferredSize(new java.awt.Dimension(15, 40));
        PanelProveedor.add(lbl_guion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 25, -1));

        PanelPaso1.setPreferredSize(new java.awt.Dimension(70, 223));

        lbl_1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("1");
        lbl_1.setPreferredSize(new java.awt.Dimension(20, 225));

        javax.swing.GroupLayout PanelPaso1Layout = new javax.swing.GroupLayout(PanelPaso1);
        PanelPaso1.setLayout(PanelPaso1Layout);
        PanelPaso1Layout.setHorizontalGroup(
            PanelPaso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPaso1Layout.setVerticalGroup(
            PanelPaso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaso1Layout.createSequentialGroup()
                .addComponent(lbl_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelProveedor.add(PanelPaso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        Background.add(PanelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        PanelIdFactura.setBackground(new java.awt.Color(204, 204, 204));
        PanelIdFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelIdFactura.setPreferredSize(new java.awt.Dimension(700, 225));
        PanelIdFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPaso2.setPreferredSize(new java.awt.Dimension(70, 223));

        lbl_2.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_2.setText("2");
        lbl_2.setPreferredSize(new java.awt.Dimension(20, 225));

        javax.swing.GroupLayout PanelPaso2Layout = new javax.swing.GroupLayout(PanelPaso2);
        PanelPaso2.setLayout(PanelPaso2Layout);
        PanelPaso2Layout.setHorizontalGroup(
            PanelPaso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPaso2Layout.setVerticalGroup(
            PanelPaso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaso2Layout.createSequentialGroup()
                .addComponent(lbl_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelIdFactura.add(PanelPaso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        lbl_folioDoc.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_folioDoc.setText("FOLIO DEL DOCUMENTO:");
        lbl_folioDoc.setPreferredSize(new java.awt.Dimension(230, 40));
        PanelIdFactura.add(lbl_folioDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        lbl_fechaEmision.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_fechaEmision.setText("FECHA DE EMISIÓN:");
        lbl_fechaEmision.setPreferredSize(new java.awt.Dimension(230, 40));
        PanelIdFactura.add(lbl_fechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        txt_folioDoc.setFont(new java.awt.Font("Roboto Thin", 1, 20)); // NOI18N
        txt_folioDoc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_folioDoc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_folioDoc.setNextFocusableComponent(txt_dia);
        txt_folioDoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_folioDocFocusLost(evt);
            }
        });
        txt_folioDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_folioDocKeyTyped(evt);
            }
        });
        PanelIdFactura.add(txt_folioDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 140, 40));

        lbl_tipoDocumento.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_tipoDocumento.setText("TIPO DE DOCUMENTO:");
        lbl_tipoDocumento.setPreferredSize(new java.awt.Dimension(230, 40));
        PanelIdFactura.add(lbl_tipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        rbGroupTipoDoc.add(rb_factura);
        rb_factura.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_factura.setText("FACTURA");
        rb_factura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_factura.setNextFocusableComponent(rb_boleta);
        rb_factura.setPreferredSize(new java.awt.Dimension(120, 40));
        PanelIdFactura.add(rb_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        rbGroupTipoDoc.add(rb_boleta);
        rb_boleta.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_boleta.setText("BOLETA");
        rb_boleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb_boleta.setNextFocusableComponent(lbl_folioDoc);
        rb_boleta.setPreferredSize(new java.awt.Dimension(120, 40));
        PanelIdFactura.add(rb_boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        txt_dia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_dia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dia.setNextFocusableComponent(cb_mes);
        txt_dia.setPreferredSize(new java.awt.Dimension(2, 40));
        txt_dia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaFocusLost(evt);
            }
        });
        txt_dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_diaKeyTyped(evt);
            }
        });
        PanelIdFactura.add(txt_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 54, -1));

        slash1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        slash1.setText("/");
        PanelIdFactura.add(slash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 20, 40));

        cb_mes.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        cb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cb_mes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cb_mes.setNextFocusableComponent(txt_anio);
        cb_mes.setPreferredSize(new java.awt.Dimension(149, 40));
        PanelIdFactura.add(cb_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        slash2.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        slash2.setText("/");
        PanelIdFactura.add(slash2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 20, 40));

        txt_anio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_anio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_anio.setNextFocusableComponent(txt_codigoBarra);
        txt_anio.setPreferredSize(new java.awt.Dimension(2, 40));
        txt_anio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anioFocusLost(evt);
            }
        });
        txt_anio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_anioKeyTyped(evt);
            }
        });
        PanelIdFactura.add(txt_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 90, -1));

        Background.add(PanelIdFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, -1, -1));

        PanelProducto.setBackground(new java.awt.Color(230, 204, 178));
        PanelProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelProducto.setForeground(new java.awt.Color(127, 85, 57));
        PanelProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelProductoKeyPressed(evt);
            }
        });

        txt_codigoBarra.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_codigoBarra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_codigoBarra.setNextFocusableComponent(txt_nombreProducto);
        txt_codigoBarra.setPreferredSize(new java.awt.Dimension(420, 40));
        txt_codigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoBarraActionPerformed(evt);
            }
        });

        lbl_escanearCodigo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lbl_escanearCodigo.setForeground(new java.awt.Color(127, 85, 57));
        lbl_escanearCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        lbl_escanearCodigo.setText("ESCANEAR CÓDIGO DE BARRA");

        lbl_buscarManual.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lbl_buscarManual.setForeground(new java.awt.Color(127, 85, 57));
        lbl_buscarManual.setText("BUSCAR PRODUCTO MANUALMENTE");

        separador.setBackground(new java.awt.Color(127, 85, 57));
        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separador.setPreferredSize(new java.awt.Dimension(1, 0));

        txt_nombreProducto.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_nombreProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_nombreProducto.setNextFocusableComponent(lbl_totalFactura);
        txt_nombreProducto.setPreferredSize(new java.awt.Dimension(420, 40));
        txt_nombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreProductoActionPerformed(evt);
            }
        });
        txt_nombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreProductoKeyReleased(evt);
            }
        });

        scrollPanelDetalleVenta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanelDetalleVenta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanelDetalleVenta.setOpaque(false);

        tbl_detalleVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_detalleVenta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_detalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD. PRODUCTO", "NOMBRE", "CANTIDAD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_detalleVenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_detalleVenta.setOpaque(false);
        tbl_detalleVenta.setShowHorizontalLines(false);
        tbl_detalleVenta.setShowVerticalLines(false);
        tbl_detalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_detalleVentaKeyPressed(evt);
            }
        });
        scrollPanelDetalleVenta.setViewportView(tbl_detalleVenta);

        lbl_3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_3.setText("3");

        javax.swing.GroupLayout PanelPaso3Layout = new javax.swing.GroupLayout(PanelPaso3);
        PanelPaso3.setLayout(PanelPaso3Layout);
        PanelPaso3Layout.setHorizontalGroup(
            PanelPaso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        PanelPaso3Layout.setVerticalGroup(
            PanelPaso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btn_anadir1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_anadir1.setPreferredSize(new java.awt.Dimension(200, 100));

        txt_anadir1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_anadir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_anadir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f1_key.png"))); // NOI18N
        txt_anadir1.setText("AÑADIR 1");
        txt_anadir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_anadir1.setPreferredSize(new java.awt.Dimension(200, 70));
        txt_anadir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_anadir1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_anadir1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_anadir1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_anadir1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_anadir1Layout = new javax.swing.GroupLayout(btn_anadir1);
        btn_anadir1.setLayout(btn_anadir1Layout);
        btn_anadir1Layout.setHorizontalGroup(
            btn_anadir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_anadir1Layout.createSequentialGroup()
                .addComponent(txt_anadir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_anadir1Layout.setVerticalGroup(
            btn_anadir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_anadir1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        );

        btn_restar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_restar1.setPreferredSize(new java.awt.Dimension(200, 100));

        txt_restar1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_restar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_restar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f2_key.png"))); // NOI18N
        txt_restar1.setText("RESTAR 1");
        txt_restar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_restar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_restar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_restar1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_restar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_restar1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_restar1Layout = new javax.swing.GroupLayout(btn_restar1);
        btn_restar1.setLayout(btn_restar1Layout);
        btn_restar1Layout.setHorizontalGroup(
            btn_restar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_restar1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        btn_restar1Layout.setVerticalGroup(
            btn_restar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_restar1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        );

        btn_eliminar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar1.setPreferredSize(new java.awt.Dimension(200, 100));

        txt_eliminar1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_eliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f3_key.png"))); // NOI18N
        txt_eliminar1.setText("ELIMINAR");
        txt_eliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_eliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_eliminar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_eliminar1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_eliminar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_eliminar1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_eliminar1Layout = new javax.swing.GroupLayout(btn_eliminar1);
        btn_eliminar1.setLayout(btn_eliminar1Layout);
        btn_eliminar1Layout.setHorizontalGroup(
            btn_eliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        btn_eliminar1Layout.setVerticalGroup(
            btn_eliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        );

        listaFiltrada.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        listaFiltrada.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaFiltrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaFiltradaMouseClicked(evt);
            }
        });
        listaFiltrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaFiltradaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaFiltrada);

        javax.swing.GroupLayout PanelProductoLayout = new javax.swing.GroupLayout(PanelProducto);
        PanelProducto.setLayout(PanelProductoLayout);
        PanelProductoLayout.setHorizontalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductoLayout.createSequentialGroup()
                .addComponent(PanelPaso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_escanearCodigo)
                    .addComponent(txt_nombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_buscarManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanelDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_anadir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_restar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        PanelProductoLayout.setVerticalGroup(
            PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelProductoLayout.createSequentialGroup()
                .addComponent(PanelPaso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addComponent(lbl_escanearCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_buscarManual, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(PanelProductoLayout.createSequentialGroup()
                        .addGroup(PanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelProductoLayout.createSequentialGroup()
                                .addComponent(btn_anadir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btn_restar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btn_eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPanelDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Background.add(PanelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 1640, 380));

        PanelDetalleFinal.setBackground(new java.awt.Color(204, 204, 204));
        PanelDetalleFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelDetalleFinal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelDetalleFinal.setPreferredSize(new java.awt.Dimension(700, 225));
        PanelDetalleFinal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPaso4.setPreferredSize(new java.awt.Dimension(70, 225));

        lbl_4.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_4.setText("4");
        lbl_4.setPreferredSize(new java.awt.Dimension(20, 225));

        javax.swing.GroupLayout PanelPaso4Layout = new javax.swing.GroupLayout(PanelPaso4);
        PanelPaso4.setLayout(PanelPaso4Layout);
        PanelPaso4Layout.setHorizontalGroup(
            PanelPaso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPaso4Layout.setVerticalGroup(
            PanelPaso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaso4Layout.createSequentialGroup()
                .addComponent(lbl_4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelDetalleFinal.add(PanelPaso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, 178));

        lbl_totalFactura.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_totalFactura.setText("TOTAL DE FACTURA:");
        lbl_totalFactura.setPreferredSize(new java.awt.Dimension(230, 40));
        PanelDetalleFinal.add(lbl_totalFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        txt_totalFactura.setFont(new java.awt.Font("Roboto Thin", 1, 20)); // NOI18N
        txt_totalFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_totalFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_totalFactura.setNextFocusableComponent(btn_ingresarDocumento);
        txt_totalFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_totalFacturaFocusLost(evt);
            }
        });
        txt_totalFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalFacturaKeyTyped(evt);
            }
        });
        PanelDetalleFinal.add(txt_totalFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 140, 40));

        lbl_docPorPagar.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_docPorPagar.setText("DOCUMENTO POR PAGAR:");
        lbl_docPorPagar.setPreferredSize(new java.awt.Dimension(245, 40));
        PanelDetalleFinal.add(lbl_docPorPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, -1));

        ChkFondo.setBackground(new java.awt.Color(255, 255, 255));
        ChkFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ChkFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChkFondo.setPreferredSize(new java.awt.Dimension(35, 35));
        ChkFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChkFondoMouseClicked(evt);
            }
        });
        ChkFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chk_porPagar.setBackground(new java.awt.Color(255, 255, 255));
        chk_porPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chk_porPagar.setPreferredSize(new java.awt.Dimension(25, 25));
        chk_porPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_porPagarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chk_porPagarLayout = new javax.swing.GroupLayout(chk_porPagar);
        chk_porPagar.setLayout(chk_porPagarLayout);
        chk_porPagarLayout.setHorizontalGroup(
            chk_porPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        chk_porPagarLayout.setVerticalGroup(
            chk_porPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        ChkFondo.add(chk_porPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, -1));

        PanelDetalleFinal.add(ChkFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 42, -1, -1));

        Background.add(PanelDetalleFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 570, 180));

        btn_ingresarDocumento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ingresarDocumento.setPreferredSize(new java.awt.Dimension(300, 140));
        btn_ingresarDocumento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ingresarDocumento.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txt_ingresarDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ingresarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill2.png"))); // NOI18N
        txt_ingresarDocumento.setText("INGRESAR FACTURA");
        txt_ingresarDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_ingresarDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ingresarDocumentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ingresarDocumentoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ingresarDocumentoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ingresarDocumentoMouseReleased(evt);
            }
        });
        btn_ingresarDocumento.add(txt_ingresarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 140));

        Background.add(btn_ingresarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 738, -1, -1));

        btn_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_salir.setPreferredSize(new java.awt.Dimension(300, 140));
        btn_salir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_salir.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbl_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        lbl_salir.setText("   SALIR");
        lbl_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_salirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_salirMouseReleased(evt);
            }
        });
        btn_salir.add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 140));

        Background.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 738, -1, -1));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1840, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tituloVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloVentanaMouseDragged

    private void txt_tituloVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloVentanaMousePressed

    private void txt_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_closeMouseEntered
        ClosePanel.setBackground(Color.RED);
        txt_close.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_closeMouseEntered

    private void txt_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_closeMouseExited
        ClosePanel.setBackground(BackgroundColor);
        txt_close.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_closeMouseExited

    private void txt_closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_closeMousePressed
        Color DarkRed = new Color(146, 55, 77);
        ClosePanel.setBackground(DarkRed);
        txt_close.setForeground(Color.WHITE);
        this.dispose();
    }//GEN-LAST:event_txt_closeMousePressed

    private void txt_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_minimizeMouseEntered
        MinPanel.setBackground(mouseEnterPanelColor);
        txt_minimize.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_minimizeMouseEntered

    private void txt_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_minimizeMouseExited
        MinPanel.setBackground(BackgroundColor);
        txt_minimize.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_minimizeMouseExited

    private void txt_minimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_minimizeMousePressed
        MinPanel.setBackground(mouseClickPanelColor);
        txt_minimize.setForeground(Color.WHITE);
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_txt_minimizeMousePressed

    private void txt_minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_minimizeMouseReleased
        MinPanel.setBackground(BackgroundColor);
        txt_minimize.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_minimizeMouseReleased

    private void txt_rutProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutProveedorKeyTyped
        onlyNumberField(evt);
        maxCharactersTyped(txt_rutProveedor, 8, evt);      
        if(txt_rutProveedor.getText().replace(".", "").length() == 7) txt_digitoVerificador.requestFocus();
    }//GEN-LAST:event_txt_rutProveedorKeyTyped

    private void txt_rutProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_rutProveedorFocusLost

        llenarCamposProveedor();
        formatearRut(txt_rutProveedor);
    }//GEN-LAST:event_txt_rutProveedorFocusLost

    private void llenarCamposProveedor(){
        ConProveedor conProveedor = new ConProveedor();
        Proveedor proveedor;
        String rut = txt_rutProveedor.getText().replace(".", "");
        if(!rut.equals("") && txt_digitoVerificador.getText().equals("")){
            proveedor = conProveedor.existeProveedorSinDV(rut);    
            if(!proveedor.getRazon_social().equals("")){
                txt_digitoVerificador.setText(proveedor.getDv());
                txt_razonSocial.setText(proveedor.getRazon_social());
                lbl_mensajeProveedorNoExiste.setVisible(false);
                txt_folioDoc.requestFocus();
            }
            else {
                txt_digitoVerificador.setText("");
                txt_razonSocial.setText("");
                lbl_mensajeProveedorNoExiste.setVisible(true);
            }
        }
        else if(rut.equals("") && !txt_digitoVerificador.getText().equals("")){
            txt_razonSocial.setText("");
            txt_rutProveedor.setText("");
            lbl_mensajeProveedorNoExiste.setVisible(false);
        }   
        else{
            proveedor = conProveedor.existeProveedorConDV(rut,txt_digitoVerificador.getText());
            if(!proveedor.getRazon_social().equals("")){
                txt_razonSocial.setText(proveedor.getRazon_social());
                lbl_mensajeProveedorNoExiste.setVisible(false);
                txt_folioDoc.requestFocus();
            }
            else {
                txt_razonSocial.setText("");
                lbl_mensajeProveedorNoExiste.setVisible(true);
            }
        }
    }
    
    
    private void txt_digitoVerificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_digitoVerificadorKeyTyped
        validarVerificador(evt);
        maxCharactersTyped(txt_digitoVerificador, 1, evt);
        if(txt_digitoVerificador.getText().length() == 0) txt_razonSocial.requestFocus();
    }//GEN-LAST:event_txt_digitoVerificadorKeyTyped

    private void txt_digitoVerificadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_digitoVerificadorFocusLost
        llenarCamposProveedor();
        txt_digitoVerificador.setText(txt_digitoVerificador.getText().toUpperCase());
    }//GEN-LAST:event_txt_digitoVerificadorFocusLost

    private void txt_razonSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_razonSocialFocusLost
        txt_razonSocial.setText(txt_razonSocial.getText().toUpperCase());
    }//GEN-LAST:event_txt_razonSocialFocusLost

    private void txt_folioDocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_folioDocFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_folioDocFocusLost

    private void txt_folioDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_folioDocKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_folioDocKeyTyped

    private void txt_diaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFocusLost
        diaValido(txt_dia);
        if(Integer.parseInt(txt_dia.getText())<10){
            txt_dia.setText("0"+Integer.parseInt(txt_dia.getText()));
        }
    }//GEN-LAST:event_txt_diaFocusLost

    private void txt_diaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaKeyTyped
        txt_dia.setTransferHandler(null);
        maxCharactersTyped(txt_dia, 2,evt);
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_diaKeyTyped

    private void txt_anioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anioFocusLost
        anioValido(txt_anio);
    }//GEN-LAST:event_txt_anioFocusLost

    private void txt_anioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anioKeyTyped
        txt_anio.setTransferHandler(null);
        maxCharactersTyped(txt_anio, 4, evt);
        onlyNumberField(evt);

    }//GEN-LAST:event_txt_anioKeyTyped

    private void txt_codigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoBarraActionPerformed
        if(actualizarListado){
            ConProducto cProducto = new ConProducto();
            productos = cProducto.listarProductos();
            actualizarProductos();
            actualizarListado = false;
        }
        threadAutomatico.run();
        txt_codigoBarra.setText("");
    }//GEN-LAST:event_txt_codigoBarraActionPerformed

    private void txt_nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreProductoActionPerformed
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoActionPerformed

    private void txt_nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreProductoKeyReleased
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoKeyReleased

    private void tbl_detalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_detalleVentaKeyPressed

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_F1:
            {
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                int row = tbl_detalleVenta.getSelectedRow();
                int cantidad = (int) table.getValueAt(row, 3);
                table.setValueAt(cantidad+1, row, 3);
                int precio = (int)table.getValueAt(row, 2);
                String valorTotal = String.format("$%,d", (cantidad + 1)*precio);
                table.setValueAt(valorTotal, row, 4);
                tbl_detalleVenta.requestFocus();
                break;
            }
            case KeyEvent.VK_F2:
            {
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                int row = tbl_detalleVenta.getSelectedRow();
                int cantidad = (int) table.getValueAt(row, 3);
                if(cantidad -1 > 0){
                    table.setValueAt(cantidad-1, row, 3);
                    int precio = (int)table.getValueAt(row, 2);
                    String valorTotal = String.format("$%,d", (cantidad - 1)*precio);
                    table.setValueAt(valorTotal, row, 4);
                    tbl_detalleVenta.requestFocus();
                }       break;
            }
            case KeyEvent.VK_F3:
            {
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                try{
                    table.removeRow(tbl_detalleVenta.getSelectedRow());
                    if(tbl_detalleVenta.getRowCount() > 0){
                        tbl_detalleVenta.requestFocus();
                    }
                    else{
                        txt_codigoBarra.requestFocus();
                    }
                }
                catch(Exception e){
                    System.out.println("NADA SELECCIONADO");
                }       break;
            }
 
            default:
            break;
        }
    }//GEN-LAST:event_tbl_detalleVentaKeyPressed

    private void txt_anadir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseEntered
        btn_anadir1.setBackground(verdeMouseEnter);
    }//GEN-LAST:event_txt_anadir1MouseEntered

    private void txt_anadir1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseExited
        btn_anadir1.setBackground(verde);
    }//GEN-LAST:event_txt_anadir1MouseExited

    private void txt_anadir1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MousePressed
        try {
            if(evt.getButton() == 1){
                btn_anadir1.setBackground(verdeClick);
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                int row = tbl_detalleVenta.getSelectedRow();
                if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                    int cantidad = (int) table.getValueAt(row, 2);
                    table.setValueAt(cantidad+1, row, 2);
                    lostFocus(null, tbl_detalleVenta);
                }
            }
        }
        catch (Exception e) {
            try {
                threadManual.run();
            }
            catch (Exception ex) {
                System.out.println("Nada seleccionado");
            }

        }

    }//GEN-LAST:event_txt_anadir1MousePressed

    private void txt_anadir1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseReleased
        if(btn_anadir1.contains(evt.getPoint())) btn_anadir1.setBackground(verdeMouseEnter);
        else  btn_anadir1.setBackground(verde);
    }//GEN-LAST:event_txt_anadir1MouseReleased

    private void txt_restar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseEntered
        btn_restar1.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_txt_restar1MouseEntered

    private void txt_restar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseExited
        btn_restar1.setBackground(rojo);
    }//GEN-LAST:event_txt_restar1MouseExited

    private void txt_restar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MousePressed
        try {
            if(evt.getButton() == 1){
                btn_restar1.setBackground(rojoClick);
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                int row = tbl_detalleVenta.getSelectedRow();
                if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                    int cantidad = (int) table.getValueAt(row, 2);
                    if(cantidad -1 > 0){
                        table.setValueAt(cantidad-1, row, 2);
                        lostFocus(null, tbl_detalleVenta);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Nada seleccionado");
        }
    }//GEN-LAST:event_txt_restar1MousePressed

    private void txt_restar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseReleased
        if(btn_restar1.contains(evt.getPoint())) btn_restar1.setBackground(rojoMouseEnter);
        else  btn_restar1.setBackground(rojo);
    }//GEN-LAST:event_txt_restar1MouseReleased

    private void txt_eliminar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eliminar1MouseEntered
        btn_eliminar1.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_txt_eliminar1MouseEntered

    private void txt_eliminar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eliminar1MouseExited
        btn_eliminar1.setBackground(rojo);
    }//GEN-LAST:event_txt_eliminar1MouseExited

    private void txt_eliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eliminar1MousePressed
        if(evt.getButton() == 1){
            btn_eliminar1.setBackground(rojoClick);
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            try{
                table.removeRow(tbl_detalleVenta.getSelectedRow());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,"NADA SELECCIONADO","Sin seleccion",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_txt_eliminar1MousePressed

    private void txt_eliminar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eliminar1MouseReleased
        if(btn_eliminar1.contains(evt.getPoint())) btn_eliminar1.setBackground(rojoMouseEnter);
        else  btn_eliminar1.setBackground(rojo);
    }//GEN-LAST:event_txt_eliminar1MouseReleased

    private void listaFiltradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaFiltradaMouseClicked
        if (evt.getClickCount() == 2) threadManual.run();

    }//GEN-LAST:event_listaFiltradaMouseClicked

    private void listaFiltradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaFiltradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            threadManual.run();
        }
    }//GEN-LAST:event_listaFiltradaKeyPressed

    private void PanelProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelProductoKeyPressed
        
    }//GEN-LAST:event_PanelProductoKeyPressed

    private void txt_totalFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_totalFacturaFocusLost
        if(txt_totalFactura.getText().equals("")) txt_totalFactura.setText("$0");
        else{
            String valor = txt_totalFactura.getText().replace("$", "").replace(".", "");
            txt_totalFactura.setText(String.format("$%,d",Integer.valueOf(valor)));
        }
    }//GEN-LAST:event_txt_totalFacturaFocusLost

    private void txt_totalFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalFacturaKeyTyped
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_totalFacturaKeyTyped

    private void chk_porPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_porPagarMouseClicked
        if(evt.getButton() == 1){
            if(chk_porPagar.getBackground() == mouseEnterPanelColor)
                chk_porPagar.setBackground(Color.WHITE);
            else
                chk_porPagar.setBackground(mouseEnterPanelColor);
        }
    }//GEN-LAST:event_chk_porPagarMouseClicked

    private void ChkFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChkFondoMouseClicked
        if(evt.getButton() == 1){
            if(chk_porPagar.getBackground() == mouseEnterPanelColor)
                chk_porPagar.setBackground(Color.WHITE);
            else
                chk_porPagar.setBackground(mouseEnterPanelColor);
        }
    }//GEN-LAST:event_ChkFondoMouseClicked

    private void txt_ingresarDocumentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ingresarDocumentoMousePressed
        if(evt.getButton() == 1){
            txt_totalFactura.requestFocus(false);
            btn_ingresarDocumento.setBackground(verdeClick);
            if(camposLlenados()){
                Proveedor proveedor = new Proveedor();
                proveedor.setRut(txt_rutProveedor.getText());
                proveedor.setDv(txt_digitoVerificador.getText());
                proveedor.setRazon_social(txt_razonSocial.getText());
                if(lbl_mensajeProveedorNoExiste.isVisible()){
                    ConProveedor conProveedor = new ConProveedor();                    
                    conProveedor.crearProveedor(proveedor);
                }
                Documento documento = new Documento();
                String tipoDoc;
                if(rb_boleta.isSelected()) tipoDoc = "B";
                else tipoDoc = "F";
                String folio = txt_folioDoc.getText();
                String id_documento = folio+tipoDoc+proveedor.getRut();
                                
                String dia = txt_dia.getText();
                String mes = String.valueOf(cb_mes.getSelectedIndex()+1);
                if(mes.length() == 1) mes = "0"+mes;
                String anio = txt_anio.getText();
                String fecha = anio+"/"+mes+"/"+dia;
                
                boolean porPagar = !chk_porPagar.getBackground().equals(Color.WHITE);
                
                int total = Integer.parseInt(txt_totalFactura.getText().replace("$", "").replace(".", ""));
                
                documento.setId_documento(id_documento);
                documento.setEs_factura(rb_factura.isSelected());
                documento.setFecha(fecha);
                documento.setFolio(folio);
                documento.setPor_pagar(porPagar);
                documento.setTotal(total);
                
                ArrayList<DetalleDocumento> detalle = new ArrayList<>();
                
                for(int i = 0; i < tbl_detalleVenta.getRowCount(); i++){
                    Producto producto = new Producto();
                    int cantidad;
                    try {
                        producto.setCodigo_barra(tbl_detalleVenta.getValueAt(i, 0).toString());
                        cantidad = Integer.parseInt(tbl_detalleVenta.getValueAt(i, 2).toString());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Hubo un problema ingresando los productos en la factura", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    DetalleDocumento d = new DetalleDocumento();
                    d.setDocumento(documento);
                    d.setProveedor(proveedor);
                    d.setProducto(producto);
                    d.setCantidad(cantidad);      
                    
                    detalle.add(d);
                }
                
                ConDocumento conDocumento = new ConDocumento();
                if(conDocumento.IngresarDocumento(documento, detalle)){
                    JOptionPane.showMessageDialog(this, "Factura registrada de forma exitosa","Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    IngresarFactura ventana = new IngresarFactura();
                    ventana.setVisible(true);
                }
                else{
                    if(conDocumento.IngresarDocumento(documento, detalle)){
                        JOptionPane.showMessageDialog(this, "Factura registrada de forma exitosa","Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        IngresarFactura ventana = new IngresarFactura();
                        ventana.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "No se pudo igresar la factura","Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            }
            
        }
        
        
    }//GEN-LAST:event_txt_ingresarDocumentoMousePressed

    private void txt_ingresarDocumentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ingresarDocumentoMouseEntered
        btn_ingresarDocumento.setBackground(verdeMouseEnter);
    }//GEN-LAST:event_txt_ingresarDocumentoMouseEntered

    private void txt_ingresarDocumentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ingresarDocumentoMouseExited
        btn_ingresarDocumento.setBackground(verde);
    }//GEN-LAST:event_txt_ingresarDocumentoMouseExited

    private void txt_ingresarDocumentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ingresarDocumentoMouseReleased
        if(btn_ingresarDocumento.contains(evt.getPoint())) btn_ingresarDocumento.setBackground(verdeMouseEnter);
        else btn_ingresarDocumento.setBackground(verde);
    }//GEN-LAST:event_txt_ingresarDocumentoMouseReleased

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        btn_salir.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        btn_salir.setBackground(rojo);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMousePressed
        if(evt.getButton() == 1){
            btn_salir.setBackground(rojoClick);
            int confirmar = JOptionPane.showConfirmDialog(this, "Si sale se perderan los datos ingresados, ¿Desea continuar?", "Cerrar ventana", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(confirmar == JOptionPane.YES_OPTION)
                this.dispose();
            
        }
        
    }//GEN-LAST:event_lbl_salirMousePressed

    private void lbl_salirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseReleased
        if(btn_salir.contains(evt.getPoint())) btn_salir.setBackground(rojoMouseEnter);
        else btn_salir.setBackground(rojo);
    }//GEN-LAST:event_lbl_salirMouseReleased

    private boolean camposLlenados() {
        boolean faltanCampos = false;
        //CAMPOS PASO 1
        String rut = txt_rutProveedor.getText();
        String dv = txt_digitoVerificador.getText();
        String razon_social = txt_razonSocial.getText();
        
        if(rut.equals("") || dv.equals("") || razon_social.equals("")){
            JOptionPane.showMessageDialog(this, "Faltan campos por llenar del PANEL 1", "Faltan campos", JOptionPane.WARNING_MESSAGE);
            faltanCampos = true;
        }
        
        //CAMPOS PASO 2
        String folio = txt_folioDoc.getText();
        
        String dia = txt_dia.getText();
        String mes = String.valueOf(cb_mes.getSelectedIndex()+1);
        if(mes.length() == 1) mes = "0"+mes;
        String anio = txt_anio.getText();
        String fecha = anio+"/"+mes+"/"+dia;
        try {
            Date date1 = new Date();
            Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(fecha); 
            if(date1.compareTo(date2) == -1){
                JOptionPane.showMessageDialog(this, "La fecha de la factura no puede ser mayor a hoy", "Error en la fecha", JOptionPane.WARNING_MESSAGE);
                faltanCampos = true;
            }
        } catch (Exception e) {
            faltanCampos = true;
        }
        
        if(folio.equals("") || dia.equals("") || anio.equals("")){
            faltanCampos = true;
            JOptionPane.showMessageDialog(this, "Faltan campos por llenar del PANEL 2", "Faltan campos", JOptionPane.WARNING_MESSAGE);
        }
        
        //CAMPOS PASO 3
        int cantidadFilas = tbl_detalleVenta.getRowCount();
        if(cantidadFilas == 0){
            faltanCampos = true;
            JOptionPane.showMessageDialog(this, "No hay productos ingresados en PANEL 3", "Faltan campos", JOptionPane.WARNING_MESSAGE);
        }
        
        //CAMPOS PASO 4
        String totalFactura = txt_totalFactura.getText().replace("$", "").replace(".","");
        if(totalFactura.equals("") || (Integer.parseInt(totalFactura) <= 0)){
            JOptionPane.showMessageDialog(this, "Debe registrar el monto de la factura en PANEL 4", "Faltan campos", JOptionPane.WARNING_MESSAGE);
            faltanCampos = true;
        }
        
        return !faltanCampos;
        
    }
    
    private void diaValido(JTextField campo){
        int intDia = Integer.parseInt(campo.getText());
        if(intDia >= 31){
            campo.setText(global_dia);
        }
    }
    
    private void anioValido(JTextField campo){
        int intAnio = Integer.parseInt(campo.getText());
        int maxAnio = Integer.parseInt(global_anio);
        if(intAnio < 2022 || intAnio > maxAnio){
            campo.setText(global_anio);
        }
    }  
   
    private int pedirCantidad(){
        int cantidad;
        String respuesta;
        do {

        try {
            respuesta = JOptionPane.showInputDialog(null, "Ingrese cantidad\nPara salir de este cuadro INGRESE 0", "Cantidad del producto", JOptionPane.INFORMATION_MESSAGE);

            if(respuesta.equals("")){
                cantidad = 0;
            }
            else{        

                cantidad = Integer.parseInt(respuesta);
            }


        } catch (NullPointerException | NumberFormatException | HeadlessException e) {
            if(e.getMessage() == null) cantidad = 0;
            else cantidad = -1;
        }

        }while(cantidad == -1);

        return cantidad;
    }    

    
    Thread threadAutomatico = new Thread(new Runnable() {
        @Override
        public void run() {
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            Producto p = new Producto();
            for(Producto producto: productos){
                if(producto.getCodigo_barra().toUpperCase().equals(txt_codigoBarra.getText().toUpperCase())){
                    p = producto;
                    break;
                }
            }
            
            if(!p.getNombre().equals("")){
                int filas=table.getRowCount();
                int cantidad = pedirCantidad();
                if(cantidad <= 0) return;
                switch (p.getCodigo_barra()) {
                    case "CODIGOPAN":
                        {
                            break;
                        }
                    case "NN0000":
                        {
                            break;
                        }
                    default:
                        if(filas == 0){
                            Object fila[] = {
                                p.getCodigo_barra(),
                                p.getNombre(),
                                cantidad
                            };
                            table.addRow(fila);    
                        }
                        else{
                            boolean existe = false;   
                            for(int i = 0; i< table.getRowCount(); i ++){
                                if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                                    int cant = (int) table.getValueAt(i, 2)+cantidad;
                                    table.setValueAt(cant, i, 2);                                    
                                    existe=true;
                                    break;
                                }
                            }
                            if(!existe){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    cantidad
                                };
                                table.addRow(fila);
                            }
                        }   break;
                }
            }
            else{
                
                System.out.println(p.getNombre());
                if(listaNoSeMuestra.contains(txt_codigoBarra.getText().toUpperCase())) {
                    JOptionPane.showMessageDialog(null, "Este producto fue descartado", "Producto descartado",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int ingresar = JOptionPane.showConfirmDialog(null, "No hay un producto ingresado con este codigo, ¿Quiere registrarlo?", "Error buscando producto", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION); 
                    if(ingresar == 0){
                        IngresarProducto ventana = new IngresarProducto();
                        ventana.setVisible(true);
                        actualizarListado = true;
                    }    
               }               
            }
        }
     });
    
    Thread threadManual = new Thread(new Runnable() {
        @Override
        public void run() {
            if(listaFiltrada.getSelectedValue() != null){
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                String codigo = listaFiltrada.getSelectedValue().replace(")", "ñÑñ").replace("(","ñÑñ").split("ñÑñ")[1];
                Producto p = new Producto();
                for(Producto producto: productos){
                    if(producto.getCodigo_barra().equals(codigo)){
                        p = producto;
                        break;
                    }
                }
                if(!p.getNombre().equals("")){
                    int filas=table.getRowCount();
                    int cantidad = pedirCantidad();
                    if(cantidad <= 0) return;
                    switch (p.getCodigo_barra()) {
                        case "CODIGOPAN":
                            {
                                break;
                            }
                        case "NN0000":
                            {
                                break;
                            }
                        default:
                            if(filas == 0){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    cantidad
                                };
                                table.addRow(fila);    
                            }
                            else{
                                boolean existe = false;
                                for(int i = 0; i< table.getRowCount(); i ++){
                                    if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                                        int cant = (int) table.getValueAt(i, 2)+cantidad;
                                        table.setValueAt(cant, i, 2);                                        
                                        existe=true;
                                        break;
                                    }
                                }
                                if(!existe){
                                    Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),
                                        cantidad
                                    };
                                    table.addRow(fila);
                                }
                            }   break;
                    }
                }                   
                txt_nombreProducto.setText("");
                DefaultListModel dl = new DefaultListModel();
                dl.clear();
                listaFiltrada.setModel(dl);
                }
            }            
     });    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel ChkFondo;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelDetalleFinal;
    private javax.swing.JPanel PanelIdFactura;
    private javax.swing.JPanel PanelPaso1;
    private javax.swing.JPanel PanelPaso2;
    private javax.swing.JPanel PanelPaso3;
    private javax.swing.JPanel PanelPaso4;
    private javax.swing.JPanel PanelProducto;
    private javax.swing.JPanel PanelProveedor;
    private javax.swing.JPanel btn_anadir1;
    private javax.swing.JPanel btn_eliminar1;
    private javax.swing.JPanel btn_ingresarDocumento;
    private javax.swing.JPanel btn_restar1;
    private javax.swing.JPanel btn_salir;
    private javax.swing.JComboBox<String> cb_mes;
    private javax.swing.JPanel chk_porPagar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_buscarManual;
    private javax.swing.JLabel lbl_docPorPagar;
    private javax.swing.JLabel lbl_escanearCodigo;
    private javax.swing.JLabel lbl_fechaEmision;
    private javax.swing.JLabel lbl_folioDoc;
    private javax.swing.JLabel lbl_guion;
    private javax.swing.JLabel lbl_mensajeProveedorNoExiste;
    private javax.swing.JLabel lbl_razonSocial;
    private javax.swing.JLabel lbl_rutProveedor;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JLabel lbl_tipoDocumento;
    private javax.swing.JLabel lbl_totalFactura;
    private javax.swing.JList<String> listaFiltrada;
    private javax.swing.ButtonGroup rbGroupTipoDoc;
    private javax.swing.JRadioButton rb_boleta;
    private javax.swing.JRadioButton rb_factura;
    private javax.swing.JScrollPane scrollPanelDetalleVenta;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel slash1;
    private javax.swing.JLabel slash2;
    private javax.swing.JTable tbl_detalleVenta;
    private javax.swing.JLabel txt_anadir1;
    private javax.swing.JTextField txt_anio;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JTextField txt_dia;
    private javax.swing.JTextField txt_digitoVerificador;
    private javax.swing.JLabel txt_eliminar1;
    private javax.swing.JTextField txt_folioDoc;
    private javax.swing.JLabel txt_ingresarDocumento;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_razonSocial;
    private javax.swing.JLabel txt_restar1;
    private javax.swing.JTextField txt_rutProveedor;
    private javax.swing.JLabel txt_tituloVentana;
    private javax.swing.JTextField txt_totalFactura;
    // End of variables declaration//GEN-END:variables
}
