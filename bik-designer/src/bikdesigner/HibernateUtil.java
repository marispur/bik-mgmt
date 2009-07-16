/*
 * HibernateUtil.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bikdesigner;

/**
 *
 * @author mpurins
 */



import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Startup Hibernate and provide access to the singleton SessionFactory
 */
public class HibernateUtil {
  private static SessionFactory sessionFactory;
  private static Session curSession;

  static {
    try {
    	sessionFactory = new AnnotationConfiguration()
        .addPackage("data") //the fully qualified package name
        .addAnnotatedClass(data.BikSection.class)
        .addAnnotatedClass(data.BikSubsection.class)
        .addAnnotatedClass(data.BikWorkItem.class)
        .addAnnotatedClass(data.BikWorkItemComponent.class)
        .addAnnotatedClass(data.HistoryEvent.class)
        .addAnnotatedClass(data.PriceDef.class)
        .addAnnotatedClass(data.BikUser.class)
        .addAnnotatedClass(data.BikComment.class)
        .addAnnotatedClass(data.PriceDefUsage.class)
    	.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
    	.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
    	.setProperty("hibernate.connection.url", "jdbc:postgresql://srv01.mvproject.local:5432/bik")
    	//.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/bik")
    	.setProperty("hibernate.connection.username", "postgres")
    	.setProperty("hibernate.connection.password", "pg131313")
    	.setProperty("hibernate.c3p0.max_size", "20")
    	.setProperty("hibernate.c3p0.timeout", "1800")
    	.setProperty("hibernate.c3p0.max_statements", "50")
    	.buildSessionFactory();
        curSession = sessionFactory.openSession();
        
    } catch (Throwable ex) {
       throw new ExceptionInInitializerError(ex);
    }
  }

  public static Session getCurrentSession() throws HibernateException{
    return curSession;
  }
  
  public static Session getSession() throws HibernateException{
	return sessionFactory.openSession();
  }
}