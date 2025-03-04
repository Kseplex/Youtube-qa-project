package steps;

import pages.NavigationMenu;
import pages.SelectMenuPage;

public class BaseSteps {
    //TODO:добавь метод для перехода на нужную вкладку через NavigationMenu
    protected final NavigationMenu navigationMenu = new NavigationMenu();
    protected final SelectMenuPage selectMenuPage = new SelectMenuPage();

}
