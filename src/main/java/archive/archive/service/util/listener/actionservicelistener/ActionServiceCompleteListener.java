package archive.service.util.listener.actionservicelistener;

import archive.service.util.actionservice.ActionService;

public interface ActionServiceCompleteListener<T> extends ActionServiceStateListener {
    abstract void onServiceActionComplete(ActionService<T> actionService);
}
