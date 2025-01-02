import java.sql.*;
public class Delete_Data {
    public static void main(String[] args) {
        //jdbc url
        String jdbc = "jdbc:mysql://localhost:3307/customer";
        //user
        String user = "root";
        //password
        String password = "Harsh$1000Pande";

        //declare Connection Object
        Connection c1 = null;
        //declare PreparedStatement Object
        PreparedStatement p1 = null;
        try {
            c1 = DriverManager.getConnection(jdbc,user,password);
            System.out.println("Successfully Connected to DataBase....");

            int id = 1;
            String query = "DELETE FROM user WHERE id = ?";

            p1 = c1.prepareStatement(query);
            p1.setInt(1,id);

            int i = p1.executeUpdate();
            System.out.println(i + " " +"Record is Deleted into DataBase.");

        }catch (SQLException s)
        {
            System.err.println(s);
        }
    }
}
