package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

import java.util.List;

public class Task1Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();
    private final List<String> placeholders = List.of("First Name", "Last Name", "name@example.com", "Age", "Salary", "Department");
    private Human humanToAdd = faker.generateHuman();

    @AfterEach
    public void closeEach() {
        steps.webTablesPage.getDeleteButtonByName(humanToAdd.firstName(), humanToAdd.lastName()).click();
    }

    @Test
    @DisplayName("Добавление ряда")
    public void addRowTest() {
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkRegistrationForm(placeholders);
        steps.checkAddRow(humanToAdd);
    }
}
