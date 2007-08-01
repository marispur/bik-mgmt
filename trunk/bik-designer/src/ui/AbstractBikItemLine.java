/*
 * AbstractBikItemLine.java
 *
 * Created on treðdiena, 2007, 18 aprîlis, 16:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ui;

import data.IBikDataObject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author mpurins
 */
public abstract class AbstractBikItemLine extends JPanel implements IBikItemLine {

    protected MainWindow mw=null;
    
    protected data.IBikDataObject bikDataObject;

    // protected static final Color backgroundColor = new Color(212,208,200,255);
    protected static final Color backgroundColor = new Color(248,248,248,255);
    
    protected static final Color editableFieldBackgroundColor = Color.WHITE;
    
    protected static final Color deletedItemColor = Color.PINK;
    
    protected static final Color selectedLineBackgroundColor = new Color(204,204,255,255);
    
    protected static final Font fieldFont = new java.awt.Font("Arial", 0, 11);
    
    /** Creates a new instance of AbstractBikItemLine */
    public AbstractBikItemLine() {
    }
    
    abstract public Boolean isPriceDefUser();
    
    public IBikDataObject getBikDataObject() {
        return bikDataObject;
    }
    
    public void setBikDataObject(IBikDataObject objVal) {
        bikDataObject = objVal;
        updateUiComponents();
        decorateLine();
    }
    
    
    public MainWindow getMainWindow(IBikItemLine comp) {
        if (mw!=null) return mw;
        try {
            this.mw = (MainWindow)((Component)comp).getParent().getParent().getParent().
                    getParent().getParent().getParent().getParent().getParent();
            return mw;
        } catch (NullPointerException ex){
            return null;
        }
    }
    
    public void selectLine(IBikItemLine comp){
        if (getMainWindow(comp)!=null) {
            if (getMainWindow(comp).getSelectedLine()==null) {
                getMainWindow(comp).setSelectedLine(comp);
            } else {
                if (!getMainWindow(comp).getSelectedLine().equals(comp))
                    getMainWindow(comp).setSelectedLine(comp);
            }
        }
    }
}
