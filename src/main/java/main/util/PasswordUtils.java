package main.util;

import main.model.User;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

/**
 * password utility class
 */

public class PasswordUtils {
    private static final Random randomSalt = new SecureRandom();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    /**
     * gets next 16 bit random salt
     * @return 16 bit salt
     */
    public static byte[] getNextSalt () {
        byte[] salt = new byte[16];
        PasswordUtils.randomSalt.nextBytes(salt);
        return salt;
    }

    /**
     * hashing method
     *
     * @param password - password value as array of characters
     * @param salt - salt value for password hashing
     * @return encoded key
     */

    public static byte[] hashPassword (final char[] password, final byte[] salt) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PasswordUtils.ALGORITHM);
            PBEKeySpec keySpec = new PBEKeySpec(password, salt, PasswordUtils.ITERATIONS, PasswordUtils.KEY_LENGTH);
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            return key.getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * check if password is valid
     *
     * @param password - password as char array
     * @param salt - salt value as byte array
     * @param expectedHash - expected hash value
     * @return true of false if password is comparable to expected value
     */

    public static boolean isExpectedPassword (char[] password, byte[] salt, byte[] expectedHash) {
        byte[] passwordHash = PasswordUtils.hashPassword(password, salt);
        if (passwordHash.length != expectedHash.length) {
            return false;
        }
        for (int i = 0; i < passwordHash.length; i++) {
            if (passwordHash[i] != expectedHash[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * method to save user password
     *
     * @param user - corresponding user
     * @param password - password as string value
     * @throws IOException on input output error
     */

    public static void savePassword (User user, String password) throws IOException {
        byte[] salt = PasswordUtils.getNextSalt();
        byte[] hashPassword = PasswordUtils.hashPassword(password.toCharArray(), salt);
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        FileWriter fileWriter = new FileWriter(users, true);
        char[] encodedPassword = Hex.encodeHex(hashPassword);
        StringBuilder strEncodedPassword = new StringBuilder();
        for (char c : encodedPassword) {
            strEncodedPassword.append(c);
        }
        char[] encodedSalt = Hex.encodeHex(salt);
        StringBuilder strEncodedSalt = new StringBuilder();
        for (char ch : encodedSalt) {
            strEncodedSalt.append(ch);
        }
        user.setSalt(salt);
        fileWriter.append(user.getEmail()).append(",").append(String.valueOf(strEncodedPassword)).append(",").append(String.valueOf(strEncodedSalt)).append("\n");
        fileWriter.close();
    }

    /**
     * method to change user password
     *
     * @param user - corresponding user
     * @param password - password replacement
     * @throws IOException on input output error
     */

    public static void changePassword (User user, String password) throws IOException {
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String line = reader.readLine();
        List<String> usersBuffer = new ArrayList<>();
        while(line != null) {
            usersBuffer.add(line + "\n");
            line = reader.readLine();
        }
        FileWriter filewriter = new FileWriter(users);
        for (String userInFile : usersBuffer) {
            if (!userInFile.split(",")[0].equals(user.getEmail())) {
                filewriter.write(userInFile);
            }
        }
        reader.close();
        filewriter.close();
        PasswordUtils.savePassword(user, password);
    }
}
