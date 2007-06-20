/*
 * BikWorkItem.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OrderBy;



/**
 * Entity class BikWorkItem
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_wi")
@NamedQueries( {
        @NamedQuery(name = "BikWorkItem.findById", query = "SELECT b FROM BikWorkItem b WHERE b.id = :id"),
        @NamedQuery(name = "BikWorkItem.findByCode", query = "SELECT b FROM BikWorkItem b WHERE b.code = :code"),
        @NamedQuery(name = "BikWorkItem.findByDateCreated", query = "SELECT b FROM BikWorkItem b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = "BikWorkItem.findByDateModified", query = "SELECT b FROM BikWorkItem b WHERE b.dateModified = :dateModified"),
        @NamedQuery(name = "BikWorkItem.findByModifiedBy", query = "SELECT b FROM BikWorkItem b WHERE b.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "BikWorkItem.findByName", query = "SELECT b FROM BikWorkItem b WHERE b.name = :name"),
        @NamedQuery(name = "BikWorkItem.findByDeleted", query = "SELECT b FROM BikWorkItem b WHERE b.deleted = :deleted"),
        @NamedQuery(name = "BikWorkItem.findByDateDeleted", query = "SELECT b FROM BikWorkItem b WHERE b.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "BikWorkItem.findByDeletedBy", query = "SELECT b FROM BikWorkItem b WHERE b.deletedBy = :deletedBy"),
        @NamedQuery(name = "BikWorkItem.findByMeasure", query = "SELECT b FROM BikWorkItem b WHERE b.measure = :measure")
    })
public class BikWorkItem extends AbstractBikDataObject implements Serializable {

    @Column(name = "code")
    private String code = "";

    @Column(name = "name")
    private String name="";

    @Column(name = "measure")
    private String measure="";

    @JoinColumn(name = "subsection", referencedColumnName = "id")
    @ManyToOne
    private BikSubsection subsection;

    @OneToMany(mappedBy = "wi")
    @OrderBy(clause="type, id")
    private Collection<BikWorkItemComponent> bikWorkItemComponentCollection;
    
    /** Creates a new instance of BikWorkItem */
    public BikWorkItem() {
    }

    /**
     * Creates a new instance of BikWorkItem with the specified values.
     * @param id the id of the BikWorkItem
     */
    public BikWorkItem(Integer id) {
        this.id = id;
    }

    /**
     * Gets the code of this BikWorkItem.
     * @return the code
     */
    public String getCode() {
        if (this.code==null) return "";
        return this.code;
    }

    /**
     * Sets the code of this BikWorkItem to the specified value.
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the name of this BikWorkItem.
     * @return the name
     */
    public String getName() {
        if (this.name==null) return "";
        return this.name;
    }

    /**
     * Sets the name of this BikWorkItem to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the measure of this BikWorkItem.
     * @return the measure
     */
    public String getMeasure() {
        if (this.measure==null) return new String("");
        return this.measure;
    }

    /**
     * Sets the measure of this BikWorkItem to the specified value.
     * @param measure the new measure
     */
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    /**
     * Gets the subsection of this BikWorkItem.
     * @return the subsection
     */
    public BikSubsection getSubsection() {
        return this.subsection;
    }

    /**
     * Sets the subsection of this BikWorkItem to the specified value.
     * @param subsection the new subsection
     */
    public void setSubsection(BikSubsection subsection) {
        this.subsection = subsection;
    }

    /**
     * Gets the bikWorkItemComponentCollection of this BikWorkItem.
     * @return the bikWorkItemComponentCollection
     */
    public Collection<BikWorkItemComponent> getBikWorkItemComponentCollection() {
        return this.bikWorkItemComponentCollection;
    }

    /**
     * Sets the bikWorkItemComponentCollection of this BikWorkItem to the specified value.
     * @param bikWorkItemComponentCollection the new bikWorkItemComponentCollection
     */
    public void setBikWorkItemComponentCollection(Collection<BikWorkItemComponent> bikWorkItemComponentCollection) {
        this.bikWorkItemComponentCollection = bikWorkItemComponentCollection;
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
     * Determines whether another object is equal to this BikWorkItem.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikWorkItem object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikWorkItem)) {
            return false;
        }
        BikWorkItem other = (BikWorkItem)object;
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
        return "data.BikWorkItem[id=" + id + "]";
    }

    public BikObjType getObjType() {
        return BikObjType.WORK_ITEM;
    }

    public BigDecimal getMaterials(){
        BigDecimal rv = new BigDecimal(0);
        BikWorkItemComponent curWic;
        Iterator wicIt = getBikWorkItemComponentCollection().iterator();
        while(wicIt.hasNext()){
            curWic = (BikWorkItemComponent) wicIt.next();
            if (!curWic.getDeleted()) rv = rv.add(curWic.getMaterials());
        }
        return rv;
    }
    public BigDecimal getDepreciation(){
        BigDecimal rv = new BigDecimal(0);
        BikWorkItemComponent curWic;
        Iterator wicIt = getBikWorkItemComponentCollection().iterator();
        while(wicIt.hasNext()){
            curWic = (BikWorkItemComponent) wicIt.next();
            if (!curWic.getDeleted()) rv = rv.add(curWic.getDepreciation());
        }
        return rv;
    }
    public BigDecimal getLabour(){
        BigDecimal rv = new BigDecimal(0);
        BikWorkItemComponent curWic;
        Iterator wicIt = getBikWorkItemComponentCollection().iterator();
        while(wicIt.hasNext()){
            curWic = (BikWorkItemComponent) wicIt.next();
            if (!curWic.getDeleted()) rv = rv.add(curWic.getLabour());
        }
        return rv;
    }
    public BigDecimal getLabourNorm(){
        // TODO: mathematics is not corect here in case there is more than one 
        // labour work component 

        BigDecimal rv = new BigDecimal(0);
        BikWorkItemComponent curWic;
        Iterator wicIt = getBikWorkItemComponentCollection().iterator();
        while(wicIt.hasNext()){
            curWic = (BikWorkItemComponent) wicIt.next();
            if (!curWic.getDeleted()) rv = rv.add(curWic.getLabourNorm());
        }
        return rv;
    }
    public BigDecimal getLabourCost(){
        // TODO: mathematics is not corect here in case there is more than one 
        // labour work component 
        BigDecimal rv = new BigDecimal(0);
        BikWorkItemComponent curWic;
        Iterator wicIt = getBikWorkItemComponentCollection().iterator();
        while(wicIt.hasNext()){
            curWic = (BikWorkItemComponent) wicIt.next();
            if (!curWic.getDeleted()) rv = rv.add(curWic.getLabourCost());
        }
        return rv;
    }

    public Boolean isDeleted() {
        Boolean retValue;
        if (getSubsection().getDeleted()) return true;
        retValue = this.deleted;
        return retValue;
    }
    
}
