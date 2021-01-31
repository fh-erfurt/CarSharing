package archive.main.app;

public class App {
    public static final String DEFAULT_APP_NAME = "CAR_SHARING_APP";

    // object comparison method
    public boolean equals (Object o){
        return false;
    }

    // return instance of archive.main.app identified by unique name
    // throws archive.main.exception if archive.main.app does not exist
    public static App getInstance(String name) throws IllegalStateException {
        return null;
    }

    // return default (first initialized) instance of archive.main.app
    // throws archive.main.exception if default has not been initialized
    public static App getInstance() throws IllegalStateException {
        return null;
    }

    // returns unique name of archive.main.app instance
    public String getName(){
        return null;
    }

    // returns options of archive.main.app instance
    public AppOptions getOptions(){
        return null;
    }

    // initialize default archive.main.app instance using default archive.main.app name as name
    public static App initializeApp(AppOptions options){
        return App.initializeApp(options, App.DEFAULT_APP_NAME);
    }

    // factory method to initialize archive.main.app with global archive.main.app options and unique name
    // throws archive.main.exception if archive.main.app with same name has already been initialized
    public static App initializeApp(AppOptions options, String name) throws IllegalStateException {
        return null;
    }
}
