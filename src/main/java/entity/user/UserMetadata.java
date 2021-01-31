package entity.user;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

// this class stores metadata to monitor the login activity of an account
public class UserMetadata implements UserEntityMetadata{

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

    @Override
    public Timestamp getCreationTimestamp() {

        return creationTimestamp;
    }

    @Override
    public long getDurationSinceCreation() {

       long durationSinceCreation = getDurationInMilliseconds(creationTimestamp);

        return durationSinceCreation;
    }

    @Override
    public Timestamp getLastSignInTimestamp() {

        return lastSignInTimestamp;
    }

    @Override
    public long getDurationSinceLastSignIn() {

        long durationSinceLastSignIn = 0;

        if (lastSignInTimestamp != null) {
            durationSinceLastSignIn = getDurationInMilliseconds(lastSignInTimestamp);

        }
        return durationSinceLastSignIn;
    }

    @Override
    public Timestamp getLastRefreshTimestamp() {

        return lastRefreshTimestamp;
    }

    @Override
    public long getDurationSinceLastRefresh() {

        long durationSinceLastRefresh = 0;

        if (lastRefreshTimestamp != null) {
            durationSinceLastRefresh = getDurationInMilliseconds(lastRefreshTimestamp);

        }

        return durationSinceLastRefresh;
    }
}
