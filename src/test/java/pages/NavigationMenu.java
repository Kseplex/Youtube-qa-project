package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {

    //TODO:здесь опиши локаторы для навигационного меню
    //TODO: неверное название метода - Изменен
    //todo: в методе нет смысла, он не относится к навигационному меню, xpath соответствует всем элементам с текстом
    // - Изменен

    public SelenideElement getTabByText(String text) {
        return $x("//div[@class='card-body']//h5[text()='" + text + "']");
    }
    public SelenideElement getMenuElementByText(String text) {
        return $x(
                "//span[@class='text'][text()='" + text + "']");
    }
}
