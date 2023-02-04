package db;

import controlador.Logs;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Conexion {
    
   
    private static Conexion instance; 
    private static Connection conn;
    
    private Conexion(){
        Logs log = new Logs();
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src//controlador//config.properties"));
        } catch (IOException e) {
            log.RegistrarLog("[Conexion|getConnection] No se puede tener acceso a datos para conexion... ("+e.getMessage()+")");  
        }
        
        String server = prop.getProperty("server_db");
        String username_prod = prop.getProperty("username_db");
        String password_prod = prop.getProperty("password_db");
        String db_name = prop.getProperty("db_name_prod");
        //String db_name = prop.getProperty("db_name_dev");
        
        Properties propiedadesConexion = new Properties();
        try{
            propiedadesConexion.put("user", username_prod);
            propiedadesConexion.put("password", password_prod);
            conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+db_name
                    ,propiedadesConexion);
            log.RegistrarLog("[Conexion|getConnection] Conexion a base de datos exitosa");    
            
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

