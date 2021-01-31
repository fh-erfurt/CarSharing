package archive.main.entity.user;

public interface UserEntityInfo {
    String getEmail();
    String getPhoneNumber();
    String getDisplayName();
    String getPhotoUrl();
    String getUserId();
    boolean isEmailVerified();
}
