package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

public class Task3Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @BeforeEach
    public void initEach() {
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.clickButtonByText("Add");
        steps.fillRegistrationForm(humanToAdd);
        steps.clickButtonByText("Submit");
    }

    @AfterEach
    public void closeEach() {
        steps.webTablesPage.getDeleteButtonByName(humanToEdit.firstName(), humanToEdit.lastName()).click();
    }

    @Test
    @DisplayName("Редактирование ряда")
    public void editRowTest() {
        steps.checkEditButton(humanToAdd, placeholders);
        steps.checkAddRow(humanToEdit);
    }
}
