import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws SQLException {
        Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db","root","rogerroger");
        Scanner input = new Scanner(System.in);
        int id = Integer.parseInt(input.nextLine());

        Statement state=  connect.createStatement();
        ResultSet username= state.executeQuery("SELECT name from villains where " +id+"=villains.id");

        if(username.next()){
        System.out.println("Villain: "+username.getString(1));}
        else {
        System.out.println("No villain with ID "+id +" exists in the database.");
        }
        // ResultSet resSet= state.executeQuery("SELECT  villains.name,count(distinct minions_villains.minion_id) as \"minion_number\" from villains  join minions_villains on villains.id=minions_villains.villain_id group by villains.name having minion_number>15 ");
        ResultSet resSet= state.executeQuery("SELECT minions.name,minions.age from minions join minions_villains mv on minions.id = mv.minion_id where villain_id="+ id);
        while (resSet.next()){
            int order=resSet.getRow();
            String name=resSet.getString(1);
            long age= resSet.getLong(2);
            System.out.println(order + ". " + name+" " + age);
        }
    }
}
