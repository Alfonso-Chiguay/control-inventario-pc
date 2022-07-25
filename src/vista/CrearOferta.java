package vista;

import controlador.ConColores;
import controlador.ConProducto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.PaletaColor;
import modelo.Producto;

public class CrearOferta extends javax.swing.JFrame {

    ArrayList<Producto> productos;
    private boolean actualizarListado;
    ArrayList<String> listaNoSeMuestra = new ArrayList<>();
    ConProducto CON_PRODUCTO = new ConProducto();
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
    Color verde = new Color(60, 157, 52);
    Color verdeMouseEnter = new Color(21, 162, 68);
    Color verdeClick = new Color(0, 80, 0);
    Color rojo = new Color(201, 0, 37);
    Color rojoMouseEnter = new Color(240, 36, 15);
    Color rojoClick = new Color(255, 116, 0);
    
    
    
    public void actualizarProductos(){
        String palabraClave = txt_nombreProducto.getText();
        if(!palabraClave.equals("")){
            DefaultListModel dl = new DefaultListModel();
            dl.clear();
            
            productos.forEach((p) -> {                
                String nombre = p.getNombre().toLowerCase().replace("á","a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
                if (nombre.contains(palabraClave.toLowerCase()) &&
                        !listaNoSeMuestra.contains(p.getCodigo_barra().toUpperCase())) {
                    dl.addElement(p.getNombre()+" ("+p.getCodigo_barra()+")");
                }
            });
            listaFiltrada.setModel(dl);
        }
        else{
            DefaultListModel dl = new DefaultListModel();
            dl.clear();
            listaFiltrada.setModel(dl);
        }
    }
    
    
    public CrearOferta() {
        initComponents();
    }
    
    public CrearOferta(ArrayList<Producto> listado){
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Crear oferta");
        productos = listado;
        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
        table.setRowCount(0);
        actualizarProductos();
        actualizarListado = false;
        
        //COLORES
        PanelPrincipal.setBackground(BackgroundColor);
        panelIzqCodigoOferta.setBackground(PanelColor);
        txt_tituloVentana.setForeground(textColor);
        lbl_codigoOferta.setForeground(textColor);
        txt_codigoOferta.setForeground(textColor);
        PanelCodigoOferta.setBackground(BackgroundColor);
        lbl_1.setForeground(mouseEnterPanelColor);
        PanelIdentificaProd.setBackground(BackgroundColor);
        PanelDetalleOferta.setBackground(BackgroundColor);
        panelIzqIdentifica.setBackground(PanelColor);
        lbl_2.setForeground(mouseEnterPanelColor);   
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);      
        lbl_codigoBarra.setForeground(textColor);
        lbl_codigoManual.setForeground(textColor);
        panelIzqDetalle.setBackground(PanelColor);
        lbl_3.setForeground(mouseEnterPanelColor);
        lbl_nombreOferta.setForeground(textColor);
        lbl_precioOferta.setForeground(textColor);
        btn_crearOferta.setBackground(PanelColor);
        btn_anadir1.setBackground(verde);
        btn_restar1.setBackground(rojo);
        btn_eliminar1.setBackground(rojo);
        
        //CODIGOS DE BARRA NO VENDIBLES
        listaNoSeMuestra.add("VASOMARLEY1");
        listaNoSeMuestra.add("VASOMARLEY2");
        listaNoSeMuestra.add("VASOMARLEY3");
        listaNoSeMuestra.add("VASONESCAFE1");
        listaNoSeMuestra.add("VASONESCAFE2");
        listaNoSeMuestra.add("614143407048");
        listaNoSeMuestra.add("614143407062");
        listaNoSeMuestra.add("614143407086");
        listaNoSeMuestra.add("614143407215");
        listaNoSeMuestra.add("7613034848550");
        listaNoSeMuestra.add("7613036935944");
        listaNoSeMuestra.add("7613036935975");
        listaNoSeMuestra.add("7613036939171");
        listaNoSeMuestra.add("7613036956895");
        listaNoSeMuestra.add("859940002991");
        
        //TABLA
        PanelTabla.setBackground(BackgroundColor);
        tbl_listadoProductos.getTableHeader().setReorderingAllowed(false);
        tbl_listadoProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //829
        tbl_listadoProductos.getColumnModel().getColumn(0).setPreferredWidth(180);
        tbl_listadoProductos.getColumnModel().getColumn(0).setMinWidth(180);
        tbl_listadoProductos.getColumnModel().getColumn(0).setMaxWidth(180);
        tbl_listadoProductos.getColumnModel().getColumn(1).setPreferredWidth(390);
        tbl_listadoProductos.getColumnModel().getColumn(1).setMinWidth(390);
        tbl_listadoProductos.getColumnModel().getColumn(1).setMaxWidth(390);
        tbl_listadoProductos.getColumnModel().getColumn(2).setPreferredWidth(90);
        tbl_listadoProductos.getColumnModel().getColumn(2).setMinWidth(90);
        tbl_listadoProductos.getColumnModel().getColumn(2).setMaxWidth(90);
    
        
        tbl_listadoProductos.setRowHeight(35);
        tbl_listadoProductos.setFont(new Font("Roboto Thin", Font.PLAIN, 22));
        tbl_listadoProductos.setBackground(BackgroundColor);
        tbl_listadoProductos.setForeground(textColor);
        tbl_listadoProductos.setOpaque(true);
        tbl_listadoProductos.setFillsViewportHeight(true);
        
        tbl_listadoProductos.getTableHeader().setOpaque(false);
        tbl_listadoProductos.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        tbl_listadoProductos.getTableHeader().setBackground(PanelColor);
        tbl_listadoProductos.getTableHeader().setForeground(Color.WHITE);
        
        tbl_listadoProductos.setSelectionBackground(mouseEnterPanelColor);
        tbl_listadoProductos.setSelectionForeground(Color.WHITE);
        
        DefaultTableCellRenderer positionRenderer = new DefaultTableCellRenderer();
        positionRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_listadoProductos.getColumnModel().getColumn(2).setCellRenderer(positionRenderer);
        
    }

    
    
    Thread threadAutomatico = new Thread(new Runnable() {
        @Override
        public void run() {
            DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();

            Producto p = new Producto();
            for(Producto producto: productos){
                if(producto.getCodigo_barra().toUpperCase().equals(txt_codigoBarra.getText().toUpperCase())){
                    p = producto;
                    break;
                }
            }
            
            if(!p.getNombre().equals("")){
                int filas=table.getRowCount();
                
                if(filas == 0){
                    Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),                                    
                                    1
                                    };
                    table.addRow(fila);     
                }
                else{
                    boolean existe = false;
                    for(int i = 0; i< table.getRowCount(); i ++){
                        if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                            int cantidad = (int) table.getValueAt(i, 2)+1;
                            table.setValueAt(cantidad, i, 2);                            
                            existe=true;
                            break;
                        }
                    }
                    if(!existe){
                        Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),
                                        1
                                        };
                        table.addRow(fila);    
                    }
                }                   
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
     });

    Thread threadManual = new Thread(new Runnable() {
        @Override
        public void run() {
            if(listaFiltrada.getSelectedValue() != null){
                DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
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
                   
                    if(filas == 0){
                        Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),                                        
                                        1
                                        };
                        table.addRow(fila);     
                    }
                    else{
                        boolean existe = false;
                        for(int i = 0; i< table.getRowCount(); i ++){
                            if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                                int cantidad = (int) table.getValueAt(i, 2)+1;
                                table.setValueAt(cantidad, i, 2);
                                existe=true;
                                break;
                            }
                        }
                        if(!existe){
                            Object fila[] = {
                                            p.getCodigo_barra(),
                                            p.getNombre(),
                                            1,
                                            };
                            table.addRow(fila);    
                        }
                    }                    
                }      
            }
        }
        
        
     
            
    });
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelCodigoOferta = new javax.swing.JPanel();
        txt_codigoOferta = new javax.swing.JTextField();
        lbl_existeCodigoOferta = new javax.swing.JLabel();
        panelIzqCodigoOferta = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        lbl_codigoOferta = new javax.swing.JLabel();
        PanelIdentificaProd = new javax.swing.JPanel();
        panelIzqIdentifica = new javax.swing.JPanel();
        lbl_2 = new javax.swing.JLabel();
        txt_codigoBarra = new javax.swing.JTextField();
        lbl_codigoBarra = new javax.swing.JLabel();
        lbl_codigoManual = new javax.swing.JLabel();
        separadorVertical = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFiltrada = new javax.swing.JList<>();
        txt_nombreProducto = new javax.swing.JTextField();
        PanelTabla = new javax.swing.JScrollPane();
        tbl_listadoProductos = new javax.swing.JTable();
        btn_anadir1 = new javax.swing.JPanel();
        txt_anadir1 = new javax.swing.JLabel();
        btn_restar1 = new javax.swing.JPanel();
        txt_restar1 = new javax.swing.JLabel();
        btn_eliminar1 = new javax.swing.JPanel();
        txt_eliminar1 = new javax.swing.JLabel();
        PanelDetalleOferta = new javax.swing.JPanel();
        lbl_precioOferta = new javax.swing.JLabel();
        txt_precioOferta = new javax.swing.JTextField();
        lbl_nombreOferta = new javax.swing.JLabel();
        txt_nombreOferta = new javax.swing.JTextField();
        panelIzqDetalle = new javax.swing.JPanel();
        lbl_3 = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        btn_crearOferta = new javax.swing.JPanel();
        txt_crearOferta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(230, 204, 178));
        PanelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(1560, 840));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCodigoOferta.setBackground(new java.awt.Color(230, 204, 178));
        PanelCodigoOferta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelCodigoOferta.setForeground(new java.awt.Color(127, 85, 57));
        PanelCodigoOferta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigoOferta.setFont(new java.awt.Font("Roboto Thin", 0, 24)); // NOI18N
        txt_codigoOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOferta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOfertaFocusLost(evt);
            }
        });
        PanelCodigoOferta.add(txt_codigoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 410, 40));

        lbl_existeCodigoOferta.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        lbl_existeCodigoOferta.setForeground(new java.awt.Color(255, 0, 0));
        lbl_existeCodigoOferta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_existeCodigoOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelCodigoOferta.add(lbl_existeCodigoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 97, 670, 40));

        lbl_1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("1");

        javax.swing.GroupLayout panelIzqCodigoOfertaLayout = new javax.swing.GroupLayout(panelIzqCodigoOferta);
        panelIzqCodigoOferta.setLayout(panelIzqCodigoOfertaLayout);
        panelIzqCodigoOfertaLayout.setHorizontalGroup(
            panelIzqCodigoOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelIzqCodigoOfertaLayout.setVerticalGroup(
            panelIzqCodigoOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        PanelCodigoOferta.add(panelIzqCodigoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 150));

        lbl_codigoOferta.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_codigoOferta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigoOferta.setText("CÓDIGO DE OFERTA");
        PanelCodigoOferta.add(lbl_codigoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 410, 40));

        PanelPrincipal.add(PanelCodigoOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 150));

        PanelIdentificaProd.setBackground(new java.awt.Color(230, 204, 178));
        PanelIdentificaProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelIdentificaProd.setForeground(new java.awt.Color(127, 85, 57));
        PanelIdentificaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelIdentificaProdKeyPressed(evt);
            }
        });
        PanelIdentificaProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIzqIdentifica.setPreferredSize(new java.awt.Dimension(50, 100));

        lbl_2.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_2.setText("2");

        javax.swing.GroupLayout panelIzqIdentificaLayout = new javax.swing.GroupLayout(panelIzqIdentifica);
        panelIzqIdentifica.setLayout(panelIzqIdentificaLayout);
        panelIzqIdentificaLayout.setHorizontalGroup(
            panelIzqIdentificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelIzqIdentificaLayout.setVerticalGroup(
            panelIzqIdentificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        PanelIdentificaProd.add(panelIzqIdentifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 360));

        txt_codigoBarra.setFont(new java.awt.Font("Roboto Thin", 0, 22)); // NOI18N
        txt_codigoBarra.setPreferredSize(new java.awt.Dimension(6, 40));
        txt_codigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoBarraActionPerformed(evt);
            }
        });
        txt_codigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoBarraKeyPressed(evt);
            }
        });
        PanelIdentificaProd.add(txt_codigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 330, -1));

        lbl_codigoBarra.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_codigoBarra.setForeground(new java.awt.Color(127, 85, 57));
        lbl_codigoBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        lbl_codigoBarra.setText("ESCANEAR CÓDIGO DE BARRA");
        PanelIdentificaProd.add(lbl_codigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 40));

        lbl_codigoManual.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_codigoManual.setForeground(new java.awt.Color(127, 85, 57));
        lbl_codigoManual.setText("BUSCAR PRODUCTO MANUALMENTE");
        PanelIdentificaProd.add(lbl_codigoManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 370, 40));

        separadorVertical.setBackground(new java.awt.Color(127, 85, 57));
        separadorVertical.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelIdentificaProd.add(separadorVertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 18, 360));

        listaFiltrada.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
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
        jScrollPane2.setViewportView(listaFiltrada);

        PanelIdentificaProd.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 415, 167));

        txt_nombreProducto.setFont(new java.awt.Font("Roboto Thin", 0, 22)); // NOI18N
        txt_nombreProducto.setPreferredSize(new java.awt.Dimension(6, 40));
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
        PanelIdentificaProd.add(txt_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 415, -1));

        PanelTabla.setPreferredSize(new java.awt.Dimension(662, 340));

        tbl_listadoProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_listadoProductos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_listadoProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_listadoProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_listadoProductos.setOpaque(false);
        tbl_listadoProductos.setShowHorizontalLines(false);
        tbl_listadoProductos.setShowVerticalLines(false);
        tbl_listadoProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_listadoProductosKeyPressed(evt);
            }
        });
        PanelTabla.setViewportView(tbl_listadoProductos);

        PanelIdentificaProd.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 662, -1));

        txt_anadir1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_anadir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_anadir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f1_key.png"))); // NOI18N
        txt_anadir1.setText("AÑADIR 1");
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
            .addComponent(txt_anadir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelIdentificaProd.add(btn_anadir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 50, -1, -1));

        btn_restar1.setPreferredSize(new java.awt.Dimension(200, 70));

        txt_restar1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_restar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_restar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f2_key.png"))); // NOI18N
        txt_restar1.setText("RESTAR 1");
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
            .addComponent(txt_restar1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        btn_restar1Layout.setVerticalGroup(
            btn_restar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_restar1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        PanelIdentificaProd.add(btn_restar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 140, -1, -1));

        btn_eliminar1.setPreferredSize(new java.awt.Dimension(200, 70));

        txt_eliminar1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_eliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f3_key.png"))); // NOI18N
        txt_eliminar1.setText("ELIMINAR");
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
            .addComponent(txt_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        btn_eliminar1Layout.setVerticalGroup(
            btn_eliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        PanelIdentificaProd.add(btn_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 230, -1, -1));

        PanelPrincipal.add(PanelIdentificaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 1520, 360));

        PanelDetalleOferta.setBackground(new java.awt.Color(230, 204, 178));
        PanelDetalleOferta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelDetalleOferta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_precioOferta.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_precioOferta.setForeground(new java.awt.Color(127, 85, 57));
        lbl_precioOferta.setText("PRECIO FINAL DE LA OFERTA");
        PanelDetalleOferta.add(lbl_precioOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 290, 30));

        txt_precioOferta.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        txt_precioOferta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_precioOferta.setText("$0");
        txt_precioOferta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_precioOfertaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_precioOfertaFocusLost(evt);
            }
        });
        txt_precioOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioOfertaKeyTyped(evt);
            }
        });
        PanelDetalleOferta.add(txt_precioOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 175, 33));

        lbl_nombreOferta.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_nombreOferta.setForeground(new java.awt.Color(127, 85, 57));
        lbl_nombreOferta.setText("NOMBRE DE LA OFERTA");
        PanelDetalleOferta.add(lbl_nombreOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 30));

        txt_nombreOferta.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        PanelDetalleOferta.add(txt_nombreOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 450, 31));

        panelIzqDetalle.setPreferredSize(new java.awt.Dimension(43, 100));

        lbl_3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_3.setText("3");

        javax.swing.GroupLayout panelIzqDetalleLayout = new javax.swing.GroupLayout(panelIzqDetalle);
        panelIzqDetalle.setLayout(panelIzqDetalleLayout);
        panelIzqDetalleLayout.setHorizontalGroup(
            panelIzqDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelIzqDetalleLayout.setVerticalGroup(
            panelIzqDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        PanelDetalleOferta.add(panelIzqDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 190));

        PanelPrincipal.add(PanelDetalleOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 890, 190));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  CREAR OFERTA");
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
        PanelPrincipal.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 40));

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

        PanelPrincipal.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 0, 40, 40));

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

        PanelPrincipal.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 0, 40, 40));

        txt_crearOferta.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_crearOferta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_crearOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sale.png"))); // NOI18N
        txt_crearOferta.setText("CREAR OFERTA");
        txt_crearOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_crearOfertaLayout = new javax.swing.GroupLayout(btn_crearOferta);
        btn_crearOferta.setLayout(btn_crearOfertaLayout);
        btn_crearOfertaLayout.setHorizontalGroup(
            btn_crearOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        btn_crearOfertaLayout.setVerticalGroup(
            btn_crearOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelPrincipal.add(btn_crearOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 650, 290, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoBarraActionPerformed
        if(actualizarListado){
            
            productos = CON_PRODUCTO.listarProductos();
            actualizarProductos();
            actualizarListado = false;
        }
        threadAutomatico.run();
        txt_codigoBarra.setText("");

    }//GEN-LAST:event_txt_codigoBarraActionPerformed

    private void txt_codigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBarraKeyPressed

    }//GEN-LAST:event_txt_codigoBarraKeyPressed

    private void txt_nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreProductoActionPerformed
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoActionPerformed

    private void txt_nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreProductoKeyReleased
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoKeyReleased

    private void PanelIdentificaProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelIdentificaProdKeyPressed

    }//GEN-LAST:event_PanelIdentificaProdKeyPressed

    private void txt_codigoOfertaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoOfertaFocusLost
        String codigo = txt_codigoOferta.getText();
        if(codigo.equals("")){
            lbl_existeCodigoOferta.setText("");
            return;
        }
        if(CON_PRODUCTO.existeCodigo(codigo)){
            lbl_existeCodigoOferta.setForeground(new Color(142, 0, 25));
            lbl_existeCodigoOferta.setText("¡Código ya registrado!, intente con otro.");
            txt_codigoOferta.requestFocus();
        }
        else{
            lbl_existeCodigoOferta.setForeground(new Color(34, 147, 39));
            lbl_existeCodigoOferta.setText("¡Código disponible!");
        }
    }//GEN-LAST:event_txt_codigoOfertaFocusLost

    private void listaFiltradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaFiltradaMouseClicked
        if (evt.getClickCount() == 2) {
            threadManual.run();            
        }
    }//GEN-LAST:event_listaFiltradaMouseClicked

    private void listaFiltradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaFiltradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            threadManual.run();
        }
                
    }//GEN-LAST:event_listaFiltradaKeyPressed


    
    private void tbl_listadoProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_listadoProductosKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F1){
            sumar_item();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            restar_item();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F3){
            eliminar_item();
        }
    }//GEN-LAST:event_tbl_listadoProductosKeyPressed

    private void txt_precioOfertaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioOfertaKeyTyped
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_precioOfertaKeyTyped

    private void txt_precioOfertaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_precioOfertaFocusGained
        txt_precioOferta.setText("");
    }//GEN-LAST:event_txt_precioOfertaFocusGained

    private void format_precio(){
        if(txt_precioOferta.getText().equals("")) txt_precioOferta.setText("$0");
        else{
            String valor = txt_precioOferta.getText().replace("$", "").replace(".", "");
            txt_precioOferta.setText(String.format("$%,d",Integer.valueOf(valor)));
        }        
    }
    
    private void txt_precioOfertaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_precioOfertaFocusLost
        format_precio();
    }//GEN-LAST:event_txt_precioOfertaFocusLost

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

    private void txt_crearOfertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseEntered
        btn_crearOferta.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_crearOfertaMouseEntered

    private void txt_crearOfertaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseExited
        btn_crearOferta.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_crearOfertaMouseExited

    private void txt_crearOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMousePressed
        if(evt.getButton() == 1){
            btn_crearOferta.setBackground(mouseClickPanelColor);
            format_precio();
            if(txt_codigoOferta.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar un código para la oferta", "Sin codigo de oferta", JOptionPane.ERROR_MESSAGE);
                txt_codigoOferta.requestFocus();
                return;
            }
            else if(tbl_listadoProductos.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Debe ingresar al menos un producto a la oferta", "Sin productos", JOptionPane.ERROR_MESSAGE);
                txt_codigoBarra.requestFocus();
                return;
            }
            else if(txt_precioOferta.getText().equals("") || txt_precioOferta.getText().equals("$0")){
                JOptionPane.showMessageDialog(this, "El precio de la oferta no puede ser 0", "Precio incorrecto", JOptionPane.ERROR_MESSAGE);
                txt_precioOferta.requestFocus();
                return;
            }
            else if(txt_nombreOferta.getText().length() < 5){
                JOptionPane.showMessageDialog(this, "El nombre de la oferta es demasiado corto", "Nombre de oferta incorrecto", JOptionPane.ERROR_MESSAGE);
                txt_nombreOferta.requestFocus();
                return;
            }

            ArrayList<String[]> codigoProductos = new ArrayList<>();
            DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();

            for(int i = 0; i < table.getRowCount(); i++){
                String[] tupla = {(String)table.getValueAt(i, 0),String.valueOf(table.getValueAt(i, 2))};
                codigoProductos.add(tupla);
            }
            String precioFormateado = txt_precioOferta.getText().replace(".", "").replace("$", "");
            int precioOferta = Integer.parseInt(precioFormateado);
            if(CON_PRODUCTO.crearOferta(codigoProductos,precioOferta, txt_codigoOferta.getText(), txt_nombreOferta.getText())){
                JOptionPane.showMessageDialog(this, "Oferta creada con exito, ya se puede utilizar en modulo de ventas", "Oferta creada", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_txt_crearOfertaMousePressed

    private void txt_crearOfertaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseReleased
        btn_crearOferta.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_crearOfertaMouseReleased

    private void txt_anadir1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseEntered
       btn_anadir1.setBackground(verdeMouseEnter);
    }//GEN-LAST:event_txt_anadir1MouseEntered

    private void txt_anadir1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseExited
        btn_anadir1.setBackground(verde);
    }//GEN-LAST:event_txt_anadir1MouseExited

    private void txt_anadir1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MousePressed
            if(evt.getButton() == 1){
                        btn_anadir1.setBackground(verdeClick);
                        sumar_item();
            }
        
    }//GEN-LAST:event_txt_anadir1MousePressed

    private void txt_anadir1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_anadir1MouseReleased
        btn_anadir1.setBackground(verdeMouseEnter);
    }//GEN-LAST:event_txt_anadir1MouseReleased

    private void txt_restar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseEntered
        btn_restar1.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_txt_restar1MouseEntered

    private void txt_restar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseExited
        btn_restar1.setBackground(rojo);
    }//GEN-LAST:event_txt_restar1MouseExited

    private void txt_restar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MousePressed
        if(evt.getButton() == 1){
            btn_restar1.setBackground(rojoClick);
            restar_item();
        }
    }//GEN-LAST:event_txt_restar1MousePressed

    private void txt_restar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_restar1MouseReleased
        btn_restar1.setBackground(rojoMouseEnter);
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
            eliminar_item();
        }
    }//GEN-LAST:event_txt_eliminar1MousePressed

    private void txt_eliminar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eliminar1MouseReleased
        btn_eliminar1.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_txt_eliminar1MouseReleased
    
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }
    
    
    public void restar_item(){
            try {
                        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
                       int row = tbl_listadoProductos.getSelectedRow();
                        if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                                   int cantidad = (int) table.getValueAt(row, 2);
                                   if(cantidad -1 > 0){
                                               table.setValueAt(cantidad-1, row, 2);
                                   }
                       }
            } catch (Exception e) {
                        System.out.println("NADA SELECCIONADO");
            }
           
    }
    
    public void eliminar_item(){
        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
        try{
            table.removeRow(tbl_listadoProductos.getSelectedRow());
        }
        catch(Exception e){
            System.out.println("NADA SELECCIONADO");
        }    
    }
    
    public void sumar_item(){
            try {
                        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
                        int row = tbl_listadoProductos.getSelectedRow();
                        if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                                    int cantidad = (int) table.getValueAt(row, 2);
                                    table.setValueAt(cantidad+1, row, 2);

                        }   
            } catch (Exception e) {
                            System.out.println("NADA SELECCIONADO");
            }
        
    }
    
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
            java.util.logging.Logger.getLogger(CrearOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearOferta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelCodigoOferta;
    private javax.swing.JPanel PanelDetalleOferta;
    private javax.swing.JPanel PanelIdentificaProd;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JScrollPane PanelTabla;
    private javax.swing.JPanel btn_anadir1;
    private javax.swing.JPanel btn_crearOferta;
    private javax.swing.JPanel btn_eliminar1;
    private javax.swing.JPanel btn_restar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_codigoBarra;
    private javax.swing.JLabel lbl_codigoManual;
    private javax.swing.JLabel lbl_codigoOferta;
    private javax.swing.JLabel lbl_existeCodigoOferta;
    private javax.swing.JLabel lbl_nombreOferta;
    private javax.swing.JLabel lbl_precioOferta;
    private javax.swing.JList<String> listaFiltrada;
    private javax.swing.JPanel panelIzqCodigoOferta;
    private javax.swing.JPanel panelIzqDetalle;
    private javax.swing.JPanel panelIzqIdentifica;
    private javax.swing.JSeparator separadorVertical;
    private javax.swing.JTable tbl_listadoProductos;
    private javax.swing.JLabel txt_anadir1;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JTextField txt_codigoOferta;
    private javax.swing.JLabel txt_crearOferta;
    private javax.swing.JLabel txt_eliminar1;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombreOferta;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_precioOferta;
    private javax.swing.JLabel txt_restar1;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables
}
