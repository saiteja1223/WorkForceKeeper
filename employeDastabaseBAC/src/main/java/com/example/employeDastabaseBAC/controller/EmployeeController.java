package com.example.employeDastabaseBAC.controller;

import com.example.employeDastabaseBAC.model.EmployeeModel;
import com.example.employeDastabaseBAC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/Allemployees")
    public ResponseEntity<List<EmployeeModel>> getEmployees(){
       List <EmployeeModel> details=employeeService.getAllEmployeeDetails();

       return   new ResponseEntity<>(details, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeById(@PathVariable ("id")  Long id){
        EmployeeModel emp=employeeService.getEmployeeDetails(id);
       return  new ResponseEntity<>(emp,HttpStatus.OK);
    }
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel emp=employeeService.createEmployee(employeeModel);
        return new ResponseEntity<>(emp,HttpStatus.OK);

    }
    @DeleteMapping("/deleteAll")
        public ResponseEntity<Void> deleteAllEmp() {
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel>updateEmployee(@RequestBody EmployeeModel employeeModel, @PathVariable Long id){
           EmployeeModel  updatemploye=  employeeService.updateEmployee(id,employeeModel);
           return new ResponseEntity<>(updatemploye,HttpStatus.OK);

    }



}
