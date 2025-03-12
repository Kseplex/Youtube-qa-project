package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import steps.tablesteps.TableSteps;

public class Task2Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();
    private final Human humanToTest = new Human()
            .age(24)
            .salary(300000)
            .department("Nanosecs")
            .email("alex@example.com")
            .firstName("Alexander")
            .lastName("Zhidyaev");

    @BeforeEach
    public void initEach(){
        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.clickButtonByText("Add");
        steps.fillRegistrationForm(humanToTest);
        steps.clickButtonByText("Submit");
    }

    @Test
    @DisplayName("Удаление ряда")
    public void deleteRowTest() {
        steps.checkDeleteRow(humanToTest);
    }

}
