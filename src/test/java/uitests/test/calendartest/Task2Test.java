package uitests.test.calendartest;

import uitests.common.enums.Chapter;
import uitests.common.enums.WidgetsSubChapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.steps.calendarsteps.CalendarSteps;

public class Task2Test extends BaseSelenideTest {

    private final CalendarSteps steps = new CalendarSteps();

    @Test
    @DisplayName("Выбор даты и времени")
    public void selectDateAndTimeTest() {
        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.DATE_PICKER);
        steps.checkEarlierDateAndTime();
    }
}
