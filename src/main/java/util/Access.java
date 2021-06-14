package util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * account access utility class
 */

public class Access {

    /**
     * login method
     *
     * @param email - user email
     * @param password - user password
     * @return boolean value based on success or failure
     * @throws IOException on IO error
     * @throws DecoderException on decoding error
     */

    public static boolean login (String email, String password) throws IOException, DecoderException {
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String readLine = reader.readLine();
        String readEmail;
        while (readLine != null) {
            readEmail = readLine.split(",")[0];
            if (readEmail.equals(email)) {
                String expectedHash = readLine.split(",")[1];
                String readSalt = readLine.split(",")[2];
                return PasswordUtils.isExpectedPassword(password.toCharArray(), Hex.decodeHex(readSalt.toCharArray()), Hex.decodeHex(expectedHash.toCharArray()));
            }
            readLine = reader.readLine();
        }
        return false;
    }
}
