package uitests.common.util;

import com.github.javafaker.Faker;
import uitests.common.model.Human;

public class DataGenerator {

    private final Faker faker = new Faker();

    public Human generateHuman() {
        return new Human()
                .age(faker.number().numberBetween(10, 99))
                .salary(faker.number().numberBetween(300000, 400000))
                .department(faker.lorem().characters(20))
                .email(faker.lorem().characters(5) + "@example.com")
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName());
    }
}
