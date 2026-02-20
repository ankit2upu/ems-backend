package net.ems.ems_backend.service;

import java.util.List;

import net.ems.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    //build add employee rest api
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //get employee rest api
    EmployeeDto getEmployeeById(Long employeeId);

    //method for get all employee rest api
    List <EmployeeDto> getAllEmployees();

    // method for update rest api
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    //build delete employee rest api
    void deleteEmployee(Long employeeId);


}
