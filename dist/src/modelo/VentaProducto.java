package modelo;

public class VentaProducto {
    private String codigo_barra;
    private int folio;
    private int cantidad;
    private int total;
    
    public VentaProducto(){
        this.codigo_barra = "";
        this.folio = 0;
        this.cantidad = 0;
        this.total = 0;
    }
    
    public VentaProducto(String codigo_barra, int folio, int cantidad, int total){
        this.codigo_barra = codigo_barra;
        this.folio = folio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
