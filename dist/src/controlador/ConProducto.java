package controlador;

import db.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.sql.*;
import modelo.Producto;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;  
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

public class ConProducto {
        
    public boolean existeCodigo(String codigo){
        Logs log = new Logs();
        try{
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE UPPER(codigo_barra) = UPPER('" + codigo + "');";
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
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE UPPER(codigo_barra) = UPPER('" + codigo + "');";
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
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "INSERT INTO PRODUCTO VALUES("
                    + "UPPER('"+producto.getCodigo_barra()+"'),"
                    + "UPPER('"+producto.getNombre()+"'),"
                    + producto.getPrecio()+","
                    + producto.getStock()+");";
            log.RegistrarLog("[Query][ConProducto|ingresarProducto] "+query);
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConProducto|ingresarProducto] Ingresado - "+producto.toString());  
            return true;
        }
        catch(Exception e){
            log.RegistrarLog("[ConProducto|ingresarProducto] NO Ingresado - "+producto.toString());
            log.RegistrarLog("[ERROR][ConProducto|ingresarProducto] "+e.getMessage());
            return false;
        }
    }
    
    
    public boolean actualizarProducto(Producto producto){
        Logs log = new Logs();
        try{
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "UPDATE PRODUCTO SET nombre = UPPER('"+producto.getNombre()+"'), "
                    + "stock = "+producto.getStock()+", precio = "+producto.getPrecio()
                    + " WHERE codigo_barra = UPPER('"+producto.getCodigo_barra()+"')";
            log.RegistrarLog("[Query][ConProducto|actualizarProducto] "+query);
            stmt.executeUpdate(query);
            log.RegistrarLog("[ConProducto|actualizarProducto] Actualizado - "+producto.toString());  
            return true;
        }
        catch(Exception e){
            log.RegistrarLog("[ConProducto|actualizarProducto] NO actualizado - "+producto.toString());
            log.RegistrarLog("[ERROR][ConProducto|actualizarProducto] "+e.getMessage());
            return false;
        }        
    }    
    
    public ArrayList<Producto> listarProductos(){
        Logs log = new Logs();
        ArrayList<Producto> lista = new ArrayList<>();
        try{      
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT * FROM PRODUCTO ORDER BY nombre;";
            log.RegistrarLog("[Query][ConProducto|listarProductos] "+query);
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<String> descartados = listarDescartados();
            
            while(rs.next()){   
                if(!descartados.contains(rs.getString((1)))){
                    Producto p = new Producto();
                    p.setCodigo_barra(rs.getString(1));
                    p.setNombre(rs.getString(2));
                    p.setPrecio(rs.getInt(3));
                    p.setStock(rs.getInt(4));
                    lista.add(p);                    
                }
                else{
                    Producto p = new Producto();
                    p.setCodigo_barra(rs.getString(1));
                    p.setNombre("CODIGO DE PRODUCTO DESCARTADO");
                    p.setPrecio(1);
                    p.setStock(0);
                    lista.add(p); 
                }

            } 
            log.RegistrarLog("[ConProducto|listarProductos] Consulta exitosa");              
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|listarProductos] "+e.getMessage());            
        }   
        return lista;
    }
    
    public ArrayList<String> listarDescartados(){
        Logs log = new Logs();
        ArrayList<String> lista = new ArrayList<>();
        try{      
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT codigo_barra FROM PRODUCTO_DESCARTADO WHERE is_descartado = true;";
            log.RegistrarLog("[Query][ConProducto|listarDescartados] "+query);
            ResultSet rs = stmt.executeQuery(query);           
            
            
            while(rs.next()){   
                lista.add(rs.getString(1));
            } 
            log.RegistrarLog("[ConProducto|listarDescartados] Consulta exitosa");              
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|listarDescartados] "+e.getMessage());            
        }   
        return lista;       
    }
    
    public ArrayList<Producto> listarProductosFiltrado(String filtro){
        Logs log = new Logs();
        ArrayList<Producto> lista = new ArrayList<>();
        try{         
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT * FROM PRODUCTO WHERE LOWER(nombre) LIKE '%"+filtro.toLowerCase()+"%' ORDER BY nombre;";
            log.RegistrarLog("[Query][ConProducto|listarProductosFiltrado] "+query);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){   
                Producto p = new Producto();
                p.setCodigo_barra(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock(rs.getInt(4));
                lista.add(p);
            } 
            log.RegistrarLog("[ConProducto|listarProductosFiltrado] Consulta exitosa");              
        }
        catch(Exception e){
            log.RegistrarLog("[ERROR][ConProducto|listarProductosFiltrado] "+e.getMessage());            
        }   
        return lista;
    }   
    
    public void cargaMasiva(File archivoExcel, JProgressBar ProgressBar, JFrame Frame){
        Logs log = new Logs();
        ArrayList<Producto> productosNoIngresados = new ArrayList<>();
        ArrayList<Producto> productosIngresados = new ArrayList<>();       
        try{ 
            log.RegistrarLog("[ConProducto|cargaMasiva] Obteniendo informacion de excel");                
            FileInputStream fis = new FileInputStream(archivoExcel);   

            XSSFWorkbook workbook = new XSSFWorkbook(fis);   
            XSSFSheet sheet = workbook.getSheetAt(0);     
            Iterator<Row> itr = sheet.iterator();   
            int filas = 0;
            
            while(itr.hasNext()){                
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   

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
                final double totalFilas = (double) filas;           
            
                Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    DecimalFormat df = new DecimalFormat("0.00");
                    final Iterator<Row> itr = sheet.iterator(); 
                    double porcentajeIndividual = 100.00/totalFilas;
                    double progresoGeneral = 0.00;       
                    
                    
                    while (itr.hasNext()){

                        Row row = itr.next();                         

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
                                        precio = 1;
                                    }

                                    try{
                                        cell = row.getCell(3);
                                        stock = Integer.parseInt(cell.getStringCellValue());
                                    }
                                    catch(Exception e){
                                        stock = (int) cell.getNumericCellValue();
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
                            
                            ProgressBar.setValue((int) progresoGeneral);
                            ProgressBar.setString(df.format(progresoGeneral)+"%");
                        }


                    }  
                ProgressBar.setValue(100);
                

                
                
                ProgressBar.setString(String.valueOf("100%"));
                JOptionPane.showMessageDialog(Frame, String.valueOf(productosIngresados.size())+" Productos ingresados correctamente \n"+String.valueOf(productosNoIngresados.size())+" Productos NO ingresados.\n"+(int)totalFilas+" Productos procesados en total.","Status de carga",JOptionPane.INFORMATION_MESSAGE);
                if(productosNoIngresados.size() > 0) excelArchivosNoSubidos(productosNoIngresados, log);
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
    
    public void excelArchivosNoSubidos(ArrayList<Producto> listado, Logs log){        
        java.util.Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
        String today = formatter.format(date);        
        String  rutaPlantilla = "src/Plantillas/Carga masiva productos.xlsx";   
        String rutaFallida =System.getProperty("user.home")+"/Desktop/Carga masiva/Carga fallida/Productos no ingresados "+today+".xlsx";        
        File archivoCopia = new File(rutaPlantilla);       
        File rutaFinalCopia = new File(rutaFallida);  
        try{
            Files.copy(archivoCopia.toPath(), rutaFinalCopia.toPath(),REPLACE_EXISTING);       
            System.out.println("archivo creado");
        }      
        
        catch(Exception e){            
            System.out.println(e.getMessage());
        }
        
        
        try {
            FileInputStream inputStream = new FileInputStream(new File(rutaFallida));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);


            int rowCount = 0;
            
            CellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            
            for (Producto p : listado) {

                    rowCount += 1;

                    Row row = sheet.createRow(rowCount);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(p.getCodigo_barra());
                    cell.setCellStyle(style);
                    cell = row.createCell(1);
                    cell.setCellValue(p.getNombre());
                    cell.setCellStyle(style);
                    cell = row.createCell(2);
                    cell.setCellValue(p.getPrecio());
                    cell.setCellStyle(style);
                    cell = row.createCell(3);
                    cell.setCellValue(p.getStock());                    
                    cell.setCellStyle(style);
            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(rutaFallida);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            log.RegistrarLog("[ConProducto|cargaMasiva] Se creo archivo con productos no ingresados: "+rutaFallida); 
            JOptionPane.showMessageDialog(null, "Se abrirá un excel con los archivos no cargados", "Operaciones fallidas", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(rutaFallida));
             
        }
        catch (Exception e) {
            
            log.RegistrarLog("[ERROR][ConProducto|cargaMasiva] "+e.getMessage());     
        }

    }

    public void excelArchivosNoActualizados(ArrayList<Producto> listado, Logs log){        
        java.util.Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
        String today = formatter.format(date);        
        String  rutaPlantilla = "src/Plantillas/Carga masiva productos.xlsx";   
        String rutaFallida =System.getProperty("user.home")+"/Desktop/Carga masiva/Actualizacion stock masivo/No actualizado/Productos no actualizados "+today+".xlsx";        
        File archivoCopia = new File(rutaPlantilla);       
        File rutaFinalCopia = new File(rutaFallida);  
        try{
            Files.copy(archivoCopia.toPath(), rutaFinalCopia.toPath(),REPLACE_EXISTING);       
            System.out.println("archivo creado");
        }      
        
        catch(Exception e){            
            System.out.println(e.getMessage());
        }
        
        
        try {
            FileInputStream inputStream = new FileInputStream(new File(rutaFallida));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);


            int rowCount = 0;
            
            CellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            
            for (Producto p : listado) {

                    rowCount += 1;

                    Row row = sheet.createRow(rowCount);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(p.getCodigo_barra());
                    cell.setCellStyle(style);
                    cell = row.createCell(1);
                    cell.setCellValue(p.getNombre());
                    cell.setCellStyle(style);
                    cell = row.createCell(2);
                    cell.setCellValue(p.getPrecio());
                    cell.setCellStyle(style);
                    cell = row.createCell(3);
                    cell.setCellValue(p.getStock());                    
                    cell.setCellStyle(style);
            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(rutaFallida);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            log.RegistrarLog("[ConProducto|actualizacionMasiva] Se creo archivo con productos no ingresados: "+rutaFallida); 
            JOptionPane.showMessageDialog(null, "Se abrirá un excel con los archivos no cargados", "Operaciones fallidas", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(rutaFallida));
             
        }
        catch (Exception e) {
            
            log.RegistrarLog("[ERROR][ConProducto|actualizacionMasiva] "+e.getMessage());     
        }

    }
    
    public void excelCargaStockMasivo(String filtro){
        Logs log = new Logs();
        String  rutaPlantilla = "src/Plantillas/Carga masiva productos.xlsx";   
        String rutaStockMasivo =System.getProperty("user.home")+"/Desktop/Carga masiva/Actualizacion stock masivo/Stock masivo.xlsx";        
        File archivoCopia = new File(rutaPlantilla);       
        File rutaFinalCopia = new File(rutaStockMasivo);  
        try{
            Files.copy(archivoCopia.toPath(), rutaFinalCopia.toPath(),REPLACE_EXISTING);       
            System.out.println("archivo creado");
        }      
        
        catch(Exception e){            
            System.out.println(e.getMessage());
        }
        try {
            FileInputStream inputStream = new FileInputStream(new File(rutaStockMasivo));
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            DataFormat fmt = workbook.createDataFormat();
        

            int rowCount = 0;
            
            CellStyle style = workbook.createCellStyle();
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setDataFormat(fmt.getFormat("@"));
            
            ArrayList<Producto> listado;

            if(filtro.equals("")) listado = listarProductos();
            else listado = listarProductosFiltrado(filtro);
            
            for (Producto p : listado) {
                
                if(p.getNombre().equals("CODIGO DE PRODUCTO DESCARTADO")) continue;
                                
                rowCount += 1;
                Row row = sheet.createRow(rowCount);
                Cell cell = row.createCell(0);
                cell.setCellValue(p.getCodigo_barra());
                cell.setCellStyle(style);
                cell = row.createCell(1);
                cell.setCellValue(p.getNombre());
                cell.setCellStyle(style);
                cell = row.createCell(2);
                cell.setCellValue(String.valueOf(p.getPrecio()));
                cell.setCellStyle(style);
                cell = row.createCell(3);
                cell.setCellValue(String.valueOf(p.getStock()));                    
                cell.setCellStyle(style);
            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(rutaStockMasivo);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            log.RegistrarLog("[ConProducto|excelCargaStockMasivo] Se creo archivo con productos no ingresados: "+rutaStockMasivo); 
            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(rutaStockMasivo));
             
        }
        catch (Exception e) {            
            log.RegistrarLog("[ERROR][ConProducto|excelCargaStockMasivo] "+e.getMessage());     
        }
    }  
    
    public Producto consultaPrecio(String codigo){
        Logs log = new Logs();
        try{
            Statement stmt = Conexion.getConnection().createStatement();
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
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "SELECT codigo_barra, nombre, stock FROM PRODUCTO WHERE stock < 0;";
            log.RegistrarLog("[Query][ConProducto|stockNegativo] "+query);
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                if(listarDescartados().contains(rs.getString(1))) continue;
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

    public void actualizacionMasiva(File archivoExcel, JProgressBar ProgressBar, JFrame Frame){
        Logs log = new Logs();
        ArrayList<Producto> productosNoIngresados = new ArrayList<>();
        ArrayList<Producto> productosIngresados = new ArrayList<>();       
        try{ 
            log.RegistrarLog("[ConProducto|actualizacionMasiva] Obteniendo informacion de excel");                
            FileInputStream fis = new FileInputStream(archivoExcel);   

            XSSFWorkbook workbook = new XSSFWorkbook(fis);   
            XSSFSheet sheet = workbook.getSheetAt(0);     
            Iterator<Row> itr = sheet.iterator();   
            int filas = 0;
            
            while(itr.hasNext()){                
                Row row = itr.next();  
                Iterator<Cell> cellIterator = row.cellIterator();   

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
                log.RegistrarLog("[ConProducto|actualizacionMasiva] Subiendo nueva informacion");                
                final double totalFilas = (double) filas;           
            
                Thread threadMasivo = new Thread(new Runnable() {
                @Override
                public void run() {
                    DecimalFormat df = new DecimalFormat("0.00");
                    final Iterator<Row> itr = sheet.iterator(); 
                    double porcentajeIndividual = 100.00/totalFilas;
                    double progresoGeneral = 0.00;       
                    System.out.println(porcentajeIndividual);
                    
                    while (itr.hasNext()){

                        Row row = itr.next();                         

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
                            if(existeCodigo(codigo_barra)){
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

                                    boolean ingreso = actualizarProducto(p);

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
                            
                            ProgressBar.setValue((int) progresoGeneral);
                            ProgressBar.setString(df.format(progresoGeneral)+"%");
                        }


                    }  
                ProgressBar.setValue(100);
                ProgressBar.setString(String.valueOf("100%"));
                JOptionPane.showMessageDialog(Frame, String.valueOf(productosIngresados.size())+" Productos ingresados correctamente \n"+String.valueOf(productosNoIngresados.size())+" Productos NO ingresados.\n"+(int)totalFilas+" Productos procesados en total.","Status de carga",JOptionPane.INFORMATION_MESSAGE);
                if(productosNoIngresados.size() > 0) excelArchivosNoSubidos(productosNoIngresados, log);
                ProgressBar.setValue(0);
                ProgressBar.setString(String.valueOf("0%"));
                }
            });
            
                threadMasivo.start();  
              
            }
            else{
                JOptionPane.showMessageDialog(Frame, "No hay productos para subir", "Error subiendo productos", JOptionPane.INFORMATION_MESSAGE);
            }
            
 
        }        
        catch(Exception e){  
            log.RegistrarLog("[ERROR][ConProducto|actualizacionMasiva] "+e.getMessage());   
        } 

    }
    
    public boolean crearOferta(ArrayList<String[]> codigosProductos, int precioOferta, String codigoOferta, String nombreOferta){
        
        Logs log = new Logs();
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();  
            
            codigoOferta = codigoOferta.trim().toUpperCase();
            nombreOferta = nombreOferta.trim().toUpperCase();
            
            //CREACION DE TRIGGER
            
            String trigger = "CREATE TRIGGER oferta_"+codigoOferta+
                             " BEFORE INSERT ON VENTA_PRODUCTO FOR EACH ROW"+
                             " BEGIN IF NEW.codigo_barra = '"+codigoOferta+"' THEN ";           
            
            
            for(String[] codigo_cantidad: codigosProductos){
                String codigo_barra = codigo_cantidad[0];
                String cantidad = String.valueOf(codigo_cantidad[1]);
                
                String updateTrigger = "UPDATE PRODUCTO SET stock = stock - (" + cantidad +"*NEW.cantidad) WHERE codigo_barra = '" + codigo_barra + "'; ";
                trigger = trigger + updateTrigger;    
            
            }
            
            trigger = trigger + "END IF; END;";
            System.out.println(trigger);
            stmt.execute(trigger);
            
            log.RegistrarLog("[ConProducto][crearOferta] Trigger creado con exito");
            log.RegistrarLog("[ConProducto][crearOferta] "+trigger);
            
            //CREACION DE OFERTA COMO PRODUCTO
            
            Producto oferta = new Producto();
            oferta.setCodigo_barra(codigoOferta);
            oferta.setNombre(nombreOferta);
            oferta.setPrecio(precioOferta);
            oferta.setStock(100);
            
            return ingresarProducto(oferta);
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConProducto|crearOferta] "+e.getMessage()); 
            JOptionPane.showMessageDialog(null, "[ERROR][ConProducto|crearOferta] "+e.getMessage(), "Error creando oferta", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
    }
    
    public boolean descartarProducto(String codigoBarra){
        Logs log = new Logs();
        try{
            Statement stmt = Conexion.getConnection().createStatement();
            String query = "INSERT INTO PRODUCTO_DESCARTADO VALUES('"+codigoBarra+"',true);";
                    
            log.RegistrarLog("[Query][ConProducto|descartarProducto] "+query);
            stmt.execute(query);
            log.RegistrarLog("[ConProducto|descartarProducto] Descartado - "+codigoBarra); 
            return true;
            
        }
        catch(Exception e){
            log.RegistrarLog("[ConProducto|descartarProducto] NO descartado - "+codigoBarra);
            log.RegistrarLog("[ERROR][ConProducto|descartarProducto] "+e.getMessage());
            return false;
        }        
    }
    
}
