/*
 * BikCatalog.java
 *
 * Created on pirmdiena, 2007, 16 apr�lis, 12:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ProgressMonitor;
import org.hibernate.*;

/**
 *
 * @author mpurins
 */
public class BikCatalog extends AbstractBikDataObject {
    
    private String name = "BIK 2007";
    private Collection<BikSection> bikSectionCollection;
    
    /** Creates a new instance of BikCatalog */
    public BikCatalog() {
    }
    
    /** Creates a new instance of BikCatalog */
    public BikCatalog(Session s) {
        bikSectionCollection = s.createQuery("from data.BikSection s order by s.code").list();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<BikSection> getBikSectionCollection() {
        return bikSectionCollection;
    }
    
    public void setBikSectionCollection(Collection<BikSection> bikSectionCollection) {
        this.bikSectionCollection = bikSectionCollection;
    }

    public BikObjType getObjType() {
        return BikObjType.CATALOG;
    }

    public void bikSave(Session s) {
        return ;
    }

    public Date getDateCreated() {
        return null;
    }

    public Date getDateDeleted() {
        return null;
    }

    public Date getDateModified() {
        return null;
    }

    public String getDeletedBy() {
        return null;
    }

    public String getModifiedBy() {
        return null;
    }

    public void delete(String userName) {
        return ;
    }

    public Integer getId() {
        return 0;
    }

    public Boolean isNotForPrint() {
        return false;
    }

    public void setNotForPrint(Boolean notForPrint) {
    }

    public Boolean isNeedProofReading() {
        return false;
    }

    public void setNeedProofReading(Boolean needProofReading) {
    }

    public Boolean isDeleted() {
        return false;
    }

    public void setDeleted(Boolean delStatus) {
    }

    public void setDeletedBy(String delBy) {
    }

    public void setDateDeleted(Date dateDeleted) {
    }
    
    public void exportToFileForTypesetting(java.io.PrintWriter output, ProgressMonitor pm){
        Iterator<BikSection> i = this.getBikSectionCollection().iterator();
        pm.setMaximum(this.getBikSectionCollection().size());
        int progressCounter=0;
        while (i.hasNext()) {
            progressCounter += 1;
            BikSection currentSection = i.next();
            pm.setProgress(progressCounter);
            pm.setNote("Eksport�ju: "+currentSection.getCode()+" "+currentSection.getName());
            currentSection.exportToFileForTypesetting(output, pm);
        }
    }

    public Integer exportToFileForBasicXML(PrintWriter output, ProgressMonitor pm, Integer seqId) {
        
        output.println("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        output.println("<item>");
        Iterator<BikSection> i = this.getBikSectionCollection().iterator();
        pm.setMaximum(this.getBikSectionCollection().size());
        int progressCounter=0;
        int localOrder=0;
        while (i.hasNext()) {
            progressCounter += 1;
            BikSection currentSection = i.next();
            pm.setProgress(progressCounter);
            pm.setNote("Eksport�ju: "+currentSection.getCode()+" "+currentSection.getName());
            seqId = currentSection.exportToFileForBasicXML(output, pm, seqId, localOrder);
            localOrder+=1;
        }
        output.println("</item>");
        return seqId;
    }
}