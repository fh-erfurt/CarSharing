package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.api.request.AddEmployeeRequest;
import com.javaii.carsharing.api.request.LoginRequest;
import com.javaii.carsharing.model.Branch;
import com.javaii.carsharing.model.Employee;
import com.javaii.carsharing.repository.BranchRepository;
import com.javaii.carsharing.repository.EmployeeRepository;
import com.javaii.carsharing.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    BranchRepository branchRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Employee findEmployeeByUserNameAndPassword(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        return employeeRepository.findEmployeeByUserNameAndPassword(userName, password);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public long addEmployee(AddEmployeeRequest request) {
        Branch branch = extractBranchFromRepository(request.getBranchId());
        Employee employee = new Employee();
        employee.setBranch(branch);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPosition(request.getPosition());
        employee.setPassword(request.getPassword());
        employee.setUserName(request.getUserName());
        employee = employeeRepository.save(employee);
        return employee.getId();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getById(id);
    }

    private Branch extractBranchFromRepository(Long branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        if (optionalBranch.isEmpty()) {
            throw new IllegalArgumentException("There is no such a branch within database");
        }
        return optionalBranch.get();
    }
}
