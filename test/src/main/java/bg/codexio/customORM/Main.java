package bg.codexio.customORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ormFramework.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Main {
    public static void main(String[] args) {
        System.out.println(123);
        ///hibernate &jpa
        SessionFactory sessionFactory= new Configuration()
                .configure().buildSessionFactory();
        EntityManager session = sessionFactory.openSession();

       Query query= session.createQuery("select u from User u where u.city.name=:un",User.class);
       query.setParameter("un","Burgas");
       query.getResultList().forEach(u->{
           System.out.println(u);
       });
        //hibernate
        //Session session =new Configuration().configure().buildSessionFactory().openSession();
       //Transaction transaction =session.beginTransaction();

        //User us1 = new User();
        //us1.setUsername("alpha");
        //us1.setPassword("ragaraga");
        //session.save(us1);
        //User us = session.get(User.class,2);
        //session.delete(us);

       //transaction.commit();
    }
}
