/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConInformes;
import db.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alfon
 */
public class ReportePeriodo extends javax.swing.JFrame {

    String global_dia,global_mes,global_anio;
    
    public ReportePeriodo() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\img\\coffee-heart-original.png");  
        this.setIconImage(icon);
        this.setTitle("Pili's Coffee POS Software | Reporte venta diario");     
        Date date = Calendar.getInstance().getTime();

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String today = formatter.format(date);
        String dia = today.split("-")[0];
        String mes = today.split("-")[1];
        String anio = today.split("-")[2];
        
        global_dia = dia;
        global_mes = mes;
        global_anio = anio;
        
        txt_dia.setText(dia);
        txt_anio.setText(anio);
        txt_dia2.setText(dia);
        txt_anio2.setText(anio);        
        asignar_mes(mes);

        
    }

    private void asignar_mes(String mes){
        switch(mes){
            case "01":
                cb_mes.setSelectedIndex(0);
                cb_mes2.setSelectedIndex(0);                
                break;
            case "02":
                cb_mes.setSelectedIndex(1);
                cb_mes2.setSelectedIndex(1);                
                break;
            case "03":
                cb_mes.setSelectedIndex(2);
                cb_mes2.setSelectedIndex(2);                
                break;
            case "04":
                cb_mes.setSelectedIndex(3);
                cb_mes2.setSelectedIndex(3);                
                break;
            case "05":
                cb_mes.setSelectedIndex(4);
                cb_mes2.setSelectedIndex(4);                
                break;
            case "06":
                cb_mes.setSelectedIndex(5);
                cb_mes2.setSelectedIndex(5);                
                break;
            case "07":
                cb_mes.setSelectedIndex(6);
                cb_mes2.setSelectedIndex(6);                
                break;
            case "08":
                cb_mes.setSelectedIndex(7);
                cb_mes2.setSelectedIndex(7);                
                break;
            case "09":
                cb_mes.setSelectedIndex(8);
                cb_mes2.setSelectedIndex(8);                
                break;
            case "10":
                cb_mes.setSelectedIndex(9);
                cb_mes2.setSelectedIndex(9);                
                break;
            case "11":
                cb_mes.setSelectedIndex(10);
                cb_mes2.setSelectedIndex(10);                
                break;
            case "12":
                cb_mes.setSelectedIndex(11);                
                cb_mes2.setSelectedIndex(11);                
                break;
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_dia = new javax.swing.JTextField();
        cb_mes = new javax.swing.JComboBox<>();
        txt_anio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_generarReporte = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_dia2 = new javax.swing.JTextField();
        cb_mes2 = new javax.swing.JComboBox<>();
        txt_anio2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 204, 178));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 85, 57));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cashmachine.png"))); // NOI18N
        jLabel1.setText(" Reporte de venta por periodo");

        jPanel2.setBackground(new java.awt.Color(230, 204, 178));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "Fecha de inicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(127, 85, 57));

        txt_dia.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_dia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_diaFocusLost(evt);
            }
        });
        txt_dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_diaKeyTyped(evt);
            }
        });

        cb_mes.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        txt_anio.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_anio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anioFocusLost(evt);
            }
        });
        txt_anio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_anioKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("/");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setText("/");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txt_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        btn_generarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/custom buttons/generarreporte_solid.png"))); // NOI18N
        btn_generarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_generarReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_generarReporteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_generarReporteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_generarReporteMouseReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(230, 204, 178));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(127, 85, 57), 1, true), "Fecha de corte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(127, 85, 57))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(127, 85, 57));

        txt_dia2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_dia2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dia2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_dia2FocusLost(evt);
            }
        });
        txt_dia2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dia2KeyTyped(evt);
            }
        });

        cb_mes2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cb_mes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        txt_anio2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_anio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_anio2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_anio2FocusLost(evt);
            }
        });
        txt_anio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_anio2KeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setText("/");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setText("/");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txt_dia2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_mes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_anio2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt_dia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_mes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_anio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_generarReporte))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btn_generarReporte)
                .addContainerGap())
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

    private void txt_diaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diaKeyTyped
        txt_dia.setTransferHandler(null);
        maxCharacter(2, txt_dia, evt);
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_diaKeyTyped

    private void txt_anioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anioKeyTyped
        txt_anio.setTransferHandler(null);
        maxCharacter(4, txt_anio, evt);        
        onlyNumberField(evt);        
    }//GEN-LAST:event_txt_anioKeyTyped

    private void txt_diaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_diaFocusLost
        diaValido(txt_dia);
        if(Integer.parseInt(txt_dia.getText())<10){
            txt_dia.setText("0"+Integer.parseInt(txt_dia.getText()));
        }
    }//GEN-LAST:event_txt_diaFocusLost

    private void txt_anioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anioFocusLost
        anioValido(txt_anio);
    }//GEN-LAST:event_txt_anioFocusLost

    private void btn_generarReporteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarReporteMousePressed
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/generarreporte_click.png"));
        btn_generarReporte.setIcon(botonClick); 
        ConInformes informe = new ConInformes();
        String mes;
        txt_diaFocusLost(null);
        txt_dia2FocusLost(null);
        
        if((cb_mes.getSelectedIndex()+1)<10){
            mes = "0"+String.valueOf(cb_mes.getSelectedIndex()+1);
        }
        else{
           mes = String.valueOf(cb_mes.getSelectedIndex()+1); 
        }
        
        
        
        String fecha1 = txt_anio.getText()+"-"+mes +"-"+txt_dia.getText();
        
        if((cb_mes2.getSelectedIndex()+1)<10){
            mes = "0"+String.valueOf(cb_mes2.getSelectedIndex()+1);
        }
        else{
           mes = String.valueOf(cb_mes2.getSelectedIndex()+1); 
        }
        String fecha2 = txt_anio2.getText()+"-"+mes +"-"+txt_dia2.getText();
        

        informe.informeVentaPeriodo(fecha1, fecha2);
    }//GEN-LAST:event_btn_generarReporteMousePressed

    private void btn_generarReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarReporteMouseEntered
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/generarreporte_click.png"));
        btn_generarReporte.setIcon(botonClick);
    }//GEN-LAST:event_btn_generarReporteMouseEntered

    private void btn_generarReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarReporteMouseExited
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/generarreporte_solid.png"));
        btn_generarReporte.setIcon(botonClick);
    }//GEN-LAST:event_btn_generarReporteMouseExited

    private void btn_generarReporteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_generarReporteMouseReleased
        ImageIcon botonClick = new ImageIcon(getClass().getResource("/img/custom buttons/generarreporte_solid.png"));
        btn_generarReporte.setIcon(botonClick);
    }//GEN-LAST:event_btn_generarReporteMouseReleased

    private void txt_dia2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dia2FocusLost
        diaValido(txt_dia2);
        if(Integer.parseInt(txt_dia2.getText())<10){
            txt_dia2.setText("0"+Integer.parseInt(txt_dia2.getText()));
        }
    }//GEN-LAST:event_txt_dia2FocusLost

    private void txt_dia2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dia2KeyTyped
        txt_dia2.setTransferHandler(null);
        maxCharacter(2, txt_dia2, evt);
        onlyNumberField(evt);
    }//GEN-LAST:event_txt_dia2KeyTyped

    private void txt_anio2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_anio2FocusLost
        anioValido(txt_anio2);
    }//GEN-LAST:event_txt_anio2FocusLost

    private void txt_anio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anio2KeyTyped
        txt_anio2.setTransferHandler(null);
        maxCharacter(4, txt_anio2, evt);        
        onlyNumberField(evt);  
    }//GEN-LAST:event_txt_anio2KeyTyped
    private void onlyNumberField(java.awt.event.KeyEvent evt){
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }
    
    private void maxCharacter(int cantidad, JTextField campo, java.awt.event.KeyEvent evt){
        if(campo.getText().length() == cantidad){
            campo.setText("");
        }
    }
    
    private void diaValido(JTextField campo){
        int intDia = Integer.parseInt(campo.getText());
        if(intDia >= 31){
            campo.setText(global_dia);
        }
    }
    
    private void anioValido(JTextField campo){
        int intAnio = Integer.parseInt(campo.getText());
        int maxAnio = Integer.parseInt(global_anio);
        if(intAnio < 2022 || intAnio > maxAnio){
            campo.setText(global_anio);
        }
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
            java.util.logging.Logger.getLogger(ReportePeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportePeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportePeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportePeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportePeriodo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_generarReporte;
    private javax.swing.JComboBox<String> cb_mes;
    private javax.swing.JComboBox<String> cb_mes2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_anio;
    private javax.swing.JTextField txt_anio2;
    private javax.swing.JTextField txt_dia;
    private javax.swing.JTextField txt_dia2;
    // End of variables declaration//GEN-END:variables
}
