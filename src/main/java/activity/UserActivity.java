package activity;

import data.Locations;
import model.location.Location;
import task.*;
import auth.*;
import exception.*;
import model.user.User;

public class UserActivity {
    private static Location lastKnownLocation;
    static void registerUser(String email, String password, Auth auth) {
        try {
            auth.createUser(email, password).addOnCompleteListener(new OnCompleteListener<AuthResponse>() {

                @Override
                public void onComplete(Task<AuthResponse> task) {
                    if(!task.isSuccessful()){
                        // report sign up error
                    } else {
                        String user_id = auth.getCurrentUser().getUserId();
                        // add new customer to archive.main.database
                    }
                }
            });
        } catch (InvalidCredentialException | UserCollisionException | WeakPasswordException e){
            e.getErrorCode();
        }
    }
    static void loginUser(String email, String password, Auth auth){
        try {
            auth.signIn(email, password).addOnCompleteListener(new OnCompleteListener<AuthResponse>() {

                @Override
                public void onComplete(Task<AuthResponse> task) {
                    if(!task.isSuccessful()){
                        // report sign in error
                    } else {
                        String user_id = auth.getCurrentUser().getUserId();
                        // sign in driver
                    }
                }
            });
        } catch (InvalidUserException | InvalidCredentialException e) {
            e.getErrorCode();
        }
    }

    static Location getLastLocation(){
        return UserActivity.lastKnownLocation;
    }

}
