package auth.accesscode;

public abstract class AccessCodeInfo {
    protected String email;
    protected String code;
    public AccessCodeInfo(){

    }
    public String getEmail() {
        return this.email;
    }
    public String getCode(){
        return this.code;
    }

}
