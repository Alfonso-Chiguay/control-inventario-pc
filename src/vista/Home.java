
package vista;

import controlador.ConColores;
import controlador.ConInformes;
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
    int xMouse, yMouse;
    
    public Home() {
        initComponents();
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Inicio");  
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
        header1.setBackground(BackgroundColor);
        header2.setBackground(PanelColor);
        
        moduloVenta_panelIzq.setBackground(PanelColor);
        moduloInforme_panelIzq.setBackground(PanelColor);
        moduloInventario_panelIzq.setBackground(PanelColor);
        moduloHome_panelIzq.setBackground(PanelColor);
        
        seleccionarModulo(MODULO);
        //COLORES PANELES CENTRAL
        ModuloInicio.setBackground(BackgroundColor);
        ModuloVentas.setBackground(BackgroundColor);
        ModuloInventario.setBackground(BackgroundColor);
        ModuloInforme.setBackground(BackgroundColor);
        //COLORES BOTONES DE PANEL CENTRAL
        btn_paletaColor.setBackground(ColorHome);
        btn_nuevaVenta.setBackground(ColorVenta);
        btn_consultarPrecio.setBackground(ColorVenta);
        btn_nuevoProducto.setBackground(ColorInventario);
        btn_consultarStock.setBackground(ColorInventario);
        btn_actualizarProducto.setBackground(ColorInventario);
        btn_crearOferta.setBackground(ColorInventario);
        btn_cargaMasivaProd.setBackground(ColorInventario);
        btn_actualizacionMasiva.setBackground(ColorInventario);
        btn_ventaDiaria.setBackground(ColorInforme);
        btn_ventaPeriodo.setBackground(ColorInforme);
        btn_stockNegativo.setBackground(ColorInforme);
        btn_stockGeneral.setBackground(ColorInforme);
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
    Color ColorHome = new Color(100, 58, 113);
    Color mouseEnterColorHome = new Color(139, 95, 191);
    Color mouseExitColorHome = ColorHome;
    Color mouseClickColorHome = new Color(209, 131, 201);
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
        ModuloInforme = new javax.swing.JPanel();
        btn_stockNegativo = new javax.swing.JPanel();
        txt_stockNegativo = new javax.swing.JLabel();
        btn_ventaPeriodo = new javax.swing.JPanel();
        txt_ventaPeriodo = new javax.swing.JLabel();
        btn_ventaDiaria = new javax.swing.JPanel();
        txt_ventaDiaria = new javax.swing.JLabel();
        btn_stockGeneral = new javax.swing.JPanel();
        txt_stockGeneral = new javax.swing.JLabel();
        logoBackground3 = new javax.swing.JLabel();
        ModuloInventario = new javax.swing.JPanel();
        btn_actualizacionMasiva = new javax.swing.JPanel();
        txt_actualizacionMasiva = new javax.swing.JLabel();
        btn_nuevoProducto = new javax.swing.JPanel();
        txt_nuevoProducto = new javax.swing.JLabel();
        btn_consultarStock = new javax.swing.JPanel();
        txt_consultarStock = new javax.swing.JLabel();
        btn_actualizarProducto = new javax.swing.JPanel();
        txt_actualizarProducto = new javax.swing.JLabel();
        btn_crearOferta = new javax.swing.JPanel();
        txt_crearOferta = new javax.swing.JLabel();
        btn_cargaMasivaProd = new javax.swing.JPanel();
        txt_cargaMasivaProd = new javax.swing.JLabel();
        logoBackground2 = new javax.swing.JLabel();
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
        header1 = new javax.swing.JPanel();
        header2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
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
        txt_moduloInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        txt_ModuloVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        txt_ModuloInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        txt_ModuloInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        Background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 300, 970));

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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 40, 40));

        MinPanel.setBackground(new java.awt.Color(230, 204, 178));
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
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        MinPanelLayout.setVerticalGroup(
            MinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 40, 40));

        PanelesPorModulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ModuloInforme.setBackground(new java.awt.Color(204, 204, 204));
        ModuloInforme.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_stockNegativo.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_stockNegativo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_stockNegativo.setForeground(new java.awt.Color(255, 255, 255));
        txt_stockNegativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        txt_stockNegativo.setText("STOCK NEGATIVO");
        txt_stockNegativo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_stockNegativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_stockNegativoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_stockNegativoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_stockNegativoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_stockNegativoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_stockNegativoLayout = new javax.swing.GroupLayout(btn_stockNegativo);
        btn_stockNegativo.setLayout(btn_stockNegativoLayout);
        btn_stockNegativoLayout.setHorizontalGroup(
            btn_stockNegativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stockNegativo, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_stockNegativoLayout.setVerticalGroup(
            btn_stockNegativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stockNegativo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInforme.add(btn_stockNegativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btn_ventaPeriodo.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_ventaPeriodo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_ventaPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        txt_ventaPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        txt_ventaPeriodo.setText("VENTA POR PERIODO");
        txt_ventaPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_ventaPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ventaPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ventaPeriodoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ventaPeriodoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ventaPeriodoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_ventaPeriodoLayout = new javax.swing.GroupLayout(btn_ventaPeriodo);
        btn_ventaPeriodo.setLayout(btn_ventaPeriodoLayout);
        btn_ventaPeriodoLayout.setHorizontalGroup(
            btn_ventaPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_ventaPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_ventaPeriodoLayout.setVerticalGroup(
            btn_ventaPeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_ventaPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInforme.add(btn_ventaPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        btn_ventaDiaria.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_ventaDiaria.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_ventaDiaria.setForeground(new java.awt.Color(255, 255, 255));
        txt_ventaDiaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        txt_ventaDiaria.setText("VENTA DIARIA");
        txt_ventaDiaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_ventaDiaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ventaDiariaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ventaDiariaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ventaDiariaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_ventaDiariaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_ventaDiariaLayout = new javax.swing.GroupLayout(btn_ventaDiaria);
        btn_ventaDiaria.setLayout(btn_ventaDiariaLayout);
        btn_ventaDiariaLayout.setHorizontalGroup(
            btn_ventaDiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_ventaDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_ventaDiariaLayout.setVerticalGroup(
            btn_ventaDiariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_ventaDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInforme.add(btn_ventaDiaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_stockGeneral.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_stockGeneral.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_stockGeneral.setForeground(new java.awt.Color(255, 255, 255));
        txt_stockGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        txt_stockGeneral.setText("STOCK GENERAL");
        txt_stockGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_stockGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_stockGeneralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_stockGeneralMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_stockGeneralMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_stockGeneralMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_stockGeneralLayout = new javax.swing.GroupLayout(btn_stockGeneral);
        btn_stockGeneral.setLayout(btn_stockGeneralLayout);
        btn_stockGeneralLayout.setHorizontalGroup(
            btn_stockGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stockGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_stockGeneralLayout.setVerticalGroup(
            btn_stockGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_stockGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInforme.add(btn_stockGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        logoBackground3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        ModuloInforme.add(logoBackground3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        PanelesPorModulo.add(ModuloInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        ModuloInventario.setBackground(new java.awt.Color(204, 204, 204));
        ModuloInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_actualizacionMasiva.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_actualizacionMasiva.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_actualizacionMasiva.setForeground(new java.awt.Color(255, 255, 255));
        txt_actualizacionMasiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_products.png"))); // NOI18N
        txt_actualizacionMasiva.setText("ACTUALIZACION MASIVA");
        txt_actualizacionMasiva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_actualizacionMasiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_actualizacionMasivaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_actualizacionMasivaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_actualizacionMasivaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_actualizacionMasivaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_actualizacionMasivaLayout = new javax.swing.GroupLayout(btn_actualizacionMasiva);
        btn_actualizacionMasiva.setLayout(btn_actualizacionMasivaLayout);
        btn_actualizacionMasivaLayout.setHorizontalGroup(
            btn_actualizacionMasivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_actualizacionMasiva, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_actualizacionMasivaLayout.setVerticalGroup(
            btn_actualizacionMasivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_actualizacionMasiva, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_actualizacionMasiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        btn_nuevoProducto.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_nuevoProducto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_nuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        txt_nuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_product.png"))); // NOI18N
        txt_nuevoProducto.setText("NUEVO PRODUCTO");
        txt_nuevoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_nuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nuevoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nuevoProductoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nuevoProductoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_nuevoProductoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_nuevoProductoLayout = new javax.swing.GroupLayout(btn_nuevoProducto);
        btn_nuevoProducto.setLayout(btn_nuevoProductoLayout);
        btn_nuevoProductoLayout.setHorizontalGroup(
            btn_nuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_nuevoProductoLayout.setVerticalGroup(
            btn_nuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_nuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_nuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_consultarStock.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_consultarStock.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_consultarStock.setForeground(new java.awt.Color(255, 255, 255));
        txt_consultarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/consultar_stock.png"))); // NOI18N
        txt_consultarStock.setText("CONSULTAR STOCK");
        txt_consultarStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_consultarStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_consultarStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_consultarStockMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_consultarStockMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_consultarStockLayout = new javax.swing.GroupLayout(btn_consultarStock);
        btn_consultarStock.setLayout(btn_consultarStockLayout);
        btn_consultarStockLayout.setHorizontalGroup(
            btn_consultarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_consultarStock, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_consultarStockLayout.setVerticalGroup(
            btn_consultarStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_consultarStock, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_consultarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        btn_actualizarProducto.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_actualizarProducto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_actualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        txt_actualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_products.png"))); // NOI18N
        txt_actualizarProducto.setText("ACTUALIZAR PRODUCTO");
        txt_actualizarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_actualizarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_actualizarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_actualizarProductoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_actualizarProductoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_actualizarProductoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_actualizarProductoLayout = new javax.swing.GroupLayout(btn_actualizarProducto);
        btn_actualizarProducto.setLayout(btn_actualizarProductoLayout);
        btn_actualizarProductoLayout.setHorizontalGroup(
            btn_actualizarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_actualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_actualizarProductoLayout.setVerticalGroup(
            btn_actualizarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_actualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_actualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btn_crearOferta.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_crearOferta.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_crearOferta.setForeground(new java.awt.Color(255, 255, 255));
        txt_crearOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sales.png"))); // NOI18N
        txt_crearOferta.setText("CREAR OFERTA");
        txt_crearOferta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_crearOferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_crearOfertaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_crearOfertaLayout = new javax.swing.GroupLayout(btn_crearOferta);
        btn_crearOferta.setLayout(btn_crearOfertaLayout);
        btn_crearOfertaLayout.setHorizontalGroup(
            btn_crearOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        btn_crearOfertaLayout.setVerticalGroup(
            btn_crearOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_crearOferta, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_crearOferta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        btn_cargaMasivaProd.setPreferredSize(new java.awt.Dimension(340, 100));

        txt_cargaMasivaProd.setFont(new java.awt.Font("Roboto", 0, 19)); // NOI18N
        txt_cargaMasivaProd.setForeground(new java.awt.Color(255, 255, 255));
        txt_cargaMasivaProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carga_masiva.png"))); // NOI18N
        txt_cargaMasivaProd.setText("CARGA MASIVA DE PRODUCTOS");
        txt_cargaMasivaProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_cargaMasivaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_cargaMasivaProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_cargaMasivaProdMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_cargaMasivaProdMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_cargaMasivaProdMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_cargaMasivaProdLayout = new javax.swing.GroupLayout(btn_cargaMasivaProd);
        btn_cargaMasivaProd.setLayout(btn_cargaMasivaProdLayout);
        btn_cargaMasivaProdLayout.setHorizontalGroup(
            btn_cargaMasivaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cargaMasivaProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_cargaMasivaProdLayout.setVerticalGroup(
            btn_cargaMasivaProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cargaMasivaProd, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        ModuloInventario.add(btn_cargaMasivaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        logoBackground2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        logoBackground2.setPreferredSize(new java.awt.Dimension(340, 100));
        ModuloInventario.add(logoBackground2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        PanelesPorModulo.add(ModuloInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        ModuloInicio.setBackground(new java.awt.Color(204, 204, 204));
        ModuloInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_paletaColor.setBackground(new java.awt.Color(51, 255, 255));

        txt_paletaColor.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_paletaColor.setForeground(new java.awt.Color(255, 255, 255));
        txt_paletaColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/color_palette.png"))); // NOI18N
        txt_paletaColor.setText("CAMBIAR PALETA DE COLORES");
        txt_paletaColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        txt_nuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        txt_consultarPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        Background.add(PanelesPorModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 750, 580));

        header1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header1MouseDragged(evt);
            }
        });
        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Background.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 820, 40));

        header2.setPreferredSize(new java.awt.Dimension(100, 40));
        header2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header2MouseDragged(evt);
            }
        });
        header2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Background.add(header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

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
        if(evt.getButton() == 1){
            Color DarkRed = new Color(146, 55, 77); 
            ClosePanel.setBackground(DarkRed);
            txt_close.setForeground(Color.WHITE);
            this.dispose();
        }
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
        if(evt.getButton() == 1){
            MinPanel.setBackground(mouseClickPanelColor);
            txt_minimize.setForeground(Color.WHITE);
            this.setState(Frame.ICONIFIED);
        }
    }//GEN-LAST:event_txt_minimizeMousePressed

    private void txt_minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_minimizeMouseReleased
        MinPanel.setBackground(mouseEnterPanelColor);
        txt_minimize.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_minimizeMouseReleased

    private void txt_paletaColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMouseEntered
        btn_paletaColor.setBackground(mouseEnterColorHome);
    }//GEN-LAST:event_txt_paletaColorMouseEntered

    private void txt_paletaColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMouseExited
        btn_paletaColor.setBackground(mouseExitColorHome);
    }//GEN-LAST:event_txt_paletaColorMouseExited

    private void txt_paletaColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paletaColorMousePressed
        if(evt.getButton() == 1){       
            btn_paletaColor.setBackground(mouseClickColorHome);
            CambiarPaleta ventana = new CambiarPaleta(this);
            ventana.setVisible(true);
        }
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
        if(evt.getButton() == 1){        
            btn_nuevaVenta.setBackground(mouseClickColorVenta);
            ConProducto cProducto = new ConProducto();
            NuevaVenta ventana = new NuevaVenta(cProducto.listarProductos());
            ventana.setVisible(true);
        }
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
        if(evt.getButton() == 1){        
            btn_consultarPrecio.setBackground(mouseClickColorVenta);
            ConProducto cProducto = new ConProducto();
            ConsultarPrecio ventana = new ConsultarPrecio(cProducto.listarProductos());
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_consultarPrecioMousePressed

    private void txt_nuevoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevoProductoMouseEntered
        btn_nuevoProducto.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_nuevoProductoMouseEntered

    private void txt_nuevoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevoProductoMouseExited
        btn_nuevoProducto.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_nuevoProductoMouseExited

    private void txt_nuevoProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevoProductoMousePressed
        if(evt.getButton() == 1){        
            btn_nuevoProducto.setBackground(mouseClickColorInventario);
            IngresarProducto ventana = new IngresarProducto();
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_nuevoProductoMousePressed

    private void txt_nuevoProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nuevoProductoMouseReleased
        btn_nuevoProducto.setBackground(mouseEnterColorInventario);        
    }//GEN-LAST:event_txt_nuevoProductoMouseReleased

    private void txt_consultarStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarStockMouseEntered
        btn_consultarStock.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_consultarStockMouseEntered

    private void txt_consultarStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarStockMouseExited
        btn_consultarStock.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_consultarStockMouseExited

    private void txt_consultarStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_consultarStockMousePressed
        if(evt.getButton() == 1){        
            btn_consultarStock.setBackground(mouseClickColorInventario);
            ConsultaStockUnit ventana = new ConsultaStockUnit();
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_consultarStockMousePressed

    private void txt_actualizarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizarProductoMouseEntered
        btn_actualizarProducto.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_actualizarProductoMouseEntered

    private void txt_actualizarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizarProductoMouseExited
        btn_actualizarProducto.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_actualizarProductoMouseExited

    private void txt_actualizarProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizarProductoMousePressed
        if(evt.getButton() == 1){
                btn_actualizarProducto.setBackground(mouseClickColorInventario);
                EditarStockPrecio ventana = new EditarStockPrecio();
                ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_actualizarProductoMousePressed

    private void txt_actualizarProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizarProductoMouseReleased
        btn_actualizarProducto.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_actualizarProductoMouseReleased

    private void txt_crearOfertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseEntered
        btn_crearOferta.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_crearOfertaMouseEntered

    private void txt_crearOfertaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseExited
        btn_crearOferta.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_crearOfertaMouseExited

    private void txt_crearOfertaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMousePressed
        if(evt.getButton() == 1){
            btn_crearOferta.setBackground(mouseClickColorInventario);
            ConProducto cProducto = new ConProducto();
            CrearOferta ventana = new CrearOferta(cProducto.listarProductos());
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_crearOfertaMousePressed

    private void txt_crearOfertaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_crearOfertaMouseReleased
        btn_crearOferta.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_crearOfertaMouseReleased

    private void txt_cargaMasivaProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargaMasivaProdMouseEntered
        btn_cargaMasivaProd.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_cargaMasivaProdMouseEntered

    private void txt_cargaMasivaProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargaMasivaProdMouseExited
        btn_cargaMasivaProd.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_cargaMasivaProdMouseExited

    private void txt_cargaMasivaProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargaMasivaProdMousePressed
        if(evt.getButton() == 1){
                    btn_cargaMasivaProd.setBackground(mouseClickColorInventario);
                    CargaMasiva ventana = new CargaMasiva();
                    ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_cargaMasivaProdMousePressed

    private void txt_cargaMasivaProdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cargaMasivaProdMouseReleased
        btn_cargaMasivaProd.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_cargaMasivaProdMouseReleased

    private void txt_actualizacionMasivaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizacionMasivaMouseEntered
        btn_actualizacionMasiva.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_actualizacionMasivaMouseEntered

    private void txt_actualizacionMasivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizacionMasivaMouseExited
        btn_actualizacionMasiva.setBackground(mouseExitColorInventario);
    }//GEN-LAST:event_txt_actualizacionMasivaMouseExited

    private void txt_actualizacionMasivaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizacionMasivaMousePressed
        if(evt.getButton() == 1){
            btn_actualizacionMasiva.setBackground(mouseClickColorInventario);
            ActualizarStockMasivo ventana = new ActualizarStockMasivo();
            ventana.setVisible(true);
        }
        
    }//GEN-LAST:event_txt_actualizacionMasivaMousePressed

    private void txt_actualizacionMasivaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_actualizacionMasivaMouseReleased
        btn_actualizacionMasiva.setBackground(mouseEnterColorInventario);
    }//GEN-LAST:event_txt_actualizacionMasivaMouseReleased

    private void txt_ventaDiariaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaDiariaMouseEntered
        btn_ventaDiaria.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_ventaDiariaMouseEntered

    private void txt_ventaDiariaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaDiariaMouseExited
        btn_ventaDiaria.setBackground(mouseExitColorInforme);
    }//GEN-LAST:event_txt_ventaDiariaMouseExited

    private void txt_ventaDiariaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaDiariaMousePressed
        if(evt.getButton() == 1){
            btn_ventaDiaria.setBackground(mouseClickColorInforme);
            ReporteDiario ventana = new ReporteDiario();
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_ventaDiariaMousePressed

    private void txt_ventaDiariaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaDiariaMouseReleased
        btn_ventaDiaria.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_ventaDiariaMouseReleased

    private void txt_ventaPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaPeriodoMouseEntered
        btn_ventaPeriodo.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_ventaPeriodoMouseEntered

    private void txt_ventaPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaPeriodoMouseExited
        btn_ventaPeriodo.setBackground(mouseExitColorInforme);
    }//GEN-LAST:event_txt_ventaPeriodoMouseExited

    private void txt_ventaPeriodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaPeriodoMousePressed
        if(evt.getButton() == 1){
                    btn_ventaPeriodo.setBackground(mouseClickColorInforme);
                    ReportePeriodo ventana = new ReportePeriodo();
                    ventana.setVisible(true);
        }
    }//GEN-LAST:event_txt_ventaPeriodoMousePressed

    private void txt_ventaPeriodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ventaPeriodoMouseReleased
                btn_ventaPeriodo.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_ventaPeriodoMouseReleased

    private void txt_stockNegativoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockNegativoMouseEntered
        btn_stockNegativo.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_stockNegativoMouseEntered

    private void txt_stockNegativoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockNegativoMouseExited
        btn_stockNegativo.setBackground(mouseExitColorInforme);
    }//GEN-LAST:event_txt_stockNegativoMouseExited

    private void txt_stockNegativoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockNegativoMousePressed
        if(evt.getButton() == 1){
            btn_stockNegativo.setBackground(mouseClickColorInforme);
            ConInformes cInforme = new ConInformes();
            cInforme.informeStockNegativo(this);      
        }
    }//GEN-LAST:event_txt_stockNegativoMousePressed

    private void txt_stockNegativoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockNegativoMouseReleased
        btn_stockNegativo.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_stockNegativoMouseReleased

    private void txt_stockGeneralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockGeneralMouseEntered
        btn_stockGeneral.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_stockGeneralMouseEntered

    private void txt_stockGeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockGeneralMouseExited
        btn_stockGeneral.setBackground(mouseExitColorInforme);
    }//GEN-LAST:event_txt_stockGeneralMouseExited

    private void txt_stockGeneralMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockGeneralMouseReleased
        btn_stockGeneral.setBackground(mouseEnterColorInforme);
    }//GEN-LAST:event_txt_stockGeneralMouseReleased

    private void txt_stockGeneralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_stockGeneralMousePressed
        if(evt.getButton() == 1){
            btn_stockGeneral.setBackground(mouseClickColorInforme);
            TipoReporteStock ventana = new TipoReporteStock();
            ventana.setVisible(true);  
        }
    }//GEN-LAST:event_txt_stockGeneralMousePressed

    private void header1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header1MousePressed

    private void header1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseDragged
        int x = evt.getXOnScreen() - 300;
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_header1MouseDragged

    private void header2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header2MousePressed

    private void header2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_header2MouseDragged

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
    private javax.swing.JPanel btn_actualizacionMasiva;
    private javax.swing.JPanel btn_actualizarProducto;
    private javax.swing.JPanel btn_cargaMasivaProd;
    private javax.swing.JPanel btn_consultarPrecio;
    private javax.swing.JPanel btn_consultarStock;
    private javax.swing.JPanel btn_crearOferta;
    private javax.swing.JPanel btn_nuevaVenta;
    private javax.swing.JPanel btn_nuevoProducto;
    private javax.swing.JPanel btn_paletaColor;
    private javax.swing.JPanel btn_stockGeneral;
    private javax.swing.JPanel btn_stockNegativo;
    private javax.swing.JPanel btn_ventaDiaria;
    private javax.swing.JPanel btn_ventaPeriodo;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
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
    private javax.swing.JLabel txt_actualizacionMasiva;
    private javax.swing.JLabel txt_actualizarProducto;
    private javax.swing.JLabel txt_cargaMasivaProd;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_consultarPrecio;
    private javax.swing.JLabel txt_consultarStock;
    private javax.swing.JLabel txt_crearOferta;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_moduloInicio;
    private javax.swing.JLabel txt_nuevaVenta;
    private javax.swing.JLabel txt_nuevoProducto;
    private javax.swing.JLabel txt_paletaColor;
    private javax.swing.JLabel txt_stockGeneral;
    private javax.swing.JLabel txt_stockNegativo;
    private javax.swing.JLabel txt_ventaDiaria;
    private javax.swing.JLabel txt_ventaPeriodo;
    // End of variables declaration//GEN-END:variables
}
