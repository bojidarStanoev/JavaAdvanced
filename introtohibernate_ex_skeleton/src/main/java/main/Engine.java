package main;

import entities.Address;
import entities.Employee;

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
                case 5 : exerciseFive();
                case 6 : exerciseSix();
                case 7 : exerciseSeven();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exerciseSeven() {
         List<Address> list = entityManager.createQuery("SELECT a from Address a order by a.employees.size  desc ",Address.class).setMaxResults(10).getResultList();
                list.forEach(address->{

                   System.out.printf("%s %s - %d employees\n",address.getText(), address.getTown()==null?"unknown":address.getTown().getName(),address.getEmployees().size());
                });
    }

    private void exerciseSix() throws IOException {
        String name=bufferedReader.readLine();
        Query query = entityManager.createQuery("SELECT e from Employee as e where e.lastName='"+name+"'");
        Employee chosenOne= (Employee) query.getSingleResult();
        Address addr= new Address();
        addr.setText("Vitoshka 15");
        entityManager.getTransaction().begin();
        entityManager.persist(addr);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        chosenOne.setAddress(addr);
        entityManager.getTransaction().commit();

    }

    private void exerciseFive() {
        Query query = entityManager.createQuery("select e from  Employee as e ");
        List<Employee> res= query.getResultList();
        res.sort((a, b) -> {
            int compresult = a.getSalary().compareTo(b.getSalary());
            if(compresult==0){
                return a.getId().compareTo(b.getId());
            }
            else return compresult;

        });

        res.forEach((e) ->{
            if(e.getDepartment().getName().equals("Research and Development"))
            System.out.println(e.getFirstName() + " " + e.getLastName() + " from " + e.getDepartment().getName() + " - " + e.getSalary());
        });

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
