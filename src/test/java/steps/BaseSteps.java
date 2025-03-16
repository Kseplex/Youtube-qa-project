package steps;

import com.codeborne.selenide.SelenideElement;
import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;
import pages.NavigationMenu;
import pages.SelectMenuPage;
import pages.WebTablesPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps {

    public final NavigationMenu navigationMenu = new NavigationMenu();
    public final SelectMenuPage selectMenuPage = new SelectMenuPage();
    public final WebTablesPage webTablesPage = new WebTablesPage();

    public void goToTab(String tabName) {
        navigationMenu.getTabByText(tabName).click();
    }

    public void goToMenuElement(Chapter chapter, SubChapter subChapter) {
        navigationMenu.selectSubchapterInChapter(chapter, subChapter);
    }

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразился заголовок вверху страницы")
    public void checkHeader(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertEquals($x("//div[@class='main-header']").getText(),
                subChapter.getValue());
    }

    @Step("Нажать на кнопку с текстом '{0}'")
    public void clickButtonByText(String text) {
        $x(String.format("//button[text()='%s']", text)).should(visible, Duration.ofSeconds(4000)).click();
    }

    @Step("В поле вводе с placeholder='{0}' ввести значение '{1}'")
    public void inputValueByPlaceholder(String placeholder, String value) {
        SelenideElement element = $x(String.format("//input[@placeholder='%s']", placeholder)).should(visible, Duration.ofSeconds(4000));
        element.clear();
        element.sendKeys(value);
    }
}
