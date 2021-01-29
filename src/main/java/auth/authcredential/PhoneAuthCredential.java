package auth.authcredential;

public class PhoneAuthCredential extends AuthCredential {
    private String phoneNumber, smsCode;
    public PhoneAuthCredential(String phoneNumber, String smsCode){
        this.phoneNumber = phoneNumber;
        this.smsCode = smsCode;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    // Gets the auto-retrieved SMS verification code if applicable.
    public String getSmsCode(){
        return this.smsCode;
    }
}
