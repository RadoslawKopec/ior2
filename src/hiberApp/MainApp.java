///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
package hiberApp;

//import static com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallerImpl.FACTORY;
import java.util.Collection;
import model.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/* 
 @author LabHiber
 */
public final class MainApp {
    //EntityManagerFactory entitymanagerfactory = -
    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);
   // private static EntityManagerFactory emfactor = Persistence.createEntityManagerFactory("labPU");
    // private EntityManager  entitymanager = emfactory.createEntityManager();
    //private static EntityManager em = SESSION_FACTORY.createEntityManager();
    private static DBCreator creator;
    public static void main(String[] args) {

        creator = new DBCreator(SESSION_FACTORY);
        creator.create();
        //create();
        
        showAllPlayersCrit();
        //zapytanie();
        
        showAllPlayersHQL();
        showPeopleBySurnameCrit("s%");
        showPeopleBySurnameCrit("m%");
        
        showGoalsCrit();
    }

  public static void showAllPlayersCrit(){
           //EntityManager em = SESSION_FACTORY.createEntityManager();
           EntityManager em = SESSION_FACTORY.createEntityManager();
           CriteriaBuilder builder = em.getCriteriaBuilder();
           CriteriaQuery criteria = builder.createQuery(Person.class);
           Root<Person> root = criteria.from(Person.class);
           criteria.select(root);
           List<Person> result = em.createQuery(criteria).getResultList();
           System.out.println("\n Lista osob kryterialna ");
           result.forEach(System.out::println);
           for(Person p: result )
        
        em.close();
  }

  public static void showAllPlayersHQL(){
      EntityManager em = SESSION_FACTORY.createEntityManager();
      List<Person> result = em.createQuery("From Person").getResultList();
      System.out.println("\n Lista osob HQL ");
           result.forEach(System.out::println);
  }
  
      public static void showPeopleBySurnameCrit(String cond){
        EntityManager em = SESSION_FACTORY.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Player> root = criteria.from(Player.class);
        
        criteria.select(builder.tuple(root,root.get("position")));
        criteria.where(builder.like(root.get("lastname"), cond));
        
        Collection<Tuple> result = em.createQuery(criteria).getResultList();
        
        System.out.println("***\n");
        
        for(Tuple t : result){
            System.out.println(t.get(0)+" "+t.get(1));
        }
        em.close();
    }
public static void showPeopleBySurname(String cond){
    EntityManager em = EMBuilder.getEM();
        List<Tuple> result = em.createQuery("SELECT p, Position FROM Person p WHERE p.lastname LIKE '"+cond+"'", Tuple.class).getResultList();
       
        System.out.println("***\n");

        for(Tuple t : result){
            System.out.println(t.get(0)+" "+t.get(1));
        }
        em.close();
    
    
}   

public static void showGoalsCrit(){
    
        EntityManager em = EMBuilder.getEM();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Statistic> root = criteria.from(Statistic.class);
      
        criteria.select(builder.tuple(root,root.get("value")));//, builder.count(root.get("value"))));
        //criteria.groupBy(root.get("type"));
        List<Tuple> result = em.createQuery(criteria).getResultList();
        for(Tuple t : result){
            System.out.println(t.get(0)+"ilosc: "+t.get(1));
        }
        em.close();
}


}
