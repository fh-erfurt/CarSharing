package auth;

public class EmailAuthCredential {
    private String email, password;
    public EmailAuthCredential(String email, String password){
        this.email = email;
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
