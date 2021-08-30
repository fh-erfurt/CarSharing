package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddCarRequest;
import com.javaii.carsharing.model.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarService {
    Long addCar(AddCarRequest request);
    List<Car> findAll();
    void deleteCarById(long id);
    Car findCarById(long id);
    List<Car> findAvailableCars(LocalDateTime startDate, LocalDateTime endDate, long branchId);
    void updateCar(AddCarRequest request, long id);
}
