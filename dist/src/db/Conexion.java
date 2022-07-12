package db;

import controlador.Logs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    private final static String SERVER="www.piliscoffee.cl:3306";
    private final static String USER="piliscof_achiguay";
    private final static String PASS="LaLo14!!";
    
    private final static String DB="piliscof_posdb";
    //private final static String DB="piliscof_posdb_desarrollo";
    
    //SINGLETON
    private static Connection conn;    
    
    public static Connection getConnection(){
        Logs log = new Logs();
        Properties propiedadesConexion = new Properties();
        if(conn == null){
            try{
                propiedadesConexion.put("user", USER);
                propiedadesConexion.put("password", PASS);
                conn = DriverManager.getConnection("jdbc:mysql://"+SERVER+"/"+DB
                        ,propiedadesConexion);
                log.RegistrarLog("[Conexion|getConnection] Conexion a base de datos exitosa");                 
                return conn;
            }
            catch(Exception err){
                log.RegistrarLog("[ERROR][Conexion|getConnection] "+err.getMessage());                  
                return null;
            }    
        }
        else{            
            return conn;
        }
        
    }
    
    public boolean isNetworkOnline(){
        return true;             
    }
}

