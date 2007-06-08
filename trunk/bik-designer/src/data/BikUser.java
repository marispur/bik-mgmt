/*
 * BikUsers.java
 *
 * Created on treðdiena, 2007, 18 aprîlis, 10:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;

/**
 * Entity class BikUsers
 * 
 * @author mpurins
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "sys_users")
@javax.persistence.NamedQueries( {
        @javax.persistence.NamedQuery(name = "BikUser.findById", query = "SELECT b FROM data.BikUser b WHERE b.id = :id"),
        @javax.persistence.NamedQuery(name = "BikUser.findByShortName", query = "SELECT b FROM data.BikUser b WHERE b.shortName = :shortName"),
        @javax.persistence.NamedQuery(name = "BikUser.findByFullName", query = "SELECT b FROM data.BikUser b WHERE b.fullName = :fullName"),
        @javax.persistence.NamedQuery(name = "BikUser.findByPassword", query = "SELECT b FROM data.BikUser b WHERE b.password = :password")
    })
public class BikUser implements Serializable {

    @javax.persistence.Id
    @javax.persistence.Column(name = "id", nullable = false)
    private Integer id;

    @javax.persistence.Column(name = "short_name")
    private String shortName;

    @javax.persistence.Column(name = "full_name")
    private String fullName;

    @javax.persistence.Column(name = "password")
    private String password;
    
    /** Creates a new instance of BikUsers */
    public BikUser() {
    }

    /**
     * Creates a new instance of BikUsers with the specified values.
     * @param id the id of the BikUsers
     */
    public BikUser(Integer id) {
        this.id = id;
    }

    /**
     * Gets the id of this BikUsers.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this BikUsers to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the shortName of this BikUsers.
     * @return the shortName
     */
    public String getShortName() {
        return this.shortName;
    }

    /**
     * Sets the shortName of this BikUsers to the specified value.
     * @param shortName the new shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets the fullName of this BikUsers.
     * @return the fullName
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Sets the fullName of this BikUsers to the specified value.
     * @param fullName the new fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the password of this BikUsers.
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of this BikUsers to the specified value.
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Determines whether another object is equal to this BikUsers.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikUsers object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikUser)) {
            return false;
        }
        BikUser other = (BikUser)object;
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
        return "bikdesigner.BikUsers[id=" + id + "]";
    }

    public void bikSave() {
        Session s = HibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.update(this);
        s.getTransaction().commit();
    }

}
