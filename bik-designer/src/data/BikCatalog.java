/*
 * BikCatalog.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:51
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
import java.util.Formatter;

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
            pm.setNote("Eksportçju: "+currentSection.getCode()+" "+currentSection.getName());
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
            pm.setNote("Eksportçju: "+currentSection.getCode()+" "+currentSection.getName());
            seqId = currentSection.exportToFileForBasicXML(output, pm, seqId, localOrder);
            localOrder+=1;
        }
        output.println("</item>");
        return seqId;
    }
    public Integer exportToFileForExtendedXML(PrintWriter output, ProgressMonitor pm, Integer seqId) {
        
        String priceProviderId = new String("999");
        
        output.println("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        output.println("<settings>");
        // Tagad exportçjam normatîvus (darbu veidus)
        output.println("<standart>");
        Iterator<BikSection> i = this.getBikSectionCollection().iterator();
        pm.setMaximum(this.getBikSectionCollection().size());
        int progressCounter=0;
        int localOrder=0;
        while (i.hasNext()) {
            progressCounter += 1;
            BikSection currentSection = i.next();
            pm.setProgress(progressCounter);
            pm.setNote("Eksportçju: "+currentSection.getCode()+" "+currentSection.getName());
            seqId = currentSection.exportToFileForExtendedXML(output, pm, seqId, localOrder);
            localOrder+=1;
        }
        output.println("</standart>");
        // Tagad exportçjam cenu datu bâzi
        output.println("<defaults>");
        
        seqId++;
        output.print("\t<item id=\""+ seqId.toString() + "\"");
        output.print(" name=\"Sadaïa (eBIK materiâli\"");
        output.print(" type=\"64\"");
        output.printf(" order=\"%d\"", 0);
        output.print(" code=\"\"");
        output.print(" comment=\"\"");
        output.printf(" provider_id=\"%s\"", priceProviderId);
        output.print(" provider_root=\"1\"");
        output.println(" />");

        Iterator<PriceDef> priceIterator = HibernateUtil.getCurrentSession().createQuery("from data.PriceDef pd order by pd.category, pd.name").list().iterator();
        PriceDef curPrice;
        Integer priceOrder = new Integer(0);
        Formatter fmt = new Formatter(output);
        pm.setMinimum(0);
        pm.setMaximum(10);
        pm.setProgress(9);
        
        while (priceIterator.hasNext())
        {
            curPrice = priceIterator.next();

            //System.out.printf("Price id:%d\n",curPrice.getId());
            pm.setNote("Eksportçju cenu ar ID:"+curPrice.getId().toString());

            seqId++;
            output.print("\t\t<subitem id=\""+ curPrice.getId().toString() + "\"");
            output.printf(" name=\"%s: %s\"",prepareForXMLOutput(curPrice.getCategory().trim()),prepareForXMLOutput(curPrice.getName().trim()));
            output.print(" type=\"64\"");
            output.printf(" order=\"%d\"", priceOrder);
            output.print(" code=\"\"");
            output.printf(" comment=\"%s\"",prepareForXMLOutput(curPrice.getSource()));
            output.printf(" unit=\"%s\"",prepareForXMLOutput(curPrice.getMeasure()));
            output.printf(" provider_id=\"%s\"", prepareForXMLOutput(priceProviderId));
            output.println(">");

            
            output.print("\t\t\t<price id=\"-"+ curPrice.getId().toString() + "\"");
            output.printf(" order=\"%d\"", 0);
            output.printf(" price_group=\"%d\"", 1);
            output.printf(" date_modified=\"%d\"", curPrice.getDateModified().getTime());
            output.printf(" provider_id=\"%s\"", prepareForXMLOutput(priceProviderId));
            output.printf(" source=\"eBIK\"");
            output.printf(" amount=\"%.4f\"",curPrice.getUnitPrice().floatValue());
            output.println(" />");
            
            output.println("\t\t</subitem>");
            priceOrder++;
        }
        
        output.println("</defaults>");
        output.println("</settings>");
        return seqId;
    }
}
