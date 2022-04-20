/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import controlador.Logs;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author alfon
 */
public class Conexion {
    private final static String SERVER="www.piliscoffee.cl:3306";
    private final static String USER="piliscof_achiguay";
    private final static String PASS="LaLo14!!";
    private final static String DB="piliscof_posdb";
    //private final static String DB="piliscof_posdb_desarrollo";

    public Connection getConnection(){
        Logs log = new Logs();
        Properties propiedadesConexion = new Properties();
        
        try{
            propiedadesConexion.put("user", USER);
            propiedadesConexion.put("password", PASS);
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+SERVER+"/"+DB
                    ,propiedadesConexion);
            log.RegistrarLog("[Conexion|getConnection] Conexion a base de datos exitosa");  
            return conn;
        
        }
        catch(Exception err){
            JOptionPane.showMessageDialog(null, "No hay conexion con la base de datos, revise su conexion a internet o reinicie la aplicación", "Problemas de conexion", JOptionPane.WARNING_MESSAGE);              
            log.RegistrarLog("[ERROR][Conexion|getConnection] "+err.getMessage());            
            return null;
        }
        
        
    }
    
    public boolean isNetworkOnline(){
        /*try{
            Process process = java.lang.Runtime.getRuntime().exec("ping www.piliscoffee.cl");
            int ping = process.waitFor();            
            if (ping == 0) return true;        
            else return false;  
        }
        catch(Exception e){
            return false;
        } */
        return true;
    }
}

