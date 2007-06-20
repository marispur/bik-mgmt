/*
 * BikSubsection.java
 *
 * Created on pirmdiena, 2007, 16 apr�lis, 12:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;
import org.hibernate.type.TrueFalseType;

/**
 * Entity class BikSubsection
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_subsection")
@NamedQueries( {
        @NamedQuery(name = "BikSubsection.findById", query = "SELECT b FROM BikSubsection b WHERE b.id = :id"),
        @NamedQuery(name = "BikSubsection.findByCode", query = "SELECT b FROM BikSubsection b WHERE b.code = :code"),
        @NamedQuery(name = "BikSubsection.findByDateCreated", query = "SELECT b FROM BikSubsection b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = "BikSubsection.findByDateModified", query = "SELECT b FROM BikSubsection b WHERE b.dateModified = :dateModified"),
        @NamedQuery(name = "BikSubsection.findByModifiedBy", query = "SELECT b FROM BikSubsection b WHERE b.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "BikSubsection.findByName", query = "SELECT b FROM BikSubsection b WHERE b.name = :name"),
        @NamedQuery(name = "BikSubsection.findByDescription", query = "SELECT b FROM BikSubsection b WHERE b.description = :description"),
        @NamedQuery(name = "BikSubsection.findByDeleted", query = "SELECT b FROM BikSubsection b WHERE b.deleted = :deleted"),
        @NamedQuery(name = "BikSubsection.findByDateDeleted", query = "SELECT b FROM BikSubsection b WHERE b.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "BikSubsection.findByDeletedBy", query = "SELECT b FROM BikSubsection b WHERE b.deletedBy = :deletedBy")
    })
public class BikSubsection extends AbstractBikDataObject implements Serializable {

    @Column(name = "code")
    private String code="";

    @Column(name = "name")
    private String name="";

    @Column(name = "description")
    private String description="";

    @OneToMany(mappedBy = "subsection")
    @OrderBy(clause="code, id")
    private Collection<BikWorkItem> bikWorkItemCollection;

    @JoinColumn(name = "section", referencedColumnName = "id")
    @ManyToOne
    private BikSection section;

    @OneToMany()
    @JoinColumn(name="parent_id")
    @OrderBy(clause="print_sequence")
    @Where(clause="parent_type=2") // This parameter must reflect ID of DB object type
    private Collection<BikComment> bikComments;
    
    /** Creates a new instance of BikSubsection */
    public BikSubsection() {
    }

    /**
     * Creates a new instance of BikSubsection with the specified values.
     * @param id the id of the BikSubsection
     */
    public BikSubsection(Integer id) {
        this.id = id;
    }

    /**
     * Gets the code of this BikSubsection.
     * @return the code
     */
    public String getCode() {
        if (this.code==null) return new String("");
        return this.code;
    }

    /**
     * Sets the code of this BikSubsection to the specified value.
     * @param code the new code
     */
    public void setCode(String code) {
        // TODO: add history handling
        this.code = code;
    }

    /**
     * Gets the name of this BikSubsection.
     * @return the name
     */
    public String getName() {
        if (this.name==null) return new String("");
        return this.name;
    }

    /**
     * Sets the name of this BikSubsection to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        // TODO: add history handling
        this.name = name;
    }

    /**
     * Gets the description of this BikSubsection.
     * @return the description
     */
    public String getDescription() {
        if (this.description==null) return new String("");
        return this.description;
    }

    /**
     * Sets the description of this BikSubsection to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the bikWorkItemCollection of this BikSubsection.
     * @return the bikWorkItemCollection
     */
    public Collection<BikWorkItem> getBikWorkItemCollection() {
        return this.bikWorkItemCollection;
    }

    /**
     * Sets the bikWorkItemCollection of this BikSubsection to the specified value.
     * @param bikWorkItemCollection the new bikWorkItemCollection
     */
    public void setBikWorkItemCollection(Collection<BikWorkItem> bikWorkItemCollection) {
        this.bikWorkItemCollection = bikWorkItemCollection;
    }

    /**
     * Gets the section of this BikSubsection.
     * @return the section
     */
    public BikSection getSection() {
        return this.section;
    }

    /**
     * Sets the section of this BikSubsection to the specified value.
     * @param section the new section
     */
    public void setSection(BikSection section) {
        this.section = section;
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
     * Determines whether another object is equal to this BikSubsection.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikSubsection object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikSubsection)) {
            return false;
        }
        BikSubsection other = (BikSubsection)object;
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
        return "data.BikSubsection[id=" + id + "]";
    }

    public BikObjType getObjType() {
        return BikObjType.SUBSECTION;
    }

    public Collection<BikComment> getBikComments() {
        return bikComments;
    }

    public void setBikComments(Collection<BikComment> bikComments) {
        this.bikComments = bikComments;
    }

    public Boolean isDeleted() {
        Boolean retValue;
        if (section.getDeleted()) return true;
        retValue = this.deleted;
        return retValue;
    }

    
}