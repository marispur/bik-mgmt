/*
 * IBikDataObject.java
 *
 * Created on tre�diena, 2007, 18 apr�lis, 16:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author mpurins
 */
public interface IBikDataObject {
    public BikObjType getObjType();
    public void bikSave(Session s);
    public Date getDateCreated();
    
    public Date getDateDeleted();
    
    public Date getDateModified();
    
    public String getDeletedBy();
    
    public String getModifiedBy();
    
    public Integer getId();
    
    public void delete(String userName);
}