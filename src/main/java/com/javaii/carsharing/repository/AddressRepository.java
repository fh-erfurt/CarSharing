package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
