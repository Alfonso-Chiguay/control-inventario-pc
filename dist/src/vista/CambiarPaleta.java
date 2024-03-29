package vista;

import controlador.ConColores;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import modelo.PaletaColor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CambiarPaleta extends javax.swing.JFrame {
    
    private static final ConColores cColor = new ConColores();
    JFrame mainWindow;
    int xMouse, yMouse;
    public CambiarPaleta() {
        initComponents(); 
    }
    
    public CambiarPaleta(JFrame ventanaPrincipal) {
        
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Cambiar paleta");    
        Background.setBackground(paleta.getBackground());
        PanelDemostracion.setBackground(Color.WHITE);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);
        btn_seleccionar.setBackground(PanelColor);
        txt_tituloVentana.setForeground(mouseEnterPanelColor);
        ArrayList<String> listadoPaletas = cColor.listarPaletas();
        listadoPaletas.forEach((paletaString) -> {
            cbb_paletas.addItem(paletaString);
        });
        cbb_paletas.setBackground(PanelColor);

        actualizarColoresDemo();
        mainWindow = ventanaPrincipal;
        txt_ejemplo.setForeground(textColor);
        
    } 
    
    PaletaColor paleta = cColor.paletaActiva();
    
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();    
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick(); 
    Color textColor = mouseEnterPanelColor;
    
    private void actualizarColoresDemo(){
        String id_paleta = cbb_paletas.getSelectedItem().toString();
        PaletaColor coloresDemo = cColor.buscarPorId(id_paleta);
        
        Color bg = coloresDemo.getBackground();
        Color panel = coloresDemo.getPanel();
        
        BackgroundDemo.setBackground(bg);
        btn1demo.setBackground(coloresDemo.getMouseEnter());
        PanelIzqDemo.setBackground(panel);
        BannerDemo.setBackground(panel);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        PanelDemostracion = new javax.swing.JPanel();
        PanelIzqDemo = new javax.swing.JPanel();
        btn1demo = new javax.swing.JPanel();
        BackgroundDemo = new javax.swing.JPanel();
        BannerDemo = new javax.swing.JPanel();
        txt_ejemplo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbb_paletas = new javax.swing.JComboBox<>();
        btn_seleccionar = new javax.swing.JPanel();
        txt_seleccionar = new javax.swing.JLabel();
        txt_tituloVentana = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(102, 102, 102));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setForeground(new java.awt.Color(102, 102, 102));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 40));

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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 40, 40));

        PanelDemostracion.setBackground(new java.awt.Color(255, 204, 204));
        PanelDemostracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelDemostracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelIzqDemo.setBackground(new java.awt.Color(153, 0, 102));

        javax.swing.GroupLayout btn1demoLayout = new javax.swing.GroupLayout(btn1demo);
        btn1demo.setLayout(btn1demoLayout);
        btn1demoLayout.setHorizontalGroup(
            btn1demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        btn1demoLayout.setVerticalGroup(
            btn1demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelIzqDemoLayout = new javax.swing.GroupLayout(PanelIzqDemo);
        PanelIzqDemo.setLayout(PanelIzqDemoLayout);
        PanelIzqDemoLayout.setHorizontalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn1demo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelIzqDemoLayout.setVerticalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIzqDemoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btn1demo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        PanelDemostracion.add(PanelIzqDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 380));

        BackgroundDemo.setBackground(new java.awt.Color(0, 153, 102));

        javax.swing.GroupLayout BannerDemoLayout = new javax.swing.GroupLayout(BannerDemo);
        BannerDemo.setLayout(BannerDemoLayout);
        BannerDemoLayout.setHorizontalGroup(
            BannerDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );
        BannerDemoLayout.setVerticalGroup(
            BannerDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundDemoLayout = new javax.swing.GroupLayout(BackgroundDemo);
        BackgroundDemo.setLayout(BackgroundDemoLayout);
        BackgroundDemoLayout.setHorizontalGroup(
            BackgroundDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundDemoLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(BannerDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BackgroundDemoLayout.setVerticalGroup(
            BackgroundDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundDemoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BannerDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        PanelDemostracion.add(BackgroundDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 330, 380));

        txt_ejemplo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_ejemplo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ejemplo.setText("EJEMPLO DE COMBINACION DE COLORES");
        PanelDemostracion.add(txt_ejemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 530, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelDemostracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 530, -1));

        Background.add(PanelDemostracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 530, 480));

        cbb_paletas.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        cbb_paletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_paletasActionPerformed(evt);
            }
        });
        Background.add(cbb_paletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 290, 40));

        btn_seleccionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_seleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_seleccionar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_seleccionar.setBackground(new java.awt.Color(255, 255, 255));
        txt_seleccionar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_seleccionar.setForeground(new java.awt.Color(255, 255, 255));
        txt_seleccionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_seleccionar.setText("Seleccionar como predeterminado");
        txt_seleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_seleccionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_seleccionarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_seleccionarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_seleccionarMouseReleased(evt);
            }
        });
        btn_seleccionar.add(txt_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 38));

        Background.add(btn_seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 230, 40));

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  CAMBIAR PALETA DE COLORES");
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
        Background.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void cbb_paletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_paletasActionPerformed
        actualizarColoresDemo();
    }//GEN-LAST:event_cbb_paletasActionPerformed

    private void txt_seleccionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_seleccionarMouseEntered
        btn_seleccionar.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_seleccionarMouseEntered

    private void txt_seleccionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_seleccionarMouseExited
        btn_seleccionar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_seleccionarMouseExited

    private void txt_seleccionarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_seleccionarMouseReleased
        if(btn_seleccionar.contains(evt.getPoint())) btn_seleccionar.setBackground(mouseEnterPanelColor);
        else btn_seleccionar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_seleccionarMouseReleased

    private void txt_seleccionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_seleccionarMousePressed
        btn_seleccionar.setBackground(mouseClickPanelColor);
        ConColores cColor = new ConColores();
        String id_paleta = cbb_paletas.getSelectedItem().toString();
        cColor.cambiarPaletaActiva(id_paleta);
        mainWindow.dispose();
        
        Home ventana = new Home();
        ventana.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(null, "Cambios realizado con exito", "Cambio de color", JOptionPane.INFORMATION_MESSAGE);
        
        
    }//GEN-LAST:event_txt_seleccionarMousePressed

    private void txt_tituloVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMousePressed
            xMouse = evt.getX();
            yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloVentanaMousePressed

    private void txt_tituloVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloVentanaMouseDragged

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
            java.util.logging.Logger.getLogger(CambiarPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarPaleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel BackgroundDemo;
    private javax.swing.JPanel BannerDemo;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelDemostracion;
    private javax.swing.JPanel PanelIzqDemo;
    private javax.swing.JPanel btn1demo;
    private javax.swing.JPanel btn_seleccionar;
    private javax.swing.JComboBox<String> cbb_paletas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_ejemplo;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_seleccionar;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables
}
