package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import modelo.LogStockPrecio;

public class ConLogStockPrecio {

    
    
    public void RegistrarLog(LogStockPrecio logSP){
        Logs log = new Logs();
        try{
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "INSERT INTO LOG_STOCK_PRECIO VALUES("
                    + ""+logSP.getId_trabajador()+","
                    + "'"+logSP.getCodigo_barra()+"',"
                    + logSP.getStock_antiguo()+","
                    + logSP.getStock_agregado()+","
                    + logSP.getPrecio_antiguo()+","
                    + logSP.getPrecio_nuevo()+",'"
                    + logSP.getFecha()+"');";
            log.RegistrarLog("[Query][ConLogStockPrecio|RegistrarLog] "+query);
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConLogStockPrecio|RegistrarLog] Ingreso exitoso");
           
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConLogStockPrecio|RegistrarLog] "+e.getMessage());
           
        }
    }
}
