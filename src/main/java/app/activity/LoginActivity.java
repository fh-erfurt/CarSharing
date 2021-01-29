package app.activity;

import auth.AppAuth;
import auth.AppAuthResult;
import exception.authexception.AuthInvalidCredentialException;
import exception.authexception.AuthInvalidUserException;
import exception.authexception.AuthUserCollisionException;
import job.Job;
import job.statelistener.OnCompleteListener;

public class LoginActivity {
    static void registerUser(String email, String password, AppAuth auth) {
        try {
            auth.createUserEntity(email, password).addOnCompleteListener(new OnCompleteListener<AppAuthResult>() {

                @Override
                public void onComplete(Job<AppAuthResult> job) {
                    if(!job.isSuccessful()){
                        // report sign up error
                    } else {
                        String user_id = auth.getCurrentUserEntity().getUserId();
                        // add new customer to database
                    }
                }
            });
        } catch (AuthInvalidCredentialException | AuthUserCollisionException e) {
            e.getErrorCode();
        }
    }

    static void loginUser(String email, String password, AppAuth auth) {
        try {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AppAuthResult>() {

                @Override
                public void onComplete(Job<AppAuthResult> job) {
                    if(!job.isSuccessful()){
                        // report sign in error
                    } else {
                        String user_id = auth.getCurrentUserEntity().getUserId();
                        // sign in driver
                    }
                }
            });
        } catch (AuthInvalidUserException | AuthInvalidCredentialException e) {
            e.getErrorCode();
        }
    }
}
