package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import steps.tablesteps.Task2Steps;

public class Task2Test extends BaseSelenideTest {

    Task2Steps task2Steps = new Task2Steps();
    Task1Test task1Test = new Task1Test();

    @Test
    @DisplayName("Удаление ряда")
    public void deleteRowTest() {
        task2Steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        task2Steps.checkNameIsNotDisplayed(task1Test.dataToFill);
    }

}
