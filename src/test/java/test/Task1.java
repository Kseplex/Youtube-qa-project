package test;

import common.enums.Chapter;
import common.enums.WidgetsSubChapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task1Steps;

import java.util.List;

public class Task1 extends BaseSelenideTest {

    private final Task1Steps task1Steps = new Task1Steps();

    private final List<String> expectedSelectOptions = List.of("Group 1, option 1", "Group 1, option 2",
            "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option");

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        task1Steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        task1Steps.checkDropdownMenu(expectedSelectOptions);
        task1Steps.checkSelectedValue("Group 2, option 2");
    }

}

