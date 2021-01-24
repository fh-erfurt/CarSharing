package service.util;

import service.util.listener.*;

public abstract class ServiceAction<T> extends Object {
    public ServiceAction() {}

    public abstract ServiceAction<T> addOnServiceActionCompleteListener(onServiceActionCompleteListener<T> listener);

    public abstract ServiceAction<T> addOnServiceActionFailureListener(onServiceActionFailureListener listener);

    public abstract ServiceAction<T> addOnServiceActionSuccessListener(onServiceActionSuccessListener<? super T> listener);

    public abstract Exception getException();

    public abstract T getResponse();

    public abstract Boolean isComplete();

    public abstract Boolean isSuccessful();
}
