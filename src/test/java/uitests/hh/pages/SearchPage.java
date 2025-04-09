package uitests.hh.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public final SelenideElement findButton = $x("//div[contains(@class,'supernova-dashboard-content')]//span[text()='Найти']");

    public final SelenideElement inputField = $x("//div[contains(@class,'supernova-dashboard-content')]//input[contains(@id,'search')]");

    public final SelenideElement vacancyList = $x("//main[@class='vacancy-serp-content']");

    public final SelenideElement dialogForm = $x("//div[@role='dialog']");

    public final SelenideElement dialogFormCross = dialogForm.$x(".//button");


}
