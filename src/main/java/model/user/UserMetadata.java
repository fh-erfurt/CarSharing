package model.user;

import java.sql.Timestamp;

// this class stores metadata to monitor the login activity of an account
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


    public long getDurationSinceCreation() {

        long durationSinceCreation = getDurationInMilliseconds(creationTimestamp);

        return durationSinceCreation;
    }


    public Timestamp getLastSignInTimestamp() {

        return lastSignInTimestamp;
    }


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


    public long getDurationSinceLastRefresh() {

        long durationSinceLastRefresh = 0;

        if (lastRefreshTimestamp != null) {
            durationSinceLastRefresh = getDurationInMilliseconds(lastRefreshTimestamp);

        }

        return durationSinceLastRefresh;
    }
}

