package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {
    //TODO:здесь опиши локаторы для навигационного меню

    //TODO: неверное название метода
    //todo: в методе нет смысла, он не относится к навигационному меню, xpath соответствует всем элементам с текстом
    public SelenideElement createXpath(String element) {
        return $x("//*[text()='" + element + "']");
    }


}
