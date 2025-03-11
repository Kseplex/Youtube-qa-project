package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

public class Task3Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Редактирование ряда")
    public void editRowTest() {
        Human humanToEdit = new Human()
                .age(28)
                .salary(0)
                .department("GMs")
                .email("valentin@example.com")
                .firstName("Valentin")
                .lastName("Dyagilev");
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkEditButton();
        steps.checkAddRow(humanToEdit);

    }
}
