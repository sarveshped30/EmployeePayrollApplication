package com.example.employeepayrollapplication.dto;

import javax.validation.constraints.NotNull;

/* EmployeePayrollDto class is (DTO) data transfer object sent to user and received from user */
public class EmployeePayrollDTO {

    @NotNull
    public String name;

    @NotNull
    public long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
