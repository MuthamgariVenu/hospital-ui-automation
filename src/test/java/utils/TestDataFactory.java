package utils;

import com.github.javafaker.Faker;

public class TestDataFactory {

    private static final Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String phone() {
        return faker.phoneNumber().cellPhone();
    }
}
