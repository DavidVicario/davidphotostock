package com.project.davidphotostock.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/davidphotostock";
    static final String USER = "root";
    static final String PASS = "88dAi12";
    static final String QUERY = "select * from ccaa;";
    
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id_ccaa"));
                System.out.println(", CCAA: " + rs.getString("ccaa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}