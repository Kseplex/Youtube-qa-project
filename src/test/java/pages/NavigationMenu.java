package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {

    public SelenideElement getTabByText(String text) {
        return $x(
                "//div[@class='card-body']//h5[text()='" + text + "']");
    }
    public SelenideElement getMenuElementByText(String text) {
        return $x(
                "//span[@class='text'][text()='" + text + "']");
    }
}
