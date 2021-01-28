package app.activity;

import auth.AppAuth;
import auth.listener.AuthStateListener;
import entity.user.UserEntity;

public class DriverUserLoginActivity extends UserLoginActivity {
    private AppAuth auth;
    private AuthStateListener authStateListener;

    DriverUserLoginActivity() {

        this.init();

    }
    private void init(){
        this.auth = AppAuth.getInstance();
        this.authStateListener = appAuth -> {
            assert AppAuth.getInstance() != null;
            UserEntity user = AppAuth.getInstance().getCurrentUserEntity();
        };
    }
    private void loginDriver(String email, String password){
        loginUser(email, password, this.auth);
    }



    private void registerDriver(String email, String password){
        registerUser(email, password, this.auth);
    }

    private void terminate() {
        this.auth.removeAuthStateListener(this.authStateListener);
    }
}
