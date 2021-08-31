package com.javaii.carsharing.controller;

import com.javaii.carsharing.api.request.AddCustomerRequest;
import com.javaii.carsharing.api.request.AddReservationRequest;
import com.javaii.carsharing.model.*;
import com.javaii.carsharing.service.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImpl customerService;
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;
    private ReservationServiceImpl reservationService;
    private InvoiceServiceImpl invoiceService;
    private Reservation reservation;

    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        CustomerController.customer = customer;
    }

    public CustomerController(CustomerServiceImpl customerService,
                              BranchServiceImpl branchService,
                              CarServiceImpl carService,
                              ReservationServiceImpl reservationService,
                              InvoiceServiceImpl invoiceService) {
        this.customerService = customerService;
        this.branchService = branchService;
        this.carService = carService;
        this.reservationService = reservationService;
        this.invoiceService = invoiceService;
    }

    @RequestMapping("/")
    public String viewPanel() {
        return "customer/panel";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("addCustomerRequest") AddCustomerRequest request, Model model) {
        long customerId = customerService.addCustomer(request);
        if (customerId != -1) {
            Customer customer = customerService.findCustomerById(customerId);
            CustomerController.setCustomer(customer);
            model.addAttribute("customer", customer);
            return "/customer/panel";
        }
        return "index";
    }

    @RequestMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        Customer customer = (Customer) model.getAttribute("user");
        List<AddReservationRequest> addReservationRequests = new LinkedList<>();
        for(Car car: cars){
            addReservationRequests.add(new AddReservationRequest(car, customer));
        }
        model.addAttribute("addReservationRequests", addReservationRequests);
        return "customer/cars";
    }

    @RequestMapping("/findCars")
    public String findCars(Model model){
        AddReservationRequest request = new AddReservationRequest();
        model.addAttribute("addReservationRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "customer/findCars";
    }

    @GetMapping("/availableCars")
    public String showFoundCars(@ModelAttribute("addReservationRequest") AddReservationRequest request, Model model) {
        LocalDateTime start = request.getReservationStart();
        LocalDateTime end = request.getReservationEnd();
        reservation = new Reservation();
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setCustomer(customer);
        reservation.setReservationStart(start);
        reservation.setReservationEnd(end);
        List<Car> availableCars = carService.findAvailableCars(start, end, request.getBranchId());
        String city = branchService.getBranchById(request.getBranchId()).getAddress().getCity();
        long numOfDays = Duration.between(start, end).toDays();
        model.addAttribute("addReservationRequest", request);
        model.addAttribute("availableCars", availableCars);
        model.addAttribute("city", city);
        model.addAttribute("days", numOfDays);
        return "customer/availableCars";
    }

    @RequestMapping("/reservations")
    public String viewReservations(Model model){
        List<Reservation> reservations = reservationService.findReservationsByCustomer(customer);
        model.addAttribute("reservations", reservations);
        return "customer/reservations";
    }

    @RequestMapping("/createReservation")
    public String createReservation(@RequestParam("carId") long carId,
                                    Model model){
        reservation.setCar(carService.findCarById(carId));
        long numOfDays = Duration.between(reservation.getReservationStart(),reservation.getReservationEnd()).toDays();
        double cost = reservation.getCar().getBasePricePerDay() * numOfDays;
        reservation.setCost(cost);
        reservationService.addReservation(reservation);
        List<Reservation> reservations = reservationService.findReservationsByCustomer(customer);
        model.addAttribute("reservations", reservations);
        return "customer/reservations";
    }

    @RequestMapping("/deleteReservation")
    public String deleteReservation(@RequestParam("reservationId") long id){
        reservationService.deleteReservation(id);
        return "redirect:/customer/reservations";
    }

    @RequestMapping("/invoices")
    public String viewInvoices(Model model){
        List<Invoice> invoices = invoiceService.findAllByCustomer(customer);
        model.addAttribute("invoices", invoices);
        return "customer/invoices";
    }
}
