package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.example.employeepayrollapplication.model.EmployeePayrollData;
import com.example.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/* service layer contains classes which has business logic for curd operations */
@Service
public class EmployeePayRollService implements IEmployeePayrollService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayRollData() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeePayrollData> getEmployeePayRollDataById(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeeRepository.findAll().size()+1,
                                                                            employeePayrollDTO);
        employeeRepository.save(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayRollDataById(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        List<EmployeePayrollData> employeePayrollDataList = this.getEmployeePayRollData();
        for (EmployeePayrollData empData : employeePayrollDataList) {
                if(empData.getEmployeeId() == empId) {
                    empData.setName(employeePayrollDTO.name);
                    empData.setSalary(employeePayrollDTO.salary);
                    employeeRepository.save(empData);
                    return empData;
                }
        }
        return null;
    }
}
