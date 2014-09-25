package test;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Lars Mortensen
 */
public class Tester {
  
  public void test(){
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemoPU");
   EntityManager em = emf.createEntityManager();
   
   Customer c1 = new Customer("Tobias");
   c1.addHobby("Lego");
   c1.addPhone("64628", "private");
   
   Customer c2 = new Customer("Henrik");
   c2.addPhone("76534", "Work");
   c2.addHobby("Bicyckling");
   c2.addHobby("Databases");
   
   em.getTransaction().begin();
   em.persist(c1);
   em.persist(c2);
   em.getTransaction().commit();
   
   Customer a = em.find(Customer.class, c2.getId());
    System.out.println(a.getHobbies());
   
   
  }
  public static void main(String[] args) {
   new Tester().test();
  }
}
