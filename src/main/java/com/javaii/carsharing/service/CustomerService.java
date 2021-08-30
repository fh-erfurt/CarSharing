package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddCustomerRequest;
import com.javaii.carsharing.api.request.LoginRequest;
import com.javaii.carsharing.model.Customer;

public interface CustomerService {
    long addCustomer(AddCustomerRequest request);
    Customer findCustomerById(long id);
    Customer findCustomerByUserNameAndPassword(LoginRequest request);
}
