package testCases;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
    private static Faker faker = new Faker();

    public static String getUserNameFake() {
        return faker.name().firstName().concat("waleed108199");
    }
    public static String getcountryFake() {
        return faker.country().name().toLowerCase();
    }
    public static String getmonthFake() {
        return faker.idNumber().valid().concat("1");
    }
    public static String getyearFake() {
        return faker.idNumber().valid().concat("2");
    }
    public static String getCardFake() {
        return faker.idNumber().valid().concat("52414");
    }
    public static String getCityFake() {
        return faker.country().capital().toLowerCase();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }
}
