package service.util.actionservice;

import service.util.listener.actionservicelistener.ActionServiceCompleteListener;
import service.util.listener.actionservicelistener.ActionServiceFailureListener;
import service.util.listener.actionservicelistener.ActionServiceSuccessListener;

public class ActionServiceUpdateUserEmail<T> extends ActionService<T> {
    @Override
    public ActionService<T> addActionServiceCompleteListener(ActionServiceCompleteListener<T> listener) {
        return null;
    }

    @Override
    public ActionService<T> addActionServiceFailureListener(ActionServiceFailureListener listener) {
        return null;
    }

    @Override
    public ActionService<T> addActionServiceSuccessListener(ActionServiceSuccessListener<? super T> listener) {
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
