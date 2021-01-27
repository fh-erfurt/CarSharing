package entity.user;

import entity.AppEntityInfo;

public interface UserEntityInfo extends AppEntityInfo {
    String getEmail();
    String getPhoneNumber();
    boolean isEmailVerified();
    boolean isLicenceVerified();
}
