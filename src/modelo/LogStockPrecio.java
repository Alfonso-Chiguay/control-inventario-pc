package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;



public class LogStockPrecio {
    private int id_trabajador;
    private String codigo_barra;
    private int stock_antiguo;
    private int stock_agregado;
    private int precio_antiguo;
    private int precio_nuevo;
    private String fecha;

    public LogStockPrecio(int id_trabajador, String codigo_barra, int stock_antiguo, int stock_agregado, int precio_antiguo, int precio_nuevo) {
        this.id_trabajador = id_trabajador;
        this.codigo_barra = codigo_barra;
        this.stock_antiguo = stock_antiguo;
        this.stock_agregado = stock_agregado;
        this.precio_antiguo = precio_antiguo;
        this.precio_nuevo = precio_nuevo;
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        
        this.fecha = format.format(date);
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public int getStock_antiguo() {
        return stock_antiguo;
    }

    public void setStock_antiguo(int stock_antiguo) {
        this.stock_antiguo = stock_antiguo;
    }

    public int getStock_agregado() {
        return stock_agregado;
    }

    public void setStock_agregado(int stock_agregado) {
        this.stock_agregado = stock_agregado;
    }

    public int getPrecio_antiguo() {
        return precio_antiguo;
    }

    public void setPrecio_antiguo(int precio_antiguo) {
        this.precio_antiguo = precio_antiguo;
    }

    public int getPrecio_nuevo() {
        return precio_nuevo;
    }

    public void setPrecio_nuevo(int precio_nuevo) {
        this.precio_nuevo = precio_nuevo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
