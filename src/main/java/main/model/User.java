package main.model;

import java.util.*;

/**
 * User main.model class
 */

public class User {
    private String name,
                   address,
                   phone,
                   email,
                   photoUri;
    private byte[] password,
                   salt;

    /**
     * set user details
     *
     * @param user - user details as Map<String, String>
     */

    public void setDetails (Map<String, String> user) {
        if (user.get("name") != null) {
            this.name = user.get("name");
        }
        if (user.get("address") != null) {
            this.address = user.get("address");
        }
        if (user.get("phone") != null) {
            this.phone = user.get("phone");
        }
        if (this.email == null) {
            this.email = user.get("email");
        }
    }

    /**
     * @return user details as Map<String, String>
     */

    public Map<String, String> getDetails() {
        return Map.of("name", this.name, "address", this.address, "phone", phone, "email", this.email);
    }

    /**
     * @return user main.model as string value
     */

    @Override
    public String toString() {
        return "Email: " + this.email + "\nName: " + this.name + "\nAddress: " + this.address + "\nPhone number: " + this.phone;
    }

    /**
     * @return name of user
     */

    public String getName () {
        return this.name;
    }

    /**
     * set name of user
     *
     * @param name - name of user
     */

    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return user email
     */

    public String getEmail () {
        return this.email;
    }

    /**
     * set email of user
     *
     * @param email - user email address
     */

    public void setEmail (String email) {
        this.email = email;
    }

    /**
     * @return user password
     */

    public byte[] getPassword () {
        return this.password;
    }

    /**
     * set user password
     *
     * @param password - user password
     */

    public void setPassword (byte[] password) {
        this.password = password;
    }

    /**
     * set salt value for password hashing
     *
     * @param salt - salt value to be set
     */

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    /**
     * @return salt value
     */

    public byte[] getSalt() {
        return this.salt;
    }

    /**
     * set profile photo uri
     *
     * @param photoUri - resource identifier for user profile image
     */

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    /**
     * @return user profile image uri as string value
     */

    public String getPhotoUri () {
        return this.photoUri;
    }

    /**
     * comparison method
     *
     * @param object - object to be compared
     * @return boolean value based on evaluation
     */

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        User user = (User) object;

        if (!Objects.equals(this.email, user.email)) {
            return false;
        }

        return Objects.equals(this.name, user.name);
    }

    /**
     * @return object hashcode
     */

    @Override
    public int hashCode () {
        int result = this.email != null ? this.email.hashCode() : 0;
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        return result;
    }
}
