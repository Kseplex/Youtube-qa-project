package uitests.hh.steps.searchsteps;

import io.qameta.allure.Step;
import uitests.hh.pages.SearchPage;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {

    private final SearchPage searchPage = new SearchPage();

    @Step("В поисковой строке ввести '{0}', нажать кнопку поиска, проверить, " +
            "что отобразился список вакансий")
    public void vacanciesListCheck(String vacancyToSearch) {
        searchPage.searchInputField.should(visible, Duration.ofSeconds(6000)).click();
        searchPage.searchInputField.sendKeys(vacancyToSearch);
        searchPage.submitButton.click();
        if (searchPage.dialogForm.isDisplayed())
            searchPage.dialogFormCross.click();
        else if (searchPage.registrationForm.isDisplayed())
            searchPage.registrationFormCross.click();
        searchPage.vacanciesList.should(visible, Duration.ofSeconds(6000));
    }

    @Step("Нажать кнопку фильтра, убрать ограничения региона, уровень дохода '{0}', показывать только вакансии " +
            "с указанным уровнем дохода = true, применить фильтр")
    public void vacanciesFilterCheck(int salaryToSearch) {
        searchPage.filterButton.should(visible, Duration.ofSeconds(6000)).click();
        searchPage.regionSearchOpenButton.should(visible, Duration.ofSeconds(6000)).scrollIntoView(true).click();
        searchPage.regionSearchCheckbox.should(visible, Duration.ofSeconds(6000)).click();
        searchPage.regionSearchCheckbox.click();
        searchPage.regionSearchSubmitButton.click();
        searchPage.salaryInputField.scrollIntoView(true).click();
        searchPage.salaryInputField.sendKeys(Integer.toString(salaryToSearch));
        searchPage.salaryCheckBox.scrollIntoView(true).click();
        searchPage.submitButtonInFilter.click();
    }

    @Step("Проверить, что все отобразившиеся вакансии имеют указанный уровень дохода, доход составляет {0} и более")
    public void shownVacanciesSalaryCheck(int salaryToSearch) {
        searchPage.salaryInfo.texts().forEach(text ->
                assertTrue(getSalaryInRub(text) >= salaryToSearch));

    }

    public double getSalaryInRub(String sal) {

        String salary = sal;
        if (sal.contains(" – ")) {
            salary = sal.split(" – ")[0];
        }

        if (sal.contains("руб.")) {
            String sum = salary.replaceAll("\\D", "");
            return Double.parseDouble(sum);
        } else if (sal.contains("EUR")) {
            String sum = salary.replaceAll("\\D", "");
            return Double.parseDouble(sum) * 76.56;
        } else {
            String sum = salary.replaceAll("\\D", "");
            return Double.parseDouble(sum) * 72.68;
        }
    }
}