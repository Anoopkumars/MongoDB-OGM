package hogm.hibernateogm_mongodb;

import Untersuchungsraum.Contact;
import Untersuchungsraum.User;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 * 
 * 
 * 
 * 
 */
public class App 
{
    private static  SessionFactory sessionfactory;
    private static ServiceRegistry serviceregistry;
    
    public static void main( String[] args ) throws InterruptedException
    {
        
        String[]  city={"Berlin","Shiraz","Chemnitz","Teheran","Stutgart","Görlitz",
            "Münster","Köln","Isfahan","Losangles","Washington","Paris","Madrid","London",
            "Newyork","Sydny","Cairo","Amsterdam","Aachen","Hamburg","Dresden","Leipzig",
            "Montreal","Vancouver","Prag","München","Isfahan"};
        OgmConfiguration cfgogm=new OgmConfiguration();
        cfgogm.configure("hibernate.cfg.xml");
        serviceregistry=new ServiceRegistryBuilder().applySettings(cfgogm.getProperties()).buildServiceRegistry();
        sessionfactory=cfgogm.buildSessionFactory(serviceregistry);         
        Session session=sessionfactory.openSession();
        session.beginTransaction();
     
     //   FullTextSession fullTextSession = Search.getFullTextSession(session);
//        fullTextSession.createIndexer(User.class).start();
        
    
        for(int i=0;i<3;i++)
        {
           
            Random rd=new Random();
            int c=rd.nextInt(27)+0;
            int id=rd.nextInt(100000)+10000;
            User user=new User();
            user.setCity(city[c]);
            user.setUserID(id);
            session.save(user);      
           
        }
           session.flush();
           session.getTransaction().commit();
     
        System.out.println("Done...");  
    
        }
    
    
    
}
