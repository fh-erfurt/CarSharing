/*package auth;

public class AuthReference {
    package auth;

import app.App;
import auth.beta.actioncode.ActionCodeResult;
import auth.beta.idtoken.IdTokenListener;
import auth.listener.AuthStateListener;
import entity.beta.appentity.AppEntity;
import entity.user.UserEntity;
import exception.authexception.*;
import job.Job;

// Salma und Sarah

    public class Auth extends AppAuth{
        //register a Listener
        // mehrere Registrieren fehlt
        @Override
        public void addAuthStateListener(AuthStateListener listener) {
            class CompositeListener implements OnEventListener{
                private List<OnEventListener> addAuthStateListener= new ArrayList<OnEventListener>();

                public void addAuthStateListener (OnEventListener AuthStateListener) {
                    AuthStateListener.add(AuthStateListener);
                }

                public void onEvent(Event e) {
                    for(OnEventListener listener:AuthStateListener) {
                        listener.onEvent(e);
                    }
                }
            }
        }

        //removes Listener
        @Override
        public void removeAuthStateListener(AuthStateListener listener) {

            AuthStateListener.remove(AuthStateListener.class, listener);
        }

        //registers a Listener
        // mehrere Registrieren fehlt
        @Override
        public void addIdTokenListener(IdTokenListener listener) {

            class CompositeListener implements OnEventListener{
                private List<OnEventListener> addIdTokenListener= new ArrayList<OnEventListener>();

                public void addIdTokenListener (OnEventListener IdTokenListener) {
                    AuthStateListener.add(IdTokenListener);
                }

                public void onEvent(Event e) {
                    for (OnEventListener listener : IdTokenListener) {
                        listener.onEvent(e);
                    }
                }
            }
        }

        //removes Listener
        @Override
        public void removeIdTokenListener(IdTokenListener listener) {

            IdTokenListener.remove(IdTokenListener.class, listener);
        }

        // applies the given code (any valid out of band code)
        @Override
        public void subscribe(CompletableEmitter emitter) throws Exception {
            RxCompletableHandler.assignOnTask(emitter, Auth.applyActionCode(code));
        };
        @test
        public Job<Void> applyAccessCode(String code) {
            TestObserver authTestObserver = RxAuth
                    .applyAccessCode(Auth, ANY_CODE)
                    .test();
            testOnCompleteListener.getValue().onComplete(voidTask);
            verify(Auth).applyAccessCode(eq(ANY_CODE));
            authTestObserver.assertNoErrors()
                    .assertValueSet(Collections.singletonList(voidTask))
                    .assertComplete()
                    .dispose();
            return null;
        }

        // checks that code given is valid.
        @Override
        public void subscribe(MaybeEmitter<AccessCodeResult> emitter) throws Exception {
            RxHandler.assignOnTask(emitter, Auth.checkAccessCode(code));
        };
        @Test
        public Job<ActionCodeResult> checkAccessCode(String code) {
            TestObserver<ActionCodeResult> authTestObserver = RxAuth
                    .checkActionCode(Auth, ANY_CODE)
                    .test();
            testOnSuccessListener.getValue().onSuccess(actionCodeResult);
            testOnCompleteListener.getValue().onComplete(actionCodeResultTask);
            verify(Auth).checkActionCode(eq(ANY_CODE));
            authTestObserver.assertNoErrors()
                    .assertValueCount(1)
                    .assertValueSet(Collections.singletonList(actionCodeResult))
                    .assertComplete()
                    .dispose();
            return null;
        }

        // changes the entity's password to newPassword for the account for which the code is valid.
        //checks Password Integrity
        @Override
        public Job<Void> confirmPasswordReset(String code, String newPassword) throws IllegalArgumentException, AuthActionCodeException, AuthInvalidUserException, AuthWeakPasswordException {
            @Test
            public void confirmPasswordReset() {
                TestObserver authTestObserver = RxAuth
                        .confirmPasswordReset(Auth, ANY_CODE, ANY_PASSWORD)
                        .test();
                testOnCompleteListener.getValue().onComplete(voidTask);
                verify(Auth).confirmPasswordReset(eq(ANY_CODE), eq(ANY_PASSWORD));
                authTestObserver.assertNoErrors()
                        .assertValueSet(Collections.singletonList(voidTask))
                        .assertComplete()
                        .dispose();
            }
            public static void checkPasswordIntegrity(String password) throws PasswordWeakException {
                if (password.length() < 8
                        || !(password.matches("(?=.[A-Z]).")
                        && password.matches("(?=.[a-z]).")
                        && password.matches("(?=.[0-9])."))) {
                    throw new PasswordWeakException(
                            "The chosen password is too weak. Password must be at least 8 chars and contain one lower case letter, "
                                    + "one "
                                    + "upper case letter and one digit");
                }
            }

            return null;
        }

        // creates new user account with given email and password
        @Override
        public Job<AppAuthResult> createUserEntity(String email, String password) throws AuthWeakPasswordException, AuthInvalidCredentialException, AuthUserCollisionException {
            .auth().createUserEntity(email, password)
                    .then((userCredential) => {
                    // Signed in
                    var user = userCredential.user;
            // ...
        })
        .catch((error) => {
                    var errorCode = error.code;
            var errorMessage = error.message;
            // ..
        });
            //creates Message for weak Password
            public static void checkPasswordIntegrity(String password) throws PasswordWeakException {
                if (password.length() < 8
                        || !(password.matches("(?=.[A-Z]).")
                        && password.matches("(?=.[a-z]).")
                        && password.matches("(?=.[0-9])."))) {
                    throw new PasswordWeakException(
                            "The chosen password is too weak. Password must be at least 8 chars and contain one lower case letter, "
                                    + "one "
                                    + "upper case letter and one digit");
                }
            }
        }
        //creates Exception
        protected InvalidCredentialException createException(final String message) {
            return new InvalidCredentialException(message);
        }

        return null;
    }

    @Override
    public App getApp() {
        return null;
    }

    // returns the current signed-in UserEntity or null if there is none
    @Override
    public UserEntity getCurrentUserEntity() {
        //public Boolean userAuthenticated()
        return Auth.getInstance().getCurrentUser() != null;

    }

    // returns an instance of this class corresponding to the default app instance      war bei AppAuth.java enthalten bei Auth.java nicht
    //public static AppAuth getInstance(){
    //public Boolean userAuthenticated() {
    //return Auth.getInstance() != null;}


    // triggers the authentication backend to send a password-reset email to the given email address, which must correspond to the an existing user of the app
    @Override
    public Job<Void> Completable sendPasswordResetEmail(final String email){

        return Completable.create(
                emitter->{
                    OnCompleteListener<Void> resultHandler = task->{
                        if (task.isSuccessful()) {
                            emitter.onComplete();
                        } else {
                            emitter.onError(getError(DatabaseError.fromException(task.getException())));
                        }
                    };
                    Auth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(resultHandler);
                }).subscribeOn(Schedulers.single());


        return null;
    }


    // tries to sign in a user with the given email address and password
    @Override
    public Job<AppAuthResult> signInWithEmailAndPassword(final Activity activity, String email, String password)
    {
        Auth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "performLogin:onComplete:" + task.isSuccessful());
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            mOnLoginListener.onSuccess(task.getResult().toString());
                            updateToken(task.getResult().getUser().getUid(),
                                    new SharedPrefUtil(activity.getApplicationContext()).getString(Constants.ARG__TOKEN, null));
                        } else {
                            mOnLoginListener.onFailure(task.getException().getMessage());
                        }
                    }
                });

        return null;
    }

    // signs out current entity
    @Override
    public void signOut() {
        if (Auth.getCurrentUser() != null) {
            Auth.getCurrentUser().signOut();
            mOnLogoutListener.onSuccess("Successfully logged out!");
        } else {
            mOnLogoutListener.onFailure("No user logged in yet!");
        }
    }

    //updates a current user(UserName, Email, Adress)
    @Override
    public Job<Void> updateCurrentUserEntity(AppEntity entity) {
        var user = .auth().currentUser;

        user.updateUserName("Jane Q. User") .then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });
        user.updateEmail("user@example.com") .then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });
        user.updateAdress("Teststreet 5").then(function() {
            // Update successful.
        }).catch(function(error) {
            // An error happened.
        });
        return null;
    }

    // checks that code is a valid password reset out of band code
    @Override
    public void subscribe(MaybeEmitter<String> emitter) throws Exception {
        RxHandler.assignOnTask(emitter, Auth.verifyPasswordResetCode(code));

    });
    @Test
    public Job<String> verifyPasswordResetCode(String code) {
        TestObserver<String> authTestObserver = RxAuth
                .verifyPasswordResetCode(Auth, ANY_CODE)
                .test();
        testOnSuccessListener.getValue().onSuccess(RESULT_CODE);
        testOnCompleteListener.getValue().onComplete(checkCodeResultTask);
        verify(Auth).verifyPasswordResetCode(ANY_CODE);
        authTestObserver.assertNoErrors()
                .assertValueCount(1)
                .assertValueSet(Collections.singletonList(RESULT_CODE))
                .assertComplete()
                .dispose();

        return null;
    }
}*/
