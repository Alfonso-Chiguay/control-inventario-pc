package vista;
import controlador.ConColores;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.PaletaColor;
import modelo.Producto;


public class ConsultarPrecio extends javax.swing.JFrame {

    ArrayList<Producto> productos;
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
    
    public ConsultarPrecio() {
        initComponents();

    }
    
    public ConsultarPrecio(ArrayList<Producto> listado) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Consultar precio");            
        productos = listado;
        txt_tituloVentana.setForeground(textColor);
        lbl_codigoProducto.setForeground(textColor);
        lbl_precio.setForeground(textColor);
        lbl_precioText.setForeground(textColor);
        txt_codigoProducto.setForeground(textColor);
        txt_nombreProducto.setBackground(BackgroundColor);
        txt_nombreProducto.setForeground(textColor);
        BackGround.setBackground(BackgroundColor);
        ContainerPrecio.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);
    }    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        lbl_codigoProducto = new javax.swing.JLabel();
        txt_codigoProducto = new javax.swing.JTextField();
        txt_nombreProducto = new javax.swing.JTextField();
        lbl_precioText = new javax.swing.JLabel();
        ContainerPrecio = new javax.swing.JPanel();
        lbl_precio = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(930, 500));
        setResizable(false);

        BackGround.setBackground(new java.awt.Color(230, 204, 178));
        BackGround.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackGround.setPreferredSize(new java.awt.Dimension(930, 500));
        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_codigoProducto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lbl_codigoProducto.setForeground(new java.awt.Color(127, 85, 57));
        lbl_codigoProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        lbl_codigoProducto.setText("CÓDIGO DE PRODUCTO");
        BackGround.add(lbl_codigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, 910, 38));

        txt_codigoProducto.setFont(new java.awt.Font("Roboto Thin", 0, 20)); // NOI18N
        txt_codigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoProductoActionPerformed(evt);
            }
        });
        BackGround.add(txt_codigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 249, 38));

        txt_nombreProducto.setEditable(false);
        txt_nombreProducto.setBackground(new java.awt.Color(230, 204, 178));
        txt_nombreProducto.setFont(new java.awt.Font("Roboto Thin", 0, 30)); // NOI18N
        txt_nombreProducto.setForeground(new java.awt.Color(127, 85, 57));
        txt_nombreProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreProducto.setBorder(null);
        txt_nombreProducto.setFocusable(false);
        txt_nombreProducto.setRequestFocusEnabled(false);
        BackGround.add(txt_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 186, 910, 38));

        lbl_precioText.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        lbl_precioText.setForeground(new java.awt.Color(127, 85, 57));
        lbl_precioText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_precioText.setText("PRECIO");
        BackGround.add(lbl_precioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 910, 32));

        ContainerPrecio.setBackground(new java.awt.Color(230, 204, 178));
        ContainerPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbl_precio.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lbl_precio.setForeground(new java.awt.Color(127, 85, 57));
        lbl_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ContainerPrecioLayout = new javax.swing.GroupLayout(ContainerPrecio);
        ContainerPrecio.setLayout(ContainerPrecioLayout);
        ContainerPrecioLayout.setHorizontalGroup(
            ContainerPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_precio, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );
        ContainerPrecioLayout.setVerticalGroup(
            ContainerPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerPrecioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        BackGround.add(ContainerPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  CONSULTA DE PRECIO");
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
        BackGround.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));

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

        BackGround.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 40, 40));

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

        BackGround.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoProductoActionPerformed

        //ConProducto cProducto = new ConProducto();
        //Producto p = cProducto.consultaPrecio(txt_codigoProducto.getText());        
        
        Producto p = new Producto();
        for(Producto producto: productos){
            if(producto.getCodigo_barra().toLowerCase().equals(txt_codigoProducto.getText().toLowerCase())){
                p = producto;
                break;
            }
        }
        
        if(!p.getNombre().equals("")){
            lbl_precio.setText(String.format("$%,d",Integer.valueOf(p.getPrecio())));
            txt_nombreProducto.setText(p.getNombre());
            txt_codigoProducto.setText("");
            
        }
        else {
            lbl_precio.setText("");
            txt_nombreProducto.setText("NO EXISTE PRODUCTO REGISTRADO");

            txt_codigoProducto.setText("");
        }            

    }//GEN-LAST:event_txt_codigoProductoActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPrecio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel ContainerPrecio;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JLabel lbl_codigoProducto;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_precioText;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_codigoProducto;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables
}
