package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.model.Customer;
import com.javaii.carsharing.model.Invoice;
import com.javaii.carsharing.model.Rental;
import com.javaii.carsharing.repository.InvoiceRepository;
import com.javaii.carsharing.repository.RentalRepository;
import com.javaii.carsharing.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    InvoiceRepository invoiceRepository;
    RentalRepository rentalRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, RentalRepository rentalRepository) {
        this.invoiceRepository = invoiceRepository;
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public long addInvoiceForRental(long rentalId) {
        Rental rental = rentalRepository.getById(rentalId);
        Invoice invoice = new Invoice();
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setRental(rental);
        return invoiceRepository.save(invoice).getId();
    }

    @Override
    public List<Invoice> findAllByCustomer(Customer customer) {
        List<Invoice> allInvoices = invoiceRepository.findAll();
        List<Invoice> customerInvoices = new ArrayList<>();
        for (Invoice inv : allInvoices){
            if (inv.getRental().getReservation().getCustomer().getId() == customer.getId()) customerInvoices.add(inv);
        }
        return customerInvoices;
    }
}
