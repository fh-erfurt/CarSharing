package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByUserNameAndPassword(String username, String password);
}
