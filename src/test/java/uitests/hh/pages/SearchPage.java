package uitests.hh.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {


    //todo: некоторые xpath могут быть попроще, обрати внимание на атрибут data-qa
    public final SelenideElement submitButton = $x(
            "//div[contains(@class,'button')]//span[text()='Найти']");

    public final SelenideElement searchInputField = $x(
            "//form[contains(@id,'search')]//input[contains(@id,'search')]");

    public final SelenideElement vacanciesList = $x("//main[contains(@class,'vacancy')]");

    public final SelenideElement dialogForm = $x("//div[@role='dialog']");

    public final SelenideElement dialogFormCross = dialogForm.$x(".//div[contains(@class,'actions')]//button");

    public final SelenideElement filterButton = $x("//form[contains(@id,'search')]//a");

    public final SelenideElement salaryInputField = $x(
            "//div[contains(@class,'container')]//input[contains(@data-qa,'search-salary')]");

    public final SelenideElement salaryCheckBox = $x(
            "//span[contains(@class,'checkbox')]//input[contains(@name,'only_with_salary')]");

    public final SelenideElement submitButtonInFilter = $x(
            "//div[contains(@class,'submit-wrapper')]//div[contains(@class,'button')]//span[text()='Найти']");

    public final ElementsCollection regionCrosses = $$x(
            "//div[contains(@class,'container')]//button/following-sibling::*[1][name()='span']");

    public final ElementsCollection salaryInfo = $$x(
            "//div[contains(@class,'vacancy-info')]//div[contains(@class,'narrow-container')][2]" +
                    "//span[contains(@class,'text')]");
}
