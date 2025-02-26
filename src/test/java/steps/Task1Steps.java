package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Task1Steps extends BaseSteps{
    ///TODO: убери элементы в Pages -> DropDownSelectorsPage
    private final SelenideElement widgets = $x(
            "//div[@class='header-wrapper']//div[text()='Widgets']");
    private final SelenideElement selectMenu = $x(
            "//span[@class='text'][text()='Select Menu']");
    private final SelenideElement headerSelectMenu = $x(
            "//div[@class='main-header'][text()='Select Menu']");

    public String findHeader() {
        widgets.click();
        selectMenu.click();
        return headerSelectMenu.getText();
    }

}
