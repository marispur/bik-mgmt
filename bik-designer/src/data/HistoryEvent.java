/*
 * HistoryEvent.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Query;

/**
 * Entity class HistoryEvent
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_bik_log")
@NamedQueries( {
        @NamedQuery(name = "HistoryEvent.findByTarget", query = "SELECT h FROM HistoryEvent h WHERE h.objId = :objId AND h.objType = :objType ORDER BY h.date DESC"),
        @NamedQuery(name = "HistoryEvent.findById", query = "SELECT h FROM HistoryEvent h WHERE h.id = :id"),
        @NamedQuery(name = "HistoryEvent.findByFieldName", query = "SELECT h FROM HistoryEvent h WHERE h.fieldName = :fieldName"),
        @NamedQuery(name = "HistoryEvent.findByOldVal", query = "SELECT h FROM HistoryEvent h WHERE h.oldVal = :oldVal"),
        @NamedQuery(name = "HistoryEvent.findByNewVal", query = "SELECT h FROM HistoryEvent h WHERE h.newVal = :newVal"),
        @NamedQuery(name = "HistoryEvent.findByDate", query = "SELECT h FROM HistoryEvent h WHERE h.date = :date"),
        @NamedQuery(name = "HistoryEvent.findByObjId", query = "SELECT h FROM HistoryEvent h WHERE h.objId = :objId"),
        @NamedQuery(name = "HistoryEvent.findByObjType", query = "SELECT h FROM HistoryEvent h WHERE h.objType = :objType"),
        @NamedQuery(name = "HistoryEvent.findByModifiedBy", query = "SELECT h FROM HistoryEvent h WHERE h.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "HistoryEvent.findByMessage", query = "SELECT h FROM HistoryEvent h WHERE h.message = :message")
    })
public class HistoryEvent implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "old_val")
    private String oldVal;

    @Column(name = "new_val")
    private String newVal;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "obj_id")
    private Integer objId;

    @Column(name = "obj_type")
    private Integer objType;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "message")
    private String message;
    
    /** Creates a new instance of HistoryEvent */
    public HistoryEvent() {
    }

    /**
     * Creates a new instance of HistoryEvent with the specified values.
     * @param id the id of the HistoryEvent
     */
    public HistoryEvent(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this HistoryEvent.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this HistoryEvent to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the fieldName of this HistoryEvent.
     * @return the fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * Sets the fieldName of this HistoryEvent to the specified value.
     * @param fieldName the new fieldName
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets the oldVal of this HistoryEvent.
     * @return the oldVal
     */
    public String getOldVal() {
        return this.oldVal;
    }

    /**
     * Sets the oldVal of this HistoryEvent to the specified value.
     * @param oldVal the new oldVal
     */
    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    /**
     * Gets the newVal of this HistoryEvent.
     * @return the newVal
     */
    public String getNewVal() {
        return this.newVal;
    }

    /**
     * Sets the newVal of this HistoryEvent to the specified value.
     * @param newVal the new newVal
     */
    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }

    /**
     * Gets the date of this HistoryEvent.
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets the date of this HistoryEvent to the specified value.
     * @param date the new date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the objId of this HistoryEvent.
     * @return the objId
     */
    public Integer getObjId() {
        return this.objId;
    }

    /**
     * Sets the objId of this HistoryEvent to the specified value.
     * @param objId the new objId
     */
    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    /**
     * Gets the objType of this HistoryEvent.
     * @return the objType
     */
    public Integer getObjType() {
        return this.objType;
    }

    /**
     * Sets the objType of this HistoryEvent to the specified value.
     * @param objType the new objType
     */
    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    /**
     * Gets the modifiedBy of this HistoryEvent.
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    /**
     * Sets the modifiedBy of this HistoryEvent to the specified value.
     * @param modifiedBy the new modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the message of this HistoryEvent.
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message of this HistoryEvent to the specified value.
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * Determines whether another object is equal to this HistoryEvent.  The result is 
     * <code>true</code> if and only if the argument is not null and is a HistoryEvent object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryEvent)) {
            return false;
        }
        HistoryEvent other = (HistoryEvent)object;
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
        return "data.HistoryEvent[id=" + id + "]";
    }
    
    public void bikSave() {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().saveOrUpdate(this);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }
}
