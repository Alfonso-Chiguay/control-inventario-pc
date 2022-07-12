package vista;

import controlador.ConColores;
import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import modelo.PaletaColor;
import java.time.*;
import db.Conexion;
import java.sql.Connection;

public class CambiarPaleta extends javax.swing.JFrame {
    
    private static final ConColores cColor = new ConColores();
    
    public CambiarPaleta() {
        initComponents(); 
    }
    
    public CambiarPaleta(PaletaColor paleta, Instant inicio) {
        
        Instant fin=Instant.now();  
        System.out.println("Constructor: "+Duration.between(inicio, fin).toMillis());
        Instant start = Instant.now();
        initComponents();
        Instant end = Instant.now();        
        System.out.println("initComponent: "+Duration.between(start, end).toMillis());
        
        start = Instant.now();
        Background.setBackground(paleta.getBackground());
        PanelDemostracion.setBackground(Color.WHITE);
        MinPanel.setBackground(paleta.getBackground());
        ClosePanel.setBackground(paleta.getBackground());
        end = Instant.now();
        
        System.out.println("Colores: "+Duration.between(start, end).toMillis());
        
        start = Instant.now();
        ArrayList<String> listadoPaletas = cColor.listarPaletas();
        end = Instant.now();
        listadoPaletas.forEach((paletaString) -> {
            cbb_paletas.addItem(paletaString);
        });
        
        System.out.println("Combobox: "+Duration.between(start, end).toMillis());
        start = Instant.now();        
        actualizarColoresDemo();
        end = Instant.now();  
        
        System.out.println("ActualizarColoresDemo: "+Duration.between(start, end).toMillis());
        System.out.println("Tiempo total: "+Duration.between(inicio, end).toMillis());
    }    
    
    PaletaColor paleta = cColor.paletaActiva();
    
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick(); 
    
    private void actualizarColoresDemo(){
        String id_paleta = cbb_paletas.getSelectedItem().toString();
        PaletaColor coloresDemo = cColor.buscarPorId(id_paleta);
        
        Color bg = coloresDemo.getBackground();
        Color panel = coloresDemo.getPanel();
        
        BackgroundDemo.setBackground(bg);
        btn1demo.setBackground(coloresDemo.getMouseEnter());
        btn2demo.setBackground(panel);
        btn3demo.setBackground(panel);
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
        btn2demo = new javax.swing.JPanel();
        btn3demo = new javax.swing.JPanel();
        BackgroundDemo = new javax.swing.JPanel();
        BannerDemo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbb_paletas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1170, 800));
        setResizable(false);

        Background.setBackground(new java.awt.Color(102, 102, 102));
        Background.setForeground(new java.awt.Color(102, 102, 102));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClosePanel.setBackground(new java.awt.Color(255, 255, 153));
        ClosePanel.setPreferredSize(new java.awt.Dimension(35, 35));

        txt_close.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txt_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_close.setText("X");
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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 40, 40));

        MinPanel.setBackground(new java.awt.Color(255, 255, 153));
        MinPanel.setPreferredSize(new java.awt.Dimension(35, 35));

        txt_minimize.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        txt_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_minimize.setText("_");
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
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        MinPanelLayout.setVerticalGroup(
            MinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 40, 40));

        PanelDemostracion.setBackground(new java.awt.Color(255, 204, 204));
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

        javax.swing.GroupLayout btn2demoLayout = new javax.swing.GroupLayout(btn2demo);
        btn2demo.setLayout(btn2demoLayout);
        btn2demoLayout.setHorizontalGroup(
            btn2demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        btn2demoLayout.setVerticalGroup(
            btn2demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout btn3demoLayout = new javax.swing.GroupLayout(btn3demo);
        btn3demo.setLayout(btn3demoLayout);
        btn3demoLayout.setHorizontalGroup(
            btn3demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        btn3demoLayout.setVerticalGroup(
            btn3demoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelIzqDemoLayout = new javax.swing.GroupLayout(PanelIzqDemo);
        PanelIzqDemo.setLayout(PanelIzqDemoLayout);
        PanelIzqDemoLayout.setHorizontalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn1demo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn2demo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn3demo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelIzqDemoLayout.setVerticalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIzqDemoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btn1demo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2demo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3demo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        PanelDemostracion.add(PanelIzqDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 380));

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

        PanelDemostracion.add(BackgroundDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 330, 380));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ejemplo de combinacion de colores");
        PanelDemostracion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 480, 30));
        PanelDemostracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 380, -1));

        Background.add(PanelDemostracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 830, 530));

        cbb_paletas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbb_paletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_paletasActionPerformed(evt);
            }
        });
        Background.add(cbb_paletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 410, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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
    private javax.swing.JPanel btn2demo;
    private javax.swing.JPanel btn3demo;
    private javax.swing.JComboBox<String> cbb_paletas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_minimize;
    // End of variables declaration//GEN-END:variables
}
