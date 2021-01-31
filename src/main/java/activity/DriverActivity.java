package activity;

import auth.*;
import data.Locations;
import model.location.Location;
import model.user.User;

public class DriverActivity extends UserActivity {
    private Auth auth;
    private AuthListener authListener;

    DriverActivity(){
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
        UserActivity.loginUser(email, password, this.auth);
    }
    public void registerDriver(String email, String password){
        UserActivity.registerUser(email, password, this.auth);
    }
    void terminateProcess(){
        this.auth.removeAuthListener(this.authListener);
    }
    public void updateLocation(Location location){
        assert Auth.getInstance() != null;
        User user = Auth.getInstance().getCurrentUser();
        Locations.updateDriverLocation(user.getUserId(), location);
    }
    public void onEndRide(){

    }
}
