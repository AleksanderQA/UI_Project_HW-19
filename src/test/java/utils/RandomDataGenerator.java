package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomDataGenerator {

    public static String generateRandomEmail() {

        String firstPart = RandomStringUtils.randomAlphanumeric(6);
        String[] domains = {"com", "net", "org", "ru", "ee"};
        int domainIndex = new Random().nextInt(domains.length);
        String domain = domains[domainIndex];
        String secondPart = RandomStringUtils.randomAlphanumeric(3,5) + "." + domain;
        return firstPart +"@"+ secondPart;
    }

    public static String generatePassword(){
        return RandomStringUtils.randomAlphanumeric(15);
    }

    public static String generateInvalidEmail() {

        String firstPart = RandomStringUtils.randomAlphanumeric(6);

        String[] domains = {"com", "net", "org", "ru", "ee"};
        String[] symbols = {"@", ""};

        int domainIndex = new Random().nextInt(domains.length);
        int symbolIndex = new Random().nextInt(symbols.length);
        String domain = domains[domainIndex];
        String symbol = symbols[symbolIndex];

        String secondPart = RandomStringUtils.randomAlphanumeric(0) + "." + domain;
        return firstPart + symbol + secondPart;
    }


}
