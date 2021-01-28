package auth.beta.actioncode;

// Holds information regarding different out of band operations.
public abstract class ActionCodeInfo {
    protected String email;
    protected String code;
    public ActionCodeInfo(){

    }

    // Returns the current email associated with the account,
    // which may be changed as a result of the ActionCodeResult Operation performed.
    public String getEmail() {
        return this.email;
    }
    // Returns the action code from the email link if present, otherwise null.
    public String getCode(){
        return this.code;
    }

}
