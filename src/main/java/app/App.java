package app;

public class App {
    public static final String DEFAULT_APP_NAME = "CAR_SHARING_APP";

    // object comparison method
    public boolean equals (Object o){
        return false;
    }

    // return instance of app identified by unique name
    // throws exception if app does not exist
    public static App getInstance(String name) throws IllegalStateException {
        return null;
    }

    // return default (first initialized) instance of app
    // throws exception if default has not been initialized
    public static App getInstance() throws IllegalStateException {
        return null;
    }

    // returns unique name of app instance
    public String getName(){
        return null;
    }

    // returns options of app instance
    public AppOptions getOptions(){
        return null;
    }

    // initialize default app instance using default app name as name
    public static App initializeApp(AppOptions options){
        return App.initializeApp(options, App.DEFAULT_APP_NAME);
    }

    // factory method to initialize app with global app options and unique name
    // throws exception if app with same name has already been initialized
    public static App initializeApp(AppOptions options, String name) throws IllegalStateException {
        return null;
    }
}
