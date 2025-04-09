package uitests.hh.steps.filtersteps;

import io.qameta.allure.Step;
import uitests.hh.pages.SearchPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class FilterSteps {

    private final SearchPage searchPage = new SearchPage();

    @Step("В поисковой строке ввести 'QA Automation Java', нажать кнопку поиска, проверить, " +
            "что отобразился список вакансий")
    public void vacanciesListCheck() {
        searchPage.inputField.shouldBe(visible, Duration.ofSeconds(4000)).click();
        searchPage.inputField.sendKeys("QA Automation Java");
        searchPage.findButton.click();
        if (searchPage.dialogForm.isDisplayed())
            searchPage.dialogFormCross.click();
        searchPage.vacancyList.should(visible, Duration.ofSeconds(4000));
    }

    @Step("Нажать кнопку фильтра, убрать ограничения региона, уровень дохода 150000, показывать только вакансии " +
            "с указанным уровнем дохода = true, применить фильтр")
    public void vacanciesFilterCheck() {

    }
}
