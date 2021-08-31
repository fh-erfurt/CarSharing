package com.javaii.carsharing.controller;

import com.javaii.carsharing.api.request.AddBranchRequest;
import com.javaii.carsharing.api.request.AddEmployeeRequest;
import com.javaii.carsharing.model.Branch;
import com.javaii.carsharing.model.Employee;
import com.javaii.carsharing.service.impl.BranchServiceImpl;
import com.javaii.carsharing.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private BranchServiceImpl branchService;
    private EmployeeServiceImpl employeeService;

    public AdminController(BranchServiceImpl branchService, EmployeeServiceImpl employeeService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String viewPanel(){
        return "admin/panel";
    }

    @RequestMapping("/employees")
    public String viewEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "admin/employees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model){
        AddEmployeeRequest request = new AddEmployeeRequest();
        model.addAttribute("addEmployeeRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "admin/addEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("addEmployeeRequest") AddEmployeeRequest request){
        employeeService.addEmployee(request);
        return "redirect:/admin/employees";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/admin/employees";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("employeeId") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        AddEmployeeRequest request = new AddEmployeeRequest();
        request.setBranchId(employee.getBranch().getId());
        request.setFirstName(employee.getFirstName());
        request.setLastName(employee.getLastName());
        request.setPassword(employee.getPassword());
        request.setUserName(employee.getPassword());
        request.setPosition(employee.getPosition());
        model.addAttribute("addEmployeeRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        employeeService.deleteEmployeeById(id);
        return "admin/addEmployee";
    }

    @RequestMapping("/branches")
    public String viewBranches(Model model){
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "admin/branches";
    }

    @RequestMapping("/addBranch")
    public String addBranch(Model model){
        AddBranchRequest request = new AddBranchRequest();
        model.addAttribute("addBranchRequest", request);
        return "admin/addBranch";
    }

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("addBranchRequest") AddBranchRequest request){
        branchService.addBranch(request);
        return "redirect:/admin/branches";
    }

    @GetMapping("/deleteBranch")
    public String deleteBranch(@RequestParam("branchId") long id){
        branchService.deleteBranchById(id);
        return "redirect:/admin/branches";
    }

    @GetMapping("/updateBranch")
    public String updateBranch(@RequestParam("branchId") long id, Model model){
        Branch branch = branchService.getBranchById(id);
        AddBranchRequest request = new AddBranchRequest();
        request.setCity(branch.getAddress().getCity());
        request.setPostalCode(branch.getAddress().getPostalCode());
        request.setStreet(branch.getAddress().getStreet());
        request.setStreetNumber(branch.getAddress().getStreetNumber());
        model.addAttribute("addBranchRequest", request);
        branchService.deleteBranchById(id);
        return "admin/addBranch";
    }

}
