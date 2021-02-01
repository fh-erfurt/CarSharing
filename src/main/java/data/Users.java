package data;

import model.user.User;

import java.util.*;

/**
 * The Users class will store all users.
 * It is divided in two hashmaps storing the customers and drivers
 */

public final class Users {
    private static final HashMap<String, HashMap<String, User>> users = new HashMap<String, HashMap<String, User>>();
    private static final String driverListKey = "DRIVERS";
    private static final String customerListKey = "CUSTOMERS";

    public Users(){
        Users.init();
    }

    public static void init(){
        HashMap<String, User> driverList = new HashMap<String, User>();
        HashMap<String, User> customerList = new HashMap<String, User>();
        users.put(driverListKey, driverList);
        users.put(customerListKey, customerList);
    }

    public static void addDriver(User driver){
        users.get(driverListKey).put(driver.getUserId(), driver);
    }
    public static void addCustomer(User customer){
        users.get(customerListKey).put(customer.getUserId(), customer);
    }
    public static User getDriver(String userId){
        return users.get(driverListKey).get(userId);
    }
    public static User getCustomer(String userId){
        return users.get(customerListKey).get(userId);
    }
}
