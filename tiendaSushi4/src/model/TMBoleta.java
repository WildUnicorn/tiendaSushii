package model;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMBoleta implements TableModel {
    List<VentaProducto> ventaProducto;
    private Data d;

    public TMBoleta(List<VentaProducto> ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    @Override
    public int getRowCount() {
        return ventaProducto.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Producto";
            case 2:
                return "Cantidad";
            case 3:
                return "Subtotal";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VentaProducto vp = ventaProducto.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vp.getId();
            case 1:
                int id = vp.getIdProducto();

                 {
                    try {
                        Producto p = d.getProductoPorId(id);
                        return p.getNombre();
                    } catch (SQLException ex) {
                        Logger.getLogger(TMAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            case 2:
                return vp.getCantidadProductos();
            case 3:
                return vp.getSubTotal();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
