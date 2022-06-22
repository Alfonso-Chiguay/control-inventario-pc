package piliscoffeepos;

import controlador.ConProducto;
import vista.CrearOferta;
import vista.Inicio;


public class Main {

    public static void main(String[] args){      
        Inicio ventana = new Inicio();
        ventana.setVisible(true);   
        ConProducto c = new ConProducto();
        CrearOferta ventana2 = new CrearOferta(c.listarProductos());
        ventana2.setVisible(true);
    }    
}
