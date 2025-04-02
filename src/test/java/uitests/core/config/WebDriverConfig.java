package uitests.core.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:testing.properties",
        "classpath:${stage}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("webdriver.baseUrl")
    String getBaseUrl();

    @Key("webdriver.browser")
    @DefaultValue("FIREFOX")
    String getBrowser();

    @Key("webdriver.remoteUrl")
    String getRemoteURL();

    @Key("service.api.url")
    String getApiUrl();

    @Key("selenide.timeout")
    Integer getTimeout();

    @Key("user.local.file_path")
    String getPathToFile();

    @Key("webdriver.browserSize")
    String getBrowserSize();

    @Key("screenshot_path")
    String getScreenshotsPath();

    @Key("download_path_dir")
    String getDownloadPathDir();

    @Key("API_LOGIN")
    String getApiLogin();

}
