package archive.main.app.activity;

import archive.main.auth.AppAuth;
import archive.main.auth.listener.AuthStateListener;
import archive.main.entity.user.UserEntity;

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
        LoginActivity.loginUser(email, password, this.auth);
    }
    private void registerCustomer(String email, String password){
        registerUser(email, password, this.auth);
    }

    private void terminate() {
        this.auth.removeAuthStateListener(this.authStateListener);
    }
}
