package vista;

import controlador.ConProducto;
import db.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.Producto;

public class IngresarProducto extends javax.swing.JFrame {

    public static final Conexion CONEXION = new Conexion();
    
    public IngresarProducto() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Pili's Coffee POS Software | Ingresar producto");
        limpiarCampos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_codigoProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombreProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_stockInicial = new javax.swing.JTextField();
        btn_guardarCerrar = new javax.swing.JButton();
        btn_guardarContinuar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 204, 178));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESO DE NUEVO PRODUCTO");

        jPanel2.setBackground(new java.awt.Color(230, 204, 178));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_codigoProducto.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 85, 57));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        jLabel2.setText("CÓDIGO DEL PRODUCTO");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 85, 57));
        jLabel3.setText("NOMBRE DEL PRODUCTO");

        txt_nombreProducto.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 85, 57));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pricetag.png"))); // NOI18N
        jLabel4.setText("PRECIO");

        txt_precio.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txt_precio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_precioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_precioFocusLost(evt);
            }
        });
        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 85, 57));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stock.png"))); // NOI18N
        jLabel5.setText("STOCK INICIAL");

        txt_stockInicial.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txt_stockInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_stockInicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_stockInicialFocusLost(evt);
            }
        });
        txt_stockInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_stockInicialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_nombreProducto)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addComponent(txt_precio))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_stockInicial)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_codigoProducto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(txt_nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stockInicial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        btn_guardarCerrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_guardarCerrar.setForeground(new java.awt.Color(127, 85, 57));
        btn_guardarCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btn_guardarCerrar.setText("Guardar y cerrar");
        btn_guardarCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarCerrarActionPerformed(evt);
            }
        });

        btn_guardarContinuar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_guardarContinuar.setForeground(new java.awt.Color(127, 85, 57));
        btn_guardarContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save edit.png"))); // NOI18N
        btn_guardarContinuar.setText("Guardar e ingresar otro");
        btn_guardarContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarContinuarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(127, 85, 57));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btn_limpiar.setText("Limpiar campos");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(127, 85, 57));
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leave.png"))); // NOI18N
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardarContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_guardarCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btn_guardarCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardarContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_guardarCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarCerrarActionPerformed
        String codigo = txt_codigoProducto.getText();
        String nombre = txt_nombreProducto.getText();
        String precio = txt_precio.getText().replace("$", "").replace(".", "");
        String stock = txt_stockInicial.getText();
        try{
            Producto p = new Producto(codigo,nombre,Integer.valueOf(precio), Integer.valueOf(stock)); 
            ConProducto cProducto = new ConProducto();
            if(cProducto.existeCodigo(codigo)){
                JOptionPane.showMessageDialog(this, "El codigo ya está registrado", "Error ingresando producto", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int confirmar = JOptionPane.showConfirmDialog(this, "Confirmar el ingreso del nuevo producto", "Ingresar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(confirmar == 0){
                    if(CONEXION.isNetworkOnline()){
                        boolean ingreso = cProducto.ingresarProducto(p);
                        if(ingreso){
                            JOptionPane.showMessageDialog(this, "Se ingreso el producto con exito", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No se pudo ingresar el producto, contáctese con soporte", "Operacion fallida", JOptionPane.INFORMATION_MESSAGE);
                        }       
                    }
                    else JOptionPane.showMessageDialog(this, "No hay acceso al servidor en estos momentos, no se puede comunicar con la base de datos, vuelva a intentarlo cuando tenga una conexion a internet", "Carga fallida", JOptionPane.WARNING_MESSAGE);  
            
                }  
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error con datos de producto",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_guardarCerrarActionPerformed

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_precioKeyTyped

    private void txt_stockInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stockInicialKeyTyped
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_stockInicialKeyTyped

    private void txt_precioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_precioFocusGained
        if(txt_precio.getText().equals("$0")) txt_precio.setText("");
    }//GEN-LAST:event_txt_precioFocusGained

    private void txt_precioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_precioFocusLost
        if(txt_precio.getText().equals("")) txt_precio.setText("$0");
        else{
            String valor = txt_precio.getText().replace("$", "").replace(".", "");
            txt_precio.setText(String.format("$%,d",Integer.valueOf(valor)));
        }
        
    }//GEN-LAST:event_txt_precioFocusLost

    private void txt_stockInicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_stockInicialFocusGained
        if(txt_stockInicial.getText().equals("0")) txt_stockInicial.setText("");
    }//GEN-LAST:event_txt_stockInicialFocusGained

    private void txt_stockInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_stockInicialFocusLost
        if(txt_stockInicial.getText().equals("")) txt_stockInicial.setText("0");
    }//GEN-LAST:event_txt_stockInicialFocusLost

    private void btn_guardarContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarContinuarActionPerformed
        String codigo = txt_codigoProducto.getText();
        String nombre = txt_nombreProducto.getText().replace("'"," ");
        String precio = txt_precio.getText().replace("$", "").replace(".", "");
        String stock = txt_stockInicial.getText();
        try{
            Producto p = new Producto(codigo,nombre,Integer.valueOf(precio), Integer.valueOf(stock)); 
            ConProducto cProducto = new ConProducto();
            if(cProducto.existeCodigo(codigo)){
                JOptionPane.showMessageDialog(this, "El codigo ya está registrado", "Error ingresando producto", JOptionPane.WARNING_MESSAGE);
            }
            else{
                int confirmar = JOptionPane.showConfirmDialog(this, "Confirmar el ingreso del nuevo producto", "Ingresar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(confirmar == 0){
                    if(CONEXION.isNetworkOnline()){
                        boolean ingreso = cProducto.ingresarProducto(p);
                        if(ingreso){
                            JOptionPane.showMessageDialog(this, "Se ingreso el producto con exito", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCampos();
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "No se pudo ingresar el producto, contáctese con soporte", "Operacion fallida", JOptionPane.INFORMATION_MESSAGE);
                        }   
                    }
                    else JOptionPane.showMessageDialog(this, "No hay acceso al servidor en estos momentos, no se puede comunicar con la base de datos, vuelva a intentarlo cuando tenga una conexion a internet", "Carga fallida", JOptionPane.WARNING_MESSAGE);  

                                       
                }  
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error con datos de producto",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_guardarContinuarActionPerformed
    
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }
    
    private void limpiarCampos(){
        txt_codigoProducto.setText("");
        txt_nombreProducto.setText("");
        txt_precio.setText("$0");
        txt_stockInicial.setText("0");
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
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardarCerrar;
    private javax.swing.JButton btn_guardarContinuar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_codigoProducto;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_stockInicial;
    // End of variables declaration//GEN-END:variables
}
