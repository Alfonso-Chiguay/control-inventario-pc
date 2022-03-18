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
    
    
}
