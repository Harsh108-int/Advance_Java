package org.HarshLib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class StoreDataInFile{
    public static void main(String[] args) {
        File file = new File("DataBase.txt");
        Connection c1 = null;
        Statement s1 = null;
        ResultSet r1 = null;
        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            if (file.createNewFile()) {
                System.out.println("file is created...");
            }else {
                System.out.println("file is already exist...");
            }
            c1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/harshlib","root","Harsh$1000Pande");
            System.out.println("connected successfully...");
            s1 = c1.createStatement();
            String query = "SELECT * FROM users";
            r1 = s1.executeQuery(query);
            while (r1.next())
            {
                int id = r1.getInt("user_id");
                String name = r1.getString("user_name");
                String user_email = r1.getString("user_email");
                String user_password = r1.getString("user_password");
                String user_role = r1.getString("user_role");
                Timestamp time = r1.getTimestamp("created_at");

                bufferedWriter.write(id +"\t" + name +"\t"+user_email+"\t"+user_password+"\t"+user_role+"\t"+time);
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}