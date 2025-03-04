package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {
    //TODO:здесь опиши локаторы для навигационного меню

    public SelenideElement createXpath(String element) {
        return $x("//*[text()='" + element + "']");
    }


}
