package controlador;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Proveedor;

public class ConProveedor {
    
    public Proveedor existeProveedorSinDV(String rut){
        Logs log = new Logs();
        try{
            
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "SELECT rut, dv, razon_social from PROVEEDOR WHERE rut = '"+rut+"';";
            log.RegistrarLog("[Query][ConProveedor|existeProveedorSinDV] "+query);
            ResultSet rs = stmt.executeQuery(query);
            Proveedor proveedor = new Proveedor();
            if(rs.next()){       
                proveedor.setRut(rs.getString(1));
                proveedor.setDv(rs.getString(2));
                proveedor.setRazon_social(rs.getString(3));
            }   
            log.RegistrarLog("[ConProveedor|existeProveedorSinDV] Obtencion exitosa");
            return proveedor;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProveedor|existeProveedorSinDV] "+e.getMessage());
            return new Proveedor();
        } 
    }
    
    public Proveedor existeProveedorConDV(String rut, String dv){
        Logs log = new Logs();
        try{
            
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "SELECT rut, dv, razon_social from PROVEEDOR WHERE rut = '"+rut+"' AND dv = '"+dv+"';";
            log.RegistrarLog("[Query][ConProveedor|existeProveedorConDV] "+query);
            ResultSet rs = stmt.executeQuery(query);
            Proveedor proveedor = new Proveedor();
            if(rs.next()){       
                proveedor.setRut(rs.getString(1));
                proveedor.setDv(rs.getString(2));
                proveedor.setRazon_social(rs.getString(3));
            }   
            log.RegistrarLog("[ConProveedor|existeProveedorConDV] Obtencion exitosa");
            return proveedor;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProveedor|existeProveedorConDV] "+e.getMessage());
            return new Proveedor();
        } 
    }
    
    public void crearProveedor(Proveedor proveedor){
        Logs log = new Logs();
        try{

            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "INSERT INTO PROVEEDOR VALUES ('"+proveedor.getRut()+"', '"+proveedor.getDv()+"', '"+proveedor.getRazon_social()+"');";
            log.RegistrarLog("[Query][ConProveedor|crearProveedor] "+query);
            stmt.execute(query);
            log.RegistrarLog("[ConProveedor|crearProveedor] Creacion exitosa");
            
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProveedor|crearProveedor] "+e.getMessage());
            
        }   
    }
    
    
}
