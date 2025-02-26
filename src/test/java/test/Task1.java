package test;

import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task1Steps;

public class Task1 extends BaseSelenideTest {
    private final static String SEARCH_HEADER = "Select Menu";
    private final Task1Steps steps = new Task1Steps();

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        //TODO:не хватает перехода с основной страницы на widgets, добавь в baseSteps
        Assertions.assertTrue(steps
                .findHeader()
                .equals(Task1.SEARCH_HEADER));
    }
}
