package main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;
    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            int select= Integer.parseInt(bufferedReader.readLine());
            switch ((select)){

                case 2: exerciseTwo();
                case 3 : exerciseThree();
                case 4 : exerciseFour();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exerciseFour() {
        Query query = entityManager.createQuery("SELECT e.firstName from Employee e where e.salary>50000");
        List<String> list= query.getResultList();
        for (String e:list
             ) {
            System.out.println(e);
        }
    }

    private void exerciseThree() throws IOException {
        String name [] = bufferedReader.readLine().split(" ");
        Query query = entityManager.createQuery("select e.firstName,e.lastName from Employee e where e.firstName='" + name[0]+"'and e.lastName='"+name[1]+"'");
        List list = query.getResultList();
        if(list.isEmpty()){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }
    }

    private void exerciseTwo() {
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("update Town t set t.name=upper(t.name) where length(t.name)<=5 ");
    int affectedRows= query.executeUpdate();
    System.out.println(affectedRows);
    entityManager.getTransaction().commit();

    }
}
