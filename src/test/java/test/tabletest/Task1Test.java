package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

public class Task1Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    private Human humanToAdd;

    @AfterEach
    public void closeEach() {
        humanToAdd = faker.generateHuman();
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
