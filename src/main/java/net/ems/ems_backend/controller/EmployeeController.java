package net.ems.ems_backend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ems.ems_backend.dto.EmployeeDto;
import net.ems.ems_backend.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")  //base url of api
public class EmployeeController {
    // dependency inject
    private EmployeeService employeeService;
    // private final  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
       EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(employeeDto);

    }

    //build get all employees rest api
    @GetMapping
    public ResponseEntity<List <EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }

    //build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
    




}
