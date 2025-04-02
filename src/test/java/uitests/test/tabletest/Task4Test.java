package uitests.test.tabletest;

import uitests.common.enums.Chapter;
import uitests.common.enums.ElementsSubchapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.steps.tablesteps.TableSteps;

public class Task4Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Сортировка значений столбцов")
    public void sortColumnsTest() {
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkColumnsSortingButtons();
    }
}
