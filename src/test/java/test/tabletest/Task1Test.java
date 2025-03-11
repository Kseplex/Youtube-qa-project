package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

public class Task1Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Добавление ряда")
    public void addRowTest() {
        Human humanToAdd = new Human()
                .age(24)
                .salary(300000)
                .department("Nanosecs")
                .email("alex@example.com")
                .firstName("Alexander")
                .lastName("Zhidyaev");

        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkRegistrationForm();
        steps.checkAddRow(humanToAdd);
    }
}
