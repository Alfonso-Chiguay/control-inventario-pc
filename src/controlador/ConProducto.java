
package controlador;

import db.Conexion;
import java.io.File;
import java.sql.*;
import modelo.Producto;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import java.io.FileInputStream;  
import java.util.ArrayList;
import java.util.Iterator;  
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.apache.commons.collections4.IteratorUtils;
/**
 *
 * @author alfon
 */
public class ConProducto {
    

    
    
    public boolean existeCodigo(String codigo){
        Logs log = new Logs();
        try{     
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            log.RegistrarLog("[Query][ConProducto|existeCodigo] "+query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) {
                log.RegistrarLog("[ConProducto|existeCodigo] Consulta exitosa");
                return true;
            }
            else {
                log.RegistrarLog("[ConProducto|existeCodigo] Consulta exitosa");
                return false;
            }        
            
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|existeCodigo] "+e.getMessage());
            return false;
        }   
    }
    
    public Producto obtenerProducto(String codigo){
        Logs log = new Logs();
        try{   
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            log.RegistrarLog("[Query][ConProducto|obtenerProducto] "+query);
            ResultSet rs = stmt.executeQuery(query);
            Producto p = new Producto();
            if(rs.next()){                
                p.setCodigo_barra(codigo);
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
            } 
            
            if(p.getNombre().equals("")){
                log.RegistrarLog("[ConProducto|obtenerProducto] Consulta exitosa, pero sin datos");      
            }
            else{
                log.RegistrarLog("[ConProducto|obtenerProducto] Consulta exitosa");  
            }
                      
            return p;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|obtenerProducto] "+e.getMessage());
            return new Producto();
        }   
    }
    
    public boolean ingresarProducto(Producto producto){
        Logs log = new Logs();
        try{
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "INSERT INTO PRODUCTO VALUES("
                    + "'"+producto.getCodigo_barra()+"',"
                    + "'"+producto.getNombre()+"',"
                    + producto.getPrecio()+","
                    + producto.getStock()+");";
            log.RegistrarLog("[Query][ConProducto|ingresarProducto] "+query);
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConProducto|ingresarProducto] Consulta exitosa");  
            return true;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|ingresarProducto] "+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Producto> listarProductos(){
        Logs log = new Logs();
        ArrayList<Producto> lista = new ArrayList<>();
        try{            
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO;";
            log.RegistrarLog("[Query][ConProducto|listarProductos] "+query);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){   
                Producto p = new Producto();
                p.setCodigo_barra(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                lista.add(p);
            } 
            log.RegistrarLog("[ConProducto|listarProductos] Consulta exitosa");              
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|listarProductos] "+e.getMessage());            
        }   
        return lista;
    }
    
    public void cargaMasiva(File archivoExcel, JProgressBar ProgressBar, JFrame Frame){
        Logs log = new Logs();
        ArrayList<Producto> productosNoIngresados = new ArrayList<>();
        ArrayList<Producto> productosIngresados = new ArrayList<>();
        
        try{ 
            log.RegistrarLog("[ConProducto|cargaMasiva] Obteniendo informacion de excel");                
            FileInputStream fis = new FileInputStream(archivoExcel);   //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook workbook = new XSSFWorkbook(fis);   
            XSSFSheet sheet = workbook.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            int filas = 0;
            while(itr.hasNext()){
                
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  

                Cell cell = row.getCell(0);
                String codigo_barra;
                
                try{
                    codigo_barra = cell.getStringCellValue();
                }
                catch(Exception e){
                    Double valueNumeric = cell.getNumericCellValue();
                    codigo_barra = String.valueOf(valueNumeric);
                }
                
                if(!codigo_barra.equals("codigo") && !codigo_barra.equals("")){ 
                    filas++;
                }   
            }
            
            if(filas > 0){
                log.RegistrarLog("[ConProducto|cargaMasiva] Subiendo nueva informacion");                
                final int totalFilas = filas;           
            
                Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    final Iterator<Row> itr = sheet.iterator(); 
                    int porcentajeIndividual = 100/totalFilas;
                    int progresoGeneral = 0;                    
                    while (itr.hasNext()){

                        Row row = itr.next();  
                        Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  

                        Cell cell = row.getCell(0);
                        String codigo_barra;

                        try{
                            codigo_barra = cell.getStringCellValue();
                        }
                        catch(Exception e){
                            Double valueNumeric = cell.getNumericCellValue();
                            codigo_barra = String.valueOf(valueNumeric);
                        }

                        if(!codigo_barra.equals("codigo") && !codigo_barra.equals("")){
                            if(!existeCodigo(codigo_barra)){
                                try{
                                    cell = row.getCell(1);
                                    String nombre = cell.getStringCellValue();
                                    int precio, stock;
                                    try{
                                        cell = row.getCell(2);
                                        precio = Integer.parseInt(cell.getStringCellValue());
                                    }
                                    catch(Exception e){
                                        precio = 0;
                                    }

                                    try{
                                        cell = row.getCell(3);
                                        stock = Integer.parseInt(cell.getStringCellValue());
                                    }
                                    catch(Exception e){
                                        stock = 0;
                                    }


                                    Producto p = new Producto(codigo_barra,nombre,precio, stock);                             

                                    boolean ingreso = ingresarProducto(p);

                                    if(ingreso){
                                        productosIngresados.add(p);
                                    }
                                    else{
                                        productosNoIngresados.add(p);
                                    }

                                }
                                catch(Exception e){
                                    cell = row.getCell(1);
                                    String nombre = cell.getStringCellValue();
                                    int precio, stock;
                                    try{
                                        cell = row.getCell(2);
                                        precio = Integer.parseInt(cell.getStringCellValue());
                                    }
                                    catch(Exception ex){
                                        precio = 0;
                                    }

                                    try{
                                        cell = row.getCell(3);
                                        stock = Integer.parseInt(cell.getStringCellValue());
                                    }
                                    catch(Exception ex){
                                        stock = 0;
                                    }

                                    Producto p = new Producto();
                                    p.ingresoExcepcional(codigo_barra, nombre, precio, stock);
                                    productosNoIngresados.add(p);
                                    System.out.println("Codigo no ingresado: "+codigo_barra+", "+e.getMessage());
                                }
                            }
                            else{
                                cell = row.getCell(1);
                                String nombre = cell.getStringCellValue();
                                int precio, stock;
                                try{
                                    cell = row.getCell(2);
                                    precio = Integer.parseInt(cell.getStringCellValue());
                                }
                                catch(Exception ex){
                                    precio = 0;
                                }

                                try{
                                    cell = row.getCell(3);
                                    stock = Integer.parseInt(cell.getStringCellValue());
                                }
                                catch(Exception ex){
                                    stock = 0;
                                }

                                Producto p = new Producto();
                                p.ingresoExcepcional(codigo_barra, nombre, precio, stock);
                                productosNoIngresados.add(p);
                                System.out.println("Codigo usado, no ingresado");
                            }  
                            progresoGeneral = progresoGeneral+porcentajeIndividual;
                            ProgressBar.setValue(progresoGeneral);
                            ProgressBar.setString(String.valueOf(progresoGeneral+"%"));
                        }


                    }  
                ProgressBar.setValue(100);
                ProgressBar.setString(String.valueOf("100%"));
                JOptionPane.showMessageDialog(Frame, String.valueOf(productosIngresados.size())+" Productos ingresados correctamente \n"+String.valueOf(productosNoIngresados.size())+" Productos NO ingresados.\n"+totalFilas+" Productos procesados en total.","Status de carga",JOptionPane.INFORMATION_MESSAGE);
                ProgressBar.setValue(0);
                ProgressBar.setString(String.valueOf("0%"));
                }
            });
            
                t.start();  
              
            }
            else{
                JOptionPane.showMessageDialog(Frame, "No hay productos para subir", "Error subiendo productos", JOptionPane.INFORMATION_MESSAGE);
            }
            
 
        }        
        catch(Exception e){  
            log.RegistrarLog("[ERROR][ConProducto|cargaMasiva] "+e.getMessage());   
        } 

    }
    
    public boolean actualizarProducto(Producto producto){
        Logs log = new Logs();
        try{
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "UPDATE PRODUCTO SET stock = "+producto.getStock()+
                    ", precio = "+producto.getPrecio()+" WHERE codigo_barra = '"+producto.getCodigo_barra()+"';";
            log.RegistrarLog("[Query][ConProducto|actualizarProducto] "+query);
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConProducto|actualizarProducto] Precio actualizado, consulta exitosa");
            return true;
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|actualizarProducto] "+e.getMessage()); 
            return false;
        }
    }
    
    public Producto consultaPrecio(String codigo){
        Logs log = new Logs();
        try{
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT precio, nombre, stock FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            log.RegistrarLog("[Query][ConProducto|consultaPrecio] "+query);
            ResultSet rs = stmt.executeQuery(query);
            Producto p = new Producto();
            if(rs.next()){                
                p.setPrecio(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodigo_barra(codigo);
                p.setStock(rs.getInt(3));
                log.RegistrarLog("[ConProducto|consultaPrecio] Consulta exitosa");                  
                return p;
            } 
            
            else{                
                log.RegistrarLog("[ConProducto|consultaPrecio] Consulta exitosa, pero sin datos");                  
                return new Producto();
            }
                      
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|consultaPrecio] "+e.getMessage()); 
            return new Producto();
        }
       
    }
    
    public ArrayList<Producto> stockNegativo(){
        Logs log = new Logs();
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Conexion conexion = new Conexion();
            Connection CONNECTION = conexion.getConnection();
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT codigo_barra, nombre, stock FROM PRODUCTO WHERE stock < 0;";
            log.RegistrarLog("[Query][ConProducto|stockNegativo] "+query);
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Producto p = new Producto();
                p.setCodigo_barra(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setStock(rs.getInt(3));
                lista.add(p);
            }
            
            log.RegistrarLog("[ConProducto|stockNegativo] Consulta exitosa");              

        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConProducto|stockNegativo] "+e.getMessage()); 
        }
        
        return lista;
    }
    
}
