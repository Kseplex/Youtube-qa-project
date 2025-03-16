package test.dropdowntest;

import common.enums.Chapter;
import common.enums.WidgetsSubChapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.dropdownsteps.DropdownSteps;

import java.util.List;

public class Task2Test extends BaseSelenideTest {

    private final DropdownSteps steps = new DropdownSteps();

    @Test
    @DisplayName("Выпадающий список с множеством значений")
    public void multipleSelectTest() {
        final List<String> expectedSelectOptions = List.of("Green", "Blue", "Black", "Red");

        steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        steps.checkDropdownMenu(expectedSelectOptions);
        steps.checkSelectedValues(List.of("Blue", "Green"));
        steps.checkCleaning();
        steps.checkSelectAll();
    }

}
