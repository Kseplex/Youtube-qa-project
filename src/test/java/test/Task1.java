package test;

import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task1Steps;

public class Task1 extends BaseSelenideTest {

    private final Task1Steps task1Steps = new Task1Steps();

    //TODO: оставь 1 экземпляр класса Task1Steps // - Done

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        //TODO:не хватает перехода с основной страницы на widgets, добавь в baseSteps
        task1Steps.checkHeader();
        task1Steps.checkDropdownMenu();
    }

}

