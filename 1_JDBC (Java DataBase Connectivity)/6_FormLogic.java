import java.util.*;
import java.sql.*;
public class FormLogic {
    public static void main(String[] args) {
        //Scanner Object Create
        Scanner sc = new Scanner(System.in);
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

        //declare PreparedStatement Object
        PreparedStatement p1 = null;

        //declare ResultSet Object
        ResultSet r1 = null;
        try {
            c1 = DriverManager.getConnection(jdbc,user,password);
            System.out.println("Connected Successfully....");
            while (true)
            {
                System.out.println("\n1.Sign Up.\n2.Login.\n3.Forget Password.");
                System.out.println("Enter Your Choice (Enter 'EXIT') For Stop : ");
                String ch = sc.next();
                if (ch.equalsIgnoreCase("Exit"))
                {
                    System.out.println("Program is Exiting...");
                    break;
                }
                switch (ch)
                {
                    case "1":
                        System.out.println("\nYou Select Sign Up.");
                        System.out.println("Enter Your Name :");
                        String name = sc.next();
                        System.out.println("Enter Your Email :");
                        String email = sc.next();
                        System.out.println("Set Your Password :");
                        String pass = sc.next();
                        String query = "INSERT INTO user (name,email,password) VALUES (?,?,?)";
                        p1 = c1.prepareStatement(query);
                        p1.setString(1,name);
                        p1.setString(2,email);
                        p1.setString(3,pass);
                        if(p1.executeUpdate() != 0) {
                            System.out.println("Successfully Signing...");
                        }else {
                            System.err.println("Error: Please Try Again Later");
                        }
                        break;

                    case "2":
                        System.out.println("\nYou Select Login.");
                        System.out.println("Enter Your Email :");
                        String email_s = sc.next();
                        System.out.println("Enter Your Password :");
                        String pass_l = sc.next();
                        String query1 = "SELECT * FROM user WHERE email = ?";
                        p1 = c1.prepareStatement(query1);
                        p1.setString(1,email_s);
                        r1 = p1.executeQuery();
                        if (r1.next())
                        {
                            String query2 = "SELECT * FROM user WHERE password = ?";
                            p1 = c1.prepareStatement(query2);
                            p1.setString(1,pass_l);
                            r1 = p1.executeQuery();
                            if(r1.next())
                            {
                                String store_password = r1.getString("password");
                                if(store_password.equals(pass_l))
                                {
                                    System.out.println("successfully Login...");
                                }else {
                                    System.err.println("Password is not matched.");
                                }
                            }
                        }else {
                            System.err.println("Wrong Email Address. Please Enter Correct One");
                        }
                        break;

                    case "3":
                        System.out.println("You Chose Forget Password.");
                        System.out.println("Enter your Email :");
                        String email_f = sc.next();
                        String query_f = "SELECT * FROM user WHERE email = ?";
                        p1 = c1.prepareStatement(query_f);
                        p1.setString(1,email_f);
                        r1 = p1.executeQuery();
                        if (r1.next())
                        {
                            System.out.println("Enter New Password :");
                            String new_password = sc.next();
                            String query_new_pass = "UPDATE user SET password = ? WHERE email = ?";
                            p1 = c1.prepareStatement(query_new_pass);
                            p1.setString(1,new_password);
                            p1.setString(2,email_f);
                            if(p1.executeUpdate() > 0)
                            {
                                System.out.println("Password Successfully Changed...");
                            }else {
                                System.err.println("Error 404.");
                            }
                        }else {
                            System.err.println("Enter Correct Password.");
                        }



                }

            }

        }catch (SQLException s)
        {
            System.err.println(s);
        }
    }
}
