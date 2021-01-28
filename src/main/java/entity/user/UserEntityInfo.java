package entity.user;

import entity.beta.appentity.AppEntityInfo;

public interface UserEntityInfo extends AppEntityInfo {
    String getEmail();
    String getPhoneNumber();
    String getDisplayName();
    String getPhotoUrl();
    String getUserId();
    boolean isEmailVerified();
}
