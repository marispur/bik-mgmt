/*
 * BikComment.java
 *
 * Created on ceturtdiena, 2007, 31 maijs, 14:31
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
 * Entity class BikComment
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_comment")
@NamedQueries( {
        @NamedQuery(name = "BikComment.findById", query = "SELECT b FROM BikComment b WHERE b.id = :id"),
        @NamedQuery(name = "BikComment.findByParentType", query = "SELECT b FROM BikComment b WHERE b.parentType = :parentType"),
        @NamedQuery(name = "BikComment.findByParentId", query = "SELECT b FROM BikComment b WHERE b.parentId = :parentId"),
        @NamedQuery(name = "BikComment.findByDateCreated", query = "SELECT b FROM BikComment b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = "BikComment.findByDateModified", query = "SELECT b FROM BikComment b WHERE b.dateModified = :dateModified"),
        @NamedQuery(name = "BikComment.findByModifiedBy", query = "SELECT b FROM BikComment b WHERE b.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "BikComment.findByPrintSequence", query = "SELECT b FROM BikComment b WHERE b.printSequence = :printSequence"),
        @NamedQuery(name = "BikComment.findByBody", query = "SELECT b FROM BikComment b WHERE b.body = :body"),
        @NamedQuery(name = "BikComment.findByDeleted", query = "SELECT b FROM BikComment b WHERE b.deleted = :deleted"),
        @NamedQuery(name = "BikComment.findByDateDeleted", query = "SELECT b FROM BikComment b WHERE b.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "BikComment.findByDeletedBy", query = "SELECT b FROM BikComment b WHERE b.deletedBy = :deletedBy")
    })
public class BikComment implements Serializable, IBikDataObject {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "parent_type")
    private Integer parentType;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "print_sequence")
    private Integer printSequence;

    @Column(name = "body")
    private String body;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @Column(name = "deleted_by")
    private String deletedBy;
    
    /** Creates a new instance of BikComment */
    public BikComment() {
    }

    /**
     * Creates a new instance of BikComment with the specified values.
     * @param id the id of the BikComment
     */
    public BikComment(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this BikComment.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this BikComment to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the parentType of this BikComment.
     * @return the parentType
     */
    public Integer getParentType() {
        return this.parentType;
    }

    /**
     * Sets the parentType of this BikComment to the specified value.
     * @param parentType the new parentType
     */
    public void setParentType(Integer parentType) {
        this.parentType = parentType;
    }

    /**
     * Gets the parentId of this BikComment.
     * @return the parentId
     */
    public Integer getParentId() {
        return this.parentId;
    }

    /**
     * Sets the parentId of this BikComment to the specified value.
     * @param parentId the new parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets the dateCreated of this BikComment.
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Sets the dateCreated of this BikComment to the specified value.
     * @param dateCreated the new dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets the dateModified of this BikComment.
     * @return the dateModified
     */
    public Date getDateModified() {
        return this.dateModified;
    }

    /**
     * Sets the dateModified of this BikComment to the specified value.
     * @param dateModified the new dateModified
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * Gets the modifiedBy of this BikComment.
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    /**
     * Sets the modifiedBy of this BikComment to the specified value.
     * @param modifiedBy the new modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the printSequence of this BikComment.
     * @return the printSequence
     */
    public Integer getPrintSequence() {
        if (this.printSequence==null) return 0;
        return this.printSequence;
    }

    /**
     * Sets the printSequence of this BikComment to the specified value.
     * @param printSequence the new printSequence
     */
    public void setPrintSequence(Integer printSequence) {
        this.printSequence = printSequence;
    }

    /**
     * Gets the body of this BikComment.
     * @return the body
     */
    public String getBody() {
        if (this.body==null) return "";
        return this.body;
    }

    /**
     * Sets the body of this BikComment to the specified value.
     * @param body the new body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the deleted of this BikComment.
     * @return the deleted
     */
    public Boolean getDeleted() {
        if (this.deleted==null) return false;
        return this.deleted;
    }

    /**
     * Sets the deleted of this BikComment to the specified value.
     * @param deleted the new deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Gets the dateDeleted of this BikComment.
     * @return the dateDeleted
     */
    public Date getDateDeleted() {
        return this.dateDeleted;
    }

    /**
     * Sets the dateDeleted of this BikComment to the specified value.
     * @param dateDeleted the new dateDeleted
     */
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    /**
     * Gets the deletedBy of this BikComment.
     * @return the deletedBy
     */
    public String getDeletedBy() {
        return this.deletedBy;
    }

    /**
     * Sets the deletedBy of this BikComment to the specified value.
     * @param deletedBy the new deletedBy
     */
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this BikComment.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikComment object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikComment)) {
            return false;
        }
        BikComment other = (BikComment)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "data.BikComment[id=" + id + "]";
    }

    public BikObjType getObjType() {
        return BikObjType.COMMENT;
    }

    public void bikSave(Session s) {
        s.beginTransaction();
        s.update(this);
        s.getTransaction().commit();
    }

    public void delete(String userName) {
        setDeleted(true);
        setDeletedBy(userName);
    }
    
}
