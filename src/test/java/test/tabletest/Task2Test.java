package test.tabletest;

import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import steps.tablesteps.TableSteps;

public class Task2Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @BeforeEach
    void preconditions(){
        //этот метод будет выполняться перед запуском каждого тестового метода в классе
    }

    @AfterEach
    void postconditions(){
        //этот метод будет выполняться после запуска каждого тестового метода в классе
    }

    @Test
    @DisplayName("Удаление ряда")
    public void deleteRowTest() {

        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
    }

}
