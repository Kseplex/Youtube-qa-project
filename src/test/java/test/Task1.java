package test;

import core.BaseSelenideTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task1Steps;

public class Task1 extends BaseSelenideTest {

    private final Task1Steps task1Steps = new Task1Steps();

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        task1Steps.checkHeader();
        task1Steps.checkDropdownMenu();
        task1Steps.checkSelectedValue();
    }

}

