package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.api.request.AddCarRequest;
import com.javaii.carsharing.model.Branch;
import com.javaii.carsharing.model.Car;
import com.javaii.carsharing.model.Reservation;
import com.javaii.carsharing.repository.BranchRepository;
import com.javaii.carsharing.repository.CarRepository;
import com.javaii.carsharing.service.CarService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private BranchRepository branchRepository;

    public CarServiceImpl(CarRepository carRepository, BranchRepository branchRepository) {
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Long addCar(AddCarRequest request) {
        Branch branch = this.extractBranchFromRepository(request.getBranchId());
        Car car = this.addCarToDataSource(request, branch);
        return car.getId();
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car findCarById(long id) {
        return carRepository.getById(id);
    }

    @Override
    public List<Car> findAvailableCars(LocalDateTime startDate, LocalDateTime endDate, long branchId) {
        Branch branch = this.branchRepository.getById(branchId);

        List<Car> carsFromTheBranch = carRepository.findAllByBranchId(branch.getId());
        List<Car> availableCars = new ArrayList<>();

        LocalDateTime reservationEnd;
        LocalDateTime reservationStart;
        for (Car car : carsFromTheBranch) {
            List<Reservation> reservations = car.getReservations();
            boolean isAvailable = true;
            if (reservations != null) {
                for (Reservation r : reservations){
                    reservationEnd = r.getReservationEnd();
                    reservationStart = r.getReservationStart();
                    if (!((startDate.isBefore(reservationStart) && endDate.isBefore(reservationStart)) ||
                            startDate.isAfter(reservationEnd) && endDate.isAfter(reservationEnd))) isAvailable = false;
                }
            }
            if (isAvailable)
                availableCars.add(car);
        }
        return availableCars;
    }

    @Override
    public void updateCar(AddCarRequest request, long id) {
        Branch branch = branchRepository.getById(request.getBranchId());
        Car car = this.configureNewCar(request, branch);
        car.setId(id);
        /*Car previousCopy = this.carRepository.getById(id);
        previousCopy = car;*/
        carRepository.save(car);
    }

    private Branch extractBranchFromRepository(Long branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        if (optionalBranch.isEmpty()) {
            throw new IllegalArgumentException("There is no such a branch within database");
        }
        return optionalBranch.get();
    }

    private Car addCarToDataSource(AddCarRequest request, Branch branch){
        Car car = this.configureNewCar(request, branch);
        return carRepository.save(car);
    }

    private Car configureNewCar(AddCarRequest request, Branch branch) {
        Car car = new Car();
        car.setBasePricePerDay(request.getBasePricePerDay());
        car.setBrand(request.getBrand());
        car.setBranch(branch);
        car.setModel(request.getModel());
        car.setProductionYear(request.getProductionYear());
        car.setSpecification(request.getSpecification());
        return car;
    }

}
