package vista;

import controlador.ConColores;
import controlador.ConProducto;
import controlador.ConVenta;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.PaletaColor;
import modelo.Producto;
import modelo.Venta;
import modelo.VentaProducto;


public class NuevaVenta extends javax.swing.JFrame {
    ArrayList<Producto> productos;
    private boolean actualizarListado;
    
    ConProducto CON_PRODUCTO = new ConProducto();
    ArrayList<String> listaNoSeMuestra = CON_PRODUCTO.listarDescartados();
    
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

    
    public NuevaVenta() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Modulo venta");
        
        productos = CON_PRODUCTO.listarProductos();
        
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        table.setRowCount(0);
        actualizarProductos();
        actualizarListado = false;
        
        lbl_confirmandoVenta.setText("Ingrese un producto para iniciar una venta");
        lbl_confirmandoVenta.setForeground(Color.red);
        tbl_detalleVenta.getTableHeader().setReorderingAllowed(false);
        tbl_detalleVenta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //829
        tbl_detalleVenta.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbl_detalleVenta.getColumnModel().getColumn(0).setMinWidth(150);
        tbl_detalleVenta.getColumnModel().getColumn(0).setMaxWidth(150);
        tbl_detalleVenta.getColumnModel().getColumn(1).setPreferredWidth(370);
        tbl_detalleVenta.getColumnModel().getColumn(1).setMinWidth(370);
        tbl_detalleVenta.getColumnModel().getColumn(1).setMaxWidth(370);
        tbl_detalleVenta.getColumnModel().getColumn(2).setPreferredWidth(110);
        tbl_detalleVenta.getColumnModel().getColumn(2).setMinWidth(110);
        tbl_detalleVenta.getColumnModel().getColumn(2).setMaxWidth(110);
        tbl_detalleVenta.getColumnModel().getColumn(3).setPreferredWidth(87);
        tbl_detalleVenta.getColumnModel().getColumn(3).setMinWidth(87);
        tbl_detalleVenta.getColumnModel().getColumn(3).setMaxWidth(87);        
        tbl_detalleVenta.getColumnModel().getColumn(4).setPreferredWidth(110);    
        tbl_detalleVenta.getColumnModel().getColumn(4).setMinWidth(110);
        tbl_detalleVenta.getColumnModel().getColumn(4).setMaxWidth(110);      
        
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
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl_detalleVenta.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
        seleccionEfectivo();
        
        //COLORES
        Background.setBackground(BackgroundColor);
        PanelPaso1.setBackground(PanelColor);
        PanelProducto.setBackground(BackgroundColor);
        PanelMetodoPago.setBackground(BackgroundColor);
        PanelTotal.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);       
        txt_tituloVentana.setForeground(textColor);
        //rb_credito.setBackground(BackgroundColor);
        //rb_debito.setBackground(BackgroundColor);
        rb_debito.setVisible(false);
        rb_credito.setVisible(false);
        img_debito.setVisible(false);
        img_credito.setVisible(false);
                
        
        rb_sumup.setBackground(BackgroundColor);
        rb_efectivo.setBackground(BackgroundColor);
        rb_transferencia.setBackground(BackgroundColor);
        //rb_credito.setForeground(textColor);
        //rb_debito.setForeground(textColor);
        rb_sumup.setForeground(textColor);
        rb_efectivo.setForeground(textColor);
        rb_transferencia.setForeground(textColor);
        lbl_buscarManual.setForeground(textColor);
        lbl_escanearCodigo.setForeground(textColor);
        lbl_pagaCon.setForeground(textColor);
        lbl_total.setForeground(textColor);
        lbl_vuelto.setForeground(textColor);
        PanelTotal.setBorder(BorderFactory.createTitledBorder(null, "RESUMEN DE VENTA", TitledBorder.CENTER, TitledBorder.TOP, new Font("Roboto",Font.BOLD,24), textColor));
        lbl_1.setForeground(mouseEnterPanelColor);
        PanelPaso2.setBackground(PanelColor);
        lbl_2.setForeground(mouseEnterPanelColor);
        btn_anadir1.setBackground(verde);
        btn_restar1.setBackground(rojo);
        btn_eliminar1.setBackground(rojo);
        scrollPanelDetalleVenta.setBackground(PanelColor);
        btn_calcularVuelto.setBackground(PanelColor);
        btn_crearVenta.setBackground(verde);
        btn_salir.setBackground(rojo);
        lbl_totalProductos.setForeground(mouseEnterPanelColor);
        lbl_metodoPago.setForeground(mouseEnterPanelColor);
        lbl_warning.setVisible(false);
        txt_codigoBarra.requestFocus();
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

    public void reiniciarModulo(){                
        NuevaVenta ventana = new NuevaVenta();
        ventana.setVisible(true);
        this.dispose();        
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

                switch (p.getCodigo_barra()) {
                    case "CODIGOPAN":
                        {
                            String precio = (String)JOptionPane.showInputDialog(
                                    null,
                                    "Ingrese el precio del pan",
                                    "Precio del Pan",
                                    JOptionPane.PLAIN_MESSAGE);
                            int int_precio = 0;
                            try {
                                int_precio = Integer.valueOf(precio);
                            }
                            catch (Exception e) {
                                int_precio = -1;
                            }       if(int_precio > 0){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    int_precio,
                                    1,
                                    String.format("$%,d",Integer.valueOf(precio))
                                };
                                table.addRow(fila);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido", "Precio incorrecto",JOptionPane.INFORMATION_MESSAGE);
                            }       break;
                        }
                    case "NN0000":
                        {
                            String precio = (String)JOptionPane.showInputDialog(
                                    null,
                                    "Ingrese el precio del producto",
                                    "Precio del NN",
                                    JOptionPane.PLAIN_MESSAGE);
                            int int_precio = 0;
                            try {
                                int_precio = Integer.valueOf(precio);
                            }
                            catch (Exception e) {
                                int_precio = -1;
                            }       if(int_precio > 0){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    int_precio,
                                    1,
                                    String.format("$%,d",Integer.valueOf(precio))
                                };
                                table.addRow(fila);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido", "Precio incorrecto",JOptionPane.INFORMATION_MESSAGE);
                            }       break;
                        }
                    default:
                        if(filas == 0){
                            Object fila[] = {
                                p.getCodigo_barra(),
                                p.getNombre(),
                                p.getPrecio(),
                                1,
                                String.format("$%,d",Integer.valueOf(p.getPrecio()))
                            };
                            table.addRow(fila);    
                        }
                        else{
                            boolean existe = false;   
                            for(int i = 0; i< table.getRowCount(); i ++){
                                if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                                    int cantidad = (int) table.getValueAt(i, 3)+1;
                                    table.setValueAt(cantidad, i, 3);
                                    String valorTotal = String.format("$%,d", cantidad*(int)table.getValueAt(i, 2));
                                    table.setValueAt(valorTotal, i, 4);
                                    existe=true;
                                    break;
                                }
                            }
                            if(!existe){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    p.getPrecio(),
                                    1,
                                    String.format("$%,d",Integer.valueOf(p.getPrecio()))
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
                    
                    switch (p.getCodigo_barra()) {
                        case "CODIGOPAN":
                            {
                                String precio = (String)JOptionPane.showInputDialog(
                                        null,
                                        "Ingrese el precio del pan",
                                        "Precio del Pan",
                                        JOptionPane.PLAIN_MESSAGE);
                                int int_precio = 0;
                                try {
                                    int_precio = Integer.valueOf(precio);
                                }
                                catch (Exception e) {
                                    int_precio = -1;
                                }       if(int_precio > 0){
                                    Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),
                                        int_precio,
                                        1,
                                        String.format("$%,d",Integer.valueOf(precio))
                                    };
                                    table.addRow(fila);
                                }
                                
                                else{
                                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido", "Precio incorrecto",JOptionPane.INFORMATION_MESSAGE);
                                    
                                }       break;
                            }
                        case "NN0000":
                            {
                                String precio = (String)JOptionPane.showInputDialog(
                                        null,
                                        "Ingrese el precio del producto",
                                        "Precio del codigo NN",
                                        JOptionPane.PLAIN_MESSAGE);
                                int int_precio;
                                try {
                                    int_precio = Integer.valueOf(precio);
                                }
                                catch (Exception e) {
                                    int_precio = -1;
                                }       if(int_precio > 0){
                                    Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),
                                        int_precio,
                                        1,
                                        String.format("$%,d",Integer.valueOf(precio))
                                    };
                                    table.addRow(fila);
                                }
                                
                                else{
                                    JOptionPane.showMessageDialog(null, "Debe ingresar un monto valido", "Precio incorrecto",JOptionPane.INFORMATION_MESSAGE);
                                    
                                }       break;
                            }
                        default:
                            if(filas == 0){
                                Object fila[] = {
                                    p.getCodigo_barra(),
                                    p.getNombre(),
                                    p.getPrecio(),
                                    1,
                                    String.format("$%,d",Integer.valueOf(p.getPrecio()))
                                };
                                table.addRow(fila);    
                            }
                            else{
                                boolean existe = false;
                                for(int i = 0; i< table.getRowCount(); i ++){
                                    if(table.getValueAt(i, 0).toString().equals(p.getCodigo_barra())){
                                        int cantidad = (int) table.getValueAt(i, 3)+1;
                                        table.setValueAt(cantidad, i, 3);
                                        String valorTotal = String.format("$%,d", cantidad*(int)table.getValueAt(i, 2));
                                        table.setValueAt(valorTotal, i, 4);
                                        existe=true;
                                        break;
                                    }
                                }
                                if(!existe){
                                    Object fila[] = {
                                        p.getCodigo_barra(),
                                        p.getNombre(),
                                        p.getPrecio(),
                                        1,
                                        String.format("$%,d",Integer.valueOf(p.getPrecio()))
                                    };
                                    table.addRow(fila);
                                }
                            }   break;
                    }
                }                       
                threadPRECIO.run();                
                txt_nombreProducto.setText("");
                DefaultListModel dl = new DefaultListModel();
                dl.clear();
                listaFiltrada.setModel(dl);
                }
            }            
     });
    
    
    
    Thread threadPRECIO = new Thread(new Runnable() {
        @Override
        public void run() {
            int cantidadGeneral = 0;
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int totalgeneral = 0;
            for(int i = 0; i< table.getRowCount(); i ++){                
                int cantidad = (int) table.getValueAt(i, 3);
                int precio = (int) table.getValueAt(i, 2);
                totalgeneral = totalgeneral + (cantidad*precio);
                cantidadGeneral += cantidad;
            }
            lbl_totalProductos.setText(String.valueOf(cantidadGeneral)+" PRODUCTO[S]");
            lbl_total.setText(String.format("$%,d",totalgeneral));
            txt_pagoEfectivo.setText(String.format("$%,d",totalgeneral));
            txt_codigoBarra.requestFocus();
            if(table.getRowCount()>0){
                lbl_confirmandoVenta.setText("Venta en progreso.");
                lbl_confirmandoVenta.setForeground(textColor);
            }
            else{
                lbl_confirmandoVenta.setText("Ingrese un producto para iniciar una venta");
                lbl_confirmandoVenta.setForeground(rojo);
            }
            
        }
    });
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_METODOPAGO = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        PanelProducto = new javax.swing.JPanel();
        txt_codigoBarra = new javax.swing.JTextField();
        lbl_escanearCodigo = new javax.swing.JLabel();
        lbl_buscarManual = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        txt_nombreProducto = new javax.swing.JTextField();
        scrollPanelDetalleVenta = new javax.swing.JScrollPane();
        tbl_detalleVenta = new javax.swing.JTable();
        PanelPaso1 = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        btn_anadir1 = new javax.swing.JPanel();
        txt_anadir1 = new javax.swing.JLabel();
        btn_restar1 = new javax.swing.JPanel();
        txt_restar1 = new javax.swing.JLabel();
        btn_eliminar1 = new javax.swing.JPanel();
        txt_eliminar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaFiltrada = new javax.swing.JList<>();
        PanelTotal = new javax.swing.JPanel();
        lbl_total = new javax.swing.JLabel();
        lbl_totalProductos = new javax.swing.JLabel();
        lbl_metodoPago = new javax.swing.JLabel();
        PanelMetodoPago = new javax.swing.JPanel();
        rb_debito = new javax.swing.JRadioButton();
        rb_credito = new javax.swing.JRadioButton();
        rb_efectivo = new javax.swing.JRadioButton();
        lbl_pagaCon = new javax.swing.JLabel();
        txt_pagoEfectivo = new javax.swing.JTextField();
        lbl_vuelto = new javax.swing.JLabel();
        txt_vuelto = new javax.swing.JTextField();
        img_debito = new javax.swing.JLabel();
        img_efectivo = new javax.swing.JLabel();
        img_credito = new javax.swing.JLabel();
        rb_transferencia = new javax.swing.JRadioButton();
        img_transferencia = new javax.swing.JLabel();
        rb_sumup = new javax.swing.JRadioButton();
        img_sumup = new javax.swing.JLabel();
        PanelPaso2 = new javax.swing.JPanel();
        lbl_2 = new javax.swing.JLabel();
        btn_calcularVuelto = new javax.swing.JPanel();
        txt_calcularVuelto = new javax.swing.JLabel();
        lbl_warning = new javax.swing.JLabel();
        lbl_confirmandoVenta = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        btn_crearVenta = new javax.swing.JPanel();
        txt_crearVenta = new javax.swing.JLabel();
        btn_salir = new javax.swing.JPanel();
        txt_salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(230, 204, 178));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setPreferredSize(new java.awt.Dimension(1924, 1045));
        Background.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BackgroundKeyPressed(evt);
            }
        });
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        txt_codigoBarra.setPreferredSize(new java.awt.Dimension(420, 40));
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
                "COD. PRODUCTO", "NOMBRE", "PRECIO (UN.)", "CANTIDAD", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        lbl_1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("1");

        javax.swing.GroupLayout PanelPaso1Layout = new javax.swing.GroupLayout(PanelPaso1);
        PanelPaso1.setLayout(PanelPaso1Layout);
        PanelPaso1Layout.setHorizontalGroup(
            PanelPaso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        PanelPaso1Layout.setVerticalGroup(
            PanelPaso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(PanelPaso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
                .addComponent(PanelPaso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        Background.add(PanelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1650, 380));

        PanelTotal.setBackground(new java.awt.Color(230, 204, 178));
        PanelTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        PanelTotal.setForeground(new java.awt.Color(127, 85, 57));
        PanelTotal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_total.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(127, 85, 57));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("$0");
        PanelTotal.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 49, 490, 76));

        lbl_totalProductos.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbl_totalProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totalProductos.setText("0 PRODUCTO[S]");
        PanelTotal.add(lbl_totalProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 140, 490, 39));

        lbl_metodoPago.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lbl_metodoPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_metodoPago.setText("MÉTODO DE PAGO: EFECTIVO");
        PanelTotal.add(lbl_metodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 195, 510, 40));

        Background.add(PanelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 588, 520, 260));

        PanelMetodoPago.setBackground(new java.awt.Color(230, 204, 178));
        PanelMetodoPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelMetodoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelMetodoPagoKeyPressed(evt);
            }
        });
        PanelMetodoPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rb_debito.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_debito);
        rb_debito.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_debito.setForeground(new java.awt.Color(127, 85, 57));
        rb_debito.setText("DÉBITO");
        rb_debito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_debitoActionPerformed(evt);
            }
        });
        rb_debito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_debitoKeyPressed(evt);
            }
        });
        PanelMetodoPago.add(rb_debito, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 180, 40));

        rb_credito.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_credito);
        rb_credito.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_credito.setForeground(new java.awt.Color(127, 85, 57));
        rb_credito.setText("CRÉDITO");
        rb_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_creditoActionPerformed(evt);
            }
        });
        rb_credito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_creditoKeyPressed(evt);
            }
        });
        PanelMetodoPago.add(rb_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 180, 40));

        rb_efectivo.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_efectivo);
        rb_efectivo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_efectivo.setForeground(new java.awt.Color(127, 85, 57));
        rb_efectivo.setText("EFECTIVO");
        rb_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_efectivoActionPerformed(evt);
            }
        });
        rb_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_efectivoKeyPressed(evt);
            }
        });
        PanelMetodoPago.add(rb_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 180, 40));

        lbl_pagaCon.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lbl_pagaCon.setLabelFor(txt_pagoEfectivo);
        lbl_pagaCon.setText("PAGA CON:");
        PanelMetodoPago.add(lbl_pagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        txt_pagoEfectivo.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        txt_pagoEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_pagoEfectivo.setText("$0");
        txt_pagoEfectivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_pagoEfectivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_pagoEfectivoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_pagoEfectivoFocusLost(evt);
            }
        });
        txt_pagoEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pagoEfectivoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pagoEfectivoKeyTyped(evt);
            }
        });
        PanelMetodoPago.add(txt_pagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 120, 40));

        lbl_vuelto.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        lbl_vuelto.setLabelFor(txt_vuelto);
        lbl_vuelto.setText("VUELTO:");
        PanelMetodoPago.add(lbl_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        txt_vuelto.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        txt_vuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_vuelto.setText("$0");
        txt_vuelto.setBorder(null);
        txt_vuelto.setEnabled(false);
        PanelMetodoPago.add(txt_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 120, 40));

        img_debito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/debito.png"))); // NOI18N
        PanelMetodoPago.add(img_debito, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 50, 51));

        img_efectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/efectivo.png"))); // NOI18N
        PanelMetodoPago.add(img_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 50, 51));

        img_credito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/credito.png"))); // NOI18N
        PanelMetodoPago.add(img_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 50, 37));

        rb_transferencia.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_transferencia);
        rb_transferencia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_transferencia.setForeground(new java.awt.Color(127, 85, 57));
        rb_transferencia.setText("TRANSFERENCIA");
        rb_transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_transferenciaActionPerformed(evt);
            }
        });
        rb_transferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_transferenciaKeyPressed(evt);
            }
        });
        PanelMetodoPago.add(rb_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 180, 40));

        img_transferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transferencia.png"))); // NOI18N
        PanelMetodoPago.add(img_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 50, -1));

        rb_sumup.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_sumup);
        rb_sumup.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rb_sumup.setForeground(new java.awt.Color(127, 85, 57));
        rb_sumup.setText("SUM UP");
        rb_sumup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_sumupActionPerformed(evt);
            }
        });
        rb_sumup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_sumupKeyPressed(evt);
            }
        });
        PanelMetodoPago.add(rb_sumup, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, 40));

        img_sumup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/debito.png"))); // NOI18N
        PanelMetodoPago.add(img_sumup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 50, -1));

        PanelPaso2.setPreferredSize(new java.awt.Dimension(70, 518));

        lbl_2.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        lbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_2.setText("2");

        javax.swing.GroupLayout PanelPaso2Layout = new javax.swing.GroupLayout(PanelPaso2);
        PanelPaso2.setLayout(PanelPaso2Layout);
        PanelPaso2Layout.setHorizontalGroup(
            PanelPaso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        PanelPaso2Layout.setVerticalGroup(
            PanelPaso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPaso2Layout.createSequentialGroup()
                .addComponent(lbl_2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelMetodoPago.add(PanelPaso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        btn_calcularVuelto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_calcularVuelto.setPreferredSize(new java.awt.Dimension(200, 40));

        txt_calcularVuelto.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txt_calcularVuelto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_calcularVuelto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calculadora.png"))); // NOI18N
        txt_calcularVuelto.setText("CALCULAR VUELTO");
        txt_calcularVuelto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_calcularVuelto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_calcularVueltoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_calcularVueltoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_calcularVueltoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_calcularVueltoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_calcularVueltoLayout = new javax.swing.GroupLayout(btn_calcularVuelto);
        btn_calcularVuelto.setLayout(btn_calcularVueltoLayout);
        btn_calcularVueltoLayout.setHorizontalGroup(
            btn_calcularVueltoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_calcularVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );
        btn_calcularVueltoLayout.setVerticalGroup(
            btn_calcularVueltoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_calcularVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        PanelMetodoPago.add(btn_calcularVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        lbl_warning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/warning_256.png"))); // NOI18N
        PanelMetodoPago.add(lbl_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 250, 240));

        Background.add(PanelMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 930, 500));

        lbl_confirmandoVenta.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbl_confirmandoVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_confirmandoVenta.setText("estado_venta");
        Background.add(lbl_confirmandoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 450, 520, 35));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  MODULO DE VENTAS");
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
        Background.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1740, 40));

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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 0, 40, 40));

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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 0, 40, 40));

        btn_crearVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_crearVenta.setPreferredSize(new java.awt.Dimension(255, 100));

        txt_crearVenta.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_crearVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_crearVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/f10_key.png"))); // NOI18N
        txt_crearVenta.setText("CONFIRMAR VENTA");
        txt_crearVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_crearVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_crearVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_crearVentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_crearVentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_crearVentaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_crearVentaLayout = new javax.swing.GroupLayout(btn_crearVenta);
        btn_crearVenta.setLayout(btn_crearVentaLayout);
        btn_crearVentaLayout.setHorizontalGroup(
            btn_crearVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        btn_crearVentaLayout.setVerticalGroup(
            btn_crearVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        );

        Background.add(btn_crearVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1152, 865, 255, -1));

        btn_salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_salir.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/esc_key.png"))); // NOI18N
        txt_salir.setText("SALIR");
        txt_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_salirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_salirMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_salirLayout = new javax.swing.GroupLayout(btn_salir);
        btn_salir.setLayout(btn_salirLayout);
        btn_salirLayout.setHorizontalGroup(
            btn_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_salir, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        btn_salirLayout.setVerticalGroup(
            btn_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_salir, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
        );

        Background.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1413, 865, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 1820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoBarraActionPerformed
        if(actualizarListado){
            ConProducto cProducto = new ConProducto();
            productos = cProducto.listarProductos();
            actualizarProductos();
            actualizarListado = false;
        }
        threadAutomatico.run();
        txt_codigoBarra.setText("");
        threadPRECIO.run();
    }//GEN-LAST:event_txt_codigoBarraActionPerformed

    private void sinSeleccionMetodoPago(){
        JOptionPane.showMessageDialog(this, "[ERROR] ¡DEBES SELECCIONAR UN MÉTODO DE PAGO PARA LA VENTA!", "Venta erronea", JOptionPane.INFORMATION_MESSAGE);
        PanelMetodoPago.setBorder(BorderFactory.createLineBorder(Color.red));
        PanelPaso2.setBackground(rojo);
        txt_codigoBarra.setEnabled(false);
        txt_nombreProducto.setEnabled(false);
        lbl_confirmandoVenta.setText("DEBE SELECCIONAR MÉTODO DE PAGO");
        lbl_confirmandoVenta.setForeground(rojo);
        lbl_warning.setVisible(true);
        lbl_2.setForeground(Color.white);
    }
    
    
    private void pressF10_ESC(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == KeyEvent.VK_F10){
            if(tbl_detalleVenta.getRowCount() > 0){
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                if(seleccion().equals("NADA SELECCIONADO")){
                    sinSeleccionMetodoPago();
                    return;
                }                
                Venta venta = new Venta();
                ArrayList<VentaProducto> lista = new ArrayList<>();

                venta.setTipo_venta(seleccion());
                venta.setTotal(Integer.parseInt(lbl_total.getText().replace(".", "").replace("$", "")));
                for(int i = 0; i< table.getRowCount(); i ++){                
                    String codigo_barra = table.getValueAt(i, 0).toString();
                    int cantidad = (int) table.getValueAt(i, 3);
                    int precio = (int)table.getValueAt(i, 2);
                    int valorTotal = cantidad*precio;
                    VentaProducto vp = new VentaProducto();
                    vp.setCodigo_barra(codigo_barra);
                    vp.setCantidad(cantidad);
                    vp.setTotal(valorTotal);
                    lista.add(vp);
                }

                ConVenta cVenta = new ConVenta();
                boolean operacion = cVenta.registrarVenta(venta, lista, this,lbl_confirmandoVenta);
                if(operacion){                         
                    reiniciarModulo();
                }                

            }
            else{
                JOptionPane.showMessageDialog(this, "Ningun producto ingresado", "Error ingresando venta", JOptionPane.ERROR_MESSAGE);                    
            }
            

        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(tbl_detalleVenta.getRowCount() == 0){
                this.dispose();
            }
            else if(tbl_detalleVenta.getRowCount() > 0){
                int cerrar = JOptionPane.showConfirmDialog(this, "Existen productos ingresados, si cierra esta ventana se perderán. ¿Desea continuar?", "Confirmacion de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(cerrar == JOptionPane.YES_OPTION){
                    this.dispose();
                }
            } 
        }     
    }
    
    
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
                    threadPRECIO.run();
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
                        threadPRECIO.run();
                        tbl_detalleVenta.requestFocus();
                    }       break;
                }
            case KeyEvent.VK_F3:
                {
                    DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                    try{
                        table.removeRow(tbl_detalleVenta.getSelectedRow());
                        threadPRECIO.run();
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
            case KeyEvent.VK_F10:
                pressF10_ESC(evt);
                break;
            case KeyEvent.VK_ESCAPE:
                pressF10_ESC(evt);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_tbl_detalleVentaKeyPressed

    private void txt_pagoEfectivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pagoEfectivoFocusGained
        txt_pagoEfectivo.setText("");        
    }//GEN-LAST:event_txt_pagoEfectivoFocusGained

    private void txt_pagoEfectivoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pagoEfectivoFocusLost
        if(txt_pagoEfectivo.getText().equals("")) txt_pagoEfectivo.setText("$0");
        else{
            String valor = txt_pagoEfectivo.getText().replace("$", "").replace(".", "");
            txt_pagoEfectivo.setText(String.format("$%,d",Integer.valueOf(valor)));
        }
    }//GEN-LAST:event_txt_pagoEfectivoFocusLost

    private void txt_pagoEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pagoEfectivoKeyTyped
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_pagoEfectivoKeyTyped
       
    private void rb_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_creditoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_creditoActionPerformed

    private void rb_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_efectivoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_efectivoActionPerformed

    private void rb_debitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_debitoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_debitoActionPerformed

    private void txt_codigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBarraKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_txt_codigoBarraKeyPressed

    private void BackgroundKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BackgroundKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_BackgroundKeyPressed

    private void rb_efectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_efectivoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_efectivoKeyPressed

    private void txt_pagoEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pagoEfectivoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_txt_pagoEfectivoKeyPressed

    private void rb_debitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_debitoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_debitoKeyPressed

    private void rb_creditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_creditoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_creditoKeyPressed

    private void PanelMetodoPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelMetodoPagoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_PanelMetodoPagoKeyPressed

    private void PanelProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PanelProductoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_PanelProductoKeyPressed

    private void txt_nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreProductoActionPerformed
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoActionPerformed

    private void txt_nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreProductoKeyReleased
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoKeyReleased

    private void rb_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_transferenciaActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_transferenciaActionPerformed

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
                    int cantidad = (int) table.getValueAt(row, 3);
                    table.setValueAt(cantidad+1, row, 3);
                    int precio = (int)table.getValueAt(row, 2);
                    String valorTotal = String.format("$%,d", (cantidad + 1)*precio);
                    table.setValueAt(valorTotal, row, 4); 
                    lostFocus(null, tbl_detalleVenta);
                    threadPRECIO.run();                 
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
                    int cantidad = (int) table.getValueAt(row, 3);
                    if(cantidad -1 > 0){
                        table.setValueAt(cantidad-1, row, 3);
                        int precio = (int)table.getValueAt(row, 2);
                        String valorTotal = String.format("$%,d", (cantidad -1) *precio);
                        table.setValueAt(valorTotal, row, 4); 
                        lostFocus(null, tbl_detalleVenta);
                        threadPRECIO.run();
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
                threadPRECIO.run();
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

    private void txt_calcularVueltoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_calcularVueltoMouseEntered
        if(btn_calcularVuelto.isEnabled()){
            btn_calcularVuelto.setBackground(mouseEnterPanelColor);
        }
    }//GEN-LAST:event_txt_calcularVueltoMouseEntered

    private void txt_calcularVueltoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_calcularVueltoMouseExited
        if(btn_calcularVuelto.isEnabled()){
            btn_calcularVuelto.setBackground(mouseExitPanelColor);
        }
    }//GEN-LAST:event_txt_calcularVueltoMouseExited

    private void txt_calcularVueltoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_calcularVueltoMouseReleased
        if(btn_calcularVuelto.isEnabled()){
            if(btn_calcularVuelto.contains(evt.getPoint())) btn_calcularVuelto.setBackground(mouseEnterPanelColor);
            else  btn_calcularVuelto.setBackground(mouseExitPanelColor);
        }
    }//GEN-LAST:event_txt_calcularVueltoMouseReleased

    private void txt_calcularVueltoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_calcularVueltoMousePressed
        if(btn_calcularVuelto.isEnabled() && evt.getButton() == 1 && !lbl_total.getText().equals("$0")){
            btn_calcularVuelto.setBackground(mouseEnterPanelColor);
            lostFocus(null, txt_pagoEfectivo);
            if(txt_pagoEfectivo.getText().equals("")) txt_pagoEfectivo.setText("$0");
            else{
                String valor = txt_pagoEfectivo.getText().replace("$", "").replace(".", "");
                txt_pagoEfectivo.setText(String.format("$%,d",Integer.valueOf(valor)));
            }

            if(rb_efectivo.isSelected()){
                int total_venta = Integer.parseInt(lbl_total.getText().replace("$", "").replace(".", ""));
                int pago_efectivo = Integer.parseInt(txt_pagoEfectivo.getText().replace("$", "").replace(".", ""));

                if(pago_efectivo >= total_venta){
                    int vuelto = pago_efectivo - total_venta;
                    txt_vuelto.setText(String.format("$%,d",vuelto));
                }
                else{
                    txt_vuelto.setText("$0");
                    JOptionPane.showMessageDialog(this, "El pago del cliente no puede ser menor al total de la venta", "Error calculando vuelto",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else{
            txt_vuelto.setText("$0");
        }
    }//GEN-LAST:event_txt_calcularVueltoMousePressed

    private void txt_crearVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearVentaMouseEntered
        btn_crearVenta.setBackground(verdeMouseEnter);
    }//GEN-LAST:event_txt_crearVentaMouseEntered

    private void txt_crearVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearVentaMouseExited
        btn_crearVenta.setBackground(verde);
    }//GEN-LAST:event_txt_crearVentaMouseExited

    private void txt_crearVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearVentaMouseReleased
        if(btn_crearVenta.contains(evt.getPoint())) btn_crearVenta.setBackground(verdeMouseEnter);
        else  btn_crearVenta.setBackground(verde);
    }//GEN-LAST:event_txt_crearVentaMouseReleased

    private void txt_crearVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearVentaMousePressed
        if(evt.getButton() == 1 && tbl_detalleVenta.getRowCount() > 0){
            
            lbl_confirmandoVenta.setVisible(true);
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            if(seleccion().equals("NADA SELECCIONADO")){
                sinSeleccionMetodoPago();
                return;
            }            
            Venta venta = new Venta();
            ArrayList<VentaProducto> lista = new ArrayList<>();

            venta.setTipo_venta(seleccion());
            venta.setTotal(Integer.parseInt(lbl_total.getText().replace(".", "").replace("$", "")));
            for(int i = 0; i< table.getRowCount(); i ++){                
                String codigo_barra = table.getValueAt(i, 0).toString();
                int cantidad = (int) table.getValueAt(i, 3);
                int precio = (int)table.getValueAt(i, 2);
                int valorTotal = cantidad*precio;
                VentaProducto vp = new VentaProducto();
                vp.setCodigo_barra(codigo_barra);
                vp.setCantidad(cantidad);
                vp.setTotal(valorTotal);
                lista.add(vp);
            }

            ConVenta cVenta = new ConVenta();
            boolean operacion = cVenta.registrarVenta(venta, lista, this, lbl_confirmandoVenta);
            if(operacion) reiniciarModulo();
            else{
                operacion = cVenta.registrarVenta(venta, lista, this, lbl_confirmandoVenta);
                if(operacion) reiniciarModulo();
                else
                    JOptionPane.showMessageDialog(this, "No se pudo ingresar la venta", "Venta erronea", JOptionPane.INFORMATION_MESSAGE);
            }
                
        }
        else{
            JOptionPane.showMessageDialog(this, "Ningun producto ingresado", "Error ingresando venta", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_txt_crearVentaMousePressed

    private void txt_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_salirMouseEntered
        btn_salir.setBackground(rojoMouseEnter);
    }//GEN-LAST:event_txt_salirMouseEntered

    private void txt_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_salirMouseExited
        btn_salir.setBackground(rojo);
    }//GEN-LAST:event_txt_salirMouseExited

    private void txt_salirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_salirMouseReleased
        if(btn_salir.contains(evt.getPoint())) btn_salir.setBackground(rojoMouseEnter);
        else  btn_salir.setBackground(rojo);
    }//GEN-LAST:event_txt_salirMouseReleased

    private void txt_salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_salirMousePressed
        if(evt.getButton() == 1 && tbl_detalleVenta.getRowCount() == 0){
            this.dispose();
        }
        else if(evt.getButton() == 1 && tbl_detalleVenta.getRowCount() > 0){
            int cerrar = JOptionPane.showConfirmDialog(this, "Existen productos ingresados, si cierra esta ventana se perderán. ¿Desea continuar?", "Confirmacion de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(cerrar == JOptionPane.YES_OPTION){
                this.dispose();
            }
        }
    }//GEN-LAST:event_txt_salirMousePressed

    private void rb_sumupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_sumupActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_sumupActionPerformed

    private void rb_transferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_transferenciaKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_transferenciaKeyPressed

    private void rb_sumupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_sumupKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_sumupKeyPressed

    private void listaFiltradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaFiltradaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            threadManual.run();
        }
    }//GEN-LAST:event_listaFiltradaKeyPressed

    private void listaFiltradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaFiltradaMouseClicked
        if (evt.getClickCount() == 2) threadManual.run();            
        
    }//GEN-LAST:event_listaFiltradaMouseClicked
    
    private void seleccionEfectivo(){        
        if(!rb_efectivo.isSelected()){
            btn_calcularVuelto.setEnabled(false);
            txt_calcularVuelto.setEnabled(false);
            txt_pagoEfectivo.setEnabled(false);
        }
        else{
            btn_calcularVuelto.setEnabled(true);
            txt_calcularVuelto.setEnabled(true);   
            txt_pagoEfectivo.setEnabled(true);   
        }         
        lbl_metodoPago.setText("MÉTODO DE PAGO: "+seleccion());
    }
    
    private String seleccion(){
        if(rb_efectivo.isSelected()) return "EFECTIVO";        
        else if(rb_debito.isSelected()) return "DEBITO";        
        else if(rb_credito.isSelected()) return "CREDITO";        
        else if(rb_transferencia.isSelected()) return "TRANSFERENCIA";        
        else if(rb_sumup.isSelected()) return "SUMUP";       
        else return "NADA SELECCIONADO";        
    }
    
    
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))) evt.consume();        
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
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelMetodoPago;
    private javax.swing.JPanel PanelPaso1;
    private javax.swing.JPanel PanelPaso2;
    private javax.swing.JPanel PanelProducto;
    private javax.swing.JPanel PanelTotal;
    private javax.swing.JPanel btn_anadir1;
    private javax.swing.JPanel btn_calcularVuelto;
    private javax.swing.JPanel btn_crearVenta;
    private javax.swing.JPanel btn_eliminar1;
    private javax.swing.JPanel btn_restar1;
    private javax.swing.JPanel btn_salir;
    private javax.swing.JLabel img_credito;
    private javax.swing.JLabel img_debito;
    private javax.swing.JLabel img_efectivo;
    private javax.swing.JLabel img_sumup;
    private javax.swing.JLabel img_transferencia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_buscarManual;
    private javax.swing.JLabel lbl_confirmandoVenta;
    private javax.swing.JLabel lbl_escanearCodigo;
    private javax.swing.JLabel lbl_metodoPago;
    private javax.swing.JLabel lbl_pagaCon;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalProductos;
    private javax.swing.JLabel lbl_vuelto;
    private javax.swing.JLabel lbl_warning;
    private javax.swing.JList<String> listaFiltrada;
    private javax.swing.ButtonGroup rb_METODOPAGO;
    private javax.swing.JRadioButton rb_credito;
    private javax.swing.JRadioButton rb_debito;
    private javax.swing.JRadioButton rb_efectivo;
    private javax.swing.JRadioButton rb_sumup;
    private javax.swing.JRadioButton rb_transferencia;
    private javax.swing.JScrollPane scrollPanelDetalleVenta;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tbl_detalleVenta;
    private javax.swing.JLabel txt_anadir1;
    private javax.swing.JLabel txt_calcularVuelto;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JLabel txt_crearVenta;
    private javax.swing.JLabel txt_eliminar1;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_pagoEfectivo;
    private javax.swing.JLabel txt_restar1;
    private javax.swing.JLabel txt_salir;
    private javax.swing.JLabel txt_tituloVentana;
    private javax.swing.JTextField txt_vuelto;
    // End of variables declaration//GEN-END:variables
}
