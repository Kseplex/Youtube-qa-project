package uitests.test.tabletest;

import uitests.common.enums.Chapter;
import uitests.common.enums.ElementsSubchapter;
import uitests.common.model.Human;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uitests.steps.tablesteps.TableSteps;

public class Task2Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();
    private Human humanToAdd;

    @BeforeEach
    public void initEach(){
        humanToAdd = faker.generateHuman();
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.clickButtonByText("Add");
        steps.fillRegistrationForm(humanToAdd);
        steps.clickButtonByText("Submit");
    }

    @Test
    @DisplayName("Удаление ряда")
    public void deleteRowTest() {
        steps.checkDeleteRow(humanToAdd);
    }
}
