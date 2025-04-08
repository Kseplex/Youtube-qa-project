package uitests.pendrak.test.tabletest;

import uitests.pendrak.common.enums.Chapter;
import uitests.pendrak.common.enums.ElementsSubchapter;
import uitests.pendrak.common.model.Human;
import uitests.core.BaseSelenideTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uitests.pendrak.steps.tablesteps.TableSteps;

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
