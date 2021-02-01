/**
 * this class stores additional metadata of one specific account to monitor the login activity
 * it also contains methods to output the duration between a point of user activity and now
 * this class is constructed in the User-class, binding each object of it to one User-object
 */

package model.user;

import java.sql.Timestamp;

public class UserMetadata{

    private Timestamp creationTimestamp;
    private Timestamp lastSignInTimestamp;
    private Timestamp lastRefreshTimestamp;

    // constructor that notes the current time as its timestamp of creation
    public UserMetadata () {

        this.creationTimestamp = new Timestamp(System.currentTimeMillis());
    }

    // gets the timestamp of the moment the function is called
    // calculates the duration between whatever start-point is needed and the current time in milliseconds
    public long getDurationInMilliseconds(Timestamp timestamp) {

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        long milliseconds = currentTimestamp.getTime() - timestamp.getTime();

        return milliseconds;
    }


    public Timestamp getCreationTimestamp() {

        return creationTimestamp;
    }


    // calculates duration since the point the account was created (in milliseconds)
    public long getDurationSinceCreation() {

        long durationSinceCreation = getDurationInMilliseconds(creationTimestamp);

        return durationSinceCreation;
    }


    public Timestamp getLastSignInTimestamp() {

        return lastSignInTimestamp;
    }


    // calculates the duration since the last sign-in (in milliseconds)
    // returns 0 if the user never signed-in
    public long getDurationSinceLastSignIn() {

        long durationSinceLastSignIn = 0;

        if (lastSignInTimestamp != null) {
            durationSinceLastSignIn = getDurationInMilliseconds(lastSignInTimestamp);

        }
        return durationSinceLastSignIn;
    }


    public Timestamp getLastRefreshTimestamp() {

        return lastRefreshTimestamp;
    }


    // calculates the duration since the last refresh (in milliseconds)
    // returns 0 if the user was never active
    public long getDurationSinceLastRefresh() {

        long durationSinceLastRefresh = 0;

        if (lastRefreshTimestamp != null) {
            durationSinceLastRefresh = getDurationInMilliseconds(lastRefreshTimestamp);

        }

        return durationSinceLastRefresh;
    }
}

