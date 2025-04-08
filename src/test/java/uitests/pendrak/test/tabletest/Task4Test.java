package uitests.pendrak.test.tabletest;

import uitests.pendrak.common.enums.Chapter;
import uitests.pendrak.common.enums.ElementsSubchapter;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.pendrak.steps.tablesteps.TableSteps;

public class Task4Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Сортировка значений столбцов")
    public void sortColumnsTest() {
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkColumnsSortingButtons();
    }
}
