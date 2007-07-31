/*
 * AbstractBikDataObject.java
 *
 * Created on treðdiena, 2007, 13 jûnijs, 16:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;
import bikdesigner.HibernateUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OrderBy;

/**
 *
 * @author Maris
 */
@MappedSuperclass
public abstract class AbstractBikDataObject implements IBikDataObject {
    
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    protected Integer id;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateModified;

    @Column(name = "modified_by")
    protected String modifiedBy;
    
    @Column(name = "deleted")
    protected Boolean deleted;

    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateDeleted;

    @Column(name = "deleted_by")
    protected String deletedBy;
    
    @Column(name = "not_for_print")
    protected Boolean notForPrint;
    
    @Column(name = "need_proofreading")
    protected Boolean needProofReading;


    /** Creates a new instance of AbstractBikDataObject */
    public AbstractBikDataObject() {
    }


    public void bikSave(Session s) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().saveOrUpdate(this);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }


    public void delete(String userName) {
        setDeleted(true);
        setDeletedBy(userName);
    }


    /**
     * Gets the dateCreated of this BikSubsection.
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }


    /**
     * Gets the dateDeleted of this BikSubsection.
     * @return the dateDeleted
     */
    public Date getDateDeleted() {
        return this.dateDeleted;
    }


    /**
     * Gets the dateModified of this BikSubsection.
     * @return the dateModified
     */
    public Date getDateModified() {
        return this.dateModified;
    }


    /**
     * Gets the deleted of this BikSubsection.
     * @return the deleted
     */
    public Boolean getDeleted() {
        if (this.deleted==null) return false;
        return this.deleted;
    }


    /**
     * Gets the deletedBy of this BikSubsection.
     * @return the deletedBy
     */
    public String getDeletedBy() {
        if (this.deletedBy==null) return new String("");
        return this.deletedBy;
    }


    /**
     * Gets the id of this BikSubsection.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }


    /**
     * Gets the modifiedBy of this BikSubsection.
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        if (this.modifiedBy==null)            return new String("");
        return this.modifiedBy;
    }


    public Boolean isDeleted() {
        return getDeleted();
    }


    public Boolean isNeedProofReading() {
        if (needProofReading==null) return false;
        return needProofReading;
    }

    public Boolean isNotForPrint() {
        if (notForPrint==null) return false;
        return notForPrint;
    }


    /**
     * Sets the dateCreated of this BikSubsection to the specified value.
     * @param dateCreated the new dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    /**
     * Sets the dateDeleted of this BikSubsection to the specified value.
     * @param dateDeleted the new dateDeleted
     */
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }


    /**
     * Sets the dateModified of this BikSubsection to the specified value.
     * @param dateModified the new dateModified
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }


    /**
     * Sets the deleted of this BikSubsection to the specified value.
     * @param deleted the new deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * Sets the deletedBy of this BikSubsection to the specified value.
     * @param deletedBy the new deletedBy
     */
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }


    /**
     * Sets the id of this BikSubsection to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Sets the modifiedBy of this BikSubsection to the specified value.
     * @param modifiedBy the new modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    public void setNeedProofReading(Boolean needProofReading) {
        this.needProofReading = needProofReading;
    }


    public void setNotForPrint(Boolean notForPrint) {
        this.notForPrint = notForPrint;
    }

    public Boolean hasDeletedChildren() {
        return false;
    }
    
    public Boolean hasNeedProofreadingChildren() {
        return false;
    }
    
    public Boolean hasNotForPrintChildren() {
        return false;
    }
    
    public void exportToFileForTypesetting(java.io.PrintWriter output){
        output.println(this.toString());
    }

}
