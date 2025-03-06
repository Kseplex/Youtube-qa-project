package steps;

import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;
import pages.NavigationMenu;
import pages.SelectMenuPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseSteps {

    protected final NavigationMenu navigationMenu = new NavigationMenu();
    protected final SelectMenuPage selectMenuPage = new SelectMenuPage();

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

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                subChapter.getValue());
    }
}
