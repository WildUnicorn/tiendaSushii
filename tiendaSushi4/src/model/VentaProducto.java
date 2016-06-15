package model;

/**
 *
 * @author Piaa FernanDaa
 */
public class VentaProducto {
    private int id;
    private int idProducto;
    private int idVenta;
    private int cantidadProductos;
    private int subTotal;

    public VentaProducto(int id, int idProducto, int idVenta, int cantidadProductos, int subTotal) {
        this.id = id;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.cantidadProductos = cantidadProductos;
        this.subTotal = subTotal;
    }

    public VentaProducto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
