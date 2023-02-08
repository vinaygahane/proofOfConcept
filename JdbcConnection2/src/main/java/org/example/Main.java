package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        int id =6;
        String email = "yg@gmail.com";
        String name = "Yugant";
        String last = "Gahane";
        String query = "INSERT INTO  students VALUES(?,?,?,?)";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "Vinyug@123");


        //        Statement stmt = con.createStatement();
//        int count = stmt.executeUpdate("INSERT INTO  students VALUES(5,'rb@gmail.com','Rahul','Bhiwre')");

        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,id);
        st.setString(2,email);
        st.setString(3,name);
        st.setString(4,last);
        int count = st.executeUpdate();
        System.out.println(count+"rows affected");
        st.close();

    }
}