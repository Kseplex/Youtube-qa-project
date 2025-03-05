package steps;

import common.enums.Chapter;
import common.enums.SubChapter;
import pages.NavigationMenu;
import pages.SelectMenuPage;

public class BaseSteps {

    protected final NavigationMenu navigationMenu = new NavigationMenu();
    protected final SelectMenuPage selectMenuPage = new SelectMenuPage();

    public void goToTab(String tabName) {
        navigationMenu.getTabByText(tabName).click();
    }

    public void goToMenuElement(Chapter chapter, SubChapter subChapter) {
        navigationMenu.selectSubchapterInChapter(chapter, subChapter);
    }
}
