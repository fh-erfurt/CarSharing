package archive.reference.service.util.listener.actionservicelistener;

public interface ActionServiceFailureListener extends ActionServiceStateListener {
    abstract void onActionFailure(Exception e);
}
