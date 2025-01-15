package Employee.Management.System;

import java.sql.*;


public class conn {
    
    Connection connection;
    Statement statement;

    public conn(){
        try {
           
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Kapil1234");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new conn();
    }

}
