package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SelectMenuPage {

    //TODO:здесь описывай элементы для тестов выпадающих списков
    public final SelenideElement headerSelectMenu = $x(
            "//div[@class='main-header'][text()='Select Menu']");
    public final SelenideElement selectValue = $x(
            "//div[text()='Select Option']");

}
