package activity;

import auth.*;
import data.Locations;
import model.location.Location;
import model.user.User;

public class CustomerActivity extends UserActivity {
    private Auth auth;
    private AuthListener authListener;

    CustomerActivity(){
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
        Location pickupLocation = UserActivity.getLastLocation();
    }

    private void getClosestDriver() {

    }
}
