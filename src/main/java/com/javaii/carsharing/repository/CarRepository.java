package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByBranchId(long branch_id);
}
