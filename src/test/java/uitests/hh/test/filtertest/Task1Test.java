package uitests.hh.test.filtertest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.core.BaseSelenideTest;
import uitests.hh.steps.filtersteps.FilterSteps;

public class Task1Test extends BaseSelenideTest {

    private final FilterSteps steps = new FilterSteps();
    private final String vacancyToSearch = "QA Automation Java";
    private final int salaryToSearch = 150000;


    @Test
    @DisplayName("Проверка фильтра в поиске вакансий")
    public void filterTest() {
        steps.vacanciesListCheck(vacancyToSearch);
        steps.vacanciesFilterCheck(salaryToSearch);
        steps.shownVacanciesSalaryCheck(salaryToSearch);
    }
}
