package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

import java.util.List;

public class Task3Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    List<String> dataToFill = List.of("Valentin", "Dyagilev", "valentin@example.com", "28", "Spasibo", "GMs");

    @Test
    @DisplayName("Редактирование ряда")
    public void editRowTest() {
        Human humanToEdit = new Human()
                .age(69)
                .salary(300000)
                .department("GMs")
                .email("valentin@example.com")
                .firstName("Valentin")
                .lastName("Dyagilev");
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkEditButton();

    }
}
