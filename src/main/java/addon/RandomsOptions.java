package addon;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.UUID;

public class RandomsOptions {

    Logger log = LogManager.getLogger(DatesOptions.class);

    public static int generateRandomInt(int min, int max) {

        Random rnd = new Random();
        int randomNumber = min + rnd.nextInt(max - min + 1);
        return randomNumber;

    }

    public static String generateRandomString(int count) {

        String capital = RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String randomStr = capital + RandomStringUtils.randomAlphabetic(count - 1).toLowerCase();
        return randomStr;

    }

    public static String generateUID() {

        return UUID.randomUUID().toString();
    }

    public static String generateEmail(int charCount) {

        return RandomStringUtils.randomAlphanumeric(charCount) + "@test.com";

    }
}