package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectMenuPage {

    public final SelenideElement headerSelectMenu = $x(
            "//div[@class='main-header'][text()='Select Menu']");
    public final SelenideElement selectValue = $x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']");
    public final SelenideElement selectedValue = $x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']//div[contains(@class,'singleValue')]");
    public final SelenideElement multiSelectValue = $x(
            "//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]");

    public final ElementsCollection valueCollection = $$x(
            "//div[@class='select-menu-container']//div[@id='withOptGroup']//div[@tabindex]");
    public final ElementsCollection multiValueCollection = $$x(
            "//div[@class='select-menu-container']//div[@class='row']//div[contains(@class,'container')]//div[@tabindex]");

    public SelenideElement getSingleSelectOption(String value){
        return $x(String.format("//div[@class='select-menu-container']//div[@id='withOptGroup']" +
                "//div[contains(@class,'menu')]//div[contains(@id,'react-select') and contains(@class,'option')][text()='%s']", value));
    }

}
