package uitests.pendrak.test.dropdowntest;

import uitests.pendrak.common.enums.Chapter;
import uitests.pendrak.common.enums.WidgetsSubChapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.pendrak.steps.dropdownsteps.DropdownSteps;

import java.util.List;

public class Task1Test extends BaseSelenideTest {

    private final DropdownSteps steps = new DropdownSteps();

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        final List<String> expectedSelectOptions = List.of("Group 1, option 1", "Group 1, option 2",
                "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option");

        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        steps.checkDropdownMenu(expectedSelectOptions);
        steps.checkSelectedValue("Group 2, option 2");
    }

}

