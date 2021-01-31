package archive.main.auth.listener;

import archive.main.auth.AppAuth;

// Listener called when there is a change in the authentication state.
public interface AuthStateListener {
    // This method gets invoked in the UI thread on changes in the authentication state:
    //
    //Right after the listener has been registered
    //When a user is signed in
    //When the current user is signed out
    //When the current user changes
    // archive.main.auth	- use it to disambiguate which Auth instance the event corresponds to,
    // in the case where you are using more than one at the same time.
    void onAuthStateChanged(AppAuth appAuth);
}
