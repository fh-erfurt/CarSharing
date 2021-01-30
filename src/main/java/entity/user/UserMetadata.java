package entity.user;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

public class UserMetadata implements UserEntityMetadata{

    private Timestamp creationTimestamp;
    private Timestamp lastSignInTimestamp;
    private Timestamp lastRefreshTimestamp;

    public UserMetadata () {

    }

    public long getDurationInMilliseconds(Timestamp timestamp) {

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        long milliseconds = currentTimestamp.getTime() - timestamp.getTime();

        return milliseconds;
    }

    @Override
    public long getCreationTimestamp() {

       long durationSinceCreation = getDurationInMilliseconds(creationTimestamp);

        return durationSinceCreation;
    }

    @Override
    public long getLastSignInTimestamp() {

        long durationSinceLastSignIn = 0;

        if (lastSignInTimestamp != null) {
            durationSinceLastSignIn = getDurationInMilliseconds(lastSignInTimestamp);

        }
        return durationSinceLastSignIn;
    }

    @Override
    public long getLastRefreshTimestamp() {

        long durationSinceLastRefresh = 0;

        if (lastRefreshTimestamp != null) {
            durationSinceLastRefresh = getDurationInMilliseconds(lastRefreshTimestamp);

        }

        return durationSinceLastRefresh;
    }
}
