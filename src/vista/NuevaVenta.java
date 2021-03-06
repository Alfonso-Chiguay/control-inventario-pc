/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConProducto;
import controlador.ConVenta;
import db.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Producto;
import modelo.Venta;
import modelo.VentaProducto;


/**
 *
 * @author AlfonsoC
 */
public class NuevaVenta extends javax.swing.JFrame {
    ArrayList<Producto> productos;
    private boolean disabled_buttons;
    private boolean actualizarListado;
    ArrayList<String> listaNoSeMuestra = new ArrayList<>();

    public NuevaVenta() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Pili's Coffee POS Software | Nueva venta");
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        table.setRowCount(0);
        
    }
    
    public NuevaVenta(ArrayList<Producto> listado) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Pili's Coffee POS Software | Nueva venta");
        productos = listado;
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        table.setRowCount(0);
        actualizarProductos();
        actualizarListado = false;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight()-35);
        
        setLocationRelativeTo(null);
        
        lbl_confirmandoVenta.setText("Ingrese un producto para iniciar una venta");
        lbl_confirmandoVenta.setForeground(Color.red);
        disabled_buttons = false;
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
        tbl_detalleVenta.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tbl_detalleVenta.setBackground(new Color(221, 184, 146));
        tbl_detalleVenta.setForeground(new Color(127,85,57));
        tbl_detalleVenta.setOpaque(true);
        tbl_detalleVenta.setFillsViewportHeight(true);
        
        tbl_detalleVenta.getTableHeader().setOpaque(false);
        tbl_detalleVenta.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        tbl_detalleVenta.getTableHeader().setBackground(new Color(127, 85, 57));
        tbl_detalleVenta.getTableHeader().setForeground(Color.WHITE);
        
        tbl_detalleVenta.setSelectionBackground(new Color(176, 137, 104));
        tbl_detalleVenta.setSelectionForeground(Color.WHITE);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl_detalleVenta.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
            
        
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
        
        
        seleccionEfectivo();
        
    }
    
    public void actualizarProductos(){
        String palabraClave = txt_nombreProducto.getText();
        if(!palabraClave.equals("")){
            DefaultListModel dl = new DefaultListModel();
            dl.clear();
            
            for(Producto p: productos){
                
                String nombre = p.getNombre().toLowerCase().replace("??","a").replace("??", "e").replace("??", "i").replace("??", "o").replace("??", "u");
                if(nombre.contains(palabraClave.toLowerCase()) &&
                        !listaNoSeMuestra.contains(p.getCodigo_barra().toUpperCase())){
                    dl.addElement(p.getNombre()+" ("+p.getCodigo_barra()+")");
                }
            }
            listaFiltrada.setModel(dl);
        }
        else{
            DefaultListModel dl = new DefaultListModel();
            dl.clear();
            listaFiltrada.setModel(dl);
        }
    }

    public void reiniciarModulo(){
/*
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        table.setRowCount(0);
        threadPRECIO.run();
        txt_pagoEfectivo.setText("$0");
        txt_vuelto.setText("$0");
        txt_codigoBarra.setEnabled(true);
        txt_nombreProducto.setEnabled(true);
        listaFiltrada.setEnabled(true);
        tbl_detalleVenta.setEnabled(true);
        txt_pagoEfectivo.setEnabled(true); 
        rb_efectivo.setEnabled(true);
        rb_debito.setEnabled(true);
        rb_credito.setEnabled(true);
        rb_transferencia.setEnabled(true);
        disabled_buttons = false;
        lbl_confirmandoVenta.setText("Ingrese un producto para iniciar una venta");
        lbl_confirmandoVenta.setForeground(Color.red);  
        rb_efectivo.setSelected(true);
        seleccionEfectivo();
        txt_codigoBarra.setText("");*/
        this.dispose();
        ConProducto cProducto = new ConProducto();
        NuevaVenta ventana = new NuevaVenta(cProducto.listarProductos());
        ventana.setVisible(true);
        
    }
    
    Thread threadAutomatico = new Thread(new Runnable() {
        @Override
        public void run() {
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            //ConProducto cProducto = new ConProducto();
            //Producto p = cProducto.obtenerProducto(txt_codigoBarra.getText());
            Producto p = new Producto();
            for(Producto producto: productos){
                if(producto.getCodigo_barra().toUpperCase().equals(txt_codigoBarra.getText().toUpperCase())){
                    p = producto;
                    break;
                }
            }
            
            if(!p.getNombre().equals("")){
                int filas=table.getRowCount();

                if(p.getCodigo_barra().equals("CODIGOPAN") ){
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
                    }

                    if(int_precio > 0){
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

                    } 


                }
                        
                else if(p.getCodigo_barra().equals("NN0000")){
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
                    }

                    if(int_precio > 0){
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

                    } 


                }    
                    
                else{
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
                                String valorTotal = String.format("$%,d",Integer.valueOf(cantidad*(int)table.getValueAt(i, 2)));
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
                    }
                }   
            }
            
            
            
            else{
               int ingresar = JOptionPane.showConfirmDialog(null, "No hay un producto ingresado con este codigo, ??Quiere registrarlo?", "Error buscando producto", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION); 
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
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                String codigo = listaFiltrada.getSelectedValue().replace(")", "??????").replace("(","??????").split("??????")[1];
                Producto p = new Producto();
                for(Producto producto: productos){
                    if(producto.getCodigo_barra().equals(codigo)){
                        p = producto;
                        break;
                    }
                }
                if(!p.getNombre().equals("")){
                    int filas=table.getRowCount();
                    
                    if(p.getCodigo_barra().equals("CODIGOPAN")){
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
                        }
                        
                        if(int_precio > 0){
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
                            
                        }  
                    }
                    else if(p.getCodigo_barra().equals("NN0000")){
                        String precio = (String)JOptionPane.showInputDialog(
                                    null,
                                    "Ingrese el precio del producto",
                                    "Precio del codigo NN",
                                    JOptionPane.PLAIN_MESSAGE);
                        

                        int int_precio = 0;
                        try {
                           int_precio = Integer.valueOf(precio); 
                        } 
                        catch (Exception e) {
                            int_precio = -1;
                        }
                        
                        if(int_precio > 0){
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
                            
                        }
                    }   
                    
                    
                    else{
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
                                    String valorTotal = String.format("$%,d",Integer.valueOf(cantidad*(int)table.getValueAt(i, 2)));
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
                        }
                    }
                }    
                    
                       
                }
            }
        
        
     
            
     });
    
    
    
    Thread threadPRECIO = new Thread(new Runnable() {
        @Override
        public void run() {
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int totalgeneral = 0;
            for(int i = 0; i< table.getRowCount(); i ++){                
                int cantidad = (int) table.getValueAt(i, 3);
                int precio = (int) table.getValueAt(i, 2);
                totalgeneral = totalgeneral + (cantidad*precio);
            }
            lbl_total.setText(String.format("$%,d",totalgeneral));
            txt_pagoEfectivo.setText(String.format("$%,d",totalgeneral));
            txt_codigoBarra.requestFocus();
            if(table.getRowCount()>0){
                lbl_confirmandoVenta.setText("Venta en progreso.");
            }
            else{
                lbl_confirmandoVenta.setText("Ingrese un producto para iniciar una venta");
            }
            
        }
    });
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rb_METODOPAGO = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_codigoBarra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_elegir_producto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFiltrada = new javax.swing.JList<>();
        txt_nombreProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detalleVenta = new javax.swing.JTable();
        btn_agregar1 = new javax.swing.JLabel();
        btn_quitar1 = new javax.swing.JLabel();
        btn_eliminarSeleccion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_total = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rb_debito = new javax.swing.JRadioButton();
        rb_credito = new javax.swing.JRadioButton();
        rb_efectivo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txt_pagoEfectivo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_vuelto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_vuelto = new javax.swing.JLabel();
        rb_transferencia = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        rb_edenred = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        btn_confirmaVenta = new javax.swing.JLabel();
        btn_salir = new javax.swing.JLabel();
        lbl_confirmandoVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 204, 178));
        jPanel1.setPreferredSize(new java.awt.Dimension(1924, 1045));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cashmachine.png"))); // NOI18N
        jLabel1.setText(" M??DULO DE VENTAS");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(230, 204, 178));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "IDENTIFICAR PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(127, 85, 57));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        txt_codigoBarra.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 85, 57));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        jLabel2.setText("ESCANEAR C??DIGO DE BARRA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 85, 57));
        jLabel3.setText("BUSCAR PRODUCTO MANUALMENTE");

        jSeparator1.setBackground(new java.awt.Color(127, 85, 57));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_elegir_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_solid.png"))); // NOI18N
        btn_elegir_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_elegir_productoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_elegir_productoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_elegir_productoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_elegir_productoMouseReleased(evt);
            }
        });

        listaFiltrada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(listaFiltrada);

        txt_nombreProducto.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_elegir_producto)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_elegir_producto)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(230, 204, 178));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DETALLE DE VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(127, 85, 57));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tbl_detalleVenta);

        btn_agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"))); // NOI18N
        btn_agregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_agregar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_agregar1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agregar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_agregar1MouseReleased(evt);
            }
        });

        btn_quitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"))); // NOI18N
        btn_quitar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_quitar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_quitar1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_quitar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_quitar1MouseReleased(evt);
            }
        });

        btn_eliminarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"))); // NOI18N
        btn_eliminarSeleccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminarSeleccionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminarSeleccionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_eliminarSeleccionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_eliminarSeleccionMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_quitar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminarSeleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_quitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(230, 204, 178));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(127, 85, 57));

        lbl_total.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(127, 85, 57));
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("$0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(230, 204, 178));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "M??TODO DE PAGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel5KeyPressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rb_debito.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_debito);
        rb_debito.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_debito.setForeground(new java.awt.Color(127, 85, 57));
        rb_debito.setText("D??BITO");
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
        jPanel5.add(rb_debito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 203, 86));

        rb_credito.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_credito);
        rb_credito.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_credito.setForeground(new java.awt.Color(127, 85, 57));
        rb_credito.setText("CR??DITO");
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
        jPanel5.add(rb_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 163, 86));

        rb_efectivo.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_efectivo);
        rb_efectivo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_efectivo.setForeground(new java.awt.Color(127, 85, 57));
        rb_efectivo.setSelected(true);
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
        jPanel5.add(rb_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 151, 51));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setLabelFor(txt_pagoEfectivo);
        jLabel4.setText("PAGA CON:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txt_pagoEfectivo.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txt_pagoEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_pagoEfectivo.setText("$0");
        txt_pagoEfectivo.setBorder(null);
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
        jPanel5.add(txt_pagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 44));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setLabelFor(txt_vuelto);
        jLabel5.setText("VUELTO:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        txt_vuelto.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txt_vuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_vuelto.setText("$0");
        txt_vuelto.setBorder(null);
        txt_vuelto.setEnabled(false);
        jPanel5.add(txt_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 120, 44));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/debito.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 82, 51));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/efectivo.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 82, 51));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/credito.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 59, 37));

        btn_vuelto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_solid.png"))); // NOI18N
        btn_vuelto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_vueltoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_vueltoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_vueltoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vueltoMouseReleased(evt);
            }
        });
        btn_vuelto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_vueltoKeyPressed(evt);
            }
        });
        jPanel5.add(btn_vuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        rb_transferencia.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_transferencia);
        rb_transferencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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
        jPanel5.add(rb_transferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 209, 85));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transferencia.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 59, -1));

        rb_edenred.setBackground(new java.awt.Color(230, 204, 178));
        rb_METODOPAGO.add(rb_edenred);
        rb_edenred.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_edenred.setForeground(new java.awt.Color(127, 85, 57));
        rb_edenred.setText("EDENRED");
        rb_edenred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_edenredActionPerformed(evt);
            }
        });
        rb_edenred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rb_edenredKeyPressed(evt);
            }
        });
        jPanel5.add(rb_edenred, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, 86));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edenred_logo.png"))); // NOI18N
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 59, -1));

        btn_confirmaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"))); // NOI18N
        btn_confirmaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_confirmaVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_confirmaVentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_confirmaVentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_confirmaVentaMouseReleased(evt);
            }
        });

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/escsalir_solid.png"))); // NOI18N
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_salirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_salirMouseReleased(evt);
            }
        });

        lbl_confirmandoVenta.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_confirmandoVenta.setText("estado_venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_confirmaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_confirmandoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btn_confirmaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_confirmandoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1902, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void pressF10_ESC(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == KeyEvent.VK_F10){
            if(!disabled_buttons){ 
                
                ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_click.png"));
                btn_confirmaVenta.setIcon(botonClick); 

                if(tbl_detalleVenta.getRowCount() > 0){  
                   

                    botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
                    btn_confirmaVenta.setIcon(botonClick);  
                    
                    DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
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
                    botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
                    btn_confirmaVenta.setIcon(botonClick);                      
                }
            }    
            else{
                int confirmar = JOptionPane.showConfirmDialog(this, "??Ingresar nueva venta? Se borrar??n los datos desplegados en la pantalla", "Nueva venta", JOptionPane.YES_NO_OPTION);
                if(confirmar == 0){
                    reiniciarModulo();
                }
            }

        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/escsalir_click.png"));
            btn_salir.setIcon(botonClick); 
            this.dispose();   
        }
    }
    
    
    private void tbl_detalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_detalleVentaKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_F1){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_click.png"));
            btn_agregar1.setIcon(botonClick); 
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            int cantidad = (int) table.getValueAt(row, 3);
            table.setValueAt(cantidad+1, row, 3);
            int precio = (int)table.getValueAt(row, 2);
            String valorTotal = String.format("$%,d",Integer.valueOf((cantidad + 1)*precio));
            table.setValueAt(valorTotal, row, 4); 
            lostFocus(null, tbl_detalleVenta);
            threadPRECIO.run();
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick); 
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_click.png"));
            btn_quitar1.setIcon(botonClick);             
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            int cantidad = (int) table.getValueAt(row, 3);
            if(cantidad -1 > 0){
                table.setValueAt(cantidad-1, row, 3);
                int precio = (int)table.getValueAt(row, 2);
                String valorTotal = String.format("$%,d",Integer.valueOf((cantidad - 1)*precio));
                table.setValueAt(valorTotal, row, 4); 
                lostFocus(null, tbl_detalleVenta);
                threadPRECIO.run();
            }
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);  
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F3){
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            try{
                table.removeRow(tbl_detalleVenta.getSelectedRow());
                threadPRECIO.run();
            }
            catch(Exception e){
                System.out.println("NADA SELECCIONADO");
            }
        }
        
        else if(evt.getKeyCode() == KeyEvent.VK_F10){
            pressF10_ESC(evt);
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            pressF10_ESC(evt);
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

    private void btn_elegir_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_elegir_productoMouseEntered
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_click.png"));
            btn_elegir_producto.setIcon(botonClick);           
        }

    }//GEN-LAST:event_btn_elegir_productoMouseEntered

    private void btn_elegir_productoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_elegir_productoMouseExited
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_solid.png"));
            btn_elegir_producto.setIcon(botonClick);            
        }

    }//GEN-LAST:event_btn_elegir_productoMouseExited

    private void btn_elegir_productoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_elegir_productoMousePressed
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_click.png"));
            btn_elegir_producto.setIcon(botonClick);
            threadManual.run();
            txt_nombreProducto.setText("");
            actualizarProductos();
            threadPRECIO.run();    
        }        
    }//GEN-LAST:event_btn_elegir_productoMousePressed
       
    private void btn_elegir_productoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_elegir_productoMouseReleased
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_solid.png"));
            btn_elegir_producto.setIcon(botonClick);
        }

    }//GEN-LAST:event_btn_elegir_productoMouseReleased

    private void btn_agregar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseEntered
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_click.png"));
            btn_agregar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_agregar1MouseEntered

    private void btn_agregar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseExited
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_agregar1MouseExited

    private void btn_agregar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MousePressed
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_click.png"));
            btn_agregar1.setIcon(botonClick);  
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                int cantidad = (int) table.getValueAt(row, 3);
                table.setValueAt(cantidad+1, row, 3);
                int precio = (int)table.getValueAt(row, 2);
                String valorTotal = String.format("$%,d",Integer.valueOf((cantidad + 1)*precio));
                table.setValueAt(valorTotal, row, 4); 
                lostFocus(null, tbl_detalleVenta);
                threadPRECIO.run();                 
            }
 
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick); 
            
        }
    }//GEN-LAST:event_btn_agregar1MousePressed

    private void btn_agregar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseReleased
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_agregar1MouseReleased

    private void btn_quitar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseEntered
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_click.png"));
            btn_quitar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_quitar1MouseEntered

    private void btn_quitar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseExited
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_quitar1MouseExited

    private void btn_quitar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MousePressed
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_click.png"));
            btn_quitar1.setIcon(botonClick); 
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
                int cantidad = (int) table.getValueAt(row, 3);
                if(cantidad -1 > 0){
                    table.setValueAt(cantidad-1, row, 3);
                    int precio = (int)table.getValueAt(row, 2);
                    String valorTotal = String.format("$%,d",Integer.valueOf((cantidad -1) *precio));
                    table.setValueAt(valorTotal, row, 4); 
                    lostFocus(null, tbl_detalleVenta);
                    threadPRECIO.run();
                }
            }    
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);             
        }
    }//GEN-LAST:event_btn_quitar1MousePressed

    private void btn_quitar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseReleased
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_quitar1MouseReleased

    private void btn_eliminarSeleccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseEntered
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_click.png"));
            btn_eliminarSeleccion.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_eliminarSeleccionMouseEntered

    private void btn_eliminarSeleccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseExited
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"));
            btn_eliminarSeleccion.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_eliminarSeleccionMouseExited

    private void btn_eliminarSeleccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMousePressed
         if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_click.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            try{
                table.removeRow(tbl_detalleVenta.getSelectedRow());
                threadPRECIO.run();
            }
            catch(Exception e){
                System.out.println("NADA SELECCIONADO");
            }            
        }
    }//GEN-LAST:event_btn_eliminarSeleccionMousePressed

    private void btn_eliminarSeleccionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseReleased
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"));
            btn_eliminarSeleccion.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_eliminarSeleccionMouseReleased

    private void rb_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_creditoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_creditoActionPerformed

    private void rb_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_efectivoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_efectivoActionPerformed

    private void rb_debitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_debitoActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_debitoActionPerformed

    private void btn_vueltoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vueltoMouseEntered
        if(!disabled_buttons && rb_efectivo.isSelected()){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_click.png"));
            btn_vuelto.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_vueltoMouseEntered

    private void btn_vueltoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vueltoMousePressed
        lostFocus(null, txt_pagoEfectivo);
        if(txt_pagoEfectivo.getText().equals("")) txt_pagoEfectivo.setText("$0");
        else{
            String valor = txt_pagoEfectivo.getText().replace("$", "").replace(".", "");
            txt_pagoEfectivo.setText(String.format("$%,d",Integer.valueOf(valor)));
        }
        
        if(!disabled_buttons && rb_efectivo.isSelected()){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_click.png"));
            btn_vuelto.setIcon(botonClick);  
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
    }//GEN-LAST:event_btn_vueltoMousePressed

    private void btn_vueltoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vueltoMouseExited
        if(!disabled_buttons && rb_efectivo.isSelected()){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_solid.png"));
            btn_vuelto.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_vueltoMouseExited

    private void btn_vueltoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vueltoMouseReleased
        if(!disabled_buttons && rb_efectivo.isSelected()){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_solid.png"));
            btn_vuelto.setIcon(botonClick);           
        }
    }//GEN-LAST:event_btn_vueltoMouseReleased

    private void btn_confirmaVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmaVentaMouseEntered
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_click.png"));
            btn_confirmaVenta.setIcon(botonClick);             
        }
        else{
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventaF10_click.png"));
            btn_confirmaVenta.setIcon(botonClick);            
        }
    }//GEN-LAST:event_btn_confirmaVentaMouseEntered

    private void btn_confirmaVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmaVentaMouseExited
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);             
        }
        else{
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventaF10_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);            
        }
    }//GEN-LAST:event_btn_confirmaVentaMouseExited

    private void btn_confirmaVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmaVentaMouseReleased
        if(!disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);             
        }
        else{
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventaF10_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);            
        }
    }//GEN-LAST:event_btn_confirmaVentaMouseReleased

    private void btn_confirmaVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmaVentaMousePressed
        if(!disabled_buttons){             
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_click.png"));
            btn_confirmaVenta.setIcon(botonClick);  
            
            if(tbl_detalleVenta.getRowCount() > 0){

                
                botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
                btn_confirmaVenta.setIcon(botonClick);  
                lbl_confirmandoVenta.setVisible(true);
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
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
                if(operacion){    
                    reiniciarModulo();
                }                   


            }
            else{
                JOptionPane.showMessageDialog(this, "Ningun producto ingresado", "Error ingresando venta", JOptionPane.ERROR_MESSAGE);
                botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
                btn_confirmaVenta.setIcon(botonClick);  
            }
        }    
        else{
            int confirmar = JOptionPane.showConfirmDialog(this, "??Ingresar nueva venta? Se borrar??n los datos desplegados en la pantalla", "Nueva venta", JOptionPane.YES_NO_OPTION);
            if(confirmar == 0){
                reiniciarModulo();
            }
        }
    }//GEN-LAST:event_btn_confirmaVentaMousePressed

    private void txt_codigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoBarraKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_txt_codigoBarraKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void rb_efectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_efectivoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_efectivoKeyPressed

    private void btn_vueltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_vueltoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_btn_vueltoKeyPressed

    private void txt_pagoEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pagoEfectivoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_txt_pagoEfectivoKeyPressed

    private void rb_debitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_debitoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_debitoKeyPressed

    private void rb_creditoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_creditoKeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_rb_creditoKeyPressed

    private void jPanel5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel5KeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_jPanel5KeyPressed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_jPanel3KeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        pressF10_ESC(evt);
    }//GEN-LAST:event_jLabel1KeyPressed

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered

        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/escsalir_click.png"));
        btn_salir.setIcon(botonClick);           

    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited

        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/escsalir_solid.png"));
        btn_salir.setIcon(botonClick);           
        
    }//GEN-LAST:event_btn_salirMouseExited

    private void btn_salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMousePressed

        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/escsalir_click.png"));
        btn_salir.setIcon(botonClick); 
        this.dispose();

    }//GEN-LAST:event_btn_salirMousePressed

    private void btn_salirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseReleased

        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/escsalir_solid.png"));
        btn_salir.setIcon(botonClick);           

    }//GEN-LAST:event_btn_salirMouseReleased

    private void txt_nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreProductoActionPerformed
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoActionPerformed

    private void txt_nombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreProductoKeyReleased
        actualizarProductos();
    }//GEN-LAST:event_txt_nombreProductoKeyReleased

    private void rb_transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_transferenciaActionPerformed
        seleccionEfectivo();
    }//GEN-LAST:event_rb_transferenciaActionPerformed

    private void rb_transferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_transferenciaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_transferenciaKeyPressed

    private void rb_edenredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_edenredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_edenredActionPerformed

    private void rb_edenredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rb_edenredKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_edenredKeyPressed
    
    private void seleccionEfectivo(){
        
        if(!rb_efectivo.isSelected()){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_disabled.png"));
            btn_vuelto.setIcon(botonClick);         
            txt_pagoEfectivo.setEnabled(false);

         
        }
        else{
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_solid.png"));
            btn_vuelto.setIcon(botonClick);     
            txt_pagoEfectivo.setEnabled(true);     

        } 
        
    }
    
    private String seleccion(){
        if(rb_efectivo.isSelected()){
            return "EFECTIVO";
        }
        else if(rb_debito.isSelected()){
            return "DEBITO";
        }
        else if(rb_credito.isSelected()){
            return "CREDITO";
        }
        else if(rb_transferencia.isSelected()){
            return "TRANSFERENCIA";
        }
        else if(rb_edenred.isSelected()){
            return "EDENRED";
        }
        else{
            return "NADA SELECCIONADO";
        }
    }
    
    
    private void des_activar_botones(){
        if(disabled_buttons){
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_disabled.png"));
            btn_elegir_producto.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_disabled.png"));
            btn_agregar1.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_disabled.png"));
            btn_quitar1.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_disabled.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_disabled.png"));
            btn_vuelto.setIcon(botonClick);       
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventaF10_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);               
            
        }
        else{
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/seleccionarproducto_solid.png"));
            btn_elegir_producto.setIcon(botonClick); 
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"));
            btn_eliminarSeleccion.setIcon(botonClick);   
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/calcularvuelto_solid.png"));
            btn_vuelto.setIcon(botonClick);  
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/confirmarventa_solid.png"));
            btn_confirmaVenta.setIcon(botonClick);                 
        }
    }
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
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
    private javax.swing.JLabel btn_agregar1;
    private javax.swing.JLabel btn_confirmaVenta;
    private javax.swing.JLabel btn_elegir_producto;
    private javax.swing.JLabel btn_eliminarSeleccion;
    private javax.swing.JLabel btn_quitar1;
    private javax.swing.JLabel btn_salir;
    private javax.swing.JLabel btn_vuelto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_confirmandoVenta;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JList<String> listaFiltrada;
    private javax.swing.ButtonGroup rb_METODOPAGO;
    private javax.swing.JRadioButton rb_credito;
    private javax.swing.JRadioButton rb_debito;
    private javax.swing.JRadioButton rb_edenred;
    private javax.swing.JRadioButton rb_efectivo;
    private javax.swing.JRadioButton rb_transferencia;
    private javax.swing.JTable tbl_detalleVenta;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_pagoEfectivo;
    private javax.swing.JTextField txt_vuelto;
    // End of variables declaration//GEN-END:variables
}
