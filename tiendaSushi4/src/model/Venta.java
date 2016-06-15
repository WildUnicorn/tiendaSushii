
package model;

/**
 *
 * @author Piaa FernanDaa
 */
public class Venta {
    int id;
    int total;

    public Venta() {
    }

    public Venta(int id, int total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
