/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author alfon
 */
public class Producto {
    private String codigo_barra;
    private String nombre;
    private int precio;
    private int stock;
    
    public Producto(){
        this.codigo_barra="";
        this.nombre="";
        this.precio=0;
        this.stock=0;
    }
    
    public Producto(String codigo_barra, String nombre, int precio, int stock) throws Exception{
        setCodigo_barra(codigo_barra);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public void ingresoExcepcional(String codigo_barra, String nombre, int precio, int stock){
        this.codigo_barra = codigo_barra;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    
    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) throws Exception {
        if(codigo_barra.length() < 1) throw new Exception("Codigo de barra invalido");        
        this.codigo_barra = codigo_barra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length() < 1) throw new Exception("Nombre invalido");
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
        if(precio <= 0) throw new Exception("El precio no puede ser menor o igual a 0");
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock){
        
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "COD: "+this.codigo_barra+", NOMBRE: "+this.nombre;
    }
    
    
    
}
