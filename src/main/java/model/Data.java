package model;

import com.google.gson.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import util.DeserializeObservable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

/**
 * Data model class
 */

public class Data {
    public static ObservableSet<Location> locations = FXCollections.observableSet();
    public static ObservableList<Location> locationsList = FXCollections.observableArrayList(locations);
    public static List<Driver> drivers = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    private static final Map<String, Driver> driverEmails = new HashMap<>();
    private static final Map<String, User> userEmails = new HashMap<>();
    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    public  static Gson gson = gsonBuilder.setPrettyPrinting().create();

    private static Driver driver;
    public static User user;

    /**
     * listen for change in locations list
     */

    public static void setDataListeners() {
        SetChangeListener<Location> listener = change -> {
            Data.locationsList.clear();
            Data.locationsList.addAll(Data.locations);
        };
        Data.locations.addListener(listener);
    }

    /**
     * @return list of locations
     */

    public ArrayList<Location> getLocations () {
        return new ArrayList<>(Data.locationsList);
    }

    /**
     * save data to file
     *
     * @param toSave - object to be saved
     * @param fileName - file to be written to
     * @throws IOException on input output error
     */

    public static void save (Object toSave, String fileName) throws IOException {
        Data.gsonBuilder.registerTypeAdapter(ObservableList.class, new DeserializeObservable());
        Data.gson = Data.gsonBuilder.setPrettyPrinting().create();
        FileOutputStream outputStream = new FileOutputStream(fileName);
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        Data.gson.toJson(toSave, writer);
        writer.close();
        outputStream.close();
    }

    /**
     * load data from file
     *
     * @param fileName - fine from which data is to be loaded
     * @throws IOException - on input output error
     */

    public static void load (String fileName) throws IOException {
        Data.gsonBuilder.registerTypeAdapter(ObservableList.class, new DeserializeObservable());
        Data.gson = gsonBuilder.setPrettyPrinting().create();
        Reader reader = new InputStreamReader(Objects.requireNonNull(Data.class.getResourceAsStream(fileName)), StandardCharsets.UTF_8);
        Rss loaded = Data.gson.fromJson(reader, Rss.class);
        reader.close();
        Objects.requireNonNull(Data.class.getResourceAsStream(fileName)).close();
        Data.drivers.clear();
        Data.users.clear();
        Data.locationsList.clear();
        Data.locations.clear();

        for (Driver driver : loaded.getDrivers()) {
            Data.addDriver(driver);
        }

        for (User user : loaded.getUsers()) {
            Data.addUser(user);
        }

        Data.locations.addAll(loaded.getDestinations());
    }

    /**
     * add user data
     *
     * @param user - user to be added
     */

    public static void addUser (User user) {
        Data.users.add(user);
        Data.userEmails.put(user.getDetails().get("email"), user);
    }

    /**
     * add driver data
     *
     * @param driver - driver to be added
     */

    public static void addDriver (Driver driver) {
        Data.drivers.add(driver);
        Data.driverEmails.put(driver.getDetails().get("email"), driver);
    }

    /**
     * get and initialize user date via email
     *
     * @param email - email of user to be gotten
     */

    public static void openAccount (String email) {
        if (Data.driverEmails.get(email) != null) {
            Data.driver = Data.driverEmails.get(email);
        }
        if (Data.userEmails.get(email) != null) {
            Data.user = Data.userEmails.get(email);
        }
    }

    /**
     * @return driver
     */

    public static Driver getDriver () {
        return Data.driver;
    }

    /**
     * @param driver - driver to be set
     */

    public static void setDriver (Driver driver) {
        Data.driver = driver;
    }

}
