package task;

public interface OnCompleteListener<ResponseT> {
    void onComplete(Task<ResponseT> task);
}
