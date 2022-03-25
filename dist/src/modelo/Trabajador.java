package modelo;


public class Trabajador {
    private int id_trabajador;
    private String nombre;

    public Trabajador() {
        this.id_trabajador = 0;
        this.nombre = "";
    }
    
    public Trabajador(int id_trabajador, String nombre) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
