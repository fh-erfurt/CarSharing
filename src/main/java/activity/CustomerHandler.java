package activity;

import auth.*;
import data.DriversAvailable;
import data.Locations;
import model.location.Location;
import model.user.User;

import java.util.HashMap;

public class CustomerHandler extends UserHandler {
    private Auth auth;
    private AuthListener authListener;
    private boolean requestMade;

    CustomerHandler(){
        this.init();
    }

    private void init(){
        this.auth = Auth.getInstance();
        this.authListener = authListener -> {
            assert Auth.getInstance() != null;
            User user = Auth.getInstance().getCurrentUser();
        };
    }
    void loginCustomer(String email, String password){
        loginUser(email, password, this.auth);
    }
    void registerCustomer(String email, String password){
        registerUser(email, password, this.auth);
    }
    void terminateProcess(){
        this.auth.removeAuthListener(this.authListener);
    }
    public void updateLocation(Location location){
        assert Auth.getInstance() != null;
        User user = Auth.getInstance().getCurrentUser();
        Locations.updateCustomerLocation(user.getUserId(), location);
    }

    void makeRequest(){
        Location pickupLocation = UserHandler.getLastLocation();
        // set request made parameter to true
        // while request made parameter is true
        // notify customer searching for nearby driver
        // get closest driver
        // show driver location on customer map
        // compare location of closest driver periodically
        // if location of closest driver less than (100)
        // notify customer driver has arrived
        // otherwise notify customer driver arriving
    }

    private User getClosestDriver(Location location) {
        HashMap<String, Location> driversAvailable = DriversAvailable.getDriverLocations();
        // while request made is true and closest driver not found
        // compare location distance to customer and find nearest driver
        // notify driver of available customer
        // if driver accepts, return driver and notify customer
        // else find next closest driver
        return null;
    }

    void cancelRequest(){
        // set request made parameter to false and cancel search for driver process
    }

    void getDriverPickupLocation(){

    }

}
