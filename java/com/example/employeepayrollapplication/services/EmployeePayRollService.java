package com.example.employeepayrollapplication.services;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.example.employeepayrollapplication.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayRollService implements IEmployeePayrollService{

    List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayRollData() {
        employeePayrollDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Sarvesh", 40000)));
        employeePayrollDataList.add(new EmployeePayrollData(2, new EmployeePayrollDTO("Chaitanya", 45000)));
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayRollDataById(int empId) {
        return employeePayrollDataList.get(empId-1);
    }

    @Override
    public EmployeePayrollData addEmployeePayRollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(3, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayRollDataById(int empId) {
        employeePayrollDataList.remove(empId-1);
    }

    @Override
    public EmployeePayrollData updateEmployeePayRollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        for (EmployeePayrollData empdata : employeePayrollDataList) {
                if(empdata.getEmployeeId() == empId) {
                    empdata.setName(employeePayrollDTO.name);
                    empdata.setSalary(employeePayrollDTO.salary);
                    return empdata;
                }
        }
        return null;
    }
}
