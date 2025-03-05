package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectMenuPage {

    public final SelenideElement headerSelectMenu = $x(
            "//div[@class='main-header'][text()='Select Menu']");
    public final SelenideElement selectValue = $x(
            "//div[@class='select-menu-container']//div[text()='Select Option']");
    public final ElementsCollection valueCollection = $$x(
            "//div[@tabindex='-1']");
    public final SelenideElement selectedValue = $x(
            "//div[@class=' css-1uccc91-singleValue'][text()='Group 2, option 2']");
}
