/**
 * this class returns userdata (email address, phone number, displayname)
 * the userdata can be updated at any time
 */

package model.user;

import model.location.Location;

public interface UserInfo {
    // Returns the main email address of the user, as stored in the database.
    // this email address can be updated at any time by calling updateEmail(String).
    String getEmail();
    // Returns the phone number of the user, as stored in the database, or null if none exists.
    // can be updated at any time by calling updatePhoneNumber(PhoneAuthCredential).
    String getPhoneNumber();
    // Returns the main display name of this user from the database.
    // this name can be updated at any time by calling updateProfile(UserEntityProfileChangeRequest).
    String getDisplayName();
    // Returns the URL of this user's main profile picture, as stored in the database.
    // this URL can be updated at any time by calling updateProfile(UserEntityProfileChangeRequest).
    String getPhotoUrl();
    // Returns a string used to uniquely identify the user in the database.
    String getUserId();
    boolean isEmailVerified();
    boolean gpsActive();
}
