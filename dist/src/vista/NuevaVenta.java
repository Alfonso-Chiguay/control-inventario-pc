/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConProducto;
import controlador.ConVenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Venta;
import modelo.VentaProducto;


/**
 *
 * @author AlfonsoC
 */
public class NuevaVenta extends javax.swing.JFrame {
    ArrayList<Producto> productos;

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
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        table.setRowCount(0);
        cb_productos.addItem("(Seleccione un producto)");
        for(Producto p: listado){
            cb_productos.addItem(p.getNombre()+" ("+p.getCodigo_barra()+")");
        }
        Color color = new Color(94,84,142);
        btn_elegirProducto.setBackground(color);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(100, 100, (int) dim.getWidth()+4, (int) dim.getHeight()-35);
        
        setLocationRelativeTo(null);
        
    }
    

    Thread threadAutomatico = new Thread(new Runnable() {
        @Override
        public void run() {
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            ConProducto cProducto = new ConProducto();
            Producto p = cProducto.obtenerProducto(txt_codigoBarra.getText());
            if(!p.getNombre().equals("")){
                int filas=table.getRowCount();

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
            else{
               int ingresar = JOptionPane.showConfirmDialog(null, "No hay un producto ingresado con este codigo, ¿Quiere registrarlo?", "Error buscando producto", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION); 
               if(ingresar == 0){
                   IngresarProducto ventana = new IngresarProducto();
                   ventana.setVisible(true);
               }
            }


        }
     });
    
    
    Thread threadManual = new Thread(new Runnable() {
        @Override
        public void run() {
            if(!cb_productos.getSelectedItem().toString().equals("(Seleccione un producto)")){
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                ConProducto cProducto = new ConProducto();
                String codigo = cb_productos.getSelectedItem().toString().replace(")", "ñÑñ").replace("(","ñÑñ").split("ñÑñ")[1];
                Producto p = cProducto.obtenerProducto(codigo);
                if(!p.getNombre().equals("")){
                    int filas=table.getRowCount();

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_codigoBarra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_elegirProducto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cb_productos = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detalleVenta = new javax.swing.JTable();
        btn_eliminarFila = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_total = new javax.swing.JLabel();
        cb_tipoVenta = new javax.swing.JComboBox<>();
        btn_calcularVuelto = new javax.swing.JButton();
        txt_pagoEfectivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_vuelto = new javax.swing.JTextField();
        btn_confirmar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1060));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(224, 177, 203));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 740));

        jLabel1.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        jLabel1.setText("Nueva Venta");

        jPanel2.setBackground(new java.awt.Color(224, 177, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "IDENTIFICAR PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        txt_codigoBarra.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_codigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoBarraActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("ESCANEAR CODIGO DE BARRA");

        btn_elegirProducto.setBackground(new java.awt.Color(94, 84, 142));
        btn_elegirProducto.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btn_elegirProducto.setForeground(new java.awt.Color(255, 255, 255));
        btn_elegirProducto.setText("SELECCIONAR PRODUCTO");
        btn_elegirProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_elegirProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_elegirProducto.setFocusPainted(false);
        btn_elegirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elegirProductoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("BUSCAR PRODUCTO");

        cb_productos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_codigoBarra)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cb_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_elegirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_elegirProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigoBarra, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(cb_productos))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(224, 177, 203));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DETALLE DE VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tbl_detalleVenta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_detalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD. PRODUCTO", "NOMBRE", "PRECIO (UN.)", "CANTIDAD", "PRECIO TOTAL"
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
        tbl_detalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_detalleVentaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_detalleVenta);

        btn_eliminarFila.setBackground(new java.awt.Color(255, 51, 51));
        btn_eliminarFila.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_eliminarFila.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminarFila.setText("Eliminar selección");
        btn_eliminarFila.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminarFila.setFocusPainted(false);
        btn_eliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarFilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminarFila, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(224, 177, 203));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        lbl_total.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("$0");

        cb_tipoVenta.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cb_tipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "DEBITO", "CREDITO" }));
        cb_tipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipoVentaActionPerformed(evt);
            }
        });

        btn_calcularVuelto.setBackground(new java.awt.Color(94, 84, 142));
        btn_calcularVuelto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_calcularVuelto.setForeground(new java.awt.Color(255, 255, 255));
        btn_calcularVuelto.setText("Calcular vuelto");
        btn_calcularVuelto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_calcularVuelto.setFocusPainted(false);
        btn_calcularVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularVueltoActionPerformed(evt);
            }
        });

        txt_pagoEfectivo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pagoEfectivoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setLabelFor(txt_pagoEfectivo);
        jLabel4.setText("PAGA CON:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setLabelFor(txt_vuelto);
        jLabel5.setText("VUELTO:");

        txt_vuelto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_vuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_vuelto.setText("$0");
        txt_vuelto.setBorder(null);
        txt_vuelto.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_tipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_calcularVuelto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txt_pagoEfectivo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_vuelto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_pagoEfectivo)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_calcularVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(cb_tipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_vuelto)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );

        btn_confirmar.setBackground(new java.awt.Color(94, 84, 142));
        btn_confirmar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_confirmar.setForeground(new java.awt.Color(255, 255, 255));
        btn_confirmar.setText("Confirmar venta");
        btn_confirmar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_confirmar.setFocusPainted(false);
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        btn_borrar.setBackground(new java.awt.Color(94, 84, 142));
        btn_borrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_borrar.setText("Cancelar y cerrar");
        btn_borrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_borrar.setFocusPainted(false);
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(395, 395, 395)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(912, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1925, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoBarraActionPerformed
        threadAutomatico.run();
        txt_codigoBarra.setText("");
        threadPRECIO.run();
        
    }//GEN-LAST:event_txt_codigoBarraActionPerformed

    private void tbl_detalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_detalleVentaKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_F1){
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            int cantidad = (int) table.getValueAt(row, 3);
            table.setValueAt(cantidad+1, row, 3);
            int precio = (int)table.getValueAt(row, 2);
            String valorTotal = String.format("$%,d",Integer.valueOf(cantidad*precio));
            table.setValueAt(valorTotal, row, 4); 
            lostFocus(null, tbl_detalleVenta);
            threadPRECIO.run();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
            int row = tbl_detalleVenta.getSelectedRow();
            int cantidad = (int) table.getValueAt(row, 3);
            if(cantidad -1 > 0){
                table.setValueAt(cantidad-1, row, 3);
                int precio = (int)table.getValueAt(row, 2);
                String valorTotal = String.format("$%,d",Integer.valueOf(cantidad*precio));
                table.setValueAt(valorTotal, row, 4); 
                lostFocus(null, tbl_detalleVenta);
                threadPRECIO.run();
            }
                
            
        }
    }//GEN-LAST:event_tbl_detalleVentaKeyPressed

    private void btn_eliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarFilaActionPerformed
        DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
        try{
            table.removeRow(tbl_detalleVenta.getSelectedRow());
            threadPRECIO.run();
        }
        catch(Exception e){
            System.out.println("NADA SELECCIONADO");
        }
    }//GEN-LAST:event_btn_eliminarFilaActionPerformed

    private void btn_elegirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elegirProductoActionPerformed
        threadManual.run();
        cb_productos.setSelectedIndex(0);
        threadPRECIO.run();
    }//GEN-LAST:event_btn_elegirProductoActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        if(btn_confirmar.getText().equals("Confirmar venta")){ 
            if(tbl_detalleVenta.getRowCount() > 0){
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                Venta venta = new Venta();
                ArrayList<VentaProducto> lista = new ArrayList<>();
                venta.setTipo_venta(cb_tipoVenta.getSelectedItem().toString());
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
                boolean operacion = cVenta.registrarVenta(venta, lista, this);
                if(operacion){                         
                    btn_confirmar.setText("Ingresar otra venta");
                    txt_codigoBarra.setEnabled(false);
                    cb_productos.setEnabled(false);
                    btn_elegirProducto.setEnabled(false);
                    cb_tipoVenta.setEnabled(false);
                    tbl_detalleVenta.setEnabled(false);
                    btn_calcularVuelto.setEnabled(false);
                    txt_pagoEfectivo.setEnabled(false);
                    btn_eliminarFila.setEnabled(false);
                }
                    
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Ningun producto ingresado", "Error ingresando venta", JOptionPane.ERROR_MESSAGE);

            }
        }    
        else{
            int confirmar = JOptionPane.showConfirmDialog(this, "¿Ingresar nueva venta? Se borrarán los datos desplegados en la pantalla", "Nueva venta", JOptionPane.YES_NO_OPTION);
            if(confirmar == 0){
                DefaultTableModel table = (DefaultTableModel) tbl_detalleVenta.getModel();
                table.setRowCount(0);
                threadPRECIO.run();
                txt_pagoEfectivo.setText("$0");
                txt_vuelto.setText("$0");
                cb_tipoVenta.setSelectedIndex(0);
                txt_codigoBarra.setEnabled(true);
                cb_productos.setEnabled(true);
                btn_elegirProducto.setEnabled(true);
                cb_tipoVenta.setEnabled(true);
                tbl_detalleVenta.setEnabled(true);
                btn_calcularVuelto.setEnabled(true);
                txt_pagoEfectivo.setEnabled(true);
                btn_eliminarFila.setEnabled(true);
                btn_confirmar.setText("Confirmar venta");
            }
        }
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void cb_tipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipoVentaActionPerformed
        if(!cb_tipoVenta.getSelectedItem().toString().equals("EFECTIVO")){
            btn_calcularVuelto.setEnabled(false);        
            txt_pagoEfectivo.setEnabled(false);
         
        }
        else{
            btn_calcularVuelto.setEnabled(true);        
            txt_pagoEfectivo.setEnabled(true);
         
        } 
    }//GEN-LAST:event_cb_tipoVentaActionPerformed

    private void btn_calcularVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularVueltoActionPerformed
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
    }//GEN-LAST:event_btn_calcularVueltoActionPerformed

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
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_calcularVuelto;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_elegirProducto;
    private javax.swing.JButton btn_eliminarFila;
    private javax.swing.JComboBox<String> cb_productos;
    private javax.swing.JComboBox<String> cb_tipoVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_detalleVenta;
    private javax.swing.JTextField txt_codigoBarra;
    private javax.swing.JTextField txt_pagoEfectivo;
    private javax.swing.JTextField txt_vuelto;
    // End of variables declaration//GEN-END:variables
}
