package app.activity;

import auth.AppAuth;
import auth.listener.AuthStateListener;
import entity.user.UserEntity;

public class CustomerLoginActivity extends LoginActivity {
    private AppAuth auth;
    private AuthStateListener authStateListener;

    CustomerLoginActivity() {

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
    private void loginCustomer(String email, String password){
        DriverLoginActivity.loginUser(email, password, this.auth);
    }
    private void registerCustomer(String email, String password){
        registerUser(email, password, this.auth);
    }

    private void terminate() {
        this.auth.removeAuthStateListener(this.authStateListener);
    }
}
