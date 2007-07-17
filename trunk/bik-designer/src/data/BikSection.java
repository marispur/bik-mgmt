/*
 * BikSection.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

import bikdesigner.HibernateUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;

/**
 * Entity class BikSection
 * 
 * @author mpurins
 */
@Entity
@Table(name = "sys_section")
@NamedQueries( {
        @NamedQuery(name = "BikSection.findById", query = "SELECT b FROM BikSection b WHERE b.id = :id"),
        @NamedQuery(name = "BikSection.findByCode", query = "SELECT b FROM BikSection b WHERE b.code = :code"),
        @NamedQuery(name = "BikSection.findByDateCreated", query = "SELECT b FROM BikSection b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = "BikSection.findByDateModified", query = "SELECT b FROM BikSection b WHERE b.dateModified = :dateModified"),
        @NamedQuery(name = "BikSection.findByModifiedBy", query = "SELECT b FROM BikSection b WHERE b.modifiedBy = :modifiedBy"),
        @NamedQuery(name = "BikSection.findByName", query = "SELECT b FROM BikSection b WHERE b.name = :name"),
        @NamedQuery(name = "BikSection.findByDescription", query = "SELECT b FROM BikSection b WHERE b.description = :description"),
        @NamedQuery(name = "BikSection.findByDeleted", query = "SELECT b FROM BikSection b WHERE b.deleted = :deleted"),
        @NamedQuery(name = "BikSection.findByDateDeleted", query = "SELECT b FROM BikSection b WHERE b.dateDeleted = :dateDeleted"),
        @NamedQuery(name = "BikSection.findByDeletedBy", query = "SELECT b FROM BikSection b WHERE b.deletedBy = :deletedBy")
    })
public class BikSection extends AbstractBikDataObject implements Serializable {

    @Column(name = "code")
    private String code = "";

    @Column(name = "name")
    private String name="";

    @Column(name = "description")
    private String description="";

    @OneToMany(mappedBy = "section")
    @OrderBy(clause="code, id")
    private Collection<BikSubsection> bikSubsectionCollection;
    
    @OneToMany()
    @JoinColumn(name="parent_id")
    @OrderBy(clause="print_sequence")
    @Where(clause="parent_type=1") // This parameter must reflect ID of DB object type
    private Collection<BikComment> bikComments;
    
    /** Creates a new instance of BikSection */
    public BikSection() {
    }

    /**
     * Creates a new instance of BikSection with the specified values.
     * @param id the id of the BikSection
     */
    public BikSection(Integer id) {
        this.id = id;
    }


    /**
     * Gets the code of this BikSection.
     * @return the code
     */
    public String getCode() {
        if (this.code==null) return new String("");
        return this.code;
    }

    /**
     * Sets the code of this BikSection to the specified value.
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the name of this BikSection.
     * @return the name
     */
    public String getName() {
        if (this.name==null) return new String("");
        return this.name;
    }

    /**
     * Sets the name of this BikSection to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this BikSection.
     * @return the description
     */
    public String getDescription() {
        if (this.description==null) return new String("");
        return this.description;
    }

    /**
     * Sets the description of this BikSection to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the bikSubsectionCollection of this BikSection.
     * @return the bikSubsectionCollection
     */
    public Collection<BikSubsection> getBikSubsectionCollection() {
        return this.bikSubsectionCollection;
    }

    /**
     * Sets the bikSubsectionCollection of this BikSection to the specified value.
     * @param bikSubsectionCollection the new bikSubsectionCollection
     */
    public void setBikSubsectionCollection(Collection<BikSubsection> bikSubsectionCollection) {
        this.bikSubsectionCollection = bikSubsectionCollection;
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
     * Determines whether another object is equal to this BikSection.  The result is 
     * <code>true</code> if and only if the argument is not null and is a BikSection object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BikSection)) {
            return false;
        }
        BikSection other = (BikSection)object;
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
        return "data.BikSection[id=" + id + "]";
    }

    public BikObjType getObjType() {
        return BikObjType.SECTION;
    }

    public Collection<BikComment> getBikComments() {
        return bikComments;
    }

    public void setBikComments(Collection<BikComment> bikComments) {
        this.bikComments = bikComments;
    }
    public void exportToFileForTypesetting(java.io.PrintWriter output){
        output.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NODAÏA");
        output.printf("%s %s%n",this.getCode().trim(),this.getName().trim());
        output.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NODAÏAS KOMENTÂRI");
        Iterator<BikComment> i = this.getBikComments().iterator();
        while (i.hasNext()) {
            i.next().exportToFileForTypesetting(output);
        }
        output.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NODAÏAS KOMENTÂRI BEIGAS");
        
        Iterator<BikSubsection> i2 = this.getBikSubsectionCollection().iterator();
        while (i2.hasNext()) {
            i2.next().exportToFileForTypesetting(output);
        }
    }
}
