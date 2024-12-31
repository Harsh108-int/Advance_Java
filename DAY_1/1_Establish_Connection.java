import java.sql.*;

public class Establish_Connection {
    public static void main(String[] args) {
        //jdbc url
        String jdbc = "jdbc:mysql://localhost:3307/customer";
        //user
        String user = "root";
        //password
        String password = "Harsh$1000Pande";

        //declare Connection Object
        Connection c1 = null;

        try {
            //Establish Connection to Database customer
            c1 = DriverManager.getConnection(jdbc,user,password);
            System.out.println("Successfully Connected to DataBase -->[customer]");
        }catch (SQLException s)
        {
            System.err.println(s);
        }
    }
}
