package service.util.listener.actionservicelistener;

import service.actionservice.ActionService;

public interface ActionServiceCompleteListener<T> {
    abstract void onServiceActionComplete(ActionService<T> actionService);
}
