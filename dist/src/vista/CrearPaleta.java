/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConColores;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.PaletaColor;

/**
 *
 * @author alfon
 */
public class CrearPaleta extends javax.swing.JFrame {

private static final ConColores cColor = new ConColores();  
    
    int xMouse, yMouse; 
    PaletaColor paleta = cColor.paletaActiva();
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick();
    Color textColor = mouseEnterPanelColor;  
    JFrame mainWindow;
    public CrearPaleta(){
        initComponents();
    }
    
    public CrearPaleta(JFrame ventanaPrincipal) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Crear paleta");         
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);
        txt_tituloVentana.setForeground(textColor);
        Background.setBackground(BackgroundColor);
        ColorChooser.removeChooserPanel(ColorChooser.getChooserPanels()[0]);
        ColorChooser.removeChooserPanel(ColorChooser.getChooserPanels()[1]);
        ColorChooser.removeChooserPanel(ColorChooser.getChooserPanels()[2]);
        ColorChooser.setPreviewPanel(new JPanel());
        ColorSelectionModel model = ColorChooser.getSelectionModel();
        ChangeListener changeListener = new ChangeListener() {
          public void stateChanged(ChangeEvent changeEvent) {
            Color color = ColorChooser.getColor();
            colorEnVivo.setBackground(color);
          }
        };
        model.addChangeListener(changeListener);
        
        
        mainWindow = ventanaPrincipal;
        btn_color1.setBackground(new Color(153,153,153));
        btn_color2.setBackground(new Color(204,204,204));
        ColorChooser.setBackground(BackgroundColor);
        PanelGuardar.setBackground(BackgroundColor);
        PanelGuardar.setBorder(BorderFactory.createTitledBorder(null, "Guardar paleta", TitledBorder.CENTER, TitledBorder.TOP, new Font("Roboto",Font.BOLD,24), textColor));
        lbl_nombrePaleta.setForeground(textColor);
        btn_guardar.setBackground(PanelColor);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        txt_tituloVentana = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        colorEnVivo = new javax.swing.JPanel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        PanelDemostracion = new javax.swing.JPanel();
        PanelIzqDemo = new javax.swing.JPanel();
        btnMouseEnter = new javax.swing.JPanel();
        BackgroundDemo = new javax.swing.JPanel();
        BannerDemo = new javax.swing.JPanel();
        lbl_Textodemo = new javax.swing.JLabel();
        btnMouseClick = new javax.swing.JPanel();
        txt_ejemplo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ColorChooser = new javax.swing.JColorChooser();
        btn_color1 = new javax.swing.JPanel();
        txt_color1 = new javax.swing.JLabel();
        btn_color2 = new javax.swing.JPanel();
        txt_color2 = new javax.swing.JLabel();
        PanelGuardar = new javax.swing.JPanel();
        lbl_nombrePaleta = new javax.swing.JLabel();
        txt_nombrePaleta = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JPanel();
        txt_guardarCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setPreferredSize(new java.awt.Dimension(1130, 915));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tituloVentana.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_tituloVentana.setText("  CREAR NUEVA PALETA DE COLORES");
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
        Background.add(txt_tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 40));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vista previa");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 160, 20));

        colorEnVivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        colorEnVivo.setPreferredSize(new java.awt.Dimension(150, 150));

        javax.swing.GroupLayout colorEnVivoLayout = new javax.swing.GroupLayout(colorEnVivo);
        colorEnVivo.setLayout(colorEnVivoLayout);
        colorEnVivoLayout.setHorizontalGroup(
            colorEnVivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        colorEnVivoLayout.setVerticalGroup(
            colorEnVivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        Background.add(colorEnVivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 160, 150));

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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 40, 40));

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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 40, 40));

        PanelDemostracion.setBackground(new java.awt.Color(0, 0, 0));
        PanelDemostracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PanelDemostracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelIzqDemo.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout btnMouseEnterLayout = new javax.swing.GroupLayout(btnMouseEnter);
        btnMouseEnter.setLayout(btnMouseEnterLayout);
        btnMouseEnterLayout.setHorizontalGroup(
            btnMouseEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        btnMouseEnterLayout.setVerticalGroup(
            btnMouseEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelIzqDemoLayout = new javax.swing.GroupLayout(PanelIzqDemo);
        PanelIzqDemo.setLayout(PanelIzqDemoLayout);
        PanelIzqDemoLayout.setHorizontalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMouseEnter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelIzqDemoLayout.setVerticalGroup(
            PanelIzqDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIzqDemoLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnMouseEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        PanelDemostracion.add(PanelIzqDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 380));

        BackgroundDemo.setBackground(new java.awt.Color(153, 153, 153));

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

        lbl_Textodemo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_Textodemo.setText("TEXTO DE EJEMPLO");

        javax.swing.GroupLayout btnMouseClickLayout = new javax.swing.GroupLayout(btnMouseClick);
        btnMouseClick.setLayout(btnMouseClickLayout);
        btnMouseClickLayout.setHorizontalGroup(
            btnMouseClickLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        btnMouseClickLayout.setVerticalGroup(
            btnMouseClickLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundDemoLayout = new javax.swing.GroupLayout(BackgroundDemo);
        BackgroundDemo.setLayout(BackgroundDemoLayout);
        BackgroundDemoLayout.setHorizontalGroup(
            BackgroundDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundDemoLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addGroup(BackgroundDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BannerDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Textodemo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundDemoLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnMouseClick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        BackgroundDemoLayout.setVerticalGroup(
            BackgroundDemoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundDemoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(BannerDemo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lbl_Textodemo)
                .addGap(60, 60, 60)
                .addComponent(btnMouseClick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        PanelDemostracion.add(BackgroundDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 330, 380));

        txt_ejemplo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_ejemplo.setForeground(new java.awt.Color(255, 255, 255));
        txt_ejemplo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ejemplo.setText("EJEMPLO DE COMBINACION DE COLORES");
        PanelDemostracion.add(txt_ejemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 530, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PanelDemostracion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 530, -1));

        Background.add(PanelDemostracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 530, 480));
        Background.add(ColorChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 1100, 360));

        btn_color1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_color1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txt_color1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_color1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pincel.png"))); // NOI18N
        txt_color1.setText("COLOR 1");
        txt_color1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_color1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_color1Layout = new javax.swing.GroupLayout(btn_color1);
        btn_color1.setLayout(btn_color1Layout);
        btn_color1Layout.setHorizontalGroup(
            btn_color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_color1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        btn_color1Layout.setVerticalGroup(
            btn_color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_color1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        Background.add(btn_color1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 290, 70));

        btn_color2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_color2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txt_color2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_color2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pincel.png"))); // NOI18N
        txt_color2.setText("COLOR 2");
        txt_color2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_color2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_color2Layout = new javax.swing.GroupLayout(btn_color2);
        btn_color2.setLayout(btn_color2Layout);
        btn_color2Layout.setHorizontalGroup(
            btn_color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_color2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        btn_color2Layout.setVerticalGroup(
            btn_color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_color2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        Background.add(btn_color2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 290, 70));

        PanelGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombrePaleta.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        lbl_nombrePaleta.setText("Nombre de la paleta");
        PanelGuardar.add(lbl_nombrePaleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, -1, -1));

        txt_nombrePaleta.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        txt_nombrePaleta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PanelGuardar.add(txt_nombrePaleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 510, 40));

        btn_guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_guardarCerrar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txt_guardarCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_guardarCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        txt_guardarCerrar.setText("GUARDAR");
        txt_guardarCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_guardarCerrar.setPreferredSize(new java.awt.Dimension(252, 48));
        txt_guardarCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_guardarCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_guardarCerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_guardarCerrarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_guardarCerrarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_guardarLayout = new javax.swing.GroupLayout(btn_guardar);
        btn_guardar.setLayout(btn_guardarLayout);
        btn_guardarLayout.setHorizontalGroup(
            btn_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_guardarCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        btn_guardarLayout.setVerticalGroup(
            btn_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_guardarCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        PanelGuardar.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 220, 70));

        Background.add(PanelGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 680, 550, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tituloVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloVentanaMouseDragged

    private void txt_tituloVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloVentanaMousePressed

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

    private void txt_color1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_color1MousePressed
        btn_color1.setBackground(ColorChooser.getColor());
        BackgroundDemo.setBackground(ColorChooser.getColor());
        
    }//GEN-LAST:event_txt_color1MousePressed

    private void txt_color2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_color2MousePressed
        btn_color2.setBackground(ColorChooser.getColor());
        PanelIzqDemo.setBackground(ColorChooser.getColor());
        lbl_Textodemo.setForeground(ColorChooser.getColor());
        BannerDemo.setBackground(ColorChooser.getColor());
        
        
        Color base = ColorChooser.getColor();
        int r = base.getRed();
        int g = base.getGreen();
        int b = base.getBlue();
        //OSCURECER UN POCO
        if(r-30 < 0) r=0;
        else r-=30;
        
        if(b-30 < 0) b=0;
        else b-=30;
        
        if(g-30 < 0) g=0;
        else g-= 30;
        btnMouseEnter.setBackground(new Color(r,g,b));
        //ACLARAR UN POCO
        r = base.getRed();
        g = base.getGreen();
        b = base.getBlue();    
        
        if(r+30 > 255) r=255;
        else r+=30;
        
        if(b+30 > 255) b=255;
        else b+=30;
        
        if(g+30 > 255) g=255;
        else g+= 30;
        btnMouseClick.setBackground(new Color(r,g,b));        
        
        
        
    }//GEN-LAST:event_txt_color2MousePressed

    
    
    
    private void txt_guardarCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseEntered
        btn_guardar.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_guardarCerrarMouseEntered

    private void txt_guardarCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseExited
        btn_guardar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_guardarCerrarMouseExited

    private void txt_guardarCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMousePressed
        if(evt.getButton() == 1){
            
            String backgroundPALETA = obtenerColorHex(btn_color1);
            String panelPALETA = obtenerColorHex(btn_color2);
            String mouseEnterPALETA = obtenerColorHex(btnMouseEnter);
            String mouseClickPALETA = obtenerColorHex(btnMouseClick);
            
            
            
            
            
            if(txt_nombrePaleta.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe darle un nombre a la paleta", "Sin nombre en la paleta",JOptionPane.INFORMATION_MESSAGE);
            }
            
            ConColores conColor = new ConColores();
            String idPaleta = txt_nombrePaleta.getText();
            int activarPaleta = JOptionPane.showConfirmDialog(this, "¿Activar paleta de inmediato?", "Confirmar accion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(activarPaleta == JOptionPane.YES_OPTION){
                if(conColor.crearPaleta(backgroundPALETA, panelPALETA, mouseEnterPALETA, mouseClickPALETA, idPaleta, txt_nombrePaleta.getText())){
                    mainWindow.dispose();
                    conColor.cambiarPaletaActiva(idPaleta);
                    this.dispose(); 
                    
                    Home window = new Home();
                    window.setVisible(true);                    
                            
                }                    
            }
            else{
                conColor.crearPaleta(backgroundPALETA, panelPALETA, mouseEnterPALETA, mouseClickPALETA, idPaleta, txt_nombrePaleta.getText());
                this.dispose();         
            }
            
            
            
        }
    }//GEN-LAST:event_txt_guardarCerrarMousePressed

    private void txt_guardarCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseReleased
        if(btn_guardar.isEnabled()){
            if(btn_guardar.contains(evt.getPoint())) btn_guardar.setBackground(mouseEnterPanelColor);
            else btn_guardar.setBackground(mouseExitPanelColor);
        }
    }//GEN-LAST:event_txt_guardarCerrarMouseReleased
    
    private String obtenerColorHex(JPanel boton){
        int r = boton.getBackground().getRed();
        int g = boton.getBackground().getGreen();
        int b = boton.getBackground().getBlue();
        return String.format("#%02x%02x%02x", r, g, b);    
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
            java.util.logging.Logger.getLogger(CrearPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPaleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPaleta().setVisible(true);
            }
        });
    }
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel BackgroundDemo;
    private javax.swing.JPanel BannerDemo;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JColorChooser ColorChooser;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelDemostracion;
    private javax.swing.JPanel PanelGuardar;
    private javax.swing.JPanel PanelIzqDemo;
    private javax.swing.JPanel btnMouseClick;
    private javax.swing.JPanel btnMouseEnter;
    private javax.swing.JPanel btn_color1;
    private javax.swing.JPanel btn_color2;
    private javax.swing.JPanel btn_guardar;
    private javax.swing.JPanel colorEnVivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Textodemo;
    private javax.swing.JLabel lbl_nombrePaleta;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_color1;
    private javax.swing.JLabel txt_color2;
    private javax.swing.JLabel txt_ejemplo;
    private javax.swing.JLabel txt_guardarCerrar;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombrePaleta;
    private javax.swing.JLabel txt_tituloVentana;
    // End of variables declaration//GEN-END:variables
}
