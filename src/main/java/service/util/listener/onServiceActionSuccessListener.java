package service.util.listener;

public interface onServiceActionSuccessListener<T> {
    abstract void actionSuccess(T t);
}
