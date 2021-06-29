package main.util;

import java.io.*;
import java.util.regex.*;

/**
 * verification utility class
 */

public class Verification {

    /**
     * verify user email based on 2 criteria
     * 1. email is not currently in use
     * 2. validity of email string pattern
     *
     * @param email - email to be verified
     * @return boolean value based on evaluation (verification of user email)
     * @throws IOException upon read failure
     */

    public static boolean userEmail (String email) throws IOException {
        String regex = "^(.+)@(.+)$";
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String readLine = reader.readLine();
        String readEmail;
        while(readLine != null) {
            readEmail = readLine.split(",")[0];
            if(readEmail.equals(email)) {
                return false;
            }
            readLine = reader.readLine();
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * compare user password string
     *
     * @param password - password as string value
     * @param check - password to be checked
     * @return boolean value based on evaluation
     */

    public static boolean userPassword (String password, String check) {
        return password.equals(check);
    }

    /**
     * verify car build based on release year and number of passenger seats available
     *
     * @param year - release year of vehicle
     * @param numOfSeats - number of passenger seats
     * @return boolean value based on evaluation
     */

    public static boolean vehicleBuild(int year, int numOfSeats) {
        return year > 0 || numOfSeats > 0;
    }


}
