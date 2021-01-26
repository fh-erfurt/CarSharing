package entity.user;

import entity.EntityInfo;

public interface UserInfo extends EntityInfo {
    String getEmail();
    String getPhoneNumber();
    boolean isEmailVerified();
    boolean isLicenceVerified();
}
