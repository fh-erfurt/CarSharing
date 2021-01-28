package entity.user;

import entity.beta.appentity.AppEntityMetadata;

// Contains additional metadata associated with a user account.
public interface UserEntityMetadata {
    // Returns the time at which the account was created.
    //
    //Returns
    //Milliseconds since epoch timestamp.
    long getCreationTimestamp();
    // Returns the time at which the user last signed in.
    //
    //Returns
    //Milliseconds since epoch timestamp, or 0 if the user has never signed in.
    long getLastSignInTimestamp();
    // Returns the time at which the user was last active (ID token refreshed).
    //
    //Returns
    //Milliseconds since epoch timestamp, or 0 if the user was never active.
    long getLastRefreshTimestamp();
}
