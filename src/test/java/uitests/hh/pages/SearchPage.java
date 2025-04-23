package uitests.hh.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public final SelenideElement submitButton = $x("//button[@data-qa='search-button']");

    public final SelenideElement searchInputField = $x("//input[@data-qa='search-input']");

    public final SelenideElement vacanciesList = $x("//div[@data-qa='vacancy-serp__results']");

    public final SelenideElement dialogForm = $x("//div[@role='dialog']");

    public final SelenideElement dialogFormCross = dialogForm.$x(".//div[contains(@class,'actions')]//button");

    public final SelenideElement registrationForm = $x("//div[contains(@class,'bloko-modal-container')]");

    public final SelenideElement registrationFormCross = $x("//div[contains(@class,'bloko-modal-container')]" +
            "//div[contains(@data-qa,'close')]");

    public final SelenideElement filterButton = $x("//a[@data-qa='advanced-search']");

    public final SelenideElement salaryInputField = $x(
            "//input[@data-qa='advanced-search-salary']");

    public final SelenideElement salaryCheckBox = $x(
            "//input[@data-qa='control-vacancysearch__only-with-compensation']");

    public final SelenideElement submitButtonInFilter = $x(
            "//button[@data-qa='advanced-search-submit-button']");

    public final SelenideElement regionSearchOpenButton =
            $x("//button[@data-qa='advanced-search-region-selectFromList']");

    public final SelenideElement regionSearchCheckbox =
            $x("//div[@data-qa='cell-left-side']//div[text()='Россия']");

    public final SelenideElement regionSearchSubmitButton =
            $x("//button[@data-qa='composite-selection-tree-selector-modal-submit']");

    public final ElementsCollection salaryInfo = $$x(
            "//div[contains(@class,'vacancy-info')]//div[contains(@class,'narrow-container')][2]" +
                    "//span[contains(@class,'text')]");
}
