package auth;

import app.App;
import auth.listener.IdTokenListener;
import auth.listener.AuthStateListener;
import entity.SuperEntity;
import exception.authexception.*;
import job.Job;

public abstract class Auth {
    public void addAuthStateListener(AuthStateListener listener){

    }
    public void removeAuthStateListener(AuthStateListener listener){

    }
    public void addIdTokenListener(IdTokenListener listener){

    }
    public void removeIdTokenListener(IdTokenListener listener){

    }

    public Job<Void> applyAccessCode(String code){
        return null;
    }

    public Job<Void> confirmPasswordReset(String code, String newPassword) throws IllegalArgumentException, AuthAccessCodeException, AuthInvalidEntityException, AuthWeakPasswordException {
        return null;
    }

    public Job<AuthReport> createUser(String email, String password) throws AuthWeakPasswordException, AuthInvalidCredentialException, AuthEntityCollisionException {
        return null;
    }
    public App getApp(){
        return null;
    }
    public SuperEntity getCurrentUser(){
        return null;
    }
    public static Auth getInstance(){
        return null;
    }
    public Job<Void> sendPasswordResetEmail(String email){
        return null;
    }
    public Job<Void> sendSignInLinkToEmail(String email){
        return null;
    }
    public Job<AuthReport> SignInWithEmailAndPassword(String email, String password) throws AuthInvalidEntityException, AuthInvalidCredentialException {
        return null;
    }
    public void signOut(){

    }
    public Job<Void> updateCurrentEntity(SuperEntity entity){
        return null;
    }
    public Job<String> verifyPasswordResetCode(String code){
        return null;
    }
}
