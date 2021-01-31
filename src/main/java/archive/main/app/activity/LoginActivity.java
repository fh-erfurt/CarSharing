package archive.main.app.activity;

import archive.main.auth.AppAuth;
import archive.main.auth.AppAuthResult;
import archive.main.exception.authexception.AuthInvalidCredentialException;
import archive.main.exception.authexception.AuthInvalidUserException;
import archive.main.exception.authexception.AuthUserCollisionException;
import archive.main.job.Job;
import archive.main.job.statelistener.OnCompleteListener;

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
                        // add new customer to archive.main.database
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
