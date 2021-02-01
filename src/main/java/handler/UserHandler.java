/**
 * This class contains methods, so a user can even use the functions of the application
 * meaning functions to register to the service, log into it and recall their location
 */

package handler;

import model.location.Location;
import task.*;
import auth.*;
import exception.*;

public class UserHandler {
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
        return UserHandler.lastKnownLocation;
    }

}
