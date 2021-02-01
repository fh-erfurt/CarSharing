package handler;

import auth.*;
import data.Locations;
import model.location.Location;
import model.user.User;

public class DriverHandler extends UserHandler {
    private Auth auth;
    private AuthListener authListener;

    DriverHandler(){
        this.init();
    }

    private void init(){
        this.auth = Auth.getInstance();
        this.authListener = auth -> {
            assert Auth.getInstance() != null;
            User user = Auth.getInstance().getCurrentUser();
        };
    }
    public void loginDriver(String email, String password){
        UserHandler.loginUser(email, password, this.auth);
    }
    public void registerDriver(String email, String password){
        UserHandler.registerUser(email, password, this.auth);
    }
    void terminateProcess(){
        this.auth.removeAuthListener(this.authListener);
    }
    public void updateLocation(Location location){
        assert Auth.getInstance() != null;
        User user = Auth.getInstance().getCurrentUser();
        Locations.updateDriverLocation(user.getUserId(), location);
    }
    void notifyDriverOfRequest(){
        // notify driver of request available
    }
    void assignCustomerToDriver(){
        // if selected, assign customer to driver and update customer
    }
    void getCustomerPickupLocation(){
        // show customer location on driver map
    }
    public void onEndRide(){

    }
}
