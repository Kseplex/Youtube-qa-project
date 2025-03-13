package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

import java.util.Map;

public class Task4Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    private final Map<String, Object> headersTypes = Map.of("First Name", String.class, "Last Name", String.class,
            "Age", Integer.class, "Email", String.class, "Salary", Integer.class, "Department", String.class);


    @Test
    @DisplayName("Сортировка значений столбцов")
    public void sortColumnsTest() {
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        //TODO: сделай метод через хардкод в webTablesPage
        //steps.checkColumnsSortingButtons();
    }
}
