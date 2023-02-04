package piliscoffeepos;
import controlador.ConDocumento;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import modelo.Documento;
import vista.AlertaFacturasPP;
import vista.Home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Main {
    public static void main(String[] args){  
        
        Home ventana = new Home();
        ventana.setVisible(true); 
        
        ConDocumento conDocumento = new ConDocumento();
        ArrayList<Documento> facturas = conDocumento.facturasPorPagar();
        if(facturas.size() > 0){
            int cantidadPP=0, cantidadPorVencer = 0;
            
            for(Documento d: facturas){
                long diferenciaDias = diferenciaEntreDias(d.getFecha());
                if(diferenciaDias >=10 && diferenciaDias < 15){
                    cantidadPP += 1;
                }
                else if(diferenciaDias >= 15){
                    cantidadPorVencer += 1;
                }
            }

            if(cantidadPP > 0 || cantidadPorVencer > 0){
                AlertaFacturasPP ventanaAlerta = new AlertaFacturasPP(cantidadPP, cantidadPorVencer);
                ventanaAlerta.setVisible(true);
                ventanaAlerta.toFront();
            }
            
        } 
        
        
    }
    private static long diferenciaEntreDias(String fechaFactura){
        long diferencia = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date firstDate = new Date();
            Date secondDate = sdf.parse(fechaFactura);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            diferencia = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        } 
        catch (Exception e) {
        }
        return diferencia;
    
    }    
}
