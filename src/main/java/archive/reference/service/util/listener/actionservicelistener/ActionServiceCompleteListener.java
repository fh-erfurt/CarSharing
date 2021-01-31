package archive.reference.service.util.listener.actionservicelistener;

import archive.reference.service.util.actionservice.ActionService;

public interface ActionServiceCompleteListener<T> extends ActionServiceStateListener {
    abstract void onServiceActionComplete(ActionService<T> actionService);
}
