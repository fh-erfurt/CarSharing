package service.util;

import service.util.listener.onServiceActionCompleteListener;
import service.util.listener.onServiceActionFailureListener;
import service.util.listener.onServiceActionSuccessListener;

public class ServiceActionUpdateUserEmail<T> extends ServiceAction<T> {
    @Override
    public ServiceAction<T> addOnServiceActionCompleteListener(onServiceActionCompleteListener<T> listener) {
        return null;
    }

    @Override
    public ServiceAction<T> addOnServiceActionFailureListener(onServiceActionFailureListener listener) {
        return null;
    }

    @Override
    public ServiceAction<T> addOnServiceActionSuccessListener(onServiceActionSuccessListener<? super T> listener) {
        return null;
    }

    @Override
    public Exception getException() {
        return null;
    }

    @Override
    public T getResponse() {
        return null;
    }

    @Override
    public Boolean isComplete() {
        return null;
    }

    @Override
    public Boolean isSuccessful() {
        return null;
    }
}
