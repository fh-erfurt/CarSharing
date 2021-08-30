package com.javaii.carsharing.controller;

import com.javaii.carsharing.api.request.AddCustomerRequest;
import com.javaii.carsharing.api.request.LoginRequest;
import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Employee;
import com.javaii.carsharing.service.CarService;
import com.javaii.carsharing.service.impl.CustomerServiceImpl;
import com.javaii.carsharing.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    CustomerServiceImpl customerService;
    CarService carService;
    EmployeeServiceImpl employeeService;

    public HomeController(CustomerServiceImpl customerService, CarService carService, EmployeeServiceImpl employeeService) {
        this.customerService = customerService;
        this.carService = carService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        model.addAttribute("cars", carService.findAll());
        CustomerController.setCustomer(null);
        EmployeeController.setEmployee(null);
        return "index";
    }

    @RequestMapping("/loginForm")
    public String viewLoginForm(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "home/loginForm";
    }

    @RequestMapping("/register")
    public String viewRegisterForm(Model model) {
        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        model.addAttribute("addCustomerRequest", addCustomerRequest);
        return "home/register";
    }

    @GetMapping("/login")
    public String loginUser(@ModelAttribute("loginRequest") LoginRequest request, Model model) {
        Employee employee = employeeService.findEmployeeByUserNameAndPassword(request);
        if (employee != null) {
            model.addAttribute("user", employee);
            EmployeeController.setEmployee(employee);
            if (employee.isAdmin()) return "admin/panel";
            return "employee/panel";
        }
        Customer customer = customerService.findCustomerByUserNameAndPassword(request);
        if (customer != null) {
            CustomerController.setCustomer(customer);
            model.addAttribute("user", customer);
            CustomerController.setCustomer(customer);
            return "customer/panel";
        }
        return "home/invalid-login";
    }

}
