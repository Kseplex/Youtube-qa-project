package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.Task3Steps;

import java.util.List;

public class Task3Test extends BaseSelenideTest {

    Task3Steps task3Steps = new Task3Steps();
    List<String> dataToFill = List.of("Valentin", "Dyagilev", "valentin@example.com", "28", "Spasibo", "GMs");

    @Test
    @DisplayName("Редактирование ряда")
    public void editRowTest() {
        task3Steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        task3Steps.checkEditButton();
        task3Steps.checkNameIsDisplayed(dataToFill);
    }
}
