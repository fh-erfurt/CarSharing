package model.user;

public interface UserMetadata {
    long getCreationTimestamp();
    long getLastSignInTimestamp();
    long getLastRefreshTimestamp();
}
