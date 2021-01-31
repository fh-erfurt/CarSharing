package model.user;

import model.location.Location;

public interface UserInfo {
    String getEmail();
    String getPhoneNumber();
    String getDisplayName();
    String getPhotoUrl();
    String getUserId();
    boolean isEmailVerified();
    boolean gpsActive();
}
