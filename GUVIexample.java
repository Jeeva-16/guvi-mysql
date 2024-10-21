package org.example;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GUVIexample {


    public class JDBCExample {
        public static void main(String[] args) {
            // Database URL, username, and password
            String url = "D:\\mySQL";
            String user = "root";  // Replace with your username
            String password = "Jeevaakshu@1416";  // Replace with your password

            // SQL query to insert data
            String insertQuery = "INSERT INTO Employe (empcode, empname, emppage,empsalary) VALUES (?, ?, ?, ?)";

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                // Step 1: Register the JDBC driver (optional since JDBC 4.0)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Step 2: Establish a connection
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the database successfully!");

                // Step 3: Prepare the SQL query
                pstmt = conn.prepareStatement(insertQuery);

                // Step 4: Set the values for placeholders (?)
                pstmt.setInt(1, 101);
                pstmt.setString(2, "Jenny");
                pstmt.setInt(3, 25);
                pstmt.setInt(4, 10000);
                

                // Step 5: Execute the query
                int rowsAffected = pstmt.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted successfully.");

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found.");
                e.printStackTrace();
            } finally {
                // Step 6: Close the resources
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
