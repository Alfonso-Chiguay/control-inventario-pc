package vista;
import controlador.ConColores;
import controlador.ConProducto;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.PaletaColor;

public class ActualizarStockMasivo extends javax.swing.JFrame {

    private static final ConColores cColor = new ConColores();
    JFrame mainWindow;
    int xMouse, yMouse;    
    
    
    
    public ActualizarStockMasivo() {
   
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Actualizar Stock Masivo");          
        txt_filtro.setEnabled(false);
        BackGround.setBackground(BackgroundColor);
        ProgressBar.setForeground(PanelColor);
        rb_filtrado.setBackground(BackgroundColor);
        rb_total.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);  
        btn_generarExcel.setBackground(PanelColor);
        btn_subirExcel.setBackground(PanelColor);
        txt_tituloVentana.setForeground(textColor);
        
        Titulo1.setForeground(textColor);
        Titulo2.setForeground(textColor);
        rb_filtrado.setForeground(textColor);
        rb_total.setForeground(textColor);
    }


    PaletaColor paleta = cColor.paletaActiva();
    
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick();
    Color textColor = mouseEnterPanelColor;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BackGround = new javax.swing.JPanel();
        Titulo1 = new javax.swing.JLabel();
        rb_total = new javax.swing.JRadioButton();
        rb_filtrado = new javax.swing.JRadioButton();
        txt_filtro = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Titulo2 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        btn_generarExcel = new javax.swing.JPanel();
        txt_generarExcel = new javax.swing.JLabel();
        btn_subirExcel = new javax.swing.JPanel();
        txt_subirExcel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        BackGround.setBackground(new java.awt.Color(230, 204, 178));
        BackGround.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackGround.setPreferredSize(new java.awt.Dimension(625, 690));
        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        Titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo1.setText("OBTENER EXCEL DE CARGA");
        BackGround.add(Titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 510, 58));

        rb_total.setBackground(new java.awt.Color(230, 204, 178));
        buttonGroup1.add(rb_total);
        rb_total.setFont(new java.awt.Font("Roboto Light", 0, 30)); // NOI18N
        rb_total.setSelected(true);
        rb_total.setText("Archivo de stock general");
        rb_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_totalActionPerformed(evt);
            }
        });
        BackGround.add(rb_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        rb_filtrado.setBackground(new java.awt.Color(230, 204, 178));
        buttonGroup1.add(rb_filtrado);
        rb_filtrado.setFont(new java.awt.Font("Roboto Light", 0, 30)); // NOI18N
        rb_filtrado.setText("Filtrar por palabra clave");
        rb_filtrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_filtradoActionPerformed(evt);
            }
        });
        BackGround.add(rb_filtrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        txt_filtro.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_filtro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        BackGround.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 390, 43));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        BackGround.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 510, 10));

        Titulo2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        Titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo2.setText("ACTUALIZACIÓN MASIVA");
        BackGround.add(Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 510, 58));

        ProgressBar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ProgressBar.setForeground(new java.awt.Color(127, 85, 57));
        ProgressBar.setBorderPainted(false);
        ProgressBar.setStringPainted(true);
        BackGround.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 490, 36));

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

        BackGround.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 40, 40));

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

        BackGround.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, 40));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  ACTUALIZACION DE STOCK MASIVO");
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
        BackGround.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        btn_generarExcel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_generarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generarExcel.setPreferredSize(new java.awt.Dimension(230, 70));

        txt_generarExcel.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_generarExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_generarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        txt_generarExcel.setLabelFor(btn_generarExcel);
        txt_generarExcel.setText("Generar Excel");
        txt_generarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_generarExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_generarExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_generarExcelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_generarExcelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_generarExcelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_generarExcelLayout = new javax.swing.GroupLayout(btn_generarExcel);
        btn_generarExcel.setLayout(btn_generarExcelLayout);
        btn_generarExcelLayout.setHorizontalGroup(
            btn_generarExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_generarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        btn_generarExcelLayout.setVerticalGroup(
            btn_generarExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_generarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        BackGround.add(btn_generarExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 250, 70));

        btn_subirExcel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_subirExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_subirExcel.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_subirExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_subirExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/upload_file.png"))); // NOI18N
        txt_subirExcel.setText("Subir Excel de carga");
        txt_subirExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_subirExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_subirExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_subirExcelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_subirExcelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_subirExcelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_subirExcelLayout = new javax.swing.GroupLayout(btn_subirExcel);
        btn_subirExcel.setLayout(btn_subirExcelLayout);
        btn_subirExcelLayout.setHorizontalGroup(
            btn_subirExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_subirExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        btn_subirExcelLayout.setVerticalGroup(
            btn_subirExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_subirExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        BackGround.add(btn_subirExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 250, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rb_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_totalActionPerformed
        filtroEditable();
    }//GEN-LAST:event_rb_totalActionPerformed

    private void rb_filtradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_filtradoActionPerformed
        filtroEditable();
    }//GEN-LAST:event_rb_filtradoActionPerformed

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

    private void txt_tituloVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloVentanaMouseDragged

    private void txt_tituloVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloVentanaMousePressed

    private void txt_generarExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_generarExcelMouseEntered
        btn_generarExcel.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_generarExcelMouseEntered

    private void txt_generarExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_generarExcelMouseExited
        btn_generarExcel.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_generarExcelMouseExited

    private void txt_generarExcelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_generarExcelMousePressed
        if(evt.getButton() == 1){
            btn_generarExcel.setBackground(mouseClickPanelColor);
            ConProducto cProducto = new ConProducto();
            if(rb_total.isSelected()){
                cProducto.excelCargaStockMasivo("");
            }
            else if(rb_filtrado.isSelected()){
                String filtro = txt_filtro.getText();
                if(filtro.equals("")){
                    JOptionPane.showMessageDialog(this, "Debe llenar el campo de texto para aplicar un filtro", "No hay filtro", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    cProducto.excelCargaStockMasivo(filtro);
                }
            }
        }
    }//GEN-LAST:event_txt_generarExcelMousePressed

    private void txt_generarExcelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_generarExcelMouseReleased
        if(btn_generarExcel.contains(evt.getPoint())) btn_generarExcel.setBackground(mouseEnterPanelColor);
        else btn_generarExcel.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_generarExcelMouseReleased

    private void txt_subirExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_subirExcelMouseEntered
        btn_subirExcel.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_subirExcelMouseEntered

    private void txt_subirExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_subirExcelMouseExited
        btn_subirExcel.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_subirExcelMouseExited

    private void txt_subirExcelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_subirExcelMousePressed
        if(evt.getButton() == 1){
            btn_subirExcel.setBackground(mouseClickPanelColor);
            String ruta =System.getProperty("user.home")+"/Desktop/Carga masiva/Actualizacion stock masivo/";
            JFileChooser jf = new JFileChooser(ruta);
            jf.updateUI();
            jf.showOpenDialog(this);
            File archivo = jf.getSelectedFile();
            if(archivo != null){
                if(archivo.toString().contains("Stock masivo.xlsx")){
                    int confirmar = JOptionPane.showConfirmDialog(this, "Este proceso puede tardar unos minutos, ¿desea continuar?", "Confirmar carga", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirmar == 0){
                        ConProducto cProducto = new ConProducto();
                        cProducto.actualizacionMasiva(archivo, ProgressBar, this);
                    }
                }
            }
            ProgressBar.setVisible(true);
        }
    }//GEN-LAST:event_txt_subirExcelMousePressed

    private void txt_subirExcelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_subirExcelMouseReleased
        if(btn_subirExcel.contains(evt.getPoint())) btn_subirExcel.setBackground(mouseEnterPanelColor);
        else btn_subirExcel.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_subirExcelMouseReleased
   
    private void filtroEditable(){
        if(rb_filtrado.isSelected()){
            txt_filtro.setEnabled(true);
        }
        else{
            txt_filtro.setEnabled(false);
            txt_filtro.setText("");
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
            java.util.logging.Logger.getLogger(ActualizarStockMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarStockMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarStockMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarStockMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarStockMasivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel Titulo1;
    private javax.swing.JLabel Titulo2;
    private javax.swing.JPanel btn_generarExcel;
    private javax.swing.JPanel btn_subirExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rb_filtrado;
    private javax.swing.JRadioButton rb_total;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_filtro;
    private javax.swing.JLabel txt_generarExcel;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_subirExcel;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables

}
