/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

public class ConnectionProvider {

    private Connection con;

    public static Connection getconn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteria", "root", "root");
            System.out.println("Connected..");
            return con;  
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Not connected..");
            return null;
        }
    }
}
