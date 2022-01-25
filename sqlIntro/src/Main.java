import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/Soft_uni","root","rogerroger");
        Statement state = connection.createStatement();
        ResultSet resset=state.executeQuery("select  * from employees");
        if(resset.next()){
           String jt= resset.getString(5);
           System.out.println(jt);
        }
    }
}
