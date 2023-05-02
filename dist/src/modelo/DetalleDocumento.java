package modelo;

public class DetalleDocumento {
    private Documento documento;
    private Proveedor proveedor;
    private Producto producto;
    private int cantidad;

    public DetalleDocumento(Documento documento, Proveedor proveedor, Producto producto, int cantidad) {
        this.documento = documento;
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleDocumento() {
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
