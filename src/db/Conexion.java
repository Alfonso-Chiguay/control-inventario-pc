/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author alfon
 */
public class Conexion {
    private final static String SERVER="######";
    private final static String USER="######";
    private final static String PASS="######";
    //private final static String DB="######";
    private final static String DB="######";
    //linea de prueba
    public Connection getConnection(){
        
        Properties propiedadesConexion = new Properties();
        
        try{
            propiedadesConexion.put("user", USER);
            propiedadesConexion.put("password", PASS);
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+SERVER+"/"+DB
                    ,propiedadesConexion);
            
            return conn;
        
        }
        catch(Exception err){
            System.out.println(err.getMessage());            
            return null;
        }
        
        
    }
    
    public boolean isNetworkOnline(){
        try{
            Process process = java.lang.Runtime.getRuntime().exec("ping www.piliscoffee.cl");
            int ping = process.waitFor();            
            if (ping == 0) return true;        
            else return false;  
        }
        catch(Exception e){
            return false;
        }                
    }
}

