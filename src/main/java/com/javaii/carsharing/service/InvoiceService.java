package com.javaii.carsharing.service;

import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
    long addInvoiceForRental(long rentalId);
    List<Invoice> findAllByCustomer(Customer customer);
}
