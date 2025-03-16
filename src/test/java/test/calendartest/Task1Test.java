package test.calendartest;

import common.enums.Chapter;
import common.enums.WidgetsSubChapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.calendarsteps.CalendarSteps;

import java.time.format.DateTimeFormatter;

public class Task1Test extends BaseSelenideTest {

    private final CalendarSteps steps = new CalendarSteps();

    @Test
    @DisplayName("Выбор даты")
    public void selectDateTest() {
        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.DATE_PICKER);
        steps.checkWeekEarlierDate();
    }
}
