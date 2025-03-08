package test.dropdowntest;

import common.enums.Chapter;
import common.enums.WidgetsSubChapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.dropdownsteps.DropdownSteps;


import java.util.List;

public class Task2Test extends BaseSelenideTest {

    private final DropdownSteps task2Steps = new DropdownSteps();

    @Test
    @DisplayName("Выпадающий список с множеством значений")
    public void multipleSelectTest() {
        final List<String> expectedSelectOptions = List.of("Green", "Blue", "Black", "Red");

        task2Steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        task2Steps.checkDropdownMenu(expectedSelectOptions);
        task2Steps.checkSelectedValues(List.of("Blue", "Green"));
        task2Steps.checkCleaning();
        task2Steps.checkSelectAll();
    }

}
