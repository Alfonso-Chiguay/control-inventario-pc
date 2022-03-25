package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import modelo.LogStockPrecio;

public class ConLogStockPrecio {
    public final static Conexion CONEXION = new Conexion();
    public final static Connection CONNECTION = CONEXION.getConnection();
    
    
    public void RegistrarLog(LogStockPrecio log){
        try{
            Statement stmt = CONNECTION.createStatement();
            String query = "INSERT INTO LOG_STOCK_PRECIO VALUES("
                    + ""+log.getId_trabajador()+","
                    + "'"+log.getCodigo_barra()+"',"
                    + log.getStock_antiguo()+","
                    + log.getStock_agregado()+","
                    + log.getPrecio_antiguo()+","
                    + log.getPrecio_nuevo()+",'"
                    + log.getFecha()+"');";
            //System.out.println(query);
            stmt.executeUpdate(query);
            System.out.println("Se ingresó log");
           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
           
        }
    }
}
