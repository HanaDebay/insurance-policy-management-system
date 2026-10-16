package com.insurance;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsurancePolicyDAO {
    public boolean insertPolicy(String policyNumber, String policyType, BigDecimal premium, LocalDate startDate, int customerId){
        String sql = """
                insert into insurance_policies(policy_number, policy_type, premium, start_date, customer_id)
                values(?,?,?,?,?)
                """;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, policyNumber);
            statement.setString(2, policyType);
            statement.setBigDecimal(3, premium);
            statement.setDate(4, Date.valueOf(startDate));
            statement.setInt(5, customerId);

            int rowInserted = statement.executeUpdate();

            return rowInserted > 0;

        } catch (SQLException e) {
            System.out.println("Failed to insert policy: "+ e.getMessage());
            return false;
        }
    }
}
