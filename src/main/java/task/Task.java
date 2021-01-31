package task;

public abstract class Task<ResponseT> {
    public Task(){

    }

    public abstract Task<ResponseT> addOnCompleteListener(OnCompleteListener<ResponseT> listener);
    public abstract Task<ResponseT> addOnFailureListener(OnFailureListener listener);
    public abstract Task<ResponseT> addOnSuccessListener(OnSuccessListener<? super ResponseT> listener);
    public abstract Exception getException();
    public abstract ResponseT getResponse() throws IllegalStateException, RuntimeException;
    public abstract boolean isComplete();
    public abstract boolean isSuccessful();
}
