package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.Task1Steps;

import java.util.List;

public class Task1Test extends BaseSelenideTest {

    Task1Steps task1Steps = new Task1Steps();
    public List<String> dataToFill = List.of("Alexander", "Zhidyaev", "alex@example.com", "25", "300000", "Nanosecs");

    @Test
    @DisplayName("Добавление ряда")
    public void addRowTest() {
        task1Steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        task1Steps.checkRegistrationForm();
        task1Steps.checkNameIsDisplayed(dataToFill);
    }
}
