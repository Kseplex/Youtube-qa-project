package uitests.pendrak.test.calendartest;

import uitests.pendrak.common.enums.Chapter;
import uitests.pendrak.common.enums.WidgetsSubChapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.pendrak.steps.calendarsteps.CalendarSteps;

public class Task1Test extends BaseSelenideTest {

    private final CalendarSteps steps = new CalendarSteps();

    @Test
    @DisplayName("Выбор даты")
    public void selectDateTest() {
        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.DATE_PICKER);
        steps.checkWeekEarlierDate();
    }
}
