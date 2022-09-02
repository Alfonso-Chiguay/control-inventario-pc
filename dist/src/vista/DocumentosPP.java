/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConColores;
import controlador.ConDocumento;
import controlador.ConProveedor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Documento;
import modelo.PaletaColor;
import modelo.Proveedor;

/**
 *
 * @author alfon
 */
public class DocumentosPP extends javax.swing.JFrame {
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
    
    public DocumentosPP() {
        initComponents();
        Background.setBackground(BackgroundColor);
        txt_titulo.setForeground(textColor);
        MinPanel.setBackground(BackgroundColor);
        ClosePanel.setBackground(BackgroundColor);
        btn_Pagar.setBackground(PanelColor);
        
        
        tbl_documentos.getTableHeader().setReorderingAllowed(false);
        tbl_documentos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        int columna1 = 120;
        int columna2 = 250;
        int columna3 = 120;
        int columna4 = 120;
        int columna5 = 50;
        int columna6 = 100;
        
        tbl_documentos.getColumnModel().getColumn(0).setPreferredWidth(columna1);
        tbl_documentos.getColumnModel().getColumn(0).setMinWidth(columna1);
        tbl_documentos.getColumnModel().getColumn(0).setMaxWidth(columna1);
        tbl_documentos.getColumnModel().getColumn(1).setPreferredWidth(columna2);
        tbl_documentos.getColumnModel().getColumn(1).setMinWidth(columna2);
        tbl_documentos.getColumnModel().getColumn(1).setMaxWidth(columna2);
        tbl_documentos.getColumnModel().getColumn(2).setPreferredWidth(columna3);
        tbl_documentos.getColumnModel().getColumn(2).setMinWidth(columna3);
        tbl_documentos.getColumnModel().getColumn(2).setMaxWidth(columna3);
        tbl_documentos.getColumnModel().getColumn(3).setPreferredWidth(columna4);
        tbl_documentos.getColumnModel().getColumn(3).setMinWidth(columna4);
        tbl_documentos.getColumnModel().getColumn(3).setMaxWidth(columna4);        
        tbl_documentos.getColumnModel().getColumn(4).setPreferredWidth(columna5);    
        tbl_documentos.getColumnModel().getColumn(4).setMinWidth(columna5);
        tbl_documentos.getColumnModel().getColumn(4).setMaxWidth(columna5);    
        tbl_documentos.getColumnModel().getColumn(5).setPreferredWidth(columna6);    
        tbl_documentos.getColumnModel().getColumn(5).setMinWidth(columna6);
        tbl_documentos.getColumnModel().getColumn(5).setMaxWidth(columna6);           
        
        tbl_documentos.setRowHeight(35);
        tbl_documentos.setFont(new Font("Roboto", Font.PLAIN, 20));
        tbl_documentos.setBackground(BackgroundColor);
        tbl_documentos.setForeground(textColor);
        tbl_documentos.setOpaque(true);
        tbl_documentos.setFillsViewportHeight(true);
        
        tbl_documentos.getTableHeader().setOpaque(false);
        tbl_documentos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tbl_documentos.getTableHeader().setBackground(PanelColor);
        tbl_documentos.getTableHeader().setForeground(Color.WHITE);
        
        tbl_documentos.setSelectionBackground(mouseEnterPanelColor);
        tbl_documentos.setSelectionForeground(Color.WHITE);        
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl_documentos.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tbl_documentos.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);        
        
        poblarTabla();
        
        
    }

    private void poblarTabla(){
        ConDocumento conDocumento = new ConDocumento();
        ArrayList<Documento> facturas = conDocumento.facturasPorPagar();
        ConProveedor conProveedor = new ConProveedor();
        DefaultTableModel table = (DefaultTableModel) tbl_documentos.getModel();  
        table.setRowCount(0);
        for(Documento doc:facturas){
            String rut;
            if(doc.getId_documento().contains("F")) rut = doc.getId_documento().split("F")[1];
            else rut = doc.getId_documento().split("B")[1];
            Proveedor p = conProveedor.existeProveedorSinDV(rut);           
            
            String fecha;
            
            String dia, mes, anio;
            
            dia = doc.getFecha().split("-")[2];
            mes = doc.getFecha().split("-")[1];
            anio = doc.getFecha().split("-")[0];
            
            fecha = dia+"-"+mes+"-"+anio;
            Object[] fila = {
                doc.getFolio(),
                p.getRazon_social(),
                p.getRut()+"-"+p.getDv(),
                fecha,
                diferenciaEntreDias(doc.getFecha()),
                String.format("$%,d",Integer.valueOf(String.valueOf(doc.getTotal())))
                               
            };
            
            table.addRow(fila);
            
        }
        
        
    }
    
    private long diferenciaEntreDias(String fechaFactura){
        long diferencia = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date firstDate = new Date();
            Date secondDate = sdf.parse(fechaFactura);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            diferencia = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        } 
        catch (Exception e) {
        }
        return diferencia;
    
    }      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        ClosePanel = new javax.swing.JPanel();
        txt_close = new javax.swing.JLabel();
        MinPanel = new javax.swing.JPanel();
        txt_minimize = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JLabel();
        scrollPanelDetalleVenta = new javax.swing.JScrollPane();
        tbl_documentos = new javax.swing.JTable();
        btn_Pagar = new javax.swing.JPanel();
        txt_Pagar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1100, 650));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Background.setPreferredSize(new java.awt.Dimension(1100, 650));
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

        Background.add(ClosePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 40, 40));

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

        Background.add(MinPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 40, 40));

        txt_titulo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txt_titulo.setText("  DOCUMENTOS PENDIENTES DE PAGO");
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
        Background.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 40));

        scrollPanelDetalleVenta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanelDetalleVenta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanelDetalleVenta.setOpaque(false);
        scrollPanelDetalleVenta.setPreferredSize(new java.awt.Dimension(700, 450));

        tbl_documentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_documentos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_documentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOLIO", "RAZON SOCIAL", "RUT", "FECHA EMISION", "DIAS", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_documentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_documentos.setOpaque(false);
        tbl_documentos.setShowHorizontalLines(false);
        tbl_documentos.setShowVerticalLines(false);
        scrollPanelDetalleVenta.setViewportView(tbl_documentos);

        Background.add(scrollPanelDetalleVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 780, -1));

        btn_Pagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Pagar.setPreferredSize(new java.awt.Dimension(240, 100));
        btn_Pagar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Pagar.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        txt_Pagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirm.png"))); // NOI18N
        txt_Pagar.setText("MARCAR PAGADO");
        txt_Pagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_Pagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_PagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_PagarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_PagarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_PagarMouseReleased(evt);
            }
        });
        btn_Pagar.add(txt_Pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 100));

        Background.add(btn_Pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, -1, -1));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void txt_tituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_txt_tituloMouseDragged

    private void txt_tituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_tituloMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_txt_tituloMousePressed

    private void txt_PagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PagarMouseEntered
        btn_Pagar.setBackground(mouseEnterPanelColor);
    }//GEN-LAST:event_txt_PagarMouseEntered

    private void txt_PagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PagarMouseExited
        btn_Pagar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_PagarMouseExited

    private void txt_PagarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PagarMouseReleased
        if(btn_Pagar.contains(evt.getPoint())) btn_Pagar.setBackground(mouseEnterPanelColor);
        else btn_Pagar.setBackground(mouseExitPanelColor);
    }//GEN-LAST:event_txt_PagarMouseReleased

    private void txt_PagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PagarMousePressed
        if(evt.getButton() == 1){
            int index = tbl_documentos.getSelectedRow();
            if(index == -1){
                JOptionPane.showMessageDialog(this, "Ninguna factura seleccionada", "Sin seleccionar", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String folio = (String)tbl_documentos.getValueAt(index, 0);
            
            ConDocumento conDocumento = new ConDocumento();
            if(conDocumento.marcarPagado(folio)) {
                JOptionPane.showMessageDialog(this, "Documento marcado como pagado", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                poblarTabla();
            }
            else{
                JOptionPane.showMessageDialog(this, "No se pudo marcar como pagado, vuelva a intentarlo", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
                
            
        }
    }//GEN-LAST:event_txt_PagarMousePressed

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
            java.util.logging.Logger.getLogger(DocumentosPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentosPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentosPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentosPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentosPP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel ClosePanel;
    private javax.swing.JPanel MinPanel;
    private javax.swing.JPanel btn_Pagar;
    private javax.swing.JScrollPane scrollPanelDetalleVenta;
    private javax.swing.JTable tbl_documentos;
    private javax.swing.JLabel txt_Pagar;
    private javax.swing.JLabel txt_close;
    private javax.swing.JLabel txt_minimize;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
