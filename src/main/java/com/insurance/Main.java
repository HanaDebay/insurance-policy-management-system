package com.insurance;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
       CustomerDAO customerDAO = new CustomerDAO();
       InsurancePolicyDAO policyDAO = new InsurancePolicyDAO();

       boolean success = customerDAO.insertCustomer(
               "Mary",
               "John",
               "mary2026@gmail.com",
               "0708654323"
       );


       if(success){
           System.out.println("Customer inserted successfully!");
       }else {
           System.out.println("customer insertion failed");
       }

       boolean policySuccess = policyDAO.insertPolicy(
               "POL-2026-002",
               "Life Insurance",
               new java.math.BigDecimal("250000.00"),
               java.time.LocalDate.of(2026, 10,16),
               1
       );
        System.out.println(policySuccess
        ? "Policy inserted successfully!": "Policy insertion failed.");

        }

}
