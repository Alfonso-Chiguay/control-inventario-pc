package vista;
import controlador.ConColores;
import controlador.ConProducto;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;  
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicProgressBarUI;
import modelo.PaletaColor;


public class CargaMasiva extends javax.swing.JFrame {

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
    
    public CargaMasiva() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Carga masiva");    
        ProgressBar.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() { return Color.black; };
            protected Color getSelectionForeground() { return Color.white; };
            
        });
        txt_tituloVentana.setForeground(textColor);
        ProgressBar.setForeground(PanelColor);
        BackGround.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor); 
        btn_descargarPlantilla.setBackground(PanelColor);
        btn_cargarExcel.setBackground(PanelColor);
        
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();
        btn_descargarPlantilla = new javax.swing.JPanel();
        txt_descargarPlantilla = new javax.swing.JLabel();
        btn_cargarExcel = new javax.swing.JPanel();
        txt_cargarExcel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        BackGround.setBackground(new java.awt.Color(230, 204, 178));
        BackGround.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProgressBar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ProgressBar.setForeground(new java.awt.Color(127, 85, 57));
        ProgressBar.setBorderPainted(false);
        ProgressBar.setStringPainted(true);
        BackGround.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 460, 36));

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

        BackGround.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 40, 40));

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

        BackGround.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 40, 40));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  CARGA MASIVA DE PRODUCTOS");
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
        BackGround.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        btn_descargarPlantilla.setPreferredSize(new java.awt.Dimension(270, 70));

        txt_descargarPlantilla.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_descargarPlantilla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_descargarPlantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        txt_descargarPlantilla.setText("Descargar plantilla");
        txt_descargarPlantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_descargarPlantilla.setPreferredSize(new java.awt.Dimension(270, 70));
        txt_descargarPlantilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_descargarPlantillaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_descargarPlantillaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_descargarPlantillaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_descargarPlantillaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_descargarPlantillaLayout = new javax.swing.GroupLayout(btn_descargarPlantilla);
        btn_descargarPlantilla.setLayout(btn_descargarPlantillaLayout);
        btn_descargarPlantillaLayout.setHorizontalGroup(
            btn_descargarPlantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_descargarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_descargarPlantillaLayout.setVerticalGroup(
            btn_descargarPlantillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_descargarPlantilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BackGround.add(btn_descargarPlantilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 270, 70));

        btn_cargarExcel.setPreferredSize(new java.awt.Dimension(270, 70));

        txt_cargarExcel.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_cargarExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_cargarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/upload_file.png"))); // NOI18N
        txt_cargarExcel.setText("Subir archivo de carga");
        txt_cargarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_cargarExcel.setPreferredSize(new java.awt.Dimension(270, 70));
        txt_cargarExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_cargarExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_cargarExcelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_cargarExcelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_cargarExcelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_cargarExcelLayout = new javax.swing.GroupLayout(btn_cargarExcel);
        btn_cargarExcel.setLayout(btn_cargarExcelLayout);
        btn_cargarExcelLayout.setHorizontalGroup(
            btn_cargarExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cargarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_cargarExcelLayout.setVerticalGroup(
            btn_cargarExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cargarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BackGround.add(btn_cargarExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 270, 70));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        BackGround.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 480, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txt_descargarPlantillaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descargarPlantillaMouseEntered
        btn_descargarPlantilla.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_descargarPlantillaMouseEntered

    private void txt_descargarPlantillaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descargarPlantillaMouseExited
        btn_descargarPlantilla.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_descargarPlantillaMouseExited

    private void txt_descargarPlantillaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descargarPlantillaMousePressed
        if(evt.getButton() == 1){
            btn_descargarPlantilla.setBackground(mouseClickPanelColor);
            String  rutaPlantilla = "src/Plantillas/Carga masiva productos.xlsx";   
            String rutaDescarga = System.getProperty("user.home")+"/Desktop/Carga masiva/"; 
            File archivoCopia = new File(rutaPlantilla);       
            File rutaFinalCopia = new File(rutaDescarga+archivoCopia.getName());  
            try{
                Files.copy(archivoCopia.toPath(), rutaFinalCopia.toPath(),REPLACE_EXISTING);  
                JOptionPane.showMessageDialog(this, "Se creó una copia", "Copia realizada", JOptionPane.INFORMATION_MESSAGE);
                Desktop.getDesktop().open(new File(rutaDescarga));
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "No se pudo obtener la copia", "Copia fallida", JOptionPane.WARNING_MESSAGE);  
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_txt_descargarPlantillaMousePressed

    private void txt_descargarPlantillaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descargarPlantillaMouseReleased
        btn_descargarPlantilla.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_descargarPlantillaMouseReleased

    private void txt_cargarExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargarExcelMouseEntered
        btn_cargarExcel.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_cargarExcelMouseEntered

    private void txt_cargarExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargarExcelMouseExited
        btn_cargarExcel.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_cargarExcelMouseExited

    private void txt_cargarExcelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargarExcelMousePressed
        if(evt.getButton() == 1){
            btn_cargarExcel.setBackground(mouseClickPanelColor);
            String ruta =System.getProperty("user.home")+"/Desktop/Carga masiva/"; 
            JFileChooser jf = new JFileChooser(ruta);
            jf.updateUI();

            jf.showOpenDialog(this);
            File archivo = jf.getSelectedFile();
            if(archivo != null){
                if(archivo.toString().contains("Carga masiva productos.xlsx")){
                    int confirmar = JOptionPane.showConfirmDialog(this, "Este proceso puede tardar unos minutos, ¿desea continuar?", "Confirmar carga", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(confirmar == 0){                      
                        ConProducto cProducto = new ConProducto();
                        cProducto.cargaMasiva(archivo, ProgressBar, this);
                    }   
                }
            }
            ProgressBar.setVisible(true);  
        }
    }//GEN-LAST:event_txt_cargarExcelMousePressed

    private void txt_cargarExcelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargarExcelMouseReleased
        btn_cargarExcel.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_cargarExcelMouseReleased

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
            java.util.logging.Logger.getLogger(CargaMasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaMasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaMasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaMasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {



                
                new CargaMasiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JPanel btn_cargarExcel;
    private javax.swing.JPanel btn_descargarPlantilla;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txt_cargarExcel;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_descargarPlantilla;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables
}


