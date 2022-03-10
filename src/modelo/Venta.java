package modelo;

public class Venta {
    private int folio;
    private String fecha;
    private String tipo_venta;
    private int total;
    
    public Venta(){
        this.folio = 0;
        this.fecha = "";
        this.tipo_venta = "";
        this.total = 0;
    }
    
    public Venta(int folio, String fecha, String tipo_venta, int total){
        this.folio = folio;
        this.fecha = fecha;
        this.tipo_venta = tipo_venta;
        this.total = total;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
