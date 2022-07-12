
package vista;

import controlador.ConColores;
import controlador.ConProducto;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.PaletaColor;


public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Pili's Coffee POS Software | Inicio");  
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaMasiva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CargaMasiva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CargaMasiva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CargaMasiva.class.getName()).log(Level.SEVERE, null, ex);
        }        

        ModuloSeleccionadoTitulo.setBackground(PanelColor);
        TipoModuloColor.setBackground(ColorHome);
        txt_ModuloSeleccionado.setText("INICIO"); 
        LeftPanel.setBackground(PanelColor);
        ClosePanel.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        Background.setBackground(BackgroundColor);
        
        moduloVenta_panelIzq.setBackground(PanelColor);
        moduloInforme_panelIzq.setBackground(PanelColor);
        moduloInventario_panelIzq.setBackground(PanelColor);
        moduloHome_panelIzq.setBackground(PanelColor);
        
        seleccionarModulo(MODULO);
        //COLORES PANELES CENTRAL
        ModuloInicio.setBackground(BackgroundColor);
        ModuloVentas.setBackground(BackgroundColor);
        //COLORES BOTONES DE PANEL CENTRAL
        btn_paletaColor.setBackground(ColorHome);
        btn_nuevaVenta.setBackground(ColorVenta);
        btn_consultarPrecio.setBackground(ColorVenta);
        
    }
    
    private void seleccionarModulo(String modulo){
        MODULO = modulo;
        
        moduloHome_panelIzq.setBackground(PanelColor);  
        moduloVenta_panelIzq.setBackground(PanelColor);
        moduloInventario_panelIzq.setBackground(PanelColor);
        moduloInforme_panelIzq.setBackground(PanelColor);
        ModuloInicio.setVisible(false);
        ModuloInventario.setVisible(false);
        ModuloInforme.setVisible(false);
        ModuloVentas.setVisible(false);
                
        
        switch (modulo) {
            case "HOME":
                moduloHome_panelIzq.setBackground(mouseEnterPanelColor);
                ModuloInicio.setVisible(true);
                break;
            case "VENTA":
                moduloVenta_panelIzq.setBackground(mouseEnterPanelColor);
                ModuloVentas.setVisible(true);
                break;
            case "INVENTARIO":
                moduloInventario_panelIzq.setBackground(mouseEnterPanelColor);
                ModuloInventario.setVisible(true);
                break;
            case "INFORMES":
                moduloInforme_panelIzq.setBackground(mouseEnterPanelColor);
                ModuloInforme.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    String MODULO = "HOME";
    
    ConColores cColor = new ConColores();
    PaletaColor paleta = cColor.paletaActiva();
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick();  
    //HOME
    Color ColorHome = new Color(35, 121, 121);
    Color mouseEnterColorHome = new Color(85, 155, 155);
    Color mouseExitColorHome = ColorHome;
    Color mouseClickColorHome = new Color(85, 177, 177);
    //VENTA
    Color ColorVenta = new Color(0, 117, 67);
    Color mouseEnterColorVenta = new Color(0, 173, 73);
    Color mouseExitColorVenta = ColorVenta;
    Color mouseClickColorVenta = new Color(0, 216, 77);
    //INVENTARIO
    Color ColorInventario = new Color(0, 78, 137);
    Color mouseEnterColorInventario = new Color(0, 110, 177);
    Color mouseExitColorInventario = ColorInventario;
    Color mouseClickColorInventario = new Color(0, 145, 215);    
    //INFORME
    Color ColorInforme = new Color(232, 63, 111);
    Color mouseEnterColorInforme = new Color(232, 95, 140);
    Color mouseExitColorInforme = ColorInforme;
    Color mouseClickColorInforme = new Color(232, 140, 190);      
    //FIN DE COLORES    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        Subtitle = new javax.swing.JLabel();
        moduloHome_panelIzq = new javax.swing.JPanel();
        txt_moduloInicio = new javax.swing.JLabel();
        moduloVenta_panelIzq = new javax.swing.JPanel();
        txt_ModuloVenta = new javax.swing.JLabel();
        moduloInventario_panelIzq = new javax.swing.JPanel();
        txt_ModuloInventario = new javax.swing.JLabel();
        moduloInforme_panelIzq = new javax.swing.JPanel();
        txt_ModuloInforme = new javax.swing.JLabel();
        ModuloSeleccionadoTitulo = new javax.swing.JPanel();
        TipoModuloColor = new javax.swing.JPanel();
        txt_ModuloSeleccionado = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        PanelesPorModulo = new javax.swing.JPanel();
        ModuloInicio = new javax.swing.JPanel();
        btn_paletaColor = new javax.swing.JPanel();
        txt_paletaColor = new javax.swing.JLabel();
        logoBackground = new javax.swing.JLabel();
        ModuloVentas = new javax.swing.JPanel();
        btn_nuevaVenta = new javax.swing.JPanel();
        txt_nuevaVenta = new javax.swing.JLabel();
        btn_consultarPrecio = new javax.swing.JPanel();
        txt_consultarPrecio = new javax.swing.JLabel();
        logoBackground1 = new javax.swing.JLabel();
        ModuloInventario = new javax.swing.JPanel();
        logoBackground2 = new javax.swing.JLabel();
        ModuloInforme = new javax.swing.JPanel();
        logoBackground3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(230, 204, 178));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftPanel.setBackground(new java.awt.Color(176, 137, 104));
        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-png-128.png"))); // NOI18N
        LeftPanel.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        Title.setFont(new java.awt.Font("Great Vibes", 1, 36)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Pili's Coffee");
        LeftPanel.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, 42));

        Subtitle.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Subtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Subtitle.setText("POS Software");
        LeftPanel.add(Subtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 280, -1));

        moduloHome_panelIzq.setBackground(new java.awt.Color(176, 137, 104));

        txt_moduloInicio.setFont(new java.awt.Font("Roboto Thin", 1, 24)); // NOI18N
        txt_moduloInicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_moduloInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_moduloInicio.setText("Inicio");
        txt_moduloInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_moduloInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_moduloInicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_moduloInicioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_moduloInicioMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout moduloHome_panelIzqLayout = new javax.swing.GroupLayout(moduloHome_panelIzq);
        moduloHome_panelIzq.setLayout(moduloHome_panelIzqLayout);
        moduloHome_panelIzqLayout.setHorizontalGroup(
            moduloHome_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_moduloInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        moduloHome_panelIzqLayout.setVerticalGroup(
            moduloHome_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_moduloInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        LeftPanel.add(moduloHome_panelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 300, 70));

        moduloVenta_panelIzq.setBackground(new java.awt.Color(176, 137, 104));

        txt_ModuloVenta.setBackground(new java.awt.Color(255, 255, 255));
        txt_ModuloVenta.setFont(new java.awt.Font("Roboto Thin", 1, 24)); // NOI18N
        txt_ModuloVenta.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModuloVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ModuloVenta.setText("Módulo Ventas");
        txt_ModuloVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ModuloVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ModuloVentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ModuloVentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ModuloVentaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout moduloVenta_panelIzqLayout = new javax.swing.GroupLayout(moduloVenta_panelIzq);
        moduloVenta_panelIzq.setLayout(moduloVenta_panelIzqLayout);
        moduloVenta_panelIzqLayout.setHorizontalGroup(
            moduloVenta_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloVenta_panelIzqLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        moduloVenta_panelIzqLayout.setVerticalGroup(
            moduloVenta_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloVenta_panelIzqLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LeftPanel.add(moduloVenta_panelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 300, -1));

        moduloInventario_panelIzq.setBackground(new java.awt.Color(176, 137, 104));
        moduloInventario_panelIzq.setPreferredSize(new java.awt.Dimension(310, 70));

        txt_ModuloInventario.setBackground(new java.awt.Color(255, 255, 255));
        txt_ModuloInventario.setFont(new java.awt.Font("Roboto Thin", 1, 24)); // NOI18N
        txt_ModuloInventario.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModuloInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ModuloInventario.setText("Módulo Inventario");
        txt_ModuloInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ModuloInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ModuloInventarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ModuloInventarioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ModuloInventarioMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout moduloInventario_panelIzqLayout = new javax.swing.GroupLayout(moduloInventario_panelIzq);
        moduloInventario_panelIzq.setLayout(moduloInventario_panelIzqLayout);
        moduloInventario_panelIzqLayout.setHorizontalGroup(
            moduloInventario_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloInventario_panelIzqLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        moduloInventario_panelIzqLayout.setVerticalGroup(
            moduloInventario_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInventario_panelIzqLayout.createSequentialGroup()
                .addComponent(txt_ModuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LeftPanel.add(moduloInventario_panelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 300, -1));

        moduloInforme_panelIzq.setBackground(new java.awt.Color(176, 137, 104));
        moduloInforme_panelIzq.setPreferredSize(new java.awt.Dimension(310, 70));

        txt_ModuloInforme.setBackground(new java.awt.Color(255, 255, 255));
        txt_ModuloInforme.setFont(new java.awt.Font("Roboto Thin", 1, 24)); // NOI18N
        txt_ModuloInforme.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModuloInforme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ModuloInforme.setText("Módulo Informe");
        txt_ModuloInforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ModuloInformeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ModuloInformeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ModuloInformeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ModuloInformeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout moduloInforme_panelIzqLayout = new javax.swing.GroupLayout(moduloInforme_panelIzq);
        moduloInforme_panelIzq.setLayout(moduloInforme_panelIzqLayout);
        moduloInforme_panelIzqLayout.setHorizontalGroup(
            moduloInforme_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInforme_panelIzqLayout.createSequentialGroup()
                .addComponent(txt_ModuloInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        moduloInforme_panelIzqLayout.setVerticalGroup(
            moduloInforme_panelIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInforme_panelIzqLayout.createSequentialGroup()
                .addComponent(txt_ModuloInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LeftPanel.add(moduloInforme_panelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 300, -1));

        Background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 1010));

        ModuloSeleccionadoTitulo.setBackground(new java.awt.Color(230, 204, 178));

        TipoModuloColor.setBackground(new java.awt.Color(230, 204, 178));

        javax.swing.GroupLayout TipoModuloColorLayout = new javax.swing.GroupLayout(TipoModuloColor);
        TipoModuloColor.setLayout(TipoModuloColorLayout);
        TipoModuloColorLayout.setHorizontalGroup(
            TipoModuloColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );
        TipoModuloColorLayout.setVerticalGroup(
            TipoModuloColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        txt_ModuloSeleccionado.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_ModuloSeleccionado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ModuloSeleccionadoTituloLayout = new javax.swing.GroupLayout(ModuloSeleccionadoTitulo);
        ModuloSeleccionadoTitulo.setLayout(ModuloSeleccionadoTituloLayout);
        ModuloSeleccionadoTituloLayout.setHorizontalGroup(
            ModuloSeleccionadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModuloSeleccionadoTituloLayout.createSequentialGroup()
                .addComponent(TipoModuloColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(txt_ModuloSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
        ModuloSeleccionadoTituloLayout.setVerticalGroup(
            ModuloSeleccionadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModuloSeleccionadoTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(TipoModuloColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ModuloSeleccionadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_ModuloSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Background.add(ModuloSeleccionadoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 800, 100));

        ClosePanel.setBackground(new java.awt.Color(230, 204, 178));
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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 40, 40));

        MinPanel.setBackground(new java.awt.Color(230, 204, 178));
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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 40, 40));

        PanelesPorModulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ModuloInicio.setBackground(new java.awt.Color(204, 204, 204));
        ModuloInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_paletaColor.setBackground(new java.awt.Color(51, 255, 255));

        txt_paletaColor.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_paletaColor.setForeground(new java.awt.Color(255, 255, 255));
        txt_paletaColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/color_palette.png"))); // NOI18N
        txt_paletaColor.setText("CAMBIAR PALETA DE COLORES");
        txt_paletaColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_paletaColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_paletaColorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_paletaColorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_paletaColorMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_paletaColorLayout = new javax.swing.GroupLayout(btn_paletaColor);
        btn_paletaColor.setLayout(btn_paletaColorLayout);
        btn_paletaColorLayout.setHorizontalGroup(
            btn_paletaColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_paletaColorLayout.createSequentialGroup()
                .addComponent(txt_paletaColor, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_paletaColorLayout.setVerticalGroup(
            btn_paletaColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_paletaColor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInicio.add(btn_paletaColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        logoBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        ModuloInicio.add(logoBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        PanelesPorModulo.add(ModuloInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        ModuloVentas.setBackground(new java.awt.Color(230, 204, 178));
        ModuloVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevaVenta.setBackground(new java.awt.Color(51, 255, 255));

        txt_nuevaVenta.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_nuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        txt_nuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nueva_venta.png"))); // NOI18N
        txt_nuevaVenta.setText("NUEVA VENTA");
        txt_nuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nuevaVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nuevaVentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nuevaVentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_nuevaVentaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_nuevaVentaLayout = new javax.swing.GroupLayout(btn_nuevaVenta);
        btn_nuevaVenta.setLayout(btn_nuevaVentaLayout);
        btn_nuevaVentaLayout.setHorizontalGroup(
            btn_nuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nuevaVentaLayout.createSequentialGroup()
                .addComponent(txt_nuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_nuevaVentaLayout.setVerticalGroup(
            btn_nuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloVentas.add(btn_nuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_consultarPrecio.setBackground(new java.awt.Color(153, 153, 153));
        btn_consultarPrecio.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_consultarPrecio.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_consultarPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txt_consultarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar_precio.png"))); // NOI18N
        txt_consultarPrecio.setText("CONSULTAR PRECIO");
        txt_consultarPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_consultarPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_consultarPrecioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_consultarPrecioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_consultarPrecioLayout = new javax.swing.GroupLayout(btn_consultarPrecio);
        btn_consultarPrecio.setLayout(btn_consultarPrecioLayout);
        btn_consultarPrecioLayout.setHorizontalGroup(
            btn_consultarPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_consultarPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_consultarPrecioLayout.setVerticalGroup(
            btn_consultarPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_consultarPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloVentas.add(btn_consultarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        logoBackground1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        ModuloVentas.add(logoBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        PanelesPorModulo.add(ModuloVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        ModuloInventario.setBackground(new java.awt.Color(230, 204, 178));
        ModuloInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoBackground2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        ModuloInventario.add(logoBackground2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 590));

        PanelesPorModulo.add(ModuloInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        ModuloInforme.setBackground(new java.awt.Color(230, 204, 178));
        ModuloInforme.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoBackground3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        ModuloInforme.add(logoBackground3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 590));

        PanelesPorModulo.add(ModuloInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        Background.add(PanelesPorModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 750, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ModuloVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMouseEntered
        moduloVenta_panelIzq.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloVentaMouseEntered

    private void txt_ModuloVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMouseExited
        if(!MODULO.equals("VENTA")) moduloVenta_panelIzq.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloVentaMouseExited

    private void txt_ModuloInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseEntered
        moduloInventario_panelIzq.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloInventarioMouseEntered

    private void txt_ModuloInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseExited
        if(!MODULO.equals("INVENTARIO")) moduloInventario_panelIzq.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloInventarioMouseExited

    private void txt_ModuloInformeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseEntered
        moduloInforme_panelIzq.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloInformeMouseEntered

    private void txt_ModuloInformeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseExited
        if(!MODULO.equals("INFORMES")) moduloInforme_panelIzq.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloInformeMouseExited

    private void txt_ModuloVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMousePressed
        if(evt.getButton() == 1){
            moduloVenta_panelIzq.setBackground(mouseClickPanelColor);
            txt_ModuloVenta.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);            
            TipoModuloColor.setBackground(ColorVenta);
            txt_ModuloSeleccionado.setText("MÓDULO DE VENTAS");
            seleccionarModulo("VENTA");
            
        }
    }//GEN-LAST:event_txt_ModuloVentaMousePressed

    private void txt_ModuloVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMouseReleased
        moduloVenta_panelIzq.setBackground(mouseEnterPanelColor);
        txt_ModuloVenta.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloVentaMouseReleased

    private void txt_ModuloInventarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMousePressed
        if(evt.getButton() == 1){
            moduloInventario_panelIzq.setBackground(mouseClickPanelColor);
            txt_ModuloInventario.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorInventario);
            txt_ModuloSeleccionado.setText("MÓDULO DE INVENTARIO");
            seleccionarModulo("INVENTARIO");
        }
    }//GEN-LAST:event_txt_ModuloInventarioMousePressed

    private void txt_ModuloInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseReleased
        moduloInventario_panelIzq.setBackground(mouseEnterPanelColor);
        txt_ModuloInventario.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloInventarioMouseReleased

    private void txt_ModuloInformeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMousePressed
        if(evt.getButton() == 1){
            moduloInforme_panelIzq.setBackground(mouseClickPanelColor);
            txt_ModuloInforme.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorInforme);
            txt_ModuloSeleccionado.setText("MÓDULO DE INFORMES");   
            seleccionarModulo("INFORMES");
            
        }
    }//GEN-LAST:event_txt_ModuloInformeMousePressed

    private void txt_ModuloInformeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseReleased
        moduloInforme_panelIzq.setBackground(mouseEnterPanelColor);
        txt_ModuloInforme.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloInformeMouseReleased

    private void txt_moduloInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseEntered
        moduloHome_panelIzq.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_moduloInicioMouseEntered

    private void txt_moduloInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseExited
        if(!MODULO.equals("HOME")) moduloHome_panelIzq.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_moduloInicioMouseExited

    private void txt_moduloInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMousePressed
        if(evt.getButton() == 1){
            moduloHome_panelIzq.setBackground(mouseClickPanelColor);
            txt_moduloInicio.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorHome);
            txt_ModuloSeleccionado.setText("INICIO"); 
            seleccionarModulo("HOME");
        }
    }//GEN-LAST:event_txt_moduloInicioMousePressed

    private void txt_moduloInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseReleased
        moduloHome_panelIzq.setBackground(mouseEnterPanelColor);
        txt_moduloInicio.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_moduloInicioMouseReleased

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

    private void txt_paletaColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMouseEntered
        btn_paletaColor.setBackground(mouseEnterColorHome);
    }//GEN-LAST:event_txt_paletaColorMouseEntered

    private void txt_paletaColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMouseExited
        btn_paletaColor.setBackground(mouseExitColorHome);
    }//GEN-LAST:event_txt_paletaColorMouseExited

    private void txt_paletaColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMousePressed
        btn_paletaColor.setBackground(mouseClickColorHome);
        CambiarPaleta ventana = new CambiarPaleta(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_txt_paletaColorMousePressed

    private void txt_paletaColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMouseReleased
        btn_paletaColor.setBackground(mouseEnterColorHome);
    }//GEN-LAST:event_txt_paletaColorMouseReleased

    private void txt_nuevaVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevaVentaMouseEntered
        btn_nuevaVenta.setBackground(mouseEnterColorVenta);
    }//GEN-LAST:event_txt_nuevaVentaMouseEntered

    private void txt_nuevaVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevaVentaMouseExited
        btn_nuevaVenta.setBackground(mouseExitColorVenta);
    }//GEN-LAST:event_txt_nuevaVentaMouseExited

    private void txt_nuevaVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevaVentaMousePressed
        btn_nuevaVenta.setBackground(mouseClickColorVenta);
        ConProducto cProducto = new ConProducto();
        NuevaVenta ventana = new NuevaVenta(cProducto.listarProductos());
        ventana.setVisible(true);
    }//GEN-LAST:event_txt_nuevaVentaMousePressed

    private void txt_nuevaVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevaVentaMouseReleased
        btn_nuevaVenta.setBackground(mouseEnterColorVenta);
    }//GEN-LAST:event_txt_nuevaVentaMouseReleased

    private void txt_consultarPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarPrecioMouseEntered
        btn_consultarPrecio.setBackground(mouseEnterColorVenta);
    }//GEN-LAST:event_txt_consultarPrecioMouseEntered

    private void txt_consultarPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarPrecioMouseExited
        btn_consultarPrecio.setBackground(mouseExitColorVenta);
    }//GEN-LAST:event_txt_consultarPrecioMouseExited

    private void txt_consultarPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarPrecioMousePressed
        btn_consultarPrecio.setBackground(mouseClickColorVenta);
        ConProducto cProducto = new ConProducto();
        ConsultarPrecio ventana = new ConsultarPrecio(cProducto.listarProductos());
        ventana.setVisible(true);
    }//GEN-LAST:event_txt_consultarPrecioMousePressed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel ModuloInforme;
    private javax.swing.JPanel ModuloInicio;
    private javax.swing.JPanel ModuloInventario;
    private javax.swing.JPanel ModuloSeleccionadoTitulo;
    private javax.swing.JPanel ModuloVentas;
    private javax.swing.JPanel PanelesPorModulo;
    private javax.swing.JLabel Subtitle;
    private javax.swing.JPanel TipoModuloColor;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel btn_consultarPrecio;
    private javax.swing.JPanel btn_nuevaVenta;
    private javax.swing.JPanel btn_paletaColor;
    private javax.swing.JLabel logoBackground;
    private javax.swing.JLabel logoBackground1;
    private javax.swing.JLabel logoBackground2;
    private javax.swing.JLabel logoBackground3;
    private javax.swing.JPanel moduloHome_panelIzq;
    private javax.swing.JPanel moduloInforme_panelIzq;
    private javax.swing.JPanel moduloInventario_panelIzq;
    private javax.swing.JPanel moduloVenta_panelIzq;
    private javax.swing.JLabel txt_ModuloInforme;
    private javax.swing.JLabel txt_ModuloInventario;
    private javax.swing.JLabel txt_ModuloSeleccionado;
    private javax.swing.JLabel txt_ModuloVenta;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_consultarPrecio;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_moduloInicio;
    private javax.swing.JLabel txt_nuevaVenta;
    private javax.swing.JLabel txt_paletaColor;
    // End of variables declaration//GEN-END:variables
}
