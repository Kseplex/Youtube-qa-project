package uitests.pendrak.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectMenuPage {

    public final SelenideElement singleSelectContainer = $x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']");
    public final SelenideElement selectedSingleValue = $x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']//div[contains(@class,'singleValue')]");
    public final SelenideElement multiSelectContainer = $x(
            "//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]");
    public final SelenideElement multiSelectCross = $x(
            "//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]" +
                    "//div[contains(@class,'indicatorContainer')][1]");
    public final SelenideElement noOptionsSelect = $x("//div[@class='select-menu-container']//div[@class='row']" +
            "//div[contains(@class,'container')]//div[contains(@class,'menu')]//div[text()='No options']");

    public final ElementsCollection singleValueCollection = $$x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']//div[@tabindex]");
    public final ElementsCollection multiValueCollection = $$x(
            "//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]//div[@tabindex]");

    public final SelenideElement getSingleSelectOption(String value) {
        return $x(String.format("//div[@class='select-menu-container']//div[@id='withOptGroup']" +
                "//div[contains(@class,'menu')]//div[contains(@id,'react-select') and contains(@class,'option')][text()='%s']", value));
    }

    public final SelenideElement getMultiSelectOption(String value) {
        return $x(String.format("//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]" +
                "//div[contains(@id,'react-select') and contains(@class,'option')][text()='%s']", value));
    }

    public final ElementsCollection getMultiSelectedOptions() {
        return $$x("//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]//div[contains(@class,'multiValue')]");
    }
}
