import java.sql.*;
public class Insert_Data {
    public static void main(String[] args) {
        //jdbc url
        String jdbc = "jdbc:mysql://localhost:3307/customer";
        //user
        String user = "root";
        //password
        String password = "Harsh$1000Pande";

        //declare Connection Object
        Connection c1 = null;
        //declare Statement Object
        Statement s1 = null;
        try {
            //establish a connection
            c1 = DriverManager.getConnection(jdbc,user,password);
            System.out.println("Successfully Connected.....");
            //create Statement Object
            s1 = c1.createStatement();
            String query = "INSERT INTO user (name,email,password) VALUES ('Harshvardhan','pande@gmail.com','Harsh$1000')";
            //use for Execute SQL Query
            int i = s1.executeUpdate(query);
            System.out.println(i + "\tRecord is Inserted Successfully....");
        }catch (SQLException s)
        {
            System.err.println(s);
        }finally {
            try {
                //Ensure all resources are close
                if (c1 != null) {
                    c1.close();
                }
                if (s1 != null)
                {
                    s1.close();
                }
            }catch (SQLException s2)
            {
                System.err.println(s2);
            }
        }
    }
}
