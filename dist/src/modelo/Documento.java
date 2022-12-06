package modelo;

public class Documento {
    private String id_documento;
    private String folio;
    private boolean es_factura;
    private String fecha;
    private int total;
    private boolean por_pagar;

    public Documento(String id_documento, String folio, boolean es_factura, String fecha, int total, boolean por_pagar) {
        this.id_documento = id_documento;
        this.folio = folio;
        this.es_factura = es_factura;
        this.fecha = fecha;
        this.total = total;
        this.por_pagar = por_pagar;
    }

    public Documento() {
        this.id_documento = "";
        this.folio = "";
        this.es_factura = false;
        this.fecha = "";
        this.total = -1;
        this.por_pagar = false;
    }

    public String getId_documento() {
        return id_documento;
    }

    public void setId_documento(String id_documento) {
        this.id_documento = id_documento;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public boolean isEs_factura() {
        return es_factura;
    }

    public void setEs_factura(boolean es_factura) {
        this.es_factura = es_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isPor_pagar() {
        return por_pagar;
    }

    public void setPor_pagar(boolean por_pagar) {
        this.por_pagar = por_pagar;
    }
    
    
}
