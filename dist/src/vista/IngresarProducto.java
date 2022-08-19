package vista;

import controlador.ConColores;
import controlador.ConProducto;
import db.Conexion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.PaletaColor;
import modelo.Producto;

public class IngresarProducto extends javax.swing.JFrame {
 
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
    
    public IngresarProducto() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Crear producto");
        limpiarCampos();
        Background.setBackground(BackgroundColor); 
        ClosePanel.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        DataPanel.setBackground(BackgroundColor);        
        txt_titulo.setForeground(textColor);
        lbl_codigoProducto.setForeground(textColor);
        lbl_nombreProducto.setForeground(textColor);
        lbl_stockInicial.setForeground(textColor);
        lbl_precio.setForeground(textColor);
        PanelDerecha.setBackground(PanelColor);
        btn_guardarCerrar.setBackground(PanelColor);
        btn_guardarOtro.setBackground(PanelColor);
        btn_limpiarCampos.setBackground(PanelColor);
        btn_exit.setBackground(PanelColor);
        txt_exit.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        txt_limpiarCampos.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        DataPanel = new javax.swing.JPanel();
        txt_codigoProducto = new javax.swing.JTextField();
        lbl_codigoProducto = new javax.swing.JLabel();
        lbl_nombreProducto = new javax.swing.JLabel();
        txt_nombreProducto = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_stockInicial = new javax.swing.JLabel();
        txt_stockInicial = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        PanelDerecha = new javax.swing.JPanel();
        btn_guardarCerrar = new javax.swing.JPanel();
        txt_guardarCerrar = new javax.swing.JLabel();
        btn_guardarOtro = new javax.swing.JPanel();
        txt_guardarOtro = new javax.swing.JLabel();
        btn_limpiarCampos = new javax.swing.JPanel();
        txt_limpiarCampos = new javax.swing.JLabel();
        btn_exit = new javax.swing.JPanel();
        txt_exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(230, 204, 178));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setPreferredSize(new java.awt.Dimension(803, 450));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataPanel.setBackground(new java.awt.Color(230, 204, 178));
        DataPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_codigoProducto.setFont(new java.awt.Font("Roboto Thin", 0, 20)); // NOI18N
        txt_codigoProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        DataPanel.add(txt_codigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, 320, 38));

        lbl_codigoProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_codigoProducto.setForeground(new java.awt.Color(127, 85, 57));
        lbl_codigoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barcode.png"))); // NOI18N
        lbl_codigoProducto.setText("CÓDIGO DEL PRODUCTO");
        DataPanel.add(lbl_codigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, 33));

        lbl_nombreProducto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_nombreProducto.setForeground(new java.awt.Color(127, 85, 57));
        lbl_nombreProducto.setText("NOMBRE DEL PRODUCTO");
        DataPanel.add(lbl_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 350, 40));

        txt_nombreProducto.setFont(new java.awt.Font("Roboto Thin", 0, 18)); // NOI18N
        txt_nombreProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        DataPanel.add(txt_nombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 470, 38));

        lbl_precio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_precio.setForeground(new java.awt.Color(127, 85, 57));
        lbl_precio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pricetag.png"))); // NOI18N
        lbl_precio.setText("PRECIO");
        DataPanel.add(lbl_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, 36));

        txt_precio.setFont(new java.awt.Font("Roboto Thin", 0, 20)); // NOI18N
        txt_precio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
        DataPanel.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 140, 38));

        lbl_stockInicial.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_stockInicial.setForeground(new java.awt.Color(127, 85, 57));
        lbl_stockInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stock.png"))); // NOI18N
        lbl_stockInicial.setText("STOCK INICIAL");
        DataPanel.add(lbl_stockInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 36));

        txt_stockInicial.setFont(new java.awt.Font("Roboto Thin", 0, 20)); // NOI18N
        txt_stockInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_stockInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
        DataPanel.add(txt_stockInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 140, 38));

        Background.add(DataPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 490, 370));

        txt_titulo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_titulo.setText("  CREAR PRODUCTO");
        txt_titulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txt_tituloMouseDragged(evt);
            }
        });
        txt_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_tituloMousePressed(evt);
            }
        });
        Background.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 40));

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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 0, 40, 40));

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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 0, 40, 40));

        PanelDerecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardarCerrar.setPreferredSize(new java.awt.Dimension(252, 88));

        txt_guardarCerrar.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txt_guardarCerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_guardarCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        txt_guardarCerrar.setText("GUARDAR Y CERRAR");
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

        javax.swing.GroupLayout btn_guardarCerrarLayout = new javax.swing.GroupLayout(btn_guardarCerrar);
        btn_guardarCerrar.setLayout(btn_guardarCerrarLayout);
        btn_guardarCerrarLayout.setHorizontalGroup(
            btn_guardarCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_guardarCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_guardarCerrarLayout.setVerticalGroup(
            btn_guardarCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_guardarCerrarLayout.createSequentialGroup()
                .addComponent(txt_guardarCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelDerecha.add(btn_guardarCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        btn_guardarOtro.setPreferredSize(new java.awt.Dimension(252, 88));

        txt_guardarOtro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_guardarOtro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_guardarOtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        txt_guardarOtro.setText("GUARDAR E INGRESAR OTRO");
        txt_guardarOtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_guardarOtro.setPreferredSize(new java.awt.Dimension(252, 48));
        txt_guardarOtro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_guardarOtroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_guardarOtroMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_guardarOtroMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_guardarOtroMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_guardarOtroLayout = new javax.swing.GroupLayout(btn_guardarOtro);
        btn_guardarOtro.setLayout(btn_guardarOtroLayout);
        btn_guardarOtroLayout.setHorizontalGroup(
            btn_guardarOtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_guardarOtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_guardarOtroLayout.setVerticalGroup(
            btn_guardarOtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_guardarOtroLayout.createSequentialGroup()
                .addComponent(txt_guardarOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelDerecha.add(btn_guardarOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        btn_limpiarCampos.setPreferredSize(new java.awt.Dimension(252, 88));

        txt_limpiarCampos.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txt_limpiarCampos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_limpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clearText.png"))); // NOI18N
        txt_limpiarCampos.setText("LIMPIAR CAMPOS");
        txt_limpiarCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_limpiarCampos.setPreferredSize(new java.awt.Dimension(252, 88));
        txt_limpiarCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_limpiarCamposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_limpiarCamposMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_limpiarCamposMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_limpiarCamposMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_limpiarCamposLayout = new javax.swing.GroupLayout(btn_limpiarCampos);
        btn_limpiarCampos.setLayout(btn_limpiarCamposLayout);
        btn_limpiarCamposLayout.setHorizontalGroup(
            btn_limpiarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_limpiarCamposLayout.createSequentialGroup()
                .addComponent(txt_limpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_limpiarCamposLayout.setVerticalGroup(
            btn_limpiarCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_limpiarCamposLayout.createSequentialGroup()
                .addComponent(txt_limpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelDerecha.add(btn_limpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        btn_exit.setPreferredSize(new java.awt.Dimension(250, 88));

        txt_exit.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txt_exit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        txt_exit.setText("SALIR");
        txt_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_exitMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_exitMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_exitLayout = new javax.swing.GroupLayout(btn_exit);
        btn_exit.setLayout(btn_exitLayout);
        btn_exitLayout.setHorizontalGroup(
            btn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_exitLayout.createSequentialGroup()
                .addComponent(txt_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_exitLayout.setVerticalGroup(
            btn_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_exitLayout.createSequentialGroup()
                .addComponent(txt_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelDerecha.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        Background.add(PanelDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 252, 409));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txt_tituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloMouseDragged

    private void txt_tituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloMousePressed

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

    private void txt_guardarOtroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarOtroMouseEntered
        btn_guardarOtro.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_guardarOtroMouseEntered

    private void txt_guardarOtroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarOtroMouseExited
        btn_guardarOtro.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_guardarOtroMouseExited

    private void txt_guardarOtroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarOtroMousePressed
        if(evt.getButton() == 1){
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
                    boolean ingreso = cProducto.ingresarProducto(p);
                    if(ingreso){
                        JOptionPane.showMessageDialog(this, "Se ingreso el producto con exito", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();

                    }
                    else{
                        JOptionPane.showMessageDialog(this, "No se pudo ingresar el producto, contáctese con soporte", "Operacion fallida", JOptionPane.INFORMATION_MESSAGE);
                    }     
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(),"Error con datos de producto",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_txt_guardarOtroMousePressed

    private void txt_guardarOtroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarOtroMouseReleased
        if(btn_guardarOtro.isEnabled()){
            if(btn_guardarOtro.contains(evt.getPoint())) btn_guardarOtro.setBackground(mouseEnterPanelColor);
            else btn_guardarOtro.setBackground(mouseExitPanelColor);
        }
    }//GEN-LAST:event_txt_guardarOtroMouseReleased

    private void txt_limpiarCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_limpiarCamposMouseEntered
        btn_limpiarCampos.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_limpiarCamposMouseEntered

    private void txt_limpiarCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_limpiarCamposMouseExited
        btn_limpiarCampos.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_limpiarCamposMouseExited

    private void txt_limpiarCamposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_limpiarCamposMousePressed
        if(evt.getButton() == 1){
            limpiarCampos();
            btn_limpiarCampos.setBackground(mouseEnterPanelColor);
        }
    }//GEN-LAST:event_txt_limpiarCamposMousePressed

    private void txt_limpiarCamposMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_limpiarCamposMouseReleased
        if(btn_limpiarCampos.contains(evt.getPoint())) btn_limpiarCampos.setBackground(mouseEnterPanelColor);
        else btn_limpiarCampos.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_limpiarCamposMouseReleased

    private void txt_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_exitMouseEntered
        btn_exit.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_exitMouseEntered

    private void txt_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_exitMouseExited
        btn_exit.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_exitMouseExited

    private void txt_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_exitMousePressed
        if(evt.getButton() == 1) this.dispose();
    }//GEN-LAST:event_txt_exitMousePressed

    private void txt_exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_exitMouseReleased
        if(btn_exit.contains(evt.getPoint())) btn_exit.setBackground(mouseEnterPanelColor);
        else btn_exit.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_exitMouseReleased

    private void txt_guardarCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseEntered
        btn_guardarCerrar.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_guardarCerrarMouseEntered

    private void txt_guardarCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseExited
        btn_guardarCerrar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_guardarCerrarMouseExited

    private void txt_guardarCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMousePressed

        if(evt.getButton() == 1){
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
                    boolean ingreso = cProducto.ingresarProducto(p);
                    if(ingreso){
                        JOptionPane.showMessageDialog(this, "Se ingreso el producto con exito", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "No se pudo ingresar el producto, contáctese con soporte", "Operacion fallida", JOptionPane.INFORMATION_MESSAGE);
                    }   
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(),"Error con datos de producto",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_txt_guardarCerrarMousePressed

    private void txt_guardarCerrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_guardarCerrarMouseReleased
        if(btn_guardarCerrar.isEnabled()) {
            if(btn_guardarCerrar.contains(evt.getPoint())) btn_guardarCerrar.setBackground(mouseEnterPanelColor);
            else btn_guardarCerrar.setBackground(mouseExitPanelColor);
        }
    }//GEN-LAST:event_txt_guardarCerrarMouseReleased
    
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
        txt_codigoProducto.requestFocus();
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
    private javax.swing.JPanel Background;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel PanelDerecha;
    private javax.swing.JPanel btn_exit;
    private javax.swing.JPanel btn_guardarCerrar;
    private javax.swing.JPanel btn_guardarOtro;
    private javax.swing.JPanel btn_limpiarCampos;
    private javax.swing.JLabel lbl_codigoProducto;
    private javax.swing.JLabel lbl_nombreProducto;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_stockInicial;
    private javax.swing.JLabel txt_close;
    private javax.swing.JTextField txt_codigoProducto;
    private javax.swing.JLabel txt_exit;
    private javax.swing.JLabel txt_guardarCerrar;
    private javax.swing.JLabel txt_guardarOtro;
    private javax.swing.JLabel txt_limpiarCampos;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JTextField txt_nombreProducto;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_stockInicial;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
