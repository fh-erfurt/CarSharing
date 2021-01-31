package entity.user;

import entity.beta.appentity.AppEntityMetadata;

import java.sql.Time;
import java.sql.Timestamp;

// Contains additional metadata associated with a user account.
public interface UserEntityMetadata {
    // Returns the time at which the account was created.
    Timestamp getCreationTimestamp();
    //
    //Returns
    //Milliseconds since epoch timestamp.
    long getDurationSinceCreation();

    // Returns the time at which the user last signed in.
    Timestamp getLastSignInTimestamp();
    //
    //Returns
    //Milliseconds since epoch timestamp, or 0 if the user has never signed in.
    long getDurationSinceLastSignIn();

    // Returns the time at which the user was last active (ID token refreshed).
    Timestamp getLastRefreshTimestamp();
    //
    //Returns
    //Milliseconds since epoch timestamp, or 0 if the user was never active.
    long getDurationSinceLastRefresh();
}
