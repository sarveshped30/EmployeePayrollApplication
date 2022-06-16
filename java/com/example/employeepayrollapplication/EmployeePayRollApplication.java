/* Project: Employee payroll application
 * CFP assignment
 * Author: Sarvesh Pednekar */
package com.example.employeepayrollapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePayRollApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to employee payroll application!!!");
        SpringApplication.run(EmployeePayRollApplication.class, args);
    }
}
