package controlador;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Producto;
import modelo.Venta;

public class ConInformes {
    
    public void informeStockNegativo(){
        Document documento = new Document();
        try {

            Date date = Calendar.getInstance().getTime();

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
            String ruta = System.getProperty("user.home")+"/Desktop/Reportes/Stock negativo/Informe stock negativo "+today+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
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
            subtitulo.add("Fecha de creacion del reporte: "+today+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);
            
            ConProducto cProducto = new ConProducto();
            ArrayList<Producto> listado = cProducto.stockNegativo();
            
            if(listado.size() == 0){
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
            
            Desktop.getDesktop().open(new File(ruta));
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void informeVentaDiario(String fecha){
        ConVenta cVenta = new ConVenta();
        ArrayList<Venta> listado = cVenta.ventasDia(fecha);
        Document documento = new Document();
        try {
            Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String today = formatter.format(date);
            String fechaSolicitada = fecha.split("-")[2]+"-"+fecha.split("-")[1]+"-"+fecha.split("-")[0];
            String ruta = System.getProperty("user.home")+"/Desktop/Reportes/Venta diaria/Venta diaria "+fechaSolicitada+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image header = Image.getInstance("src/img/Piliscoffee header.png");
            header.scaleToFit(150, 150);
            
            header.setAlignment(Chunk.ALIGN_LEFT);
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Chunk.ALIGN_CENTER);

            titulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.RED));
            titulo.add("\nDETALLE DE VENTA DEL "+fechaSolicitada);
            
            Paragraph subtitulo = new Paragraph();
            subtitulo.setAlignment(Chunk.ALIGN_CENTER);
            subtitulo.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED));
            subtitulo.add("Fecha de creacion del reporte: "+today+"\n\n");
            
            documento.open();
            documento.add(header);
            documento.add(titulo);
            documento.add(subtitulo);    
            
            if(listado.size() == 0){
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
                for(Venta v: listado){
                    totalVenta += v.getTotal();
                    if(v.getTipo_venta().equals("EFECTIVO")) ventaEfectivo+=v.getTotal();
                    else if(v.getTipo_venta().equals("DEBITO")) ventaDebito+=v.getTotal();
                    else ventaCredito+=v.getTotal();
                }
                
                String str_totalVenta = String.format("$%,d",Integer.valueOf(totalVenta));
                String str_efectivo = String.format("$%,d",Integer.valueOf(ventaEfectivo));
                String str_debito = String.format("$%,d",Integer.valueOf(ventaDebito));
                String str_credito = String.format("$%,d",Integer.valueOf(ventaCredito));
                
                Paragraph venta = new Paragraph();
                venta.setAlignment(Chunk.ALIGN_LEFT);
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.NORMAL, new BaseColor(16, 125, 67)));
                venta.add("TOTAL DE VENTA DEL DIA:  "+str_totalVenta);
                documento.add(venta);
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("EFECTIVO: "+str_efectivo);
                documento.add(venta);
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("DÉBITO:      "+str_debito);
                documento.add(venta);
                venta = new Paragraph();
                venta.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK));
                venta.add("CRÉDITO:   "+str_credito);
                documento.add(venta);
                
                
            }
            
            
            
            
            Paragraph firma = new Paragraph("\n\n\n________________________");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);
            firma = new Paragraph("V° B° REVISION          ");
            firma.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(firma);        
            documento.close();
            
            Desktop.getDesktop().open(new File(ruta));
        } 
        catch (Exception e) {
        }
        
    }
    
    
    
}
