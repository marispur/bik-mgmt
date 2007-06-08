/*
 * BikItemLine.java
 *
 * Created on treðdiena, 2007, 18 aprîlis, 16:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ui;

import data.IBikDataObject;
import java.util.Date;

/**
 *
 * @author mpurins
 */
public interface IBikItemLine {
    public void setBikDataObject(IBikDataObject objVal);
    public IBikDataObject getBikDataObject();

    public Boolean isPriceDefUser();

    public void updateUiComponents();
    
    public void decorateLine();
    
    public void expand();
}
