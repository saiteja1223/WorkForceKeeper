package com.example.employeDastabaseBAC.service;

import com.example.employeDastabaseBAC.exception.resourceNotFoundException;
import com.example.employeDastabaseBAC.model.EmployeeModel;
import com.example.employeDastabaseBAC.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
      public List<EmployeeModel> getAllEmployeeDetails(){
           return employeeRepository.findAll();

      }
      public EmployeeModel getEmployeeDetails(Long id){
           return  employeeRepository.findById(id).
                   orElseThrow(() -> new resourceNotFoundException("Employee not exist with id: " + id));
      }
      public void deleteEmployee( Long id){
            employeeRepository.deleteById(id);
      }
      public void deleteAllEmployees(){
            employeeRepository.deleteAll();
      }
      public EmployeeModel createEmployee( EmployeeModel employee){
          return employeeRepository.save(employee);

      }
      public EmployeeModel updateEmployee(Long id,EmployeeModel employee){
          EmployeeModel oldEmployee=employeeRepository.findById(id).
                  orElseThrow(() -> new resourceNotFoundException("Employee not exist with id: " + id));
          oldEmployee.setFirstName(employee.getFirstName());
          oldEmployee.setSalary(employee.getSalary());
          oldEmployee.setTechnology(employee.getTechnology());
          return employeeRepository.save(oldEmployee);

      }


}
