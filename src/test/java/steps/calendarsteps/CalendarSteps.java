package steps.calendarsteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalendarSteps extends BaseSteps {

    private final LocalDate today = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Step("Нажать на селектор 'select date', выбрать минус неделю от текущей даты, проверить, что отобразится верная дата")
    public void checkWeekEarlierDate() {
        LocalDate expectedDate = today.minusWeeks(1);

        calendarPage.dateSelector.click();

        calendarPage.yearSelector.click();
        calendarPage.getYearToSelectByValue(expectedDate.getYear()).click();

        calendarPage.monthSelector.click();
        String monthName = calendarPage.getMonthToSelectByValue(expectedDate.getMonthValue()).getText();
        calendarPage.getMonthToSelectByValue(expectedDate.getMonthValue()).click();

        calendarPage.getDayToSelectByMonthAndValue(monthName, expectedDate.getDayOfMonth()).click();

        assertThat(calendarPage.dateSelector.getValue()).isEqualTo(expectedDate.format(formatter));
    }
}
