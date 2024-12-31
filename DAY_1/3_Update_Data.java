import java.sql.*;
public class Update_Data {
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

            String exist_email = "pande@gmail.com";
            String change_password = "Harsh1000";

            //Parameterized Query
            String query  = "UPDATE user SET password = ? WHERE email = ?";

            //create preparedstatement object and execute precompiled query
            p1 = c1.prepareStatement(query);

            //set actual values in query
            p1.setString(1,change_password);
            p1.setString(2,exist_email);

            //execute sql statement
            int row = p1.executeUpdate();
            System.out.println(row + "\trecord Successfully Updated...");

        }catch (SQLException s)
        {
            System.err.println(s);
        }
    }
}
