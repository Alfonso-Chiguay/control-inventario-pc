package vista;

import controlador.ConProducto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class CrearOferta extends javax.swing.JFrame {

    ArrayList<Producto> productos;
    private boolean actualizarListado;
    ArrayList<String> listaNoSeMuestra = new ArrayList<>();
    ConProducto CON_PRODUCTO = new ConProducto();
    
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
        this.setTitle("Pili's Coffee POS Software | Crear oferta");
        productos = listado;
        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
        table.setRowCount(0);
        actualizarProductos();
        actualizarListado = false;
        
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
        tbl_listadoProductos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        tbl_listadoProductos.setBackground(new Color(221, 184, 146));
        tbl_listadoProductos.setForeground(new Color(127,85,57));
        tbl_listadoProductos.setOpaque(true);
        tbl_listadoProductos.setFillsViewportHeight(true);
        
        tbl_listadoProductos.getTableHeader().setOpaque(false);
        tbl_listadoProductos.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        tbl_listadoProductos.getTableHeader().setBackground(new Color(127, 85, 57));
        tbl_listadoProductos.getTableHeader().setForeground(Color.WHITE);
        
        tbl_listadoProductos.setSelectionBackground(new Color(176, 137, 104));
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
        lbl_Titulo = new javax.swing.JLabel();
        PanelCodigoOferta = new javax.swing.JPanel();
        txt_codigoOferta = new javax.swing.JTextField();
        lbl_existeCodigoOferta = new javax.swing.JLabel();
        PanelIdentificaProd = new javax.swing.JPanel();
        txt_codigoBarra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFiltrada = new javax.swing.JList<>();
        txt_nombreProducto = new javax.swing.JTextField();
        PanelGrupoProducto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listadoProductos = new javax.swing.JTable();
        btn_agregar1 = new javax.swing.JLabel();
        btn_quitar1 = new javax.swing.JLabel();
        btn_eliminarSeleccion = new javax.swing.JLabel();
        PanelDetalleOferta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_precioOferta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_nombreOferta = new javax.swing.JTextField();
        btn_crearOferta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(230, 204, 178));

        lbl_Titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(127, 85, 57));
        lbl_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sale.png"))); // NOI18N
        lbl_Titulo.setText("  CREAR NUEVA OFERTA");

        PanelCodigoOferta.setBackground(new java.awt.Color(230, 204, 178));
        PanelCodigoOferta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "CODIGO DE OFERTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(127, 85, 57))); // NOI18N
        PanelCodigoOferta.setForeground(new java.awt.Color(127, 85, 57));

        txt_codigoOferta.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_codigoOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoOferta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoOfertaFocusLost(evt);
            }
        });

        lbl_existeCodigoOferta.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_existeCodigoOferta.setForeground(new java.awt.Color(255, 0, 0));
        lbl_existeCodigoOferta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_existeCodigoOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PanelCodigoOfertaLayout = new javax.swing.GroupLayout(PanelCodigoOferta);
        PanelCodigoOferta.setLayout(PanelCodigoOfertaLayout);
        PanelCodigoOfertaLayout.setHorizontalGroup(
            PanelCodigoOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCodigoOfertaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCodigoOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoOferta)
                    .addComponent(lbl_existeCodigoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(224, 224, 224))
        );
        PanelCodigoOfertaLayout.setVerticalGroup(
            PanelCodigoOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCodigoOfertaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_codigoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_existeCodigoOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelIdentificaProd.setBackground(new java.awt.Color(230, 204, 178));
        PanelIdentificaProd.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "IDENTIFICAR PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        PanelIdentificaProd.setForeground(new java.awt.Color(127, 85, 57));
        PanelIdentificaProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PanelIdentificaProdKeyPressed(evt);
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
        jLabel2.setText("ESCANEAR CÓDIGO DE BARRA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 85, 57));
        jLabel3.setText("BUSCAR PRODUCTO MANUALMENTE");

        jSeparator1.setBackground(new java.awt.Color(127, 85, 57));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listaFiltrada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout PanelIdentificaProdLayout = new javax.swing.GroupLayout(PanelIdentificaProd);
        PanelIdentificaProd.setLayout(PanelIdentificaProdLayout);
        PanelIdentificaProdLayout.setHorizontalGroup(
            PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIdentificaProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigoBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_nombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        PanelIdentificaProdLayout.setVerticalGroup(
            PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIdentificaProdLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIdentificaProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelIdentificaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(PanelIdentificaProdLayout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        PanelGrupoProducto.setBackground(new java.awt.Color(230, 204, 178));
        PanelGrupoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 85, 57)), "GRUPO DE PRODUCTOS EN OFERTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        PanelGrupoProducto.setForeground(new java.awt.Color(127, 85, 57));

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
        jScrollPane1.setViewportView(tbl_listadoProductos);

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

        javax.swing.GroupLayout PanelGrupoProductoLayout = new javax.swing.GroupLayout(PanelGrupoProducto);
        PanelGrupoProducto.setLayout(PanelGrupoProductoLayout);
        PanelGrupoProductoLayout.setHorizontalGroup(
            PanelGrupoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGrupoProductoLayout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addGroup(PanelGrupoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_quitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_agregar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(PanelGrupoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelGrupoProductoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(289, Short.MAX_VALUE)))
        );
        PanelGrupoProductoLayout.setVerticalGroup(
            PanelGrupoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGrupoProductoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btn_agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_quitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(PanelGrupoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGrupoProductoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        PanelDetalleOferta.setBackground(new java.awt.Color(230, 204, 178));
        PanelDetalleOferta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 85, 57)), "DETALLE DE LA OFERTA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setText("PRECIO FINAL DE LA OFERTA");

        txt_precioOferta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 85, 57));
        jLabel4.setText("NOMBRE DE LA OFERTA");

        txt_nombreOferta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout PanelDetalleOfertaLayout = new javax.swing.GroupLayout(PanelDetalleOferta);
        PanelDetalleOferta.setLayout(PanelDetalleOfertaLayout);
        PanelDetalleOfertaLayout.setHorizontalGroup(
            PanelDetalleOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetalleOfertaLayout.createSequentialGroup()
                .addGroup(PanelDetalleOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDetalleOfertaLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_precioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDetalleOfertaLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel4))
                    .addGroup(PanelDetalleOfertaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txt_nombreOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PanelDetalleOfertaLayout.setVerticalGroup(
            PanelDetalleOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDetalleOfertaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nombreOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(PanelDetalleOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_precioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btn_crearOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/crearoferta_solid.png"))); // NOI18N
        btn_crearOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_crearOfertaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_crearOfertaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_crearOfertaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_crearOfertaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(lbl_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87))
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelGrupoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCodigoOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelDetalleOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_crearOferta)
                        .addGap(140, 140, 140))))
            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelIdentificaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(612, Short.MAX_VALUE)))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelCodigoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(PanelGrupoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(PanelDetalleOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_crearOferta)
                        .addGap(34, 34, 34))))
            .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPrincipalLayout.createSequentialGroup()
                    .addGap(237, 237, 237)
                    .addComponent(PanelIdentificaProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(400, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            return;
        }
        if(CON_PRODUCTO.existeCodigo(codigo)){
            lbl_existeCodigoOferta.setText("¡Código ya registrado!, intente con otro.");
            txt_codigoOferta.requestFocus();
        }
        else{
            lbl_existeCodigoOferta.setText("");
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

    private void btn_agregar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseEntered
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_click.png"));
            btn_agregar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_agregar1MouseEntered

    private void btn_agregar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseExited
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_agregar1MouseExited

    private void btn_agregar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MousePressed
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_click.png"));
            btn_agregar1.setIcon(botonClick);
            sumar_item();

            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);

       
    }//GEN-LAST:event_btn_agregar1MousePressed

    private void btn_agregar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar1MouseReleased
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/agregar1_solid.png"));
            btn_agregar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_agregar1MouseReleased

    private void btn_quitar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseEntered
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_click.png"));
            btn_quitar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_quitar1MouseEntered

    private void btn_quitar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseExited
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_quitar1MouseExited

    private void btn_quitar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MousePressed
       
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_click.png"));
            btn_quitar1.setIcon(botonClick);
            restar_item();
            botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_quitar1MousePressed


    
    private void btn_quitar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitar1MouseReleased
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/quitar1_solid.png"));
            btn_quitar1.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_quitar1MouseReleased

    private void btn_eliminarSeleccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseEntered
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_click.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_eliminarSeleccionMouseEntered

    private void btn_eliminarSeleccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseExited
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_eliminarSeleccionMouseExited

    private void btn_eliminarSeleccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMousePressed
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_click.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
            eliminar_item();
        
    }//GEN-LAST:event_btn_eliminarSeleccionMousePressed

    private void btn_eliminarSeleccionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarSeleccionMouseReleased
        
            ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/eliminarseleccion_solid.png"));
            btn_eliminarSeleccion.setIcon(botonClick);
        
    }//GEN-LAST:event_btn_eliminarSeleccionMouseReleased

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

    private void btn_crearOfertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearOfertaMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/crearoferta_click.png"));
        btn_crearOferta.setIcon(botonClick);
    }//GEN-LAST:event_btn_crearOfertaMouseEntered

    private void btn_crearOfertaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearOfertaMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/crearoferta_solid.png"));
        btn_crearOferta.setIcon(botonClick);
    }//GEN-LAST:event_btn_crearOfertaMouseExited

    private void btn_crearOfertaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearOfertaMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/crearoferta_solid.png"));
        btn_crearOferta.setIcon(botonClick);
    }//GEN-LAST:event_btn_crearOfertaMouseReleased

    private void btn_crearOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearOfertaMousePressed
        
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/crearoferta_click.png"));
        btn_crearOferta.setIcon(botonClick);
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
        
    }//GEN-LAST:event_btn_crearOfertaMousePressed
    
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }
    
    
    public void restar_item(){
        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
        int row = tbl_listadoProductos.getSelectedRow();
        if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
            int cantidad = (int) table.getValueAt(row, 2);
            if(cantidad -1 > 0){
                table.setValueAt(cantidad-1, row, 2);
            }
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
        DefaultTableModel table = (DefaultTableModel) tbl_listadoProductos.getModel();
        int row = tbl_listadoProductos.getSelectedRow();
        if(!String.valueOf(table.getValueAt(row, 0)).equals("CODIGOPAN") && !String.valueOf(table.getValueAt(row, 0)).equals("NN0000")){
            int cantidad = (int) table.getValueAt(row, 2);
            table.setValueAt(cantidad+1, row, 2);

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
    private javax.swing.JPanel PanelCodigoOferta;
    private javax.swing.JPanel PanelDetalleOferta;
    private javax.swing.JPanel PanelGrupoProducto;
    private javax.swing.JPanel PanelIdentificaProd;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel btn_agregar1;
    private javax.swing.JLabel btn_crearOferta;
    private javax.swing.JLabel btn_eliminarSeleccion;
    private javax.swing.JLabel btn_quitar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_existeCodigoOferta;
    private javax.swing.JList<String> listaFiltrada;
    private javax.swing.JTable tbl_listadoProductos;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JTextField txt_codigoOferta;
    private javax.swing.JTextField txt_nombreOferta;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_precioOferta;
    // End of variables declaration//GEN-END:variables
}
