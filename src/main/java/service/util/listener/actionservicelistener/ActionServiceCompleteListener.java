package service.util.listener.actionservicelistener;

import service.util.actionservice.ActionService;

public interface ActionServiceCompleteListener<T> extends ActionServiceStateListener {
    abstract void onServiceActionComplete(ActionService<T> actionService);
}
