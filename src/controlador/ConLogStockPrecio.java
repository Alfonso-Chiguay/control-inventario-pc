package controlador;

import db.Conexion;
import java.sql.Statement;
import modelo.LogStockPrecio;

public class ConLogStockPrecio {

    
    
    public void RegistrarLog(LogStockPrecio logSP){
        Logs log = new Logs();
        try{
            Statement stmt = Conexion.getConnection().createStatement();
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
