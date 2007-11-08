/*
 * BikWorkItemComponent.java
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
import javax.crypto.NullCipher;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
//import org.hibernate.annotations.*;
//import org.hibernate.*;

/**
 * Entity class BikWorkItemComponent
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_wic")
@NamedQueries( {
        @NamedQuery(name = "BikWorkItemComponent.findById", query = "SELECT b FROM BikWorkItemComponent b WHERE b.id = :id"),
        @NamedQuery(name = "BikWorkItemComponent.findByDateCreated", query = "SELECT b FROM BikWorkItemComponent b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = "BikWorkItemComponent.findByDateModified", query = "SELECT b FROM BikWorkItemComponent b WHERE b.dateModified = :dateModified"),
        @NamedQuery(name = "BikWorkItemComponent.findByModifiedBy", query = "SELECT b FROM BikWorkItemComponent b WHERE b.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "BikWorkItemComponent.findByName", query = "SELECT b FROM BikWorkItemComponent b WHERE b.name = :name"),
        @NamedQuery(name = "BikWorkItemComponent.findByMeasure", query = "SELECT b FROM BikWorkItemComponent b WHERE b.measure = :measure"),
        @NamedQuery(name = "BikWorkItemComponent.findByDeleted", query = "SELECT b FROM BikWorkItemComponent b WHERE b.deleted = :deleted"),
        @NamedQuery(name = "BikWorkItemComponent.findByDateDeleted", query = "SELECT b FROM BikWorkItemComponent b WHERE b.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "BikWorkItemComponent.findByDeletedBy", query = "SELECT b FROM BikWorkItemComponent b WHERE b.deletedBy = :deletedBy"),
        @NamedQuery(name = "BikWorkItemComponent.findByType", query = "SELECT b FROM BikWorkItemComponent b WHERE b.type = :type"),
        @NamedQuery(name = "BikWorkItemComponent.findByUnitPrice", query = "SELECT b FROM BikWorkItemComponent b WHERE b.unitPrice = :unitPrice"),
        @NamedQuery(name = "BikWorkItemComponent.findByQty", query = "SELECT b FROM BikWorkItemComponent b WHERE b.qty = :qty"),
        @NamedQuery(name = "BikWorkItemComponent.findByPriceDef", query = "SELECT b FROM BikWorkItemComponent b WHERE b.priceDef = :priceDef")
    })
public class BikWorkItemComponent extends AbstractBikDataObject implements Serializable {

    @Column(name = "name")
    private String name="";

    @Column(name = "measure")
    private String measure="";

    @Column(name = "type")
    private Integer type=0;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "qty")
    private BigDecimal qty;

    @JoinColumn(name = "price_def", referencedColumnName = "id")
    @ManyToOne
    private PriceDef priceDef=null;

    @JoinColumn(name = "wi", referencedColumnName = "id")
    @ManyToOne
    private BikWorkItem wi=null;

    
    /** Creates a new instance of BikWorkItemComponent */
    public BikWorkItemComponent() {
        unitPrice = new BigDecimal(0);
        qty = new BigDecimal(0);
        needProofReading = true;
        notForPrint = false;
    }

    /**
     * Creates a new instance of BikWorkItemComponent with the specified values.
     * @param id the id of the BikWorkItemComponent
     */
    public BikWorkItemComponent(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of this BikWorkItemComponent.
     * @return the name
     */
    public String getName() {
        if (getPriceDef()!=null && 
                getObjType()!=BikObjType.DEPRECIATION_PERCENT &&
                getObjType()!=BikObjType.LABOUR) 
            if (getPriceDef().getCategory()!=null) return getPriceDef().getCategory() + 
                    ": " + getPriceDef().getName();
            else return getPriceDef().getName();
        else return this.name;
    }

    /**
     * Sets the name of this BikWorkItemComponent to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the measure of this BikWorkItemComponent.
     * @return the measure
     */
    public String getMeasure() {
        if (getPriceDef()!=null && 
                getObjType()!=BikObjType.DEPRECIATION_PERCENT &&
                getObjType()!=BikObjType.LABOUR) 
            return getPriceDef().getMeasure();
        else return this.measure;
    }

    /**
     * Sets the measure of this BikWorkItemComponent to the specified value.
     * @param measure the new measure
     */
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    /**
     * Gets the type of this BikWorkItemComponent.
     * @return the type
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * Sets the type of this BikWorkItemComponent to the specified value.
     * @param type the new type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gets the unitPrice of this BikWorkItemComponent.
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        if (getPriceDef()!=null && 
                getObjType()!=BikObjType.DEPRECIATION_PERCENT &&
                getObjType()!=BikObjType.LABOUR) 
            return getPriceDef().getUnitPrice();
        else return this.unitPrice;
    }

    /**
     * Sets the unitPrice of this BikWorkItemComponent to the specified value.
     * @param unitPrice the new unitPrice
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the qty of this BikWorkItemComponent.
     * @return the qty
     */
    public BigDecimal getQty() {
        return this.qty;
    }

    /**
     * Sets the qty of this BikWorkItemComponent to the specified value.
     * @param qty the new qty
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * Gets the priceDef of this BikWorkItemComponent.
     * @return the priceDef
     */
    public PriceDef getPriceDef() {
        return this.priceDef;
    }

    /**
     * Sets the priceDef of this BikWorkItemComponent to the specified value.
     * @param priceDefId String containing ID of new price definition
     * @return <I>true</I> id PriceDef successfully set, <I>false</I> otherwise
     */
    public Boolean setPriceDef(String priceDefId) {
        Session s = HibernateUtil.getCurrentSession();
        org.hibernate.Query q=s.getNamedQuery("PriceDef.findById");
        Integer pdid;
        try {
            pdid = new Integer(priceDefId);
        } catch (NumberFormatException ex){
            return false;
        }
        q.setInteger("id", pdid);
        q.setMaxResults(1);
        List pdList = q.list();
        
        Iterator i = pdList.iterator();
        
        if (i.hasNext()){
            this.priceDef = (PriceDef) i.next();
            return true;
        } else {
            return false;
        }
            
    }

    /** 
     * Clears priceDef for this worki item component
     */
    public void clearPriceDef(){
        this.priceDef = null;
    }
    /**
     * Sets the priceDef of this BikWorkItemComponent to the specified value.
     * @param priceDef the new priceDef
     */
    public void setPriceDef(PriceDef priceDef) {
        this.priceDef = priceDef;
    }

    /**
     * Gets the wi of this BikWorkItemComponent.
     * @return the wi
     */
    public BikWorkItem getWi() {
        return this.wi;
    }

    /**
     * Sets the wi of this BikWorkItemComponent to the specified value.
     * @param wi the new wi
     */
    public void setWi(BikWorkItem wi) {
        this.wi = wi;
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
     * Determines whether another object is equal to this BikWorkItemComponent.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikWorkItemComponent object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikWorkItemComponent)) {
            return false;
        }
        BikWorkItemComponent other = (BikWorkItemComponent)object;
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
        return "data.BikWorkItemComponent[id=" + id + "]";
    }

    public BikObjType getObjType() {
       if (getType()==BikObjType.DEPRECIATION_PERCENT.getId()) return BikObjType.DEPRECIATION_PERCENT;
       if (getType()==BikObjType.DEPRECIATION.getId()) return BikObjType.DEPRECIATION;
       if (getType()==BikObjType.MATERIAL.getId()) return BikObjType.MATERIAL;
       if (getType()==BikObjType.LABOUR.getId()) return BikObjType.LABOUR;
       return null;
    }
    
    public BigDecimal getMaterials(){
        if (this.getType() == BikObjType.MATERIAL.getId()) {
            if (getUnitPrice()!=null && getQty()!=null) return getUnitPrice().multiply(getQty());
        } 
        return new BigDecimal(0);
    }
    
    public BigDecimal getDepreciation(){
        if (this.getType() == BikObjType.DEPRECIATION.getId()) {
            if (getUnitPrice()!=null && getQty()!=null) return getUnitPrice().multiply(getQty());
        } else if (this.getType() == BikObjType.DEPRECIATION_PERCENT.getId()) {
            if (getQty()!=null) return getWi().getLabour().multiply(getQty());
        }
        return new BigDecimal(0);
    }
    
    public BigDecimal getLabour(){
        if (this.getType() == BikObjType.LABOUR.getId()) {
            if (getUnitPrice()!=null && getQty()!=null) return getUnitPrice().multiply(getQty());
        } 
        return new BigDecimal(0);
    }
    
    public BigDecimal getLabourNorm(){
        if (this.getType() == BikObjType.LABOUR.getId()) {
            if (getQty()!=null) return getQty();
        } 
        return new BigDecimal(0);
    }
    
    public BigDecimal getLabourCost(){
        if (this.getType() == BikObjType.LABOUR.getId()) {
            if (getUnitPrice()!=null) return getUnitPrice();
        } 
        return new BigDecimal(0);
    }

    public void delete(String userName) {
        setDeleted(true);
        setDeletedBy(userName);
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

    public Boolean isDeleted() {
        return getDeleted();
    }

    public Boolean getDeleted() {
        Boolean retValue;
        if (getWi().getDeleted()) return true;
        retValue = super.getDeleted();
        return retValue;
    }

}
