package uitests.steps.calendarsteps;

import io.qameta.allure.Step;
import uitests.steps.BaseSteps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalendarSteps extends BaseSteps {

    private final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a", Locale.ENGLISH);

    @Step("Нажать на селектор 'select date', выбрать минус неделю от текущей даты, проверить, что отобразится верная дата")
    public void checkWeekEarlierDate() {
        LocalDate expectedDate = LocalDate.now().minusWeeks(1);
        String monthName = expectedDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        calendarPage.dateSelector.click();

        calendarPage.dateYearSelector.click();
        calendarPage.getYearInDateSelector(expectedDate.getYear()).click();

        calendarPage.dateMonthSelector.click();
        calendarPage.getMonthInDateSelector(expectedDate.getMonthValue()).click();

        calendarPage.getDayInSelectorByMonth(monthName, expectedDate.getDayOfMonth()).click();

        assertThat(calendarPage.dateSelector.getValue()).isEqualTo(expectedDate.format(formatterDate));
    }

    @Step("Нажать на селектор 'Date And Time', выбрать минус 5 месяцев и 5 лет от текущей даты, время 11:30 АМ,\n" +
            " проверить, что отобразятся верные дата и время")
    public void checkEarlierDateAndTime() {
        LocalDateTime expectedDateAndTime = LocalDateTime.of(
                LocalDate.now().minusYears(14).minusMonths(5),
                LocalTime.parse("11:30"));
        String monthName = expectedDateAndTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        calendarPage.dateAndTimeSelector.click();
        calendarPage.dateTimeYearSelector.click();
        calendarPage.getYearInDateTimeSelector(Integer.toString(expectedDateAndTime.getYear())).click();

        calendarPage.dateTimeMonthSelector.click();
        calendarPage.getMonthInDateTimeSelector(monthName).click();

        calendarPage.getDayInSelectorByMonth(monthName, expectedDateAndTime.getDayOfMonth()).click();

        calendarPage.getTimeInDateTimeSelector(expectedDateAndTime.getHour() + ":" + expectedDateAndTime.getMinute()).click();
        assertThat(calendarPage.dateAndTimeSelector.getValue()).isEqualTo(expectedDateAndTime.format(formatterDateTime));
    }

}
