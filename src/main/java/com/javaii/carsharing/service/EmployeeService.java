package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddEmployeeRequest;
import com.javaii.carsharing.api.request.LoginRequest;
import com.javaii.carsharing.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeByUserNameAndPassword(LoginRequest request);
    List<Employee> findAll();
    void deleteEmployeeById(long employeeId);
    long addEmployee(AddEmployeeRequest request);
    Employee getEmployeeById(long id);
}
