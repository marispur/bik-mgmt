/*
 * HistoryTableModel.java
 *
 * Created on pirmdiena, 2007, 21 maijs, 22:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Query;

/**
 *
 * @author mpurins
 */
public class HistoryTableModel extends AbstractTableModel{
    private static final String[] columnTitles = {
        "Datums", "Lietotâjs","Apraksts"};
    Integer objId;
    int objType;
    List historyEventsList = null;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    /** Creates a new instance of HistoryTableModel */
    public HistoryTableModel() {
    }
    
    public void setParent(Integer objIdVal, int objTypeVal ){
        historyEventsList = getBikObjectHistoryList(objIdVal,objTypeVal);
        if (historyEventsList==null) return ;
        fireTableDataChanged();
    }
    
    public int getRowCount() {
        if (historyEventsList==null) return 0;
        return historyEventsList.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (historyEventsList==null) return null;
        if (rowIndex >= historyEventsList.size()) return null;
        if (columnIndex > getColumnCount()-1) return null;
        HistoryEvent he = (HistoryEvent)historyEventsList.get(rowIndex);
        switch (columnIndex) {
            case 0: return dateFormat.format(he.getDate());
            case 1: return he.getModifiedBy();
            case 2: return he.getMessage();
            default: return null;
        }
    }

    /**
     *  Returns a default name for the column using spreadsheet conventions:
     *  A, B, C, ... Z, AA, AB, etc.  If <code>column</code> cannot be found,
     *  returns an empty string.
     * 
     * 
     * @param column  the column being queried
     * @return a string containing the default name of <code>column</code>
     */
    public String getColumnName(int column) {
        if (column >= columnTitles.length || column < 0) return "";
        return columnTitles[column];
    }
     /** 
     * Returns history object list for sepcified BIK object
     * Return null = if no records found
     */

    private List getBikObjectHistoryList(Integer idVal, int objTypeVal) {
        List rv=null;
        Query q = HibernateUtil.getCurrentSession().getNamedQuery("HistoryEvent.findByTarget");
        q.setParameter("objId", idVal);
        q.setParameter("objType", objTypeVal);
        rv=q.list();
        if (rv.size()==0) return null;
        return rv;
    }
   
}
