package core;

import com.codeborne.selenide.Selenide;
import core.config.WebDriverConfig;
import core.config.WebDriverProviderSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс для инициализации селенида
 */
public class BaseSelenideTest {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {
        new WebDriverProviderSelenide().get();
    }
/*
* beforeall
* beforeach
*
* test
*
* aftereach
* afterall
 */
    @BeforeEach
    void beforeEach(){
        Selenide.open(config.getBaseUrl());
    }

    @AfterEach
    void afterEach(){
        Selenide.closeWindow();
    }
}
