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
import javax.swing.ProgressMonitor;
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
public class BikComment extends AbstractBikDataObject implements Serializable {


    @Column(name = "parent_type")
    protected  Integer parentType;

    @Column(name = "parent_id")
    protected Integer parentId;

    @Column(name = "print_sequence")
    private Integer printSequence;

    @Column(name = "body")
    private String body;

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
    public void exportToFileForTypesetting(java.io.PrintWriter output, ProgressMonitor pm){
        if (!this.isDeleted() && !this.isNotForPrint()) {
            output.printf("%s%n", this.getBody().trim());
        }
    }
    
}
