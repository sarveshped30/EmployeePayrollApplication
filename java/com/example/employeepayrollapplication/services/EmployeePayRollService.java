package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.example.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/* service layer contains classes which has business logic for curd operations */
@Service
public class EmployeePayRollService implements IEmployeePayrollService{

    List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayRollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayRollDataById(int empId) {
        return employeePayrollDataList.get(empId-1);
    }

    @Override
    public EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size()+1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayRollDataById(int empId) {
        employeePayrollDataList.remove(empId-1);
    }

    @Override
    public EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        for (EmployeePayrollData empData : employeePayrollDataList) {
                if(empData.getEmployeeId() == empId) {
                    empData.setName(employeePayrollDTO.name);
                    empData.setSalary(employeePayrollDTO.salary);
                    return empData;
                }
        }
        return null;
    }
}
