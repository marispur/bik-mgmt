/*
 * BikSubsection.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:45
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
public class BikSubsection implements Serializable, IBikDataObject {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code")
    private String code="";

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column(name = "modified_by")
    private String modifiedBy="";

    @Column(name = "name")
    private String name="";

    @Column(name = "description")
    private String description="";

    @Column(name = "deleted")
    private Boolean deleted=false;

    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @Column(name = "deleted_by")
    private String deletedBy="";

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

    @Column(name = "not_for_print")
    private Boolean notForPrint;
    
    @Column(name = "need_proofreading")
    private Boolean needProofReading;

    
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
     * Gets the id of this BikSubsection.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this BikSubsection to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
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
     * Gets the dateCreated of this BikSubsection.
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Sets the dateCreated of this BikSubsection to the specified value.
     * @param dateCreated the new dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets the dateModified of this BikSubsection.
     * @return the dateModified
     */
    public Date getDateModified() {
        return this.dateModified;
    }

    /**
     * Sets the dateModified of this BikSubsection to the specified value.
     * @param dateModified the new dateModified
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * Gets the modifiedBy of this BikSubsection.
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        if (this.modifiedBy==null) return new String("");
        return this.modifiedBy;
    }

    /**
     * Sets the modifiedBy of this BikSubsection to the specified value.
     * @param modifiedBy the new modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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
     * Gets the deleted of this BikSubsection.
     * @return the deleted
     */
    public Boolean getDeleted() {
        if (getSection().getDeleted()) return true;
        return this.deleted;
    }

    /**
     * Sets the deleted of this BikSubsection to the specified value.
     * @param deleted the new deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Gets the dateDeleted of this BikSubsection.
     * @return the dateDeleted
     */
    public Date getDateDeleted() {
        return this.dateDeleted;
    }

    /**
     * Sets the dateDeleted of this BikSubsection to the specified value.
     * @param dateDeleted the new dateDeleted
     */
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
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
     * Sets the deletedBy of this BikSubsection to the specified value.
     * @param deletedBy the new deletedBy
     */
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
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

    public void bikSave(Session s) {
        s.beginTransaction();
        s.update(this);
        s.getTransaction().commit();

    }

    public void delete(String userName) {
        setDeleted(true);
        setDeletedBy(userName);
    }

    public Collection<BikComment> getBikComments() {
        return bikComments;
    }

    public void setBikComments(Collection<BikComment> bikComments) {
        this.bikComments = bikComments;
    }
    public Boolean isNotForPrint() {
        if (notForPrint==null) return false;
        return notForPrint;
    }

    public void setNotForPrint(Boolean notForPrint) {
        this.notForPrint = notForPrint;
    }

    public Boolean isNeedProofReading() {
        if (needProofReading==null) return false;
        return needProofReading;
    }

    public void setNeedProofReading(Boolean needProofReading) {
        this.needProofReading = needProofReading;
    }

    public boolean isDeleted() {
        return getDeleted();
    }
    
}
