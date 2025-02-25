package test;

import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Task1Steps;

public class Task1 extends BaseSelenideTest {
    private final static String URL = "http://85.192.34.140:8081/widgets";
    private final static String SEARCH_HEADER = "Select Menu";

    private final Task1Steps steps = new Task1Steps(URL);

    @Test
    @DisplayName("Выпадающий список")
    public void singleSelectTest() {
        Assertions.assertTrue(steps
                .findHeader()
                .equals(Task1.SEARCH_HEADER));
    }
}
