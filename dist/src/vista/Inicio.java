package vista;
import controlador.ConInformes;
import controlador.ConProducto;
import db.Conexion;
import java.awt.*;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Producto;


public class Inicio extends javax.swing.JFrame {
    

    
        
    public Inicio() {
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
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(100, 100, (int) dim.getWidth()+4, (int) dim.getHeight()-35);        
        setLocationRelativeTo(null);
        
        System.out.println((int) dim.getWidth()+4);
        System.out.println((int) dim.getHeight()-35);
        
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        btn_nuevaVenta = new javax.swing.JLabel();
        btn_consultarPrecio = new javax.swing.JLabel();
        btn_actualizarStockPrecio = new javax.swing.JLabel();
        btn_nuevoProducto = new javax.swing.JLabel();
        btn_cargaMasiva = new javax.swing.JLabel();
        btn_ventaDiaria = new javax.swing.JLabel();
        btn_stockNegativo = new javax.swing.JLabel();
        lbl_headerVenta = new javax.swing.JLabel();
        lbl_headerInventario = new javax.swing.JLabel();
        lbl_headerReporte = new javax.swing.JLabel();
        btn_ventaPeriodo = new javax.swing.JLabel();
        btn_consultaStockU = new javax.swing.JLabel();
        btn_stockGral = new javax.swing.JLabel();
        btn_actualizarStockMasivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(230, 204, 178));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/POS Software logo.png"))); // NOI18N

        btn_nuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/nuevaventa_solid.png"))); // NOI18N
        btn_nuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevaVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevaVentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_nuevaVentaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_nuevaVentaMouseReleased(evt);
            }
        });

        btn_consultarPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/consultarprecio_solid.png"))); // NOI18N
        btn_consultarPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_consultarPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_consultarPrecioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_consultarPrecioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_consultarPrecioMouseReleased(evt);
            }
        });

        btn_actualizarStockPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/actualizarStockPrecio_solid.png"))); // NOI18N
        btn_actualizarStockPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizarStockPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizarStockPrecioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_actualizarStockPrecioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_actualizarStockPrecioMouseReleased(evt);
            }
        });

        btn_nuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/nuevoproducto_solid.png"))); // NOI18N
        btn_nuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nuevoProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nuevoProductoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_nuevoProductoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_nuevoProductoMouseReleased(evt);
            }
        });

        btn_cargaMasiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/cargamasiva_solid.png"))); // NOI18N
        btn_cargaMasiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cargaMasivaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cargaMasivaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cargaMasivaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_cargaMasivaMouseReleased(evt);
            }
        });

        btn_ventaDiaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/ventadiaria_solid.png"))); // NOI18N
        btn_ventaDiaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ventaDiariaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ventaDiariaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ventaDiariaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ventaDiariaMouseReleased(evt);
            }
        });

        btn_stockNegativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/stocknegativo_solid.png"))); // NOI18N
        btn_stockNegativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_stockNegativoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_stockNegativoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_stockNegativoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_stockNegativoMouseReleased(evt);
            }
        });

        lbl_headerVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Módulo de ventas header.png"))); // NOI18N

        lbl_headerInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Módulo inventario header.png"))); // NOI18N

        lbl_headerReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Módulo de reportes header.png"))); // NOI18N

        btn_ventaPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/ventaperiodo_solid.png"))); // NOI18N
        btn_ventaPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ventaPeriodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ventaPeriodoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ventaPeriodoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ventaPeriodoMouseReleased(evt);
            }
        });

        btn_consultaStockU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/consultastock_solid.png"))); // NOI18N
        btn_consultaStockU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_consultaStockUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_consultaStockUMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_consultaStockUMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_consultaStockUMouseReleased(evt);
            }
        });

        btn_stockGral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/stockgral_solid.png"))); // NOI18N
        btn_stockGral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_stockGralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_stockGralMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_stockGralMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_stockGralMouseReleased(evt);
            }
        });

        btn_actualizarStockMasivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/actualizarstockmasivo_solid.png"))); // NOI18N
        btn_actualizarStockMasivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizarStockMasivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizarStockMasivoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_actualizarStockMasivoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_actualizarStockMasivoMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_nuevaVenta)
                                .addGap(66, 66, 66)
                                .addComponent(btn_consultarPrecio)
                                .addGap(249, 249, 249))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_headerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_ventaDiaria)
                                    .addComponent(btn_ventaPeriodo))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_stockNegativo)
                                    .addComponent(btn_stockGral)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_nuevoProducto)
                                        .addComponent(btn_cargaMasiva))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_consultaStockU)
                                        .addComponent(btn_actualizarStockPrecio))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_actualizarStockMasivo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(lbl_headerReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_headerVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(lbl_headerVenta)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(236, 236, 236))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_nuevaVenta)
                            .addComponent(btn_consultarPrecio))
                        .addGap(52, 52, 52)
                        .addComponent(lbl_headerInventario)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_nuevoProducto)
                                    .addComponent(btn_consultaStockU))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_actualizarStockPrecio)
                                    .addComponent(btn_cargaMasiva)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btn_actualizarStockMasivo)))
                        .addGap(68, 68, 68)
                        .addComponent(lbl_headerReporte)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_stockNegativo)
                                .addGap(18, 18, 18)
                                .addComponent(btn_stockGral))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_ventaDiaria)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ventaPeriodo)))
                        .addGap(127, 127, 127))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevaVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevaVentaMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventa_click.png"));
        btn_nuevaVenta.setIcon(botonClick);

        ConProducto cProducto = new ConProducto();
        ArrayList<Producto> listado = cProducto.listarProductos();
        NuevaVenta ventana = new NuevaVenta(listado);
        ventana.setVisible(true);

    }//GEN-LAST:event_btn_nuevaVentaMousePressed

    private void btn_nuevaVentaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevaVentaMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventa_solid.png"));
        btn_nuevaVenta.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevaVentaMouseReleased

    private void btn_nuevaVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevaVentaMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventa_click.png"));
        btn_nuevaVenta.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevaVentaMouseEntered

    private void btn_nuevaVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevaVentaMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevaventa_solid.png"));
        btn_nuevaVenta.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevaVentaMouseExited

    private void btn_consultarPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultarPrecioMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultarprecio_click.png"));
        btn_consultarPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultarPrecioMouseEntered

    private void btn_consultarPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultarPrecioMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultarprecio_solid.png"));
        btn_consultarPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultarPrecioMouseExited

    private void btn_consultarPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultarPrecioMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultarprecio_click.png"));
        btn_consultarPrecio.setIcon(botonClick);
        ConProducto cProducto = new ConProducto();
        ArrayList<Producto> listado = cProducto.listarProductos();        
        ConsultarPrecio ventana = new ConsultarPrecio(listado);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_consultarPrecioMousePressed

    private void btn_consultarPrecioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultarPrecioMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultarprecio_solid.png"));
        btn_consultarPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultarPrecioMouseReleased

    private void btn_actualizarStockPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockPrecioMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarStockPrecio_click.png"));
        btn_actualizarStockPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockPrecioMouseEntered

    private void btn_actualizarStockPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockPrecioMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarStockPrecio_solid.png"));
        btn_actualizarStockPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockPrecioMouseExited

    private void btn_actualizarStockPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockPrecioMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarStockPrecio_click.png"));
        btn_actualizarStockPrecio.setIcon(botonClick);
        EditarStockPrecio ventana = new EditarStockPrecio();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_actualizarStockPrecioMousePressed

    private void btn_actualizarStockPrecioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockPrecioMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarStockPrecio_solid.png"));
        btn_actualizarStockPrecio.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockPrecioMouseReleased

    private void btn_nuevoProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoProductoMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevoproducto_click.png"));
        btn_nuevoProducto.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevoProductoMouseEntered

    private void btn_nuevoProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoProductoMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevoproducto_solid.png"));
        btn_nuevoProducto.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevoProductoMouseExited

    private void btn_nuevoProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoProductoMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevoproducto_click.png"));
        btn_nuevoProducto.setIcon(botonClick);
        IngresarProducto ventana = new IngresarProducto();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_nuevoProductoMousePressed

    private void btn_nuevoProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nuevoProductoMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/nuevoproducto_solid.png"));
        btn_nuevoProducto.setIcon(botonClick);
    }//GEN-LAST:event_btn_nuevoProductoMouseReleased

    private void btn_cargaMasivaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargaMasivaMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/cargamasiva_click.png"));
        btn_cargaMasiva.setIcon(botonClick);
    }//GEN-LAST:event_btn_cargaMasivaMouseEntered

    private void btn_cargaMasivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargaMasivaMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/cargamasiva_solid.png"));
        btn_cargaMasiva.setIcon(botonClick);
    }//GEN-LAST:event_btn_cargaMasivaMouseExited

    private void btn_cargaMasivaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargaMasivaMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/cargamasiva_click.png"));
        btn_cargaMasiva.setIcon(botonClick);
        CargaMasiva ventana = new CargaMasiva();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_cargaMasivaMousePressed

    private void btn_cargaMasivaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cargaMasivaMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/cargamasiva_solid.png"));
        btn_cargaMasiva.setIcon(botonClick);
    }//GEN-LAST:event_btn_cargaMasivaMouseReleased

    private void btn_ventaDiariaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaDiariaMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventadiaria_click.png"));
        btn_ventaDiaria.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaDiariaMouseEntered

    private void btn_ventaDiariaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaDiariaMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventadiaria_solid.png"));
        btn_ventaDiaria.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaDiariaMouseExited

    private void btn_ventaDiariaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaDiariaMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventadiaria_click.png"));
        btn_ventaDiaria.setIcon(botonClick);
        ReporteDiario ventana = new ReporteDiario();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_ventaDiariaMousePressed

    private void btn_ventaDiariaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaDiariaMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventadiaria_solid.png"));
        btn_ventaDiaria.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaDiariaMouseReleased

    private void btn_stockNegativoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockNegativoMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stocknegativo_click.png"));
        btn_stockNegativo.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockNegativoMouseEntered

    private void btn_stockNegativoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockNegativoMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stocknegativo_solid.png"));
        btn_stockNegativo.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockNegativoMouseExited

    private void btn_stockNegativoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockNegativoMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stocknegativo_click.png"));
        btn_stockNegativo.setIcon(botonClick);
        ConInformes cInforme = new ConInformes();
        cInforme.informeStockNegativo(this);        
    }//GEN-LAST:event_btn_stockNegativoMousePressed

    private void btn_stockNegativoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockNegativoMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stocknegativo_solid.png"));
        btn_stockNegativo.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockNegativoMouseReleased

    private void btn_ventaPeriodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaPeriodoMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventaperiodo_click.png"));
        btn_ventaPeriodo.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaPeriodoMouseEntered

    private void btn_ventaPeriodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaPeriodoMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventaperiodo_solid.png"));
        btn_ventaPeriodo.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaPeriodoMouseExited

    private void btn_ventaPeriodoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaPeriodoMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventaperiodo_click.png"));
        btn_ventaPeriodo.setIcon(botonClick);
        ReportePeriodo ventana = new ReportePeriodo();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_ventaPeriodoMousePressed

    private void btn_ventaPeriodoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ventaPeriodoMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/ventaperiodo_solid.png"));
        btn_ventaPeriodo.setIcon(botonClick);
    }//GEN-LAST:event_btn_ventaPeriodoMouseReleased

    private void btn_consultaStockUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultaStockUMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultastock_click.png"));
        btn_consultaStockU.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultaStockUMouseEntered

    private void btn_consultaStockUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultaStockUMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultastock_solid.png"));
        btn_consultaStockU.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultaStockUMouseExited

    private void btn_consultaStockUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultaStockUMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultastock_click.png"));
        btn_consultaStockU.setIcon(botonClick);
        ConsultaStockUnit ventana = new ConsultaStockUnit();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_consultaStockUMousePressed

    private void btn_consultaStockUMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultaStockUMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/consultastock_solid.png"));
        btn_consultaStockU.setIcon(botonClick);
    }//GEN-LAST:event_btn_consultaStockUMouseReleased

    private void btn_stockGralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockGralMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stockgral_click.png"));
        btn_stockGral.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockGralMouseEntered

    private void btn_stockGralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockGralMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stockgral_solid.png"));
        btn_stockGral.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockGralMouseExited

    private void btn_stockGralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockGralMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stockgral_click.png"));
        btn_stockGral.setIcon(botonClick);
        TipoReporteStock ventana = new TipoReporteStock();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_stockGralMousePressed

    private void btn_stockGralMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stockGralMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/stockgral_solid.png"));
        btn_stockGral.setIcon(botonClick);
    }//GEN-LAST:event_btn_stockGralMouseReleased

    private void btn_actualizarStockMasivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockMasivoMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarstockmasivo_click.png"));
        btn_actualizarStockMasivo.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockMasivoMouseEntered

    private void btn_actualizarStockMasivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockMasivoMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarstockmasivo_solid.png"));
        btn_actualizarStockMasivo.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockMasivoMouseExited

    private void btn_actualizarStockMasivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockMasivoMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarstockmasivo_click.png"));
        btn_actualizarStockMasivo.setIcon(botonClick);
        ActualizarStockMasivo ventana = new ActualizarStockMasivo();
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_actualizarStockMasivoMousePressed

    private void btn_actualizarStockMasivoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarStockMasivoMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/actualizarstockmasivo_solid.png"));
        btn_actualizarStockMasivo.setIcon(botonClick);
    }//GEN-LAST:event_btn_actualizarStockMasivoMouseReleased

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_actualizarStockMasivo;
    private javax.swing.JLabel btn_actualizarStockPrecio;
    private javax.swing.JLabel btn_cargaMasiva;
    private javax.swing.JLabel btn_consultaStockU;
    private javax.swing.JLabel btn_consultarPrecio;
    private javax.swing.JLabel btn_nuevaVenta;
    private javax.swing.JLabel btn_nuevoProducto;
    private javax.swing.JLabel btn_stockGral;
    private javax.swing.JLabel btn_stockNegativo;
    private javax.swing.JLabel btn_ventaDiaria;
    private javax.swing.JLabel btn_ventaPeriodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_headerInventario;
    private javax.swing.JLabel lbl_headerReporte;
    private javax.swing.JLabel lbl_headerVenta;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
