package model;

import java.sql.SQLException;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Piaa FernanDaa
 */
public class TMSushi implements TableModel{
        private List<Producto> sushi;

        
    public TMSushi(List<Producto> sushi) throws SQLException{
        this.sushi = sushi;

    }   
        
    @Override
    public int getRowCount() {
       return sushi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "id";
            case 1: return "Nombre";
            case 2: return "Precio";             
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
        Producto p = sushi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getNombre();
            case 2:
                return p.getPrecio();
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
