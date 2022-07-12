/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.MouseEvent;
import controlador.ConColores;
import controlador.ConProducto;
import db.Conexion;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.PaletaColor;
import modelo.Producto;


public class Home extends javax.swing.JFrame {

    private static final Conexion CONEXION = new Conexion();
    private static final Connection CONNECTION = CONEXION.getConnection();
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
        txt_opcion1.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0));
        txt_opcion2.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0));
        txt_opcion3.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0));
        txt_opcion4.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0));
        txt_opcion5.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0));
        txt_opcion6.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 0)); 
        activarBotonesPorModulo("HOME");
        ModuloSeleccionadoTitulo.setBackground(PanelColor);
        TipoModuloColor.setBackground(ColorHome);
        txt_ModuloSeleccionado.setText("INICIO"); 
        LeftPanel.setBackground(PanelColor);
        ClosePanel.setBackground(BackgroundColor);
        MinPanel.setBackground(BackgroundColor);
        Background.setBackground(BackgroundColor);
        PanelVenta.setBackground(BackgroundColor);

        
    }
    
    String MODULO = "";

    


    
    private void activarBotonesPorModulo(String Modulo){
        MODULO = Modulo;
        
        if(Modulo.equals("VENTA")){
            btn_opcion1.setVisible(true);
            btn_opcion2.setVisible(false);
            btn_opcion3.setVisible(false);
            btn_opcion4.setVisible(true);
            btn_opcion5.setVisible(false);
            btn_opcion6.setVisible(false);
            txt_opcion1.setText("NUEVA VENTA");
            txt_opcion2.setText("");
            txt_opcion3.setText("");
            txt_opcion4.setText("CONSULTAR PRECIOS");
            txt_opcion5.setText("");
            txt_opcion6.setText("");   
            
            ImageIcon img = new ImageIcon("src/img/nueva_venta.png");
            txt_opcion1.setIcon(img);
            
            img = new ImageIcon("src/img/consultar_precio.png");
            txt_opcion4.setIcon(img);            
            
            btn_opcion1.setBackground(ColorVenta);
            btn_opcion4.setBackground(ColorVenta);
            
            moduloHome.setBackground(PanelColor);
            moduloVenta.setBackground(mouseEnterPanelColor);
            moduloInventario.setBackground(PanelColor);
            moduloInforme.setBackground(PanelColor);
            
        }
        else if(Modulo.equals("INVENTARIO")){
            btn_opcion1.setVisible(true);
            btn_opcion2.setVisible(true);
            btn_opcion3.setVisible(true);
            btn_opcion4.setVisible(true);
            btn_opcion5.setVisible(true);
            btn_opcion6.setVisible(true);
            
            txt_opcion1.setText("NUEVO PRODUCTO");
            txt_opcion2.setText("CARGA MASIVA");
            txt_opcion3.setText("ACTUALIZACION MASIVA");
            txt_opcion4.setText("CONSULTA DE STOCK");
            txt_opcion5.setText("OFERTAS"); 
            txt_opcion6.setText("ACTUALIZAR STOCK/PRECIO");
            
            
            ImageIcon img = new ImageIcon("src/img/add_product.png");
            txt_opcion1.setIcon(img);
            
            img = new ImageIcon("src/img/carga_masiva.png");
            txt_opcion2.setIcon(img);
            
            img = new ImageIcon("src/img/update_products.png");
            txt_opcion3.setIcon(img);
            
            img = new ImageIcon("src/img/consultar_stock.png");
            txt_opcion4.setIcon(img);

            img = new ImageIcon("src/img/sales.png");
            txt_opcion5.setIcon(img);  
            
            img = new ImageIcon("src/img/update_stock.png");
            txt_opcion6.setIcon(img);            
            
              
            
            btn_opcion1.setBackground(ColorInventario);
            btn_opcion2.setBackground(ColorInventario);
            btn_opcion3.setBackground(ColorInventario);
            btn_opcion4.setBackground(ColorInventario);
            btn_opcion5.setBackground(ColorInventario);
            btn_opcion6.setBackground(ColorInventario);
            
            moduloHome.setBackground(PanelColor);
            moduloVenta.setBackground(PanelColor);
            moduloInventario.setBackground(mouseEnterPanelColor);
            moduloInforme.setBackground(PanelColor);
        }
        else if(Modulo.equals("INFORMES")){
            btn_opcion1.setVisible(true);
            btn_opcion2.setVisible(true);
            btn_opcion3.setVisible(false);
            btn_opcion4.setVisible(true);
            btn_opcion5.setVisible(true);
            btn_opcion6.setVisible(false);
            txt_opcion1.setText("VENTA DIARIA");
            txt_opcion2.setText("VENTA POR PERIODO");
            txt_opcion3.setText("");
            txt_opcion4.setText("STOCK NEGATIVO");
            txt_opcion5.setText("STOCK GENERAL");
            txt_opcion6.setText("");  
            
            ImageIcon img = new ImageIcon("src/img/pdf.png");
            txt_opcion1.setIcon(img);
            txt_opcion2.setIcon(img);
            txt_opcion4.setIcon(img);
            txt_opcion5.setIcon(img);
            
            btn_opcion1.setBackground(ColorInforme);
            btn_opcion2.setBackground(ColorInforme);
            btn_opcion4.setBackground(ColorInforme);
            btn_opcion5.setBackground(ColorInforme);   
            
            moduloHome.setBackground(PanelColor);
            moduloVenta.setBackground(PanelColor);
            moduloInventario.setBackground(PanelColor);
            moduloInforme.setBackground(mouseEnterPanelColor);
        }  
        else if(Modulo.equals("HOME")){
            btn_opcion1.setVisible(true);
            btn_opcion2.setVisible(false);
            btn_opcion3.setVisible(false);
            btn_opcion4.setVisible(false);
            btn_opcion5.setVisible(false);
            btn_opcion6.setVisible(false);
            
            txt_opcion1.setText("CAMBIAR PALETA DE COLOR");
            btn_opcion1.setBackground(PanelColor);
            ImageIcon img = new ImageIcon("src/img/color_palette.png");
            txt_opcion1.setIcon(img);
            moduloHome.setBackground(mouseEnterPanelColor);
            moduloVenta.setBackground(PanelColor);
            moduloInventario.setBackground(PanelColor);
            moduloInforme.setBackground(PanelColor);
        }
    }
    
    ConColores cColor = new ConColores();
    PaletaColor paleta = cColor.paletaActiva();
    //COLORES    
    Color BackgroundColor = paleta.getBackground();
    Color PanelColor = paleta.getPanel();
    Color mouseEnterPanelColor = paleta.getMouseEnter();
    Color mouseExitPanelColor = PanelColor;
    Color mouseClickPanelColor = paleta.getMouseClick();  
    //HOME
    Color ColorHome = new Color(85, 156, 173);
    //VENTA
    Color ColorVenta = new Color(0, 117, 67);
    Color mouseEnterColorVenta = new Color(13, 173, 73);
    Color mouseExitColorVenta = ColorVenta;
    Color mouseClickColorVenta = new Color(24, 216, 77);
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
        moduloHome = new javax.swing.JPanel();
        txt_moduloInicio = new javax.swing.JLabel();
        moduloVenta = new javax.swing.JPanel();
        txt_ModuloVenta = new javax.swing.JLabel();
        moduloInventario = new javax.swing.JPanel();
        txt_ModuloInventario = new javax.swing.JLabel();
        moduloInforme = new javax.swing.JPanel();
        txt_ModuloInforme = new javax.swing.JLabel();
        ModuloSeleccionadoTitulo = new javax.swing.JPanel();
        TipoModuloColor = new javax.swing.JPanel();
        txt_ModuloSeleccionado = new javax.swing.JLabel();
        PanelVenta = new javax.swing.JPanel();
        btn_opcion1 = new javax.swing.JPanel();
        txt_opcion1 = new javax.swing.JLabel();
        btn_opcion2 = new javax.swing.JPanel();
        txt_opcion2 = new javax.swing.JLabel();
        btn_opcion3 = new javax.swing.JPanel();
        txt_opcion3 = new javax.swing.JLabel();
        btn_opcion4 = new javax.swing.JPanel();
        txt_opcion4 = new javax.swing.JLabel();
        btn_opcion5 = new javax.swing.JPanel();
        txt_opcion5 = new javax.swing.JLabel();
        btn_opcion6 = new javax.swing.JPanel();
        txt_opcion6 = new javax.swing.JLabel();
        logoBackground = new javax.swing.JLabel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();

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

        moduloHome.setBackground(new java.awt.Color(176, 137, 104));

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

        javax.swing.GroupLayout moduloHomeLayout = new javax.swing.GroupLayout(moduloHome);
        moduloHome.setLayout(moduloHomeLayout);
        moduloHomeLayout.setHorizontalGroup(
            moduloHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_moduloInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        moduloHomeLayout.setVerticalGroup(
            moduloHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_moduloInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        LeftPanel.add(moduloHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 300, 70));

        moduloVenta.setBackground(new java.awt.Color(176, 137, 104));

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

        javax.swing.GroupLayout moduloVentaLayout = new javax.swing.GroupLayout(moduloVenta);
        moduloVenta.setLayout(moduloVentaLayout);
        moduloVentaLayout.setHorizontalGroup(
            moduloVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        moduloVentaLayout.setVerticalGroup(
            moduloVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        LeftPanel.add(moduloVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 300, -1));

        moduloInventario.setBackground(new java.awt.Color(176, 137, 104));
        moduloInventario.setPreferredSize(new java.awt.Dimension(310, 70));

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

        javax.swing.GroupLayout moduloInventarioLayout = new javax.swing.GroupLayout(moduloInventario);
        moduloInventario.setLayout(moduloInventarioLayout);
        moduloInventarioLayout.setHorizontalGroup(
            moduloInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moduloInventarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ModuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        moduloInventarioLayout.setVerticalGroup(
            moduloInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInventarioLayout.createSequentialGroup()
                .addComponent(txt_ModuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LeftPanel.add(moduloInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 300, -1));

        moduloInforme.setBackground(new java.awt.Color(176, 137, 104));
        moduloInforme.setPreferredSize(new java.awt.Dimension(310, 70));

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

        javax.swing.GroupLayout moduloInformeLayout = new javax.swing.GroupLayout(moduloInforme);
        moduloInforme.setLayout(moduloInformeLayout);
        moduloInformeLayout.setHorizontalGroup(
            moduloInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInformeLayout.createSequentialGroup()
                .addComponent(txt_ModuloInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        moduloInformeLayout.setVerticalGroup(
            moduloInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moduloInformeLayout.createSequentialGroup()
                .addComponent(txt_ModuloInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        LeftPanel.add(moduloInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 300, -1));

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

        PanelVenta.setBackground(new java.awt.Color(230, 204, 178));
        PanelVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_opcion1.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_opcion1.setForeground(new java.awt.Color(255, 255, 255));
        txt_opcion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_opcion1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_opcion1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_opcion1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_opcion1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btn_opcion1Layout = new javax.swing.GroupLayout(btn_opcion1);
        btn_opcion1.setLayout(btn_opcion1Layout);
        btn_opcion1Layout.setHorizontalGroup(
            btn_opcion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion1Layout.createSequentialGroup()
                .addComponent(txt_opcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion1Layout.setVerticalGroup(
            btn_opcion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 50, -1, -1));

        btn_opcion2.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_opcion2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_opcion2Layout = new javax.swing.GroupLayout(btn_opcion2);
        btn_opcion2.setLayout(btn_opcion2Layout);
        btn_opcion2Layout.setHorizontalGroup(
            btn_opcion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion2Layout.createSequentialGroup()
                .addComponent(txt_opcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion2Layout.setVerticalGroup(
            btn_opcion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 185, -1, -1));

        btn_opcion3.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_opcion3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_opcion3Layout = new javax.swing.GroupLayout(btn_opcion3);
        btn_opcion3.setLayout(btn_opcion3Layout);
        btn_opcion3Layout.setHorizontalGroup(
            btn_opcion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion3Layout.createSequentialGroup()
                .addComponent(txt_opcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion3Layout.setVerticalGroup(
            btn_opcion3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 320, -1, -1));

        btn_opcion4.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion4.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_opcion4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_opcion4Layout = new javax.swing.GroupLayout(btn_opcion4);
        btn_opcion4.setLayout(btn_opcion4Layout);
        btn_opcion4Layout.setHorizontalGroup(
            btn_opcion4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion4Layout.createSequentialGroup()
                .addComponent(txt_opcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion4Layout.setVerticalGroup(
            btn_opcion4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 50, -1, -1));

        btn_opcion5.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion5.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_opcion5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_opcion5Layout = new javax.swing.GroupLayout(btn_opcion5);
        btn_opcion5.setLayout(btn_opcion5Layout);
        btn_opcion5Layout.setHorizontalGroup(
            btn_opcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion5Layout.createSequentialGroup()
                .addComponent(txt_opcion5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion5Layout.setVerticalGroup(
            btn_opcion5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 185, -1, -1));

        btn_opcion6.setBackground(new java.awt.Color(156, 102, 68));

        txt_opcion6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_opcion6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout btn_opcion6Layout = new javax.swing.GroupLayout(btn_opcion6);
        btn_opcion6.setLayout(btn_opcion6Layout);
        btn_opcion6Layout.setHorizontalGroup(
            btn_opcion6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcion6Layout.createSequentialGroup()
                .addComponent(txt_opcion6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_opcion6Layout.setVerticalGroup(
            btn_opcion6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_opcion6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelVenta.add(btn_opcion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 320, -1, -1));

        logoBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/piliscoffee-logo-no-bg.png"))); // NOI18N
        PanelVenta.add(logoBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 750, 580));

        Background.add(PanelVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 790, 620));

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
        moduloVenta.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloVentaMouseEntered

    private void txt_ModuloVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMouseExited
        if(!MODULO.equals("VENTA")) moduloVenta.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloVentaMouseExited

    private void txt_ModuloInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseEntered
        moduloInventario.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloInventarioMouseEntered

    private void txt_ModuloInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseExited
        if(!MODULO.equals("INVENTARIO")) moduloInventario.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloInventarioMouseExited

    private void txt_ModuloInformeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseEntered
        moduloInforme.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_ModuloInformeMouseEntered

    private void txt_ModuloInformeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseExited
        if(!MODULO.equals("INFORMES")) moduloInforme.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_ModuloInformeMouseExited

    private void txt_ModuloVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMousePressed
        if(evt.getButton() == 1){
            moduloVenta.setBackground(mouseClickPanelColor);
            txt_ModuloVenta.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);            
            TipoModuloColor.setBackground(ColorVenta);
            txt_ModuloSeleccionado.setText("MÓDULO DE VENTAS");
            PanelVenta.setVisible(true);
            activarBotonesPorModulo("VENTA");
        }
    }//GEN-LAST:event_txt_ModuloVentaMousePressed

    private void txt_ModuloVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloVentaMouseReleased
        moduloVenta.setBackground(mouseEnterPanelColor);
        txt_ModuloVenta.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloVentaMouseReleased

    private void txt_ModuloInventarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMousePressed
        if(evt.getButton() == 1){
            moduloInventario.setBackground(mouseClickPanelColor);
            txt_ModuloInventario.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorInventario);
            txt_ModuloSeleccionado.setText("MÓDULO DE INVENTARIO");
            PanelVenta.setVisible(true);
            activarBotonesPorModulo("INVENTARIO");
        }
    }//GEN-LAST:event_txt_ModuloInventarioMousePressed

    private void txt_ModuloInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInventarioMouseReleased
        moduloInventario.setBackground(mouseEnterPanelColor);
        txt_ModuloInventario.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloInventarioMouseReleased

    private void txt_ModuloInformeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMousePressed
        if(evt.getButton() == 1){
            moduloInforme.setBackground(mouseClickPanelColor);
            txt_ModuloInforme.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorInforme);
            txt_ModuloSeleccionado.setText("MÓDULO DE INFORMES");    
            PanelVenta.setVisible(true); 
            activarBotonesPorModulo("INFORMES");
        }
    }//GEN-LAST:event_txt_ModuloInformeMousePressed

    private void txt_ModuloInformeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ModuloInformeMouseReleased
        moduloInforme.setBackground(mouseEnterPanelColor);
        txt_ModuloInforme.setForeground(Color.WHITE);
    }//GEN-LAST:event_txt_ModuloInformeMouseReleased

    private void txt_opcion1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_opcion1MouseEntered
        if(MODULO.equals("VENTA")){
            btn_opcion1.setBackground(mouseEnterColorVenta);
        }
        else if(MODULO.equals("INVENTARIO")){
            btn_opcion1.setBackground(mouseEnterColorInventario);
        }
        else if(MODULO.equals("INFORMES")){
            btn_opcion1.setBackground(mouseEnterColorInforme);
        }
        else if(MODULO.equals("HOME")){
            btn_opcion1.setBackground(mouseEnterPanelColor);
        }
    }//GEN-LAST:event_txt_opcion1MouseEntered

    private void txt_opcion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_opcion1MouseExited
        if(MODULO.equals("VENTA")){
            btn_opcion1.setBackground(mouseExitColorVenta);
        }
        else if(MODULO.equals("INVENTARIO")){
            btn_opcion1.setBackground(mouseExitColorInventario);
        }
        else if(MODULO.equals("INFORMES")){
            btn_opcion1.setBackground(mouseExitColorInforme);
        }
        else if(MODULO.equals("HOME")){
            btn_opcion1.setBackground(mouseExitPanelColor);
        }        
    }//GEN-LAST:event_txt_opcion1MouseExited

    private void txt_opcion1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_opcion1MousePressed
        if(evt.getButton() == 1){
            if(MODULO.equals("VENTA")){
                //NUEVA VENTA
                btn_opcion1.setBackground(mouseClickColorVenta);
                ConProducto cProducto = new ConProducto();
                ArrayList<Producto> listado = cProducto.listarProductos();
                NuevaVenta ventana = new NuevaVenta(listado);
                ventana.setVisible(true);
            } 
            else if(MODULO.equals("INVENTARIO")){
                //NUEVO PRODUCTO
                btn_opcion1.setBackground(mouseClickColorInventario);
                IngresarProducto ventana = new IngresarProducto();
                ventana.setVisible(true);
            }
            else if(MODULO.equals("INFORMES")){
                //VENTA DIARIA
                btn_opcion1.setBackground(mouseClickColorInforme);
                ReporteDiario ventana = new ReporteDiario();
                ventana.setVisible(true);                
            }
            else if(MODULO.equals("HOME")){
                Instant start = Instant.now();
                CambiarPaleta ventana = new CambiarPaleta(paleta, start);
                ventana.setVisible(true);
            }
        }

    }//GEN-LAST:event_txt_opcion1MousePressed

    private void txt_opcion1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_opcion1MouseReleased
        if(MODULO.equals("VENTA")){
           btn_opcion1.setBackground(mouseEnterColorVenta);
        } 
        else if(MODULO.equals("INVENTARIO")){
            btn_opcion1.setBackground(mouseEnterColorInventario);
        }
        else if(MODULO.equals("INFORMES")){
            btn_opcion1.setBackground(mouseEnterColorInforme);
        }        
    }//GEN-LAST:event_txt_opcion1MouseReleased

    private void txt_moduloInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseEntered
        moduloHome.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_moduloInicioMouseEntered

    private void txt_moduloInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseExited
        if(!MODULO.equals("HOME")) moduloHome.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_moduloInicioMouseExited

    private void txt_moduloInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMousePressed
        if(evt.getButton() == 1){
            moduloHome.setBackground(mouseClickPanelColor);
            txt_moduloInicio.setForeground(Color.BLACK);
            ModuloSeleccionadoTitulo.setBackground(PanelColor);
            TipoModuloColor.setBackground(ColorHome);
            txt_ModuloSeleccionado.setText("INICIO");  
            activarBotonesPorModulo("HOME");
        }
    }//GEN-LAST:event_txt_moduloInicioMousePressed

    private void txt_moduloInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_moduloInicioMouseReleased
        moduloHome.setBackground(mouseEnterPanelColor);
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
    private javax.swing.JPanel ModuloSeleccionadoTitulo;
    public javax.swing.JPanel PanelVenta;
    private javax.swing.JLabel Subtitle;
    private javax.swing.JPanel TipoModuloColor;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel btn_opcion1;
    private javax.swing.JPanel btn_opcion2;
    private javax.swing.JPanel btn_opcion3;
    private javax.swing.JPanel btn_opcion4;
    private javax.swing.JPanel btn_opcion5;
    private javax.swing.JPanel btn_opcion6;
    private javax.swing.JLabel logoBackground;
    private javax.swing.JPanel moduloHome;
    private javax.swing.JPanel moduloInforme;
    private javax.swing.JPanel moduloInventario;
    private javax.swing.JPanel moduloVenta;
    private javax.swing.JLabel txt_ModuloInforme;
    private javax.swing.JLabel txt_ModuloInventario;
    private javax.swing.JLabel txt_ModuloSeleccionado;
    private javax.swing.JLabel txt_ModuloVenta;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_moduloInicio;
    private javax.swing.JLabel txt_opcion1;
    private javax.swing.JLabel txt_opcion2;
    private javax.swing.JLabel txt_opcion3;
    private javax.swing.JLabel txt_opcion4;
    private javax.swing.JLabel txt_opcion5;
    private javax.swing.JLabel txt_opcion6;
    // End of variables declaration//GEN-END:variables
}
