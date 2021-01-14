package carsharing.javaproject;

import java.util.*;

public class CarManager {

    private ArrayList<Car> carList;
    private int currentAmountOfCars;

    public CarManager () {
        currentAmountOfCars = 0;
    }

    //adds new Car object to the ArrayList
    void addCar (Car _newCar) {
        carList.add(_newCar);
        currentAmountOfCars += 1;
    }

    //deletes car out of ArrayList by given id
    void deleteCarById (int _ID) {

        for (Car counter: carList) {

            if (counter.getId() == _ID)
            {
                this.carList.remove(counter);
            }
        }

    }

    //returns ArrayList of cars which are neither in use or reserved
    ArrayList<Car> getCarsAvailable () {

        ArrayList<Car> result = new ArrayList<Car>();

        for (Car counter: carList) {

            if (!counter.getInUse() && !counter.getReserved())
            {
                result.add(counter);
            }
        }

        if (result.size() == 0){result = null;}

        return result;
    }

    //returns ArrayList of cars which are in use
    ArrayList<Car> getCarsInUse () {

        ArrayList<Car> result = new ArrayList<Car>();

        for (Car counter: carList) {

            if (counter.getInUse())
            {
                result.add(counter);
            }

        }

        if (result.size() == 0){
            result = null;
        }

        return result;
    }

    //returns ArrayList of cars which are reserved
    ArrayList<Car> getCarsReserved () {

        ArrayList<Car> result = new ArrayList<Car>();

        for (Car counter: carList) {

            if (counter.getReserved())
            {
                result.add(counter);
            }

        }

        if (result.size() == 0){result = null;}

        return result;
    }

    //returns ArrayList of cars which match the searched status
    ArrayList<Car> getCarsByStatus (Car.status _searchedStatus) {

        ArrayList<Car> result = new ArrayList<Car>();

        for (Car counter: carList) {

            if (counter.getCarStatus() == _searchedStatus)
            {
                result.add(counter);
            }

        }

        if (result.size() == 0){result = null;}

        return result;

    }

    //returns ArrayList of cars which match the searched type
    ArrayList<Car> getCarsByType (Car.types _searchedTypes) {

        ArrayList<Car> result = new ArrayList<Car>();

        for (Car counter: carList) {

            if (counter.getCarType() == _searchedTypes)
            {
                result.add(counter);
            }
        }

        if (result.size() == 0){result = null;}

        return result;
    }

    //returns the next available id for new car
    public int getNextAvailableId()
    {
        return currentAmountOfCars+1;
    }

}
