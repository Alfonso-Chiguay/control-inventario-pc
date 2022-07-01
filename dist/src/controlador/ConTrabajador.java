package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Trabajador;


public class ConTrabajador {        
    
    public ArrayList<Trabajador> listarTrabajadores(){
        ArrayList<Trabajador> listado = new ArrayList<Trabajador>(); 
        Logs log = new Logs();        
        try {  
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String consulta = "SELECT * FROM TRABAJADOR;";
            log.RegistrarLog("[Query][ConTrabajador|listarTrabajadores] "+consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.setId_trabajador(rs.getInt(1));
                t.setNombre(rs.getString(2));
                listado.add(t);                
            }
            log.RegistrarLog("[ConTrabajador|listarTrabajadores] Consulta exitosa");            
            return listado;
        } 
        catch (Exception e) {        
            log.RegistrarLog("[ERROR][ConTrabajador|listarTrabajadores] "+e.getMessage()); 
            return listado;
        }
        
        
        
    }
}
