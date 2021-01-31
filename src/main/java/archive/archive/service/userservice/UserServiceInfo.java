package archive.service.userservice;

// representation of standard user information

public interface UserServiceInfo {
    // returns user's name
    abstract String getName();

    // returns user's registered email address
    abstract String getEmail();

    // returns user's active phone number
    abstract String getPhoneNumber();

    // returns unique user identifier
    abstract String getUid();

    // returns true if user's email is verified
    abstract Boolean isEmailVerified();
}
