package service.userservice;

public interface UserServiceMetadata {
    public abstract long getUserCreationTimestamp ();
    public abstract long getUserLastSignInTimestamp ();
    public abstract long getUserProfileUpdateTimestamp ();
}
