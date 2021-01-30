package map_beta.connection;

public final class ConnectionResult {
    public ConnectionResult(int statusCode){

    }
    int getErrorCode(){
        return 0;
    }
    String getErrorMessage(){
        return null;
    }
    boolean isSuccessful(){
        return false;
    }
}
