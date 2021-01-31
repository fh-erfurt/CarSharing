package archive.service.util.listener.actionservicelistener;

public interface ActionServiceSuccessListener<T> extends ActionServiceStateListener {
    abstract void actionSuccess(T t);
}
