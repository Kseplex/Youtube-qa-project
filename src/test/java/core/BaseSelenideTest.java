package core;

import core.config.WebDriverConfig;
import core.config.WebDriverProviderSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

/**
 * Базовый класс для инициализации селенида
 */
public class BaseSelenideTest {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {
        new WebDriverProviderSelenide().get();
    }
}
