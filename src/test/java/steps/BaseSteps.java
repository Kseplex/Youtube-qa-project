package steps;

import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;
import pages.NavigationMenu;
import pages.SelectMenuPage;
import pages.WebTablesPage;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseSteps {

    protected final NavigationMenu navigationMenu = new NavigationMenu();
    protected final SelectMenuPage selectMenuPage = new SelectMenuPage();
    protected final WebTablesPage webTablesPage = new WebTablesPage();

    public void goToTab(String tabName) {
        navigationMenu.getTabByText(tabName).click();
    }

    public void goToMenuElement(Chapter chapter, SubChapter subChapter) {
        navigationMenu.selectSubchapterInChapter(chapter, subChapter);
    }

    public void fillRegistrationForm(List<String> data) {
        Iterator<String> iterator = data.iterator();
        webTablesPage.registrationFormFields.forEach(field -> {
            field.click();
            field.clear();
            field.sendKeys(iterator.next());
        });
        webTablesPage.buttonSubmit.click();
    }

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразилась таблица")
    public void checkTable(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertTrue(webTablesPage.table.isDisplayed());
    }

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразился заголовок вверху страницы")
    public void checkHeader(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                subChapter.getValue());
    }
}
