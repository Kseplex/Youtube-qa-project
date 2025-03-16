package steps.calendarsteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalendarSteps extends BaseSteps {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Step("Нажать на селектор 'select date', выбрать минус неделю от текущей даты, проверить, что отобразится верная дата")
    public void checkWeekEarlierDate() {
        LocalDate expectedDate = LocalDate.now().minusWeeks(1);

        calendarPage.dateSelector.click();

        calendarPage.yearSelector.click();
        calendarPage.getYearToSelectByValue(expectedDate.getYear()).click();

        calendarPage.monthSelector.click();
        String monthName = calendarPage.getMonthToSelectByValue(expectedDate.getMonthValue()).getText();
        calendarPage.getMonthToSelectByValue(expectedDate.getMonthValue()).click();

        calendarPage.getDayToSelectByMonthAndValue(monthName, expectedDate.getDayOfMonth()).click();

        assertThat(calendarPage.dateSelector.getValue()).isEqualTo(expectedDate.format(formatter));
    }

    @Step("Нажать на селектор 'Date And Time', выбрать минус 5 месяцев и 5 лет от текущей даты, время 11:30 АМ,\n" +
            " проверить, что отобразятся верные дата и время")
    public void checkEarlierDateAndTime() {
        LocalDateTime expectedDateAndTime = LocalDateTime.of(
                LocalDate.now().minusYears(5).minusMonths(5),
                LocalTime.parse("11:30"));
        calendarPage.dateAndTimeSelector.click();
        //TODO доделать 2 тест
    }

}
