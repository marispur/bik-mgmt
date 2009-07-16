/*
 * PriceDefUsageProvider.java
 *
 * Created on ceturtdiena, 2009, 16 jûlijs, 23:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bikdesigner;
import bikdesigner.HibernateUtil;
import java.util.Collection;
import java.util.Iterator;
import org.hibernate.*;
/**
 *
 * @author Maris
 */
public class PriceDefUsageProvider {
    
    public static Integer getPriceDefUsageCount(Integer priceDefId) {
        Collection<data.PriceDefUsage> usage;
        
        usage = HibernateUtil.getCurrentSession().createQuery("from data.PriceDefUsage p where p.id="+priceDefId.toString()).list();
        while (usage.iterator().hasNext())
        {
            return usage.iterator().next().getUsageCount();
        }
        return 0;
    }
}