package service.util.listener;

import service.util.ServiceAction;

public interface onServiceActionCompleteListener<T> {
    abstract void onServiceActionComplete(ServiceAction<T> serviceAction);
}
