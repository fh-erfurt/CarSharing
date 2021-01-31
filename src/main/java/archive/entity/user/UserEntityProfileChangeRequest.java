package entity.user;

// Request used to update user profile information.
public class UserEntityProfileChangeRequest {
    public String getDisplayName(){
        return null;
    }

    public String getPhotoUrl(){
        return null;
    }

    // The request builder.
    public static class Builder {
        Builder(){

        }
        public UserEntityProfileChangeRequest build (){
            return null;
        }
        // Sets the updated display name.
        public UserEntityProfileChangeRequest.Builder setDisplayName(String displayName){
            return null;
        }
        // Sets the updated photo Url.
        public UserEntityProfileChangeRequest.Builder setPhotoUrl(String photoUrl){
            return null;
        }
    }

}

