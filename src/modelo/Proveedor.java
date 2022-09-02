package modelo;

public class Proveedor {

    private String rut;
    private String dv;
    private String razon_social;

    public Proveedor(String rut, String dv, String razon_social) {
        this.rut = rut;
        this.dv = dv;
        this.razon_social = razon_social;
    }

    public Proveedor() {
        this.rut = "";
        this.dv = "";
        this.razon_social = "";
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {        
        this.rut = rut.replace(".", "");
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv.toUpperCase();
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social.toUpperCase();
    }
    
    
    
    
    
}
