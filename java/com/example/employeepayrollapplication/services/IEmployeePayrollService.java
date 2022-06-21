package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.example.employeepayrollapplication.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    
    List<EmployeePayrollData> getEmployeePayRollData();
    Optional<EmployeePayrollData> getEmployeePayRollDataById(int empId);
    EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayRollDataById(int empId);
    EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO);
}
