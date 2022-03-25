
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
    
    public final static Conexion CONEXION = new Conexion();
    public final static Connection CONNECTION = CONEXION.getConnection();
    
    
    public boolean existeCodigo(String codigo){

        try{
            
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            //System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) return true;
            else return false;            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }   
    }
    
    public Producto obtenerProducto(String codigo){
        try{            
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            //System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            Producto p = new Producto();
            if(rs.next()){                
                p.setCodigo_barra(codigo);
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
            } 
            return p;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new Producto();
        }   
    }
    
    public boolean ingresarProducto(Producto producto){
        try{
            Statement stmt = CONNECTION.createStatement();
            String query = "INSERT INTO PRODUCTO VALUES("
                    + "'"+producto.getCodigo_barra()+"',"
                    + "'"+producto.getNombre()+"',"
                    + producto.getPrecio()+","
                    + producto.getStock()+");";
            //System.out.println(query);
            stmt.executeUpdate(query);
            System.out.println("Se ingresó "+producto.toString());
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> lista = new ArrayList<>();
        try{            
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT * FROM PRODUCTO;";
            //System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){   
                Producto p = new Producto();
                p.setCodigo_barra(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                lista.add(p);
            } 
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
        }   
        return lista;
    }
    
    public void cargaMasiva(File archivoExcel, JProgressBar ProgressBar, JFrame Frame){
        ArrayList<Producto> productosNoIngresados = new ArrayList<>();
        ArrayList<Producto> productosIngresados = new ArrayList<>();
        
        try{ 
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
                Frame.setVisible(false);
                ProgressBar.setValue(0);
                ProgressBar.setVisible(false);
                }
            });
            
                t.start();  
              
            }
            else{
                JOptionPane.showMessageDialog(Frame, "No hay productos para subir", "Error subiendo productos", JOptionPane.INFORMATION_MESSAGE);
            }
            
 
        }        
        catch(Exception e){  
            e.printStackTrace();  
        } 

    }
    
    public boolean actualizarProducto(Producto producto){
        try{
            Statement stmt = CONNECTION.createStatement();
            String query = "UPDATE PRODUCTO SET stock = "+producto.getStock()+
                    ", precio = "+producto.getPrecio()+" WHERE codigo_barra = '"+producto.getCodigo_barra()+"';";
            //System.out.println("CONSULTA: "+query);
            stmt.executeUpdate(query);
            System.out.println("Producto actualizado");
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Producto consultaPrecio(String codigo){
        try{
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT precio, nombre FROM PRODUCTO WHERE codigo_barra = '" + codigo + "';";
            //System.out.println("CONSULTA: "+query);
            ResultSet rs = stmt.executeQuery(query);
            Producto p = new Producto();
            if(rs.next()){                
                p.setPrecio(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCodigo_barra(codigo);
                return p;
            } 
            
            else{
                
                return new Producto();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new Producto();
        }
       
    }
    
    public ArrayList<Producto> stockNegativo(){
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Statement stmt = CONNECTION.createStatement();
            String query = "SELECT codigo_barra, nombre, stock FROM PRODUCTO WHERE stock < 0;";

            ResultSet rs = stmt.executeQuery(query);


            while(rs.next()){
                Producto p = new Producto();
                p.setCodigo_barra(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setStock(rs.getInt(3));
                lista.add(p);
            }
            
            

        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
}
