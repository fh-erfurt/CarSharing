package app.activity;

import auth.AppAuth;
import auth.AppAuthResult;
import auth.listener.AuthStateListener;
import entity.user.UserEntity;
import exception.authexception.AuthInvalidCredentialException;
import exception.authexception.AuthInvalidUserException;
import exception.authexception.AuthUserCollisionException;
import job.Job;
import job.statelistener.OnCompleteListener;

public class DriverLoginActivity {
    private AppAuth auth;
    private AuthStateListener authStateListener;

    DriverLoginActivity() {

        this.init();

    }
    private void init(){
        this.auth = AppAuth.getInstance();
        this.authStateListener = new AuthStateListener() {

            @Override
            public void onAuthStateChanged(AppAuth appAuth) {
                assert AppAuth.getInstance() != null;
                UserEntity user = AppAuth.getInstance().getCurrentUserEntity();

            }
        };
    }
    private void loginDriver(String email, String password){
        try {
            this.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AppAuthResult>() {

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
    private void registerDriver(String email, String password){
        try {
            this.auth.createUserEntity(email, password).addOnCompleteListener(new OnCompleteListener<AppAuthResult>() {

                @Override
                public void onComplete(Job<AppAuthResult> job) {
                    if(!job.isSuccessful()){
                        // report sign up error
                    } else {
                        String user_id = auth.getCurrentUserEntity().getUserId();
                        // add new driver to database
                    }
                }
            });
        } catch (AuthInvalidCredentialException | AuthUserCollisionException e) {
            e.getErrorCode();
        }
    }

    private void terminate() {
        this.auth.removeAuthStateListener(this.authStateListener);
    }
}
