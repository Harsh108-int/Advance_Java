import java.sql.*;
public class Retrive_Data{
    public static void main(String[] args) {
        //jdbc url
        String jdbc = "jdbc:mysql://localhost:3307/customer";
        //user
        String user = "root";
        //password
        String password = "Harsh$1000Pande";

        //declare Connection Object
        Connection c1 = null;
        Statement s1 = null;
        ResultSet r1 = null;
        try {
            //establish connection
            c1 = DriverManager.getConnection(jdbc,user,password);
            System.out.println("Successfully Connected...");

            //create a statement object
            s1 = c1.createStatement();

            //query for select data
            String query = "SELECT * FROM user";

            r1 = s1.executeQuery(query);
            while (r1.next())
            {
                int id = r1.getInt("id");
                String user_name = r1.getString("name");
                String email = r1.getString("email");
                String user_password = r1.getString("password");
                System.out.println("Id : " + id + "\tName :" + user_name + "\tEmail :" + email + "\tpassword : " + user_password);
            }
        }catch (SQLException s)
        {
            System.err.println(s);
        }finally {
            try {
                if(c1 != null)
                {
                    c1.close();
                }
                if (s1 != null)
                {
                    s1.close();
                }
                if(r1 != null)
                {
                    r1.close();
                }
            }catch (SQLException s)
            {
                System.err.println(s);
            }
        }

    }
}
