package controlador;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PaletaColor;


public class ConColores {
 
    public PaletaColor paletaActiva(){
        Logs log = new Logs();
        try{
            if(Conexion.getConnection() == null || Conexion.getConnection().isClosed()){
                Conexion.getConnection();
            }
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "SELECT c.id_paleta, c.background, c.panel, c.mouse_enter, c.mouse_click " +
                            "FROM COLORES c  JOIN PALETA p ON c.id_paleta = p.id_paleta " +
                            "WHERE p.is_active;";
            log.RegistrarLog("[Query][ConColores|paletaActiva] "+query);
            ResultSet rs = stmt.executeQuery(query);
            PaletaColor pc = new PaletaColor();
            if(rs.next()){       
                pc = new PaletaColor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }   
            
            return pc;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConColores|paletaActiva] "+e.getMessage());
            return new PaletaColor();
        } 
    }
    
    public void cambiarPaletaActiva(String id_paleta){
        Logs log = new Logs();
        try{   
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "UPDATE PALETA SET is_active = 1 WHERE id_paleta = '"+id_paleta+"';";
            log.RegistrarLog("[Query][ConColores|cambiarPaletaActiva] "+query);
            
            stmt.execute(query);
            query =  "UPDATE PALETA SET is_active = 0 WHERE id_paleta != '"+id_paleta+"';";
            log.RegistrarLog("[Query][ConColores|cambiarPaletaActiva] "+query);
            stmt.execute(query);
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConColores|cambiarPaletaActiva] "+e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo cambiar la paleta activa","Error cambiando paleta",JOptionPane.ERROR_MESSAGE);
            
        } 
    }
    
    public ArrayList<String> listarPaletas(){
        Logs log = new Logs();
        try {           
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT id_paleta FROM PALETA;";
            log.RegistrarLog("[Query][ConColores|listarPaletas] "+query);
            ArrayList<String> listado = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                listado.add(rs.getString(1));
            }
            
            return listado;
            
        } catch (Exception e) {
            log.RegistrarLog("[ERROR][ConColores|cambiarPaletaActiva] "+e.getMessage());
            return new ArrayList<String>();
        }        
    }
    
    public PaletaColor buscarPorId(String id_paleta){
        Logs log = new Logs();
        try{   
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "SELECT id_paleta, background, panel, mouse_enter, mouse_click " +
                            "FROM COLORES WHERE id_paleta = '"+id_paleta+"';";
            log.RegistrarLog("[Query][ConColores|paletaActiva] "+query);
            ResultSet rs = stmt.executeQuery(query);
            PaletaColor pc = new PaletaColor();
            if(rs.next()){       
                pc = new PaletaColor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }         
                      
            return pc;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConColores|buscarPorId] "+e.getMessage());
            return new PaletaColor();
        } 
    }
    
    public boolean crearPaleta(String bg, String panel, String mouseEnter, String mouseClick, String idPaleta, String nombrePaleta){
        Logs log = new Logs();
        try {

            Statement stmt = Conexion.getConnection().createStatement();
            String query = "INSERT INTO PALETA VALUES ('"+idPaleta+"','"+nombrePaleta+"',0);";
            log.RegistrarLog("[Query][ConColores|crearPaleta] "+query);    
            stmt.execute(query);
            
            query = "INSERT INTO COLORES VALUES ('"+bg+"','"+panel+"','"+mouseEnter+"','"+mouseClick+"','"+idPaleta+"');";
            log.RegistrarLog("[Query][ConColores|crearPaleta] "+query);  
            stmt.execute(query); 
            
            return true;
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConColores|buscarPorId] "+e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage(), "No se pudo guardar la paleta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
}
