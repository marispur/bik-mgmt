/*
 * HistoryTableColumnModel.java
 *
 * Created on ceturtdiena, 2007, 8 novembris, 23:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ui;

import java.util.Enumeration;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;

/**
 *
 * @author Maris
 */
public class HistoryTableColumnModel extends javax.swing.table.DefaultTableColumnModel{
    
    /**
     * Creates a new instance of HistoryTableColumnModel
     */
    public HistoryTableColumnModel() {
    }

    /**
     * Returns the <code>TableColumn</code> object for the column
     * at <code>columnIndex</code>.
     * 
     * 
     * @param columnIndex	the index of the column desired
     * @return the <code>TableColumn</code> object for the column
     * 				at <code>columnIndex</code>
     */
    public TableColumn getColumn(int columnIndex) {
        TableColumn retValue;
        
        retValue = super.getColumn(columnIndex);
        if (columnIndex==0) retValue.setPreferredWidth(50);
        if (columnIndex==1) retValue.setPreferredWidth(80);
        if (columnIndex==2) retValue.setPreferredWidth(130);
        return retValue;
    }

}
