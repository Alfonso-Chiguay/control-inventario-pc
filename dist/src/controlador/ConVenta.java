package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Venta;
import modelo.VentaProducto;

public class ConVenta {
    public final static Conexion CONEXION = new Conexion();
    public final static Connection CONNECTION = CONEXION.getConnection();
    
    public boolean registrarVenta(Venta venta, ArrayList<VentaProducto> detalleVenta, JFrame ventana){
        try{
            Statement stmt = CONNECTION.createStatement();
            
            String query = "INSERT INTO VENTA VALUES((SELECT nuevo_folio FROM SEQ_FOLIO), "
                            + "(SELECT NOW() FROM DUAL), '"
                            + venta.getTipo_venta() +"',"
                            + venta.getTotal()+ ");";                   
            
            stmt.executeUpdate(query);
            
            for(VentaProducto vp: detalleVenta){
                query = "INSERT INTO VENTA_PRODUCTO VALUES ('"
                        + vp.getCodigo_barra() + "', "
                        + "(SELECT nuevo_folio FROM SEQ_FOLIO), "
                        + vp.getCantidad() + ","
                        + vp.getTotal()+ " );";
                stmt.executeUpdate(query);
                
                query = "UPDATE PRODUCTO SET stock = stock - " + vp.getCantidad() + " WHERE codigo_barra = '" + vp.getCodigo_barra() + "';";
                stmt.executeUpdate(query);
            }
            
            query = "UPDATE SEQ_FOLIO SET nuevo_folio = nuevo_folio + 1;";
            stmt.executeUpdate(query);
            
            JOptionPane.showMessageDialog(ventana, "Venta registrada con éxito", "Venta ingresada", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo ingresar la venta", "Venta erronea", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Venta> ventasDia(String fecha){
        //la fecha debe venir en formato año-mes-dia
        ArrayList<Venta> lista = new ArrayList<>();
        try {
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM VENTA WHERE fecha BETWEEN '"+fecha+" 00:00:00' AND '"+fecha+" 23:59:59';";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                Venta v = new Venta();
                v.setFolio(rs.getInt(1));
                v.setFecha(rs.getString(2));
                v.setTipo_venta(rs.getString(3));
                v.setTotal(rs.getInt(4));
                lista.add(v);
            }            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public ArrayList<Object[]> resumenVentaMetodoPago(String fecha){
        ArrayList<Object[]> detalle = new ArrayList<>();
        try {
            Statement stmt = CONNECTION.createStatement();
            //RESUMEN DE VENTAS SEGUN METODO DE PAGO
            String query = "SELECT V.folio, V.tipo_venta, DATE_FORMAT(V.fecha, '%d/%m/%Y %H:%i:%s') as FECHA, SUM(VP.valor_total) " +
                            "FROM VENTA V JOIN VENTA_PRODUCTO VP ON V.folio = VP.folio " +
                            "JOIN PRODUCTO P ON VP.codigo_barra = P.codigo_barra " +
                            "WHERE fecha BETWEEN '"+fecha+" 00:00:00' AND '"+fecha+" 23:59:59' " +
                            "GROUP BY V.folio";
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
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
        return detalle;
    }
    
    public ArrayList<Object[]> detalleProductoVendido(String fecha){
        ArrayList<Object[]> detalle = new ArrayList<>();
        try {
            Statement stmt = CONNECTION.createStatement();
            //RESUMEN DE VENTAS SEGUN METODO DE PAGO
            String query = "SELECT P.nombre, sum(VP.cantidad), sum(VP.valor_total) " +
                            "FROM VENTA V JOIN VENTA_PRODUCTO VP ON V.folio = VP.folio " +
                            "JOIN PRODUCTO P ON VP.codigo_barra = P.codigo_barra " +
                            "WHERE fecha BETWEEN '"+fecha+" 00:00:00' AND '"+fecha+" 23:59:59' " +
                            "GROUP BY P.nombre;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Object[] item = {
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3)
                };
                
                detalle.add(item);                        
            }
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
               
        return detalle;
    }
    
    
}