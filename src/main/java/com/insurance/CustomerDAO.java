package com.insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAO {
    public boolean insertCustomer( String firstName, String lastName, String email, String phone){
        String sql = """
                insert into customers (first_name, last_name, email, phone) values(?,?,?,?)
                """;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, phone);

                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;


        } catch (Exception e) {
            System.out.println("Failed to insert customer: "+ e.getMessage());
        return false;
        }
    }
}
