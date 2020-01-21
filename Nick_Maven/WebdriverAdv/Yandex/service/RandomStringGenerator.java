package Nick_Maven.WebdriverAdv.Yandex.service;

import java.util.Random;

public class RandomStringGenerator {
    public static String randomStringGenerator() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 4;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}