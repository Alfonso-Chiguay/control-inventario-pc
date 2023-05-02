package controlador;

import db.Conexion;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Venta;
import modelo.VentaProducto;

public class ConVenta {
    
    public boolean registrarVenta(Venta venta, ArrayList<VentaProducto> detalleVenta, JFrame ventana, JLabel texto){
        Logs log = new Logs();      
        texto.setVisible(true);
        try{
            Statement stmt = Conexion.getConnection().createStatement();
            String query;
            try {
                query = "INSERT INTO VENTA VALUES((SELECT nuevo_folio FROM SEQ_FOLIO), "
                                + "(SELECT NOW() FROM DUAL), '"
                                + venta.getTipo_venta() +"',"
                                + venta.getTotal()+ ");";                   
                log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);            
                stmt.executeUpdate(query);

            } catch (Exception e) {
                if(e.getMessage().contains("Duplicate entry")){ 
                    query = "UPDATE SEQ_FOLIO SET nuevo_folio = nuevo_folio + 1;";
                    log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                
                    stmt.executeUpdate(query);
                    query = "INSERT INTO VENTA VALUES((SELECT nuevo_folio FROM SEQ_FOLIO), "
                                + "(SELECT NOW() FROM DUAL), '"
                                + venta.getTipo_venta() +"',"
                                + venta.getTotal()+ ");";                   
                    log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);            
                    stmt.executeUpdate(query);
                }
                else{
                    throw e;
                }
            }            
            
            log.RegistrarLog("[ConVenta|registrarVenta] Consulta exitosa");             
            for(VentaProducto vp: detalleVenta){
                query = "INSERT INTO VENTA_PRODUCTO VALUES ('"
                        + vp.getCodigo_barra() + "', "
                        + "(SELECT nuevo_folio FROM SEQ_FOLIO), "
                        + vp.getCantidad() + ","
                        + vp.getTotal()+ " );";
                stmt.executeUpdate(query);
                
                switch(vp.getCodigo_barra()){
                    case "PCCROISSANTP":
                        query = "UPDATE PRODUCTO SET stock = stock - 2 WHERE codigo_barra = 'PCCROISSANTU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "PCDONARELLP":
                        query = "UPDATE PRODUCTO SET stock = stock - 6 WHERE codigo_barra = 'PCDONARELLU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "PCDONASRELLP":
                        query = "UPDATE PRODUCTO SET stock = stock - 6 WHERE codigo_barra = 'PCDONASRELLU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "PCMACARONP2":
                        query = "UPDATE PRODUCTO SET stock = stock - 12 WHERE codigo_barra = 'PCMACARONU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "PCMACARONP1":
                        query = "UPDATE PRODUCTO SET stock = stock - 6 WHERE codigo_barra = 'PCMACARONU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);    
                        break;
                    case "PCMEDLUNCRP":
                        query = "UPDATE PRODUCTO SET stock = stock - 3 WHERE codigo_barra = 'PCMEDLUNCRU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query); 
                        break;
                    case "PCMEDLUNCRP2":
                        query = "UPDATE PRODUCTO SET stock = stock - 3 WHERE codigo_barra = 'PCMEDLUNCRU2';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);  
                        break;
                    case "PCMEDLUNSRP":
                        query = "UPDATE PRODUCTO SET stock = stock - 3 WHERE codigo_barra = 'PCMEDLUNSRU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);  
                        break;
                    case "PCMUFFINP":
                        query = "UPDATE PRODUCTO SET stock = stock - 6 WHERE codigo_barra = 'PCMUFFINU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query); 
                        break;
                    case "PCROLLOCANP":
                        query = "UPDATE PRODUCTO SET stock = stock - 2 WHERE codigo_barra = 'PCROLLOCANU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "PCWAFFLEP":
                        query = "UPDATE PRODUCTO SET stock = stock - 6 WHERE codigo_barra = 'PCWAFFLEU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;
                    case "CAFEMARESP":
                        query = "UPDATE PRODUCTO SET stock = stock - 1 WHERE codigo_barra = 'VASOMARLEY1';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;      
                    case "CAFEMARGRA":
                        query = "UPDATE PRODUCTO SET stock = stock - 1 WHERE codigo_barra = 'VASOMARLEY3';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;       
                    case "CAFEMARMED":
                        query = "UPDATE PRODUCTO SET stock = stock - 1 WHERE codigo_barra = 'VASOMARLEY2';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;  
                    case "CAFENESCMED":
                        query = "UPDATE PRODUCTO SET stock = stock - 1 WHERE codigo_barra = 'VASONESCAFE2';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;   
                    case "CAFENESCESP":
                        query = "UPDATE PRODUCTO SET stock = stock - 1 WHERE codigo_barra = 'VASONESCAFE1';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;        
                    case "PCBROWNIEP":
                        query = "UPDATE PRODUCTO SET stock = stock - 4 WHERE codigo_barra = 'PCBROWNIEU';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;     
                    case "PCMINICANELA":
                        query = "UPDATE PRODUCTO SET stock = stock - 5 WHERE codigo_barra = 'PCMINIDONAU1';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        query = "UPDATE PRODUCTO SET stock = stock - 5 WHERE codigo_barra = 'PCMINIDONAU2';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);                        
                        break; 
                    case "PCMINIDONAD":
                        query = "UPDATE PRODUCTO SET stock = stock - 10 WHERE codigo_barra = 'PCMINIDONAU3';";
                        log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                        stmt.executeUpdate(query);
                        break;                          
                }
                
                query = "UPDATE PRODUCTO SET stock = stock - " + vp.getCantidad() + " WHERE codigo_barra = '" + vp.getCodigo_barra() + "';";
                log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                    
                stmt.executeUpdate(query);
                
                log.RegistrarLog("[ConVenta|registrarVenta] Consulta exitosa");                   
            }
            
            query = "UPDATE SEQ_FOLIO SET nuevo_folio = nuevo_folio + 1;";
            log.RegistrarLog("[Query][ConVenta|registrarVenta] "+query);                
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConVenta|registrarVenta] Consulta exitosa");               
            
            texto.setText("¡Venta ingresada!");
            texto.setForeground(new Color(16,125,67));            
            JOptionPane.showMessageDialog(ventana, "Venta registrada con éxito", "Venta ingresada", JOptionPane.INFORMATION_MESSAGE);

            return true;
        }
        catch(Exception e){            
            log.RegistrarLog("[ERROR][ConVenta|registrarVenta] "+e.getMessage());               
            return false;
        }
    }
    
    public ArrayList<Venta> ventasDia(String fecha1, String fecha2){
        //la fecha debe venir en formato año-mes-dia
        Logs log = new Logs();
        ArrayList<Venta> lista = new ArrayList<>();
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT * FROM VENTA WHERE fecha BETWEEN '"+fecha1+" 00:00:00' AND '"+fecha2+" 23:59:59';";
            log.RegistrarLog("[Query][ConVenta|ventasDia] "+query);            
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Venta v = new Venta();
                v.setFolio(rs.getInt(1));
                v.setFecha(rs.getString(2));
                v.setTipo_venta(rs.getString(3));
                v.setTotal(rs.getInt(4));
                lista.add(v);
            }   
           log.RegistrarLog("[ConVenta|ventasDia] Consulta exitosa");               
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConVenta|ventasDia] "+e.getMessage());   
        }
        return lista;
    }
    
    public ArrayList<Object[]> resumenVentaMetodoPago(String fecha1, String fecha2){
        ArrayList<Object[]> detalle = new ArrayList<>();
        Logs log = new Logs();
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            //RESUMEN DE VENTAS SEGUN METODO DE PAGO
            String query = "SELECT V.folio, V.tipo_venta, DATE_FORMAT(V.fecha, '%d/%m/%Y %H:%i:%s') as FECHA, SUM(VP.valor_total) " +
                            "FROM VENTA V JOIN VENTA_PRODUCTO VP ON V.folio = VP.folio " +
                            "JOIN PRODUCTO P ON VP.codigo_barra = P.codigo_barra " +
                            "WHERE fecha BETWEEN '"+fecha1+" 00:00:00' AND '"+fecha2+" 23:59:59' " +
                            "GROUP BY V.folio";
            log.RegistrarLog("[Query][ConVenta|resumenVentaMetodoPago] "+query);              
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Object[] item = {
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4)
                };
                
                detalle.add(item);                        
            }
           log.RegistrarLog("[ConVenta|resumenVentaMetodoPago] Consulta exitosa");                
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConVenta|resumenVentaMetodoPago] "+e.getMessage());   
        }
               
        return detalle;
    }
    
    public ArrayList<Object[]> detalleProductoVendido(String fecha1, String fecha2){
        ArrayList<Object[]> detalle = new ArrayList<>();
        Logs log = new Logs();
        try {;
            Statement stmt = Conexion.getConnection().createStatement();
            //RESUMEN DE VENTAS SEGUN METODO DE PAGO
            String query = "SELECT P.nombre, sum(VP.cantidad), sum(VP.valor_total) " +
                            "FROM VENTA V JOIN VENTA_PRODUCTO VP ON V.folio = VP.folio " +
                            "JOIN PRODUCTO P ON VP.codigo_barra = P.codigo_barra " +
                            "WHERE fecha BETWEEN '"+fecha1+" 00:00:00' AND '"+fecha2+" 23:59:59' " +
                            "GROUP BY P.nombre ORDER BY P.nombre;";
            log.RegistrarLog("[Query][ConVenta|detalleProductoVendido] "+query);               
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Object[] item = {
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3)
                };
                
                detalle.add(item);                        
            }
           log.RegistrarLog("[ConVenta|detalleProductoVendido] Consulta exitosa");               
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConVenta|detalleProductoVendido] "+e.getMessage()); 
        }
               
        return detalle;
    }
    
    
}
