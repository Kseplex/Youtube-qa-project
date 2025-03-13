package core;

import com.codeborne.selenide.Selenide;
import common.model.Human;
import common.util.DataGenerator;
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

    protected final DataGenerator faker = new DataGenerator();

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
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
