package uitests.test.tabletest;

import uitests.common.enums.Chapter;
import uitests.common.enums.ElementsSubchapter;
import uitests.common.model.Human;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitests.steps.tablesteps.TableSteps;

import java.util.List;

public class Task3Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    private final List<String> placeholders = List.of("First Name", "Last Name", "name@example.com", "Age", "Salary", "Department");
    private Human humanToAdd;
    private Human humanToEdit;

    @BeforeEach
    public void initEach() {
        humanToAdd = faker.generateHuman();
        humanToEdit = faker.generateHuman();
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
