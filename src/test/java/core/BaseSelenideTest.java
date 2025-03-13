package core;

import com.codeborne.selenide.Selenide;
import common.model.Human;
import core.config.WebDriverConfig;
import core.config.WebDriverProviderSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

/**
 * Базовый класс для инициализации селенида
 */

public class BaseSelenideTest {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public final Human humanToAdd = new Human()
            .age(24)
            .salary(300000)
            .department("Nanosecs")
            .email("alex@example.com")
            .firstName("Alexander")
            .lastName("Zhidyaev");
    public final Human humanToEdit = new Human()
            .age(28)
            .salary(0)
            .department("GMs")
            .email("valentin@example.com")
            .firstName("Valentin")
            .lastName("Dyagilev");
    public final List<String> placeholders = List.of("First Name", "Last Name", "name@example.com", "Age", "Salary", "Department");

    @BeforeAll
    static void setUp() {
        new WebDriverProviderSelenide().get();
    }

    @BeforeEach
    void beforeEach(){
        Selenide.open(config.getBaseUrl());
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWindow();
    }
}
