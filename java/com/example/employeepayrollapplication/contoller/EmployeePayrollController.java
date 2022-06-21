package com.example.employeepayrollapplication.contoller;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import com.example.employeepayrollapplication.dto.ResponseDTO;
import com.example.employeepayrollapplication.model.EmployeePayrollData;
import com.example.employeepayrollapplication.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controller class with @RestController annotation which receives rest api calls
 * and provide response in form json or xml */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.getEmployeePayRollData();
        ResponseDTO responseDTO = new ResponseDTO("Get call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Getting data from server */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayrollService.getEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get employee data by Id success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /* Posting data to server */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = employeePayrollService.addEmployeePayRollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create employee payroll data  successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create/param")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestParam(value = "name") String name, @RequestParam(value = "salary") long salary) {
        EmployeePayrollDTO employeePayrollDTO = new EmployeePayrollDTO(name, salary);
        EmployeePayrollData employeePayrollData = employeePayrollService.addEmployeePayRollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee payroll data successfully using request params", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /* Deleting data from server */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataById(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayRollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", "Deleted by id: " + empId);
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    /* Updating data to server */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayRollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated data successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
