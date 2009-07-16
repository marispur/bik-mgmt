/*
 * PriceDefUsage.java
 *
 * Created on ceturtdiena, 2009, 16 jûlijs, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Maris
 */

@Entity
@Table(name = "price_def_usage")
@NamedQueries( {
        @NamedQuery(name = "PriceDefUsage.findById", query = "SELECT p FROM PriceDefUsage p WHERE p.id = :id")
})
public class PriceDefUsage implements Serializable{
    @Id
    @Column(name = "sys_price_def_id", nullable = false)
    private Integer id;
    
    @Column(name = "sys_price_def_usage_count")
    private Integer usageCount;
    
    
    /** Creates a new instance of PriceDefUsage */
    public PriceDefUsage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }
    
}
