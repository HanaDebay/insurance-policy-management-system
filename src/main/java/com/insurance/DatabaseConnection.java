package com.insurance;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/insurance_db";
        private static final String PASSWORD = "HanaLearnJava2026!";
        private static final String USER = "root";
        public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL, USER,PASSWORD);
        }
public static void main(String[] args){
            try(Connection connection = getConnection()){
                System.out.println("Connected to MySQL successfully!");
            }catch (SQLException e){
                System.out.println("Database Connection failed.");
                System.out.println(e.getMessage());
            }
}
}
