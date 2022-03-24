package bg.jpa.main;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
     public static void main(String[] args) {
        EntityManagerFactory enf= Persistence.createEntityManagerFactory("soft_uni");
     EntityManager em =enf.createEntityManager();
    }
}
