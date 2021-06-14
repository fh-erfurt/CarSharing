package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

/**
 *
 */

public class DeserializeObservable implements InstanceCreator<ObservableList<?>> {
    public ObservableList<?> createInstance (Type type) {
        return FXCollections.observableArrayList();
    }
}
