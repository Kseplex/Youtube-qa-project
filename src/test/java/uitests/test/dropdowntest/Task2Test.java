package uitests.test.dropdowntest;

import uitests.common.enums.Chapter;
import uitests.common.enums.WidgetsSubChapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.steps.dropdownsteps.DropdownSteps;

import java.util.List;

public class Task2Test extends BaseSelenideTest {

    private final DropdownSteps steps = new DropdownSteps();

    @Test
    @DisplayName("Выпадающий список с множеством значений")
    public void multipleSelectTest() {
        final List<String> expectedSelectOptions = List.of("Green", "Blue", "Black", "Red");

        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        steps.checkMultiDropdownMenu(expectedSelectOptions);
        steps.checkSelectedValues(List.of("Blue", "Green"));
        steps.checkCleaning();
        steps.checkSelectAll();
    }

}
