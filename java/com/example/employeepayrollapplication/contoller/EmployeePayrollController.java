package com.example.employeepayrollapplication.contoller;

import com.example.employeepayrollapplication.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* Controller class with @RestController annotation which receives rest api calls
 * and provide response in form json or xml */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<>("Get call success", HttpStatus.OK);
    }

    /* Getting data from server */
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollDataById(@PathVariable("empId") int empId) {
        return new ResponseEntity<>("Get call success for id: " + empId, HttpStatus.OK);
    }

    /* Posting data to server */
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<>("Created employee payroll data for: " + employeePayrollDTO, HttpStatus.OK);
    }

    /* Deleting data from server */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollDataById(@PathVariable("empId") int empId) {
        return new ResponseEntity<>("Deleted employee payroll data for: " + empId, HttpStatus.OK);
    }

    /* Updating data to server */
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<>("Updated employeepayroll data for: " + employeePayrollDTO, HttpStatus.OK);
    }
}
