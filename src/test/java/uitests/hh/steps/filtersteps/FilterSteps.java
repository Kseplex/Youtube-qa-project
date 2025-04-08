package uitests.hh.steps.filtersteps;

import io.qameta.allure.Step;
import uitests.hh.pages.SearchPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class FilterSteps {

    private final SearchPage searchPage = new SearchPage();

    @Step("В поисковой строке ввести 'QA Automation Java', нажать кнопку поиска, проверить, " +
            "что отобразился список вакансий")
    public void vacancyListCheck() {
        searchPage.inputField.sendKeys("QA Automation Java");
        searchPage.findButton.click();
        searchPage.vacancyList.should(visible, Duration.ofSeconds(4000));
    }
}
