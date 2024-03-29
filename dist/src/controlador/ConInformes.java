package controlador;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Venta;

public class ConInformes {
    public void listadoStockGeneral(JFrame ventana){
        Document documento = new Document();
        Logs log = new Logs();
        try {
            
            
            Date date = Calendar.getInstance().getTime();

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
                        
            formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            
            String fullDate = formatter.format(date);
            formatter = new SimpleDateFormat("HHmmss");
            String hora = formatter.format(date);
            
            
            String ruta = System.getProperty("user.home")+"/Desktop/Reportes/Stock/Stock general/Listado stock "+today+" "+hora+".pdf";
            
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            
            log.RegistrarLog("[ConInformes|listadoStockGeneral] Creacion reporte en blanco: "+ruta);
            documento.open();
            Image header = Image.getInstance("src/img/Piliscoffee header.png");
            header.scaleToFit(150, 150);
            
            header.setAlignment(Chunk.ALIGN_LEFT);
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Chunk.ALIGN_CENTER);

            titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.RED));
            titulo.add("\nINVENTARIO - STOCK GENERAL");
            
            Paragraph subtitulo = new Paragraph();
            subtitulo.setAlignment(Chunk.ALIGN_CENTER);
            subtitulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            subtitulo.add("Fecha de creacion del reporte: "+fullDate+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);   
            
            ConProducto cProducto = new ConProducto();
            ArrayList<Producto> listado = cProducto.listarProductos();
            PdfPTable reporte = new PdfPTable(new float[] { 25, 63, 12 });
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.GRAY);
            Font font = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            font.setColor(BaseColor.WHITE);
            cell.setPhrase(new Phrase("CÓD. PRODUCTO", font));
            reporte.addCell(cell);
            cell.setPhrase(new Phrase("NOMBRE DEL PRODUCTO", font));
            reporte.addCell(cell);
            cell.setPhrase(new Phrase("STOCK", font));

            reporte.addCell(cell);

            for(Producto p: listado){ 
                if(cProducto.listarDescartados().contains(p.getCodigo_barra())) continue;
                
                if(p.getStock() <= 0){
                    font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
                    font.setColor(BaseColor.RED);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    cell.setPhrase(new Phrase(p.getCodigo_barra(),font));
                    reporte.addCell(cell);
                    cell.setPhrase(new Phrase(p.getNombre(),font));
                    reporte.addCell(cell);
                    PdfPCell cellStock = new PdfPCell();
                    cellStock.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellStock.setBackgroundColor(BaseColor.WHITE);
                    cellStock.setPhrase(new Phrase(String.valueOf(p.getStock()),font));
                    reporte.addCell(cellStock);
                }
                else{
                    reporte.addCell(p.getCodigo_barra());
                    reporte.addCell(p.getNombre());
                    PdfPCell cellStock = new PdfPCell();
                    cellStock.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellStock.setPhrase(new Phrase(String.valueOf(p.getStock())));
                    reporte.addCell(cellStock);                   
                }

            }
            documento.add(reporte); 
            
            
            documento.close();
            JOptionPane.showMessageDialog(ventana, "Reporte generado con éxito", "Stock general", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(ruta));
            log.RegistrarLog("[ConInformes|listadoStockGeneral] Creacion de reporte exitoso");            
            
            
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConInformes|listadoStockGeneral] "+e.getMessage());            
        }
    }

    public void listadoStockFamilia(JFrame ventana, String filtro){
        Document documento = new Document();
        Logs log = new Logs();
        try {
            Date date = Calendar.getInstance().getTime();

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
                        
            formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            
            String fullDate = formatter.format(date);
            formatter = new SimpleDateFormat("HHmmss");
            String hora = formatter.format(date);
            
            
            String ruta = System.getProperty("user.home")+"/Desktop/Reportes/Stock/Stock general/Listado stock "+filtro.toLowerCase()+" "+today+" "+hora+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            
            log.RegistrarLog("[ConInformes|listadoStockGeneral] Creacion reporte en blanco: "+ruta);
            documento.open();
            Image header = Image.getInstance("src/img/Piliscoffee header.png");
            header.scaleToFit(150, 150);
            
            header.setAlignment(Chunk.ALIGN_LEFT);
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Chunk.ALIGN_CENTER);

            titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.RED));
            titulo.add("\nINVENTARIO - STOCK FILTRADO: '"+filtro.toUpperCase()+"'");
            
            Paragraph subtitulo = new Paragraph();
            subtitulo.setAlignment(Chunk.ALIGN_CENTER);
            subtitulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            subtitulo.add("Fecha de creacion del reporte: "+fullDate+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);   
            
            ConProducto cProducto = new ConProducto();
            ArrayList<Producto> listado = cProducto.listarProductosFiltrado(filtro);
            PdfPTable reporte = new PdfPTable(new float[] { 25, 63, 12 });
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.GRAY);
            Font font = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            font.setColor(BaseColor.WHITE);
            cell.setPhrase(new Phrase("CÓD. PRODUCTO", font));
            reporte.addCell(cell);
            cell.setPhrase(new Phrase("NOMBRE DEL PRODUCTO", font));
            reporte.addCell(cell);
            cell.setPhrase(new Phrase("STOCK", font));

            reporte.addCell(cell);

            for(Producto p: listado){   
                if(cProducto.listarDescartados().contains(p.getCodigo_barra())) continue;
                if(p.getStock() <= 0){
                    font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
                    font.setColor(BaseColor.RED);
                    cell.setBackgroundColor(BaseColor.WHITE);
                    cell.setPhrase(new Phrase(p.getCodigo_barra(),font));
                    reporte.addCell(cell);
                    cell.setPhrase(new Phrase(p.getNombre(),font));
                    reporte.addCell(cell);
                    PdfPCell cellStock = new PdfPCell();
                    cellStock.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellStock.setBackgroundColor(BaseColor.WHITE);
                    cellStock.setPhrase(new Phrase(String.valueOf(p.getStock()),font));
                    reporte.addCell(cellStock);
                }
                else{
                    reporte.addCell(p.getCodigo_barra());
                    reporte.addCell(p.getNombre());
                    PdfPCell cellStock = new PdfPCell();
                    cellStock.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellStock.setPhrase(new Phrase(String.valueOf(p.getStock())));
                    reporte.addCell(cellStock);                   
                }

            }
            documento.add(reporte); 
            
            
            documento.close();
            JOptionPane.showMessageDialog(ventana, "Reporte generado con éxito", "Stock general", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(ruta));
            log.RegistrarLog("[ConInformes|listadoStockGeneral] Creacion de reporte exitoso");            
            
            
            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConInformes|listadoStockGeneral] "+e.getMessage());            
        }
    }

    
    public void informeStockNegativo(JFrame ventana){
        Document documento = new Document();
        Logs log = new Logs();
        try {

            Date date = Calendar.getInstance().getTime();

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
                        
            formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            
            String fullDate = formatter.format(date);
            formatter = new SimpleDateFormat("HHmmss");
            String hora = formatter.format(date);
            
            
            String ruta = System.getProperty("user.home")+"/Desktop/Reportes/Stock/Stock negativo/Informe stock negativo "+today+" "+hora+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            log.RegistrarLog("[ConInformes|informeStockNegativo] Creacion reporte en blanco: "+ruta);
            documento.open();
            Image header = Image.getInstance("src/img/Piliscoffee header.png");
            header.scaleToFit(150, 150);
            
            header.setAlignment(Chunk.ALIGN_LEFT);
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Chunk.ALIGN_CENTER);

            titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.RED));
            titulo.add("\nINVENTARIO - STOCK NEGATIVO");
            
            Paragraph subtitulo = new Paragraph();
            subtitulo.setAlignment(Chunk.ALIGN_CENTER);
            subtitulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            subtitulo.add("Fecha de creacion del reporte: "+fullDate+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);
            
            ConProducto cProducto = new ConProducto();
            ArrayList<Producto> listado = cProducto.stockNegativo();
            
            if(listado.isEmpty()){
                Image body = Image.getInstance("src/img/stockOK.png");
                body.scaleToFit(200, 200);
            
                body.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(body);
            }
            else{
                PdfPTable reporte = new PdfPTable(new float[] { 25, 63, 12 });
                PdfPCell cell = new PdfPCell();
                cell.setBackgroundColor(BaseColor.GRAY);
                Font font = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
                font.setColor(BaseColor.WHITE);
                cell.setPhrase(new Phrase("CÓD. PRODUCTO", font));
                reporte.addCell(cell);
                cell.setPhrase(new Phrase("NOMBRE DEL PRODUCTO", font));
                reporte.addCell(cell);
                cell.setPhrase(new Phrase("STOCK", font));

                reporte.addCell(cell);
                
                for(Producto p: listado){                                
                    reporte.addCell(p.getCodigo_barra());
                    reporte.addCell(p.getNombre());
                    PdfPCell cellStock = new PdfPCell();
                    cellStock.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellStock.setPhrase(new Phrase(String.valueOf(p.getStock())));
                    reporte.addCell(cellStock);
                }
                documento.add(reporte);
            }         
            
            Paragraph firma = new Paragraph("\n\n\n________________________");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);
            firma = new Paragraph("V° B° REVISION          ");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);           
            
            documento.close();
            JOptionPane.showMessageDialog(ventana, "Reporte generado con éxito", "Stock negativo", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(ruta));
            log.RegistrarLog("[ConInformes|informeStockNegativo] Creacion de reporte exitoso");            
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConInformes|informeStockNegativo] "+e.getMessage());
        }
    }
    
    public void informeVentaPeriodo(String fecha1, String fecha2){
        Logs log = new Logs();
        ConVenta cVenta = new ConVenta();
        ArrayList<Venta> listado = cVenta.ventasDia(fecha1, fecha2);
        Document documento = new Document();
        try {
            Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");            
            String fullDate = formatter.format(date);
            
            formatter = new SimpleDateFormat("HHmmss");
            String hora = formatter.format(date);
            
            String fechaSolicitada, ruta;
            
            if(fecha1.equals(fecha2)){
                fechaSolicitada = fecha1.split("-")[2]+"-"+fecha1.split("-")[1]+"-"+fecha1.split("-")[0]+" "+hora;
                ruta = System.getProperty("user.home")+"/Desktop/Reportes/Venta diaria/Venta diaria "+fechaSolicitada+".pdf";
            }
            else{
                fechaSolicitada = fecha1.split("-")[2]+"-"+fecha1.split("-")[1]+"-"+fecha1.split("-")[0]+" al "+fecha2.split("-")[2]+"-"+fecha2.split("-")[1]+"-"+fecha2.split("-")[0]+" "+hora;
                ruta = System.getProperty("user.home")+"/Desktop/Reportes/Venta periodo/Ventas "+fechaSolicitada+".pdf";
            }
            
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream("src//controlador//config.properties"));
            } catch (IOException e) {
                log.RegistrarLog("[ConInformes|informeVentaPeriodo] No se puede tener acceso a datos de archivo de configuracion... ("+e.getMessage()+")");  
            }
            
            
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            writer.setEncryption(prop.getProperty("password_pdf").getBytes(), prop.getProperty("password_pdf").getBytes(),
                    PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
            
            log.RegistrarLog("[ConInformes|informeVentaPeriodo] Creacion reporte en blanco: "+ruta);            
            documento.open();
            Image header = Image.getInstance("src/img/Piliscoffee header.png");
            header.scaleToFit(150, 150);
            
            header.setAlignment(Chunk.ALIGN_LEFT);
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Chunk.ALIGN_CENTER);

            
            if(!fecha1.equals(fecha2)){
                titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD, BaseColor.RED));
                String fecha_ini, fecha_fin;
                fecha_ini = fecha1.split("-")[2]+"-"+fecha1.split("-")[1]+"-"+fecha1.split("-")[0];
                fecha_fin = fecha2.split("-")[2]+"-"+fecha2.split("-")[1]+"-"+fecha2.split("-")[0];
                titulo.add("\nVENTAS DEL "+fecha_ini+" al "+fecha_fin);                
            }
            else{
                titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.RED));
                titulo.add("\nDETALLE DE VENTA DEL "+fechaSolicitada.split(" ")[0]);
            }
            
            
            Paragraph subtitulo = new Paragraph();
            subtitulo.setAlignment(Chunk.ALIGN_CENTER);
            subtitulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            subtitulo.add("Fecha de creacion del reporte: "+fullDate+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);    
            
            if(listado.isEmpty()){
                Image body = Image.getInstance("src/img/noventas.png");
                body.scaleToFit(200, 200);
            
                body.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(body);
            }
            
            else{
                int totalVenta = 0;
                int ventaEfectivo = 0;
                int ventaDebito = 0;
                int ventaCredito = 0;
                int ventaTransferencia = 0;
                int ventaSumUp = 0;
                
                for(Venta v: listado){
                    totalVenta += v.getTotal();
                    switch (v.getTipo_venta()) {
                        case "EFECTIVO":
                            ventaEfectivo+=v.getTotal();
                            break;                    
                        case "TRANSFERENCIA":
                            ventaTransferencia+=v.getTotal();
                            break;
                        case "SUMUP":
                            ventaSumUp+=v.getTotal();
                            break;
                        default:
                            break;
                    }
                    //else if(v.getTipo_venta().equals("DEBITO")) ventaDebito+=v.getTotal();
                    //else ventaCredito+=v.getTotal();
                }
                
                String str_totalVenta = String.format("$%,d", totalVenta);
                String str_efectivo = String.format("$%,d", ventaEfectivo);
                //String str_debito = String.format("$%,d", ventaDebito);
                String str_transferencia = String.format("$%,d", ventaTransferencia);
                //String str_credito = String.format("$%,d", ventaCredito);
                String str_sumup = String.format("$%,d", ventaSumUp);
                
                Paragraph venta = new Paragraph();
                venta.setAlignment(Chunk.ALIGN_LEFT);
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, new BaseColor(16, 125, 67)));
                venta.add("TOTAL DE VENTAS:  "+str_totalVenta);
                documento.add(venta);
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("EFECTIVO: "+str_efectivo);
                documento.add(venta);
                /*venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("DÉBITO:      "+str_debito);
                documento.add(venta);
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("CRÉDITO:   "+str_credito);
                documento.add(venta);*/
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("TRANSFERENCIA:   "+str_transferencia);
                documento.add(venta);                
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("SUM UP:   "+str_sumup+"\n\n");
                documento.add(venta); 
                
                ArrayList<Object[]> resumenMetodoPago = cVenta.resumenVentaMetodoPago(fecha1, fecha2);
                


                
                PdfPTable tablaEfectivo = new PdfPTable(new float[]{10,20, 30,20});
                //PdfPTable tablaDebito = new PdfPTable(new float[]{10,20, 30,20});
                //PdfPTable tablaCredito = new PdfPTable(new float[]{10,20, 30,20});
                PdfPTable tablaTransferencia = new PdfPTable(new float[]{10,20, 30,20});
                PdfPTable tablaSumUp = new PdfPTable(new float[]{10,20, 30,20});
                PdfPCell cell = new PdfPCell();
                cell.setBackgroundColor(BaseColor.GRAY);
                Font font = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
                font.setColor(BaseColor.WHITE);
                cell.setPhrase(new Phrase("FOLIO", font));
                tablaEfectivo.addCell(cell);
                /*tablaDebito.addCell(cell);
                tablaCredito.addCell(cell);*/ 
                tablaTransferencia.addCell(cell);     
                tablaSumUp.addCell(cell);
                cell.setPhrase(new Phrase("METODO PAGO", font));
                tablaEfectivo.addCell(cell);
               /* tablaDebito.addCell(cell);
                tablaCredito.addCell(cell); */
                tablaTransferencia.addCell(cell);   
                tablaSumUp.addCell(cell);
                cell.setPhrase(new Phrase("FECHA", font));
                tablaEfectivo.addCell(cell);
               /* tablaDebito.addCell(cell);
                tablaCredito.addCell(cell); */
                tablaTransferencia.addCell(cell);  
                tablaSumUp.addCell(cell);
                cell.setPhrase(new Phrase("TOTAL", font));
                tablaEfectivo.addCell(cell);
                /*tablaDebito.addCell(cell);
                tablaCredito.addCell(cell); */
                tablaTransferencia.addCell(cell); 
                tablaSumUp.addCell(cell);                
                
                for(Object[] o: resumenMetodoPago){
                    int int_folio = (int) o[0];
                    String str_folio = String.valueOf(int_folio);
                    String tipo_venta = o[1].toString();
                    String fechaTransacction = o[2].toString();
                    int int_total = (int) o[3];
                    String str_total = String.format("$%,d", int_total);
                    PdfPCell cellTotal = new PdfPCell();
                    cellTotal.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    cellTotal.setPhrase(new Phrase(str_total));
                    
                    if(tipo_venta.equals("EFECTIVO")){
                        tablaEfectivo.addCell(str_folio);
                        tablaEfectivo.addCell(tipo_venta);
                        tablaEfectivo.addCell(fechaTransacction);
                        tablaEfectivo.addCell(cellTotal);   
                    }
                    /*else if(tipo_venta.equals("DEBITO")){
                        tablaDebito.addCell(str_folio);
                        tablaDebito.addCell(tipo_venta);
                        tablaDebito.addCell(fechaTransacction);
                        tablaDebito.addCell(cellTotal); 
                    }*/
                    else if(tipo_venta.equals("TRANSFERENCIA")){
                        tablaTransferencia.addCell(str_folio);
                        tablaTransferencia.addCell(tipo_venta);
                        tablaTransferencia.addCell(fechaTransacction);
                        tablaTransferencia.addCell(cellTotal); 
                    }                    
                    /*else if(tipo_venta.equals("CREDITO")){
                        tablaCredito.addCell(str_folio);
                        tablaCredito.addCell(tipo_venta);
                        tablaCredito.addCell(fechaTransacction);
                        tablaCredito.addCell(cellTotal);                        
                    }*/
                    else if(tipo_venta.equals("SUMUP")){
                        tablaSumUp.addCell(str_folio);
                        tablaSumUp.addCell(tipo_venta);
                        tablaSumUp.addCell(fechaTransacction);
                        tablaSumUp.addCell(cellTotal);                        
                    }                    
                    
                }
                Paragraph tituloEfectivo = new Paragraph();
                tituloEfectivo.setAlignment(Chunk.ALIGN_CENTER);
                tituloEfectivo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloEfectivo.add("METODO DE PAGO: EFECTIVO\n\n");
                documento.add(tituloEfectivo);
                documento.add(tablaEfectivo);
                
                
                /*Paragraph tituloDebito = new Paragraph();
                tituloDebito.setAlignment(Chunk.ALIGN_CENTER);
                tituloDebito.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloDebito.add("\n\nMETODO DE PAGO: DEBITO\n\n");
                documento.add(tituloDebito);
                documento.add(tablaDebito);*/
                
                /*Paragraph tituloCredito = new Paragraph();
                tituloCredito.setAlignment(Chunk.ALIGN_CENTER);
                tituloCredito.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloCredito.add("\n\nMETODO DE PAGO: CREDITO\n\n");
                documento.add(tituloCredito);
                documento.add(tablaCredito); */
                
                Paragraph tituloTransferencia = new Paragraph();
                tituloTransferencia.setAlignment(Chunk.ALIGN_CENTER);
                tituloTransferencia.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloTransferencia.add("\n\nMETODO DE PAGO: TRANSFERENCIA\n\n");
                documento.add(tituloTransferencia);
                documento.add(tablaTransferencia); 
                
                Paragraph tituloSumUp = new Paragraph();
                tituloSumUp.setAlignment(Chunk.ALIGN_CENTER);
                tituloSumUp.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloSumUp.add("\n\nMETODO DE PAGO: SUM UP\n\n");
                documento.add(tituloSumUp);
                documento.add(tablaSumUp);                 
                
                Paragraph tituloProducto = new Paragraph();
                tituloProducto.setAlignment(Chunk.ALIGN_CENTER);
                tituloProducto.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLUE));
                tituloProducto.add("\n\n\n\nDETALLE DE PRODUCTOS VENDIDOS\n\n");
                
                ArrayList<Object[]> detalleProducto = cVenta.detalleProductoVendido(fecha1, fecha2);
                PdfPTable tablaProductos = new PdfPTable(new float[]{50,20,20});

                cell.setPhrase(new Phrase("PRODUCTO", font));
                tablaProductos.addCell(cell);               
                cell.setPhrase(new Phrase("CANTIDAD", font));
                tablaProductos.addCell(cell);
                cell.setPhrase(new Phrase("TOTAL VENTA", font));
                tablaProductos.addCell(cell);
                
                for(Object[] o: detalleProducto){
                    String nombreProducto = o[0].toString();
                    int cantidad = (int) o[1];
                    int total = (int) o[2];
                    String str_total = String.format("$%,d", total);
                    
                    
                    PdfPCell cellDerecha = new PdfPCell();
                    cellDerecha.setHorizontalAlignment(Chunk.ALIGN_RIGHT);
                    
                    tablaProductos.addCell(nombreProducto);
                    
                    
                    cellDerecha.setPhrase(new Phrase(String.valueOf(cantidad)));
                    tablaProductos.addCell(cellDerecha);
                    
                    cellDerecha.setPhrase(new Phrase(str_total));
                    tablaProductos.addCell(cellDerecha);
                    
                }
                documento.add(tituloProducto);
                documento.add(tablaProductos);                
            }            
            
            Paragraph firma = new Paragraph("\n\n\n________________________");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);
            firma = new Paragraph("V° B° REVISION          ");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);        
            documento.close();
            log.RegistrarLog("[ConInformes|informeVentaPeriodo] Creacion de reporte exitoso");            
            Desktop.getDesktop().open(new File(ruta));
        } 
        catch (Exception e) {
            log.RegistrarLog("[ERROR][ConInformes|informeVentaPeriodo] "+e.getMessage());
        }
        
    }
    

    
}
