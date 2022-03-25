package controlador;
import java.io.*;

public class OfflineQueuesBD {
    public void EscribirQueue(String queue){
        FileWriter uploadQueueTxt = null;
        PrintWriter pw = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{            
            fr = new FileReader ("src\\\\QueuesFolder\\\\queueToUpload.txt");
            br = new BufferedReader(fr);
            String linea;
            String texto = "";
            
            while((linea=br.readLine())!= null)
                if(!linea.equals("")) texto = texto + linea + "\n";    
                               
            uploadQueueTxt = new FileWriter("src\\\\QueuesFolder\\\\queueToUpload.txt");
            pw = new PrintWriter(uploadQueueTxt);
            pw.println(texto+queue);   
        } 
        catch (Exception e){
            e.printStackTrace();
        } 
        finally{
            try{
                if(null != uploadQueueTxt)
                   uploadQueueTxt.close();
            } 
           catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public boolean isQueueToUpload(){
        FileReader fr = null;
        BufferedReader br = null;
        boolean respuesta = false;
        try{
            fr = new FileReader ("src\\\\QueuesFolder\\\\queueToUpload.txt");
            br = new BufferedReader(fr);
            String linea; 
            while((linea=br.readLine())!= null){
                if(linea.contains("WHERE") || linea.contains("FROM") || linea.contains("UPDATE") || linea.contains("SELECT") || linea.contains("*")){
                    respuesta = true;
                    break;
                }                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        
        } 
        finally{
            try{           
                if (null != fr)
                     fr.close();
            } 
            catch (Exception e2){
              e2.printStackTrace();
            }
        }
        return respuesta;
    }
    
    public void uploadQueues(){
        
    }
}
