package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logs {
    public void RegistrarLog(String log){
        FileWriter fWriter = null;
        PrintWriter pWriter = null;
        FileReader fReader = null;
        BufferedReader bReader = null;
        try{ 
            Date date = Calendar.getInstance().getTime();   
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
            String rutaLogHoy = System.getProperty("user.home")+"/Documents/Logs PilisCoffeePOS/Log "+today+".txt";
            File file = new File(rutaLogHoy);
            if(!file.exists()){
                file.getParentFile().mkdirs(); 
                file.createNewFile();
                FileOutputStream s = new FileOutputStream(file,false);                
            }
                   
            fReader = new FileReader (rutaLogHoy);
            bReader = new BufferedReader(fReader);
            String linea;
            String texto = "";
            
            while((linea=bReader.readLine())!= null){
                if(!linea.equals("")) {
                    texto = texto + linea + "\n";
                }     
            }
            
            date.setHours(date.getHours()-1);
            
            formatter = new SimpleDateFormat("HH:mm:ss"); 
            String hora = formatter.format(date);
            fWriter = new FileWriter(rutaLogHoy);
            pWriter = new PrintWriter(fWriter);
            pWriter.println(texto+"<"+hora+"> "+log);   
        } 
        catch (Exception e){
            e.printStackTrace();
        } 
        finally{
            try{
                if(null != fWriter)
                   fWriter.close();
            } 
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
