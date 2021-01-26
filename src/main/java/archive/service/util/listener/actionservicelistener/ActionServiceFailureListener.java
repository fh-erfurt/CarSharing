package archive.service.util.listener.actionservicelistener;

public interface ActionServiceFailureListener extends ActionServiceStateListener {
    abstract void onActionFailure(Exception e);
}
