package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Trabajador;


public class ConTrabajador {        
    public final static Conexion CONEXION = new Conexion();
    public final static Connection CONNECTION = CONEXION.getConnection();
    
    public ArrayList<Trabajador> listarTrabajadores(){
        ArrayList<Trabajador> listado = new ArrayList<Trabajador>();        
        try {            
            Statement stmt = CONNECTION.createStatement();
            String consulta = "SELECT * FROM TRABAJADOR;";
            //System.out.println(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.setId_trabajador(rs.getInt(1));
                t.setNombre(rs.getString(2));
                listado.add(t);                
            }
            return listado;
        } 
        catch (Exception e) {        
            System.out.println("ERROR [Metodo listarTrabajadores]: "+e.getMessage());
            return listado;
        }
        
        
        
    }
}
