/*
 * PriceList.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 15:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreeModel;
import org.hibernate.*;

/**
 * returns tree model with prices
 * @author mpurins
 */
public class PriceList extends AbstractTableModel{
    private static final String[] columnTitles = {
        "Kods", "Kategorija","Nosaukums", "Avots", "Mçra vien.","Cena, Ls"};
    private List prices=null;
    private Session hibernateSession;
    private String filter = "";

    /** Creates a new instance of PriceList */
    public PriceList(Session sVal) {
        this.setHibernateSession(sVal);
        setFilter("");
    }
    
    public void setFilter(String filterVal){
        Query q = HibernateUtil.getCurrentSession().getNamedQuery("PriceDef.universalFilter");
        if (filterVal==null || filterVal==""){
            q.setParameter("filterString", "no or missing data");
            q.setParameter("filterStringInteger", 0);
        } else {
            this.filter = filterVal;
            q.setParameter("filterString", "%"+ filterVal.trim()+"%");
            try {
                q.setParameter("filterStringInteger", Integer.valueOf(filterVal.trim()));
            } catch (NumberFormatException ex) {
                q.setParameter("filterStringInteger", 0);
            }
        }
        
        this.prices = q.list();
        this.fireTableDataChanged();
    }
    
    public void refreshData(){
        setFilter(this.filter);
        this.fireTableDataChanged();
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (this.prices==null) return null;
        PriceDef pd = (PriceDef) prices.get(rowIndex);
        switch (columnIndex) {
            case 0: return pd.getId();
            case 1: return pd.getCategory();
            case 2: return pd.getName();
            case 3: return pd.getSource();
            case 4: return pd.getMeasure();
            case 5: return pd.getUnitPrice();
            default: return null;
        }
    }

    public int getRowCount() {
        return prices.size();        
    }

    public int getColumnCount() {
        return 6;
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
        if (column<= columnTitles.length) return columnTitles[column];
        return "";
    }

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }
    
}
