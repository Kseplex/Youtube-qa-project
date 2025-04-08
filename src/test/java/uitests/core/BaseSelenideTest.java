package uitests.core;

import com.codeborne.selenide.Selenide;
import uitests.pendrak.common.util.DataGenerator;
import uitests.core.config.WebDriverConfig;
import uitests.core.config.WebDriverProviderSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс для инициализации селенида
 */

public class BaseSelenideTest {

    protected final DataGenerator faker = new DataGenerator();

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


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
