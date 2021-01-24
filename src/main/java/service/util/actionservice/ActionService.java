package service.util.actionservice;

import service.util.listener.actionservicelistener.*;

public abstract class ActionService<T> extends Object {
    public ActionService() {}

    public abstract ActionService<T> addActionServiceCompleteListener(ActionServiceCompleteListener<T> listener);

    public abstract ActionService<T> addActionServiceFailureListener(ActionServiceFailureListener listener);

    public abstract ActionService<T> addActionServiceSuccessListener(ActionServiceSuccessListener<? super T> listener);

    public abstract Exception getException();

    public abstract T getResponse();

    public abstract Boolean isComplete();

    public abstract Boolean isSuccessful();
}
