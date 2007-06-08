/*
 * PriceDef.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;



/**
 * Entity class PriceDef
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_price_def")
@NamedQueries( {
        @NamedQuery(name = "PriceDef.findById", query = "SELECT p FROM PriceDef p WHERE p.id = :id"),
        @NamedQuery(name = "PriceDef.findByCode", query = "SELECT p FROM PriceDef p WHERE p.code = :code"),
        @NamedQuery(name = "PriceDef.findByDateCreated", query = "SELECT p FROM PriceDef p WHERE p.dateCreated = :dateCreated"),
        @NamedQuery(name = "PriceDef.findByDateModified", query = "SELECT p FROM PriceDef p WHERE p.dateModified = :dateModified"),
        @NamedQuery(name = "PriceDef.findByModifiedBy", query = "SELECT p FROM PriceDef p WHERE p.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "PriceDef.findByName", query = "SELECT p FROM PriceDef p WHERE p.name = :name"),
        @NamedQuery(name = "PriceDef.findByDeleted", query = "SELECT p FROM PriceDef p WHERE p.deleted = :deleted"),
        @NamedQuery(name = "PriceDef.findByDateDeleted", query = "SELECT p FROM PriceDef p WHERE p.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "PriceDef.findByDeletedBy", query = "SELECT p FROM PriceDef p WHERE p.deletedBy = :deletedBy"),
        @NamedQuery(name = "PriceDef.findByCategory", query = "SELECT p FROM PriceDef p WHERE p.category = :category"),
        @NamedQuery(name = "PriceDef.findByMeasure", query = "SELECT p FROM PriceDef p WHERE p.measure = :measure"),
        @NamedQuery(name = "PriceDef.findByUnitPrice", query = "SELECT p FROM PriceDef p WHERE p.unitPrice = :unitPrice"),
        @NamedQuery(name = "PriceDef.findBySource", query = "SELECT p FROM PriceDef p WHERE p.source = :source"),
        @NamedQuery(name = "PriceDef.universalFilter", query = "SELECT p FROM PriceDef p WHERE p.id = :filterStringInteger OR upper(p.name) LIKE upper(:filterString) OR upper(p.category) LIKE upper(:filterString) OR upper(p.source) LIKE upper(:filterString)")
    })
public class PriceDef implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "date_deleted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted;

    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "category")
    private String category;

    @Column(name = "measure")
    private String measure;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "source")
    private String source;
    
    /** Creates a new instance of PriceDef */
    public PriceDef() {
    }

    /**
     * Creates a new instance of PriceDef with the specified values.
     * @param id the id of the PriceDef
     */
    public PriceDef(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this PriceDef.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this PriceDef to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the code of this PriceDef.
     * @return the code
     */
    public String getCode() {
        if (this.code==null) return new String("");
        return this.code;
    }

    /**
     * Sets the code of this PriceDef to the specified value.
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the dateCreated of this PriceDef.
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Sets the dateCreated of this PriceDef to the specified value.
     * @param dateCreated the new dateCreated
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets the dateModified of this PriceDef.
     * @return the dateModified
     */
    public Date getDateModified() {
        return this.dateModified;
    }

    /**
     * Sets the dateModified of this PriceDef to the specified value.
     * @param dateModified the new dateModified
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * Gets the modifiedBy of this PriceDef.
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        if (this.modifiedBy==null) return new String("");
        return this.modifiedBy;
    }

    /**
     * Sets the modifiedBy of this PriceDef to the specified value.
     * @param modifiedBy the new modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the name of this PriceDef.
     * @return the name
     */
    public String getName() {
        if (this.name==null) return new String("");
        return this.name;
    }

    /**
     * Sets the name of this PriceDef to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the deleted of this PriceDef.
     * @return the deleted
     */
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Sets the deleted of this PriceDef to the specified value.
     * @param deleted the new deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Gets the dateDeleted of this PriceDef.
     * @return the dateDeleted
     */
    public Date getDateDeleted() {
        return this.dateDeleted;
    }

    /**
     * Sets the dateDeleted of this PriceDef to the specified value.
     * @param dateDeleted the new dateDeleted
     */
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    /**
     * Gets the deletedBy of this PriceDef.
     * @return the deletedBy
     */
    public String getDeletedBy() {
        if (this.deletedBy==null) return new String("");
        return this.deletedBy;
    }

    /**
     * Sets the deletedBy of this PriceDef to the specified value.
     * @param deletedBy the new deletedBy
     */
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    /**
     * Gets the category of this PriceDef.
     * @return the category
     */
    public String getCategory() {
        if (this.category==null) return "";
        return this.category;
    }

    /**
     * Sets the category of this PriceDef to the specified value.
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the measure of this PriceDef.
     * @return the measure
     */
    public String getMeasure() {
        return this.measure;
    }

    /**
     * Sets the measure of this PriceDef to the specified value.
     * @param measure the new measure
     */
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    /**
     * Gets the unitPrice of this PriceDef.
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets the unitPrice of this PriceDef to the specified value.
     * @param unitPrice the new unitPrice
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the source of this PriceDef.
     * @return the source
     */
    public String getSource() {
        if (this.source==null) return new String("");
        return this.source;
    }

    /**
     * Sets the source of this PriceDef to the specified value.
     * @param source the new source
     */
    public void setSource(String source) {
        this.source = source;
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
     * Determines whether another object is equal to this PriceDef.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PriceDef object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceDef)) {
            return false;
        }
        PriceDef other = (PriceDef)object;
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
        return "data.PriceDef[id=" + id + "]";
    }
    
    /**
     * Returns a price definition object instance who's ID is supplied
     * @param idVal String containing ID of a price definition to find
     * @return price definition object or null if ID is invalid e.g. cannot find
     * price definition with such ID
     */
    static public PriceDef getPriceDefById(String idVal) {
        PriceDef rv = null;
        Query q = HibernateUtil.getCurrentSession()
            .getNamedQuery("PriceDef.findById");

        try {
            q.setParameter("id", Integer.valueOf(idVal.trim()));
        } catch (NumberFormatException ex) {
            // cannot parse supplied string into integer
            return null;
        }
        List pDefList = q.list();
        if (!pDefList.isEmpty()) {
            rv = (PriceDef) pDefList.iterator().next();
        }
        return rv;
    }
}
