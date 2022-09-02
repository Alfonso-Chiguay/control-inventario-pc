package controlador;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.DetalleDocumento;
import modelo.Documento;
import modelo.Producto;
import modelo.Proveedor;


public class ConDocumento {

    public boolean IngresarDocumento(Documento documento,ArrayList<DetalleDocumento> detalle){
        Logs log = new Logs();
        try{
            
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "INSERT INTO DOCUMENTO VALUES ('"+documento.getId_documento()+"', '"+documento.getFolio()+"',"
                                                            + ""+ documento.isEs_factura()+" , '"+documento.getFecha()+"',"
                                                            + ""+documento.getTotal()+" ,"+documento.isPor_pagar()+");";
            log.RegistrarLog("[Query][ConDocumento|IngresarDocumento] "+query);
            stmt.execute(query);
            
            for(DetalleDocumento d: detalle){
                Proveedor proveedor = d.getProveedor();
                Documento doc = d.getDocumento();
                query = "INSERT INTO DETALLE_DOCUMENTO VALUES('"+doc.getId_documento()+"',"
                                                           + "'"+proveedor.getRut()+"',"
                                                           + "'"+d.getProducto().getCodigo_barra()+"',"
                                                           + " "+d.getCantidad()+");";                
                log.RegistrarLog("[Query][ConDocumento|IngresarDocumento] "+query);
                stmt.execute(query);           
                ConProducto conProducto = new ConProducto();
                Producto producto = conProducto.obtenerProducto(d.getProducto().getCodigo_barra());
                producto.setStock(producto.getStock() + d.getCantidad());
                conProducto.actualizarProducto(producto);
                
            }
                

            log.RegistrarLog("[ConDocumento|IngresarDocumento] Ingreso exitoso");
            return true;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConDocumento|IngresarDocumento] "+e.getMessage());
            
            return false;
        } 
    }
    
    public ArrayList<Documento> facturasPorPagar(){
        Logs log = new Logs();
        ArrayList<Documento> facturas = new ArrayList<>();
        try{            
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "SELECT id_documento, folio, es_factura, fecha, total FROM DOCUMENTO WHERE por_pagar = true;";
            log.RegistrarLog("[Query][ConDocumento|IngresarDocumento] "+query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Documento d = new Documento();
                d.setId_documento(rs.getString(1));
                d.setFolio(rs.getString(2));
                d.setEs_factura(rs.getBoolean(3));
                d.setFecha(rs.getString(4));
                d.setTotal(rs.getInt(5));
                d.setPor_pagar(true);
                
                facturas.add(d);
            }                

            log.RegistrarLog("[ConDocumento|facturasPorPagar] Consulta exitosa");
            
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConDocumento|facturasPorPagar] "+e.getMessage());
        }
        return facturas;
    }
    
    public boolean marcarPagado(String folio){
        Logs log = new Logs();
        
        try{            
            Statement stmt = Conexion.getConnection().createStatement();
            String query =  "UPDATE DOCUMENTO SET por_pagar = false WHERE folio = '"+folio+"';";
            log.RegistrarLog("[Query][ConDocumento|marcarPagado] "+query);
            stmt.execute(query);
            log.RegistrarLog("[ConDocumento|marcarPagado] Consulta exitosa");
            return true;
            
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConDocumento|marcarPagado] "+e.getMessage());
            return false;
        }
        
    }
    
}
