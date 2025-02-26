package core.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverProviderSelenide {

    private final WebDriverConfig config;

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    public WebDriverProviderSelenide() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    public void get() {
        Configuration.browser = config.getBrowser();
        //Configuration.remote = config.driverManagerEnabled() ? null : propertiesLoader.getWebdriverRemoteUrl();
        Configuration.browserCapabilities = setChromeOptions();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 12000;
        Configuration.pageLoadTimeout=120000;
        Configuration.baseUrl = config.getBaseUrl();
        open(config.getBaseUrl());
    }
    
    private ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }
}
