package db;

import controlador.Logs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private final static String SERVER="www.piliscoffee.cl:3306";
    private final static String USER="piliscof_achiguay";
    private final static String PASS="LaLo14!!";
    
    private final static String DB="piliscof_posdb";
    //private final static String DB="piliscof_posdb_desarrollo";
    
    private static Conexion instance; 
    private static Connection conn;
    
    private Conexion(){
        Logs log = new Logs();
        Properties propiedadesConexion = new Properties();
        try{
            propiedadesConexion.put("user", USER);
            propiedadesConexion.put("password", PASS);
            conn = DriverManager.getConnection("jdbc:mysql://"+SERVER+"/"+DB
                    ,propiedadesConexion);
            log.RegistrarLog("[Conexion|getConnection] Conexion a base de datos exitosa");    
            System.out.println("Creando conexion");
            
        }
        catch(Exception err){
            log.RegistrarLog("[ERROR][Conexion|getConnection] "+err.getMessage()); 
            conn = null;
            instance = null;
            System.out.println("Error creando conexion: "+err.getMessage());
        }
    }
    
    public static synchronized Connection getConnection() throws SQLException{
        if(conn == null || conn.isClosed()){
            instance = new Conexion();            
        }
        return conn;
    }   
}

