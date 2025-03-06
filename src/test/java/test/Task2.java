package test;

import common.enums.Chapter;
import common.enums.WidgetsSubChapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task2Steps;

import java.util.List;

public class Task2 extends BaseSelenideTest {

    private final Task2Steps task2Steps = new Task2Steps();
    private final List<String> expectedSelectOptions = List.of("Green", "Blue", "Black", "Red");

    @Test
    @DisplayName("Выпадающий список с множеством значений")
    public void multipleSelectTest() {
        task2Steps.checkHeader(Chapter.WIDGETS, WidgetsSubChapter.SELECT_MENU);
        task2Steps.checkDropdownMenu(expectedSelectOptions);
        task2Steps.checkSelectedValues(List.of("Blue", "Green"));
        task2Steps.checkCleaning();
        task2Steps.checkSelectAll();
    }

}
