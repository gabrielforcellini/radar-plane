package telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import classes.Aviao;

@SuppressWarnings("serial")
public class TAviaoTableModel  extends AbstractTableModel {
	private static final int COL_ID = 0;
    private static final int COL_X = 1;
    private static final int COL_Y = 2;
    private static final int COL_R = 3;
    private static final int COL_A = 4;
    private static final int COL_V = 5;
    private static final int COL_D = 6;
    
    private final String[] columns = new String[] {"ID", "X", "Y", "R", "A", "V", "D"};
    private List<Aviao> lines;
    
    public TAviaoTableModel() {
        this.lines = new ArrayList<>();
    }
    
    public int getRowCount() {
        return this.lines.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return Double.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    @Override
    public Object getValueAt(int row, int column) {
        Aviao m = lines.get(row);
 
        switch (column) {
            case COL_ID:
                return m.getCodigo();
            case COL_X:
                return m.getPontoX();
            case COL_Y:
                return m.getPontoY();
            case COL_R:
                return m.getRaio();
            case COL_A:
                return m.getAngulo();
            case COL_V:
                return m.getVelocidade();
            case COL_D:
                return m.getDirecao();
            default:
                break;
        }
        
        return 0.0;
    }
 
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Aviao u = lines.get(row);
        
        switch (column) {
            case COL_ID:
                u.setCodigo((Integer) aValue);
                break;
            case COL_X:
                u.setPontoX((Double) aValue);
                break;
            case COL_Y:
                u.setPontoY((Double) aValue);
                break;
            case COL_R:
                u.setRaio((Double) aValue);
                break;
            case COL_A:
                u.setAngulo((Double) aValue);
                break;
            case COL_V:
                u.setVelocidade((Double) aValue);
                break;
            case COL_D:
                u.setDirecao((Double) aValue);
                break;
            default:
                break;
        }
    }
    
    public Aviao getPlane(int indiceLinha) {
        return lines.get(indiceLinha);
    }
 
    public void addAviao(Aviao aviao) {
        aviao.setCodigo(getNextCode());
        lines.add(aviao);
        int lastIndex = getRowCount() - 1;
        fireTableRowsInserted(lastIndex, lastIndex);
    }
    
    public void update() {
        fireTableRowsInserted(0, lines.size() - 1);
    }
 
    public void removeAviao(int lineIndex) {
        lines.remove(lineIndex);
        fireTableRowsDeleted(lineIndex, lineIndex);
    }
    
    private int getNextCode() {
        int nextCode = 1;
        
        if (lines.size() == 0) {
            return nextCode;
        }
        
        for (Aviao a : lines) {
            if (a.getCodigo() >= nextCode) {
            	nextCode = a.getCodigo() + 1;
            }
        }
        
        return nextCode;
    }
}
