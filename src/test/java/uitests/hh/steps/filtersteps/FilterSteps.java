package uitests.hh.steps.filtersteps;

import io.qameta.allure.Step;
import uitests.hh.pages.SearchPage;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterSteps {

    private final SearchPage searchPage = new SearchPage();

    @Step("В поисковой строке ввести '{0}', нажать кнопку поиска, проверить, " +
            "что отобразился список вакансий")
    public void vacanciesListCheck(String vacancyToSearch) {
        searchPage.searchInputField.should(visible, Duration.ofSeconds(6000)).click();
        searchPage.searchInputField.sendKeys(vacancyToSearch);
        searchPage.submitButton.click();
        if (searchPage.dialogForm.isDisplayed())
            searchPage.dialogFormCross.click();
        searchPage.vacanciesList.should(visible, Duration.ofSeconds(6000));
    }

    @Step("Нажать кнопку фильтра, убрать ограничения региона, уровень дохода '{0}', показывать только вакансии " +
            "с указанным уровнем дохода = true, применить фильтр")
    public void vacanciesFilterCheck(int salaryToSearch) {
        searchPage.filterButton.should(visible, Duration.ofSeconds(6000)).click();
        searchPage.regionCrosses.forEach(element ->
                element.scrollIntoView(true).click()
        );
        searchPage.salaryInputField.scrollIntoView(true).click();
        searchPage.salaryInputField.sendKeys(Integer.toString(salaryToSearch));
        searchPage.salaryCheckBox.scrollIntoView(true).click();
        searchPage.submitButtonInFilter.click();
    }

    @Step("Проверить, что все отобразившиеся вакансии имеют указанный уровень дохода, доход составляет {0} и более")
    public void shownVacanciesSalaryCheck(int salaryToSearch) {
        searchPage.salaryInfo.texts().forEach(text-> {
                    System.out.println(text);
                    assertTrue(text.contains("₽") ? checkSalaryInRubles(text.replaceAll(" ", ""), salaryToSearch)
                            : checkSalaryInDollars(text.replaceAll(" ", ""), salaryToSearch));
                }
        );
    }

    public boolean checkSalaryInRubles(String text, int salaryToSearch) {
        Pattern pattern = Pattern.compile("\\d{4}");
        System.out.println(text);

        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
            return Integer.parseInt(matcher.group()) >= salaryToSearch;
        }
        System.out.println(matcher.group());
        return false;
    }

    public boolean checkSalaryInDollars(String text, int salaryToSearch) {
        Pattern pattern = Pattern.compile("^\\d\\s\\d{3}$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
            return Integer.parseInt(matcher.group(1).replaceAll(" ", "")) >= salaryToSearch / 83;
        return false;
    }
}
