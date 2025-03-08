package steps.tablesteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Steps extends BaseSteps {

    @Step("Нажать кнопку редактирования в правой части ряда, проверить, что открылось окно")
    public void checkEditButton() {
        webTablesPage.getEditButtonByName("Cierra", "Vega").click();

        assertTrue(webTablesPage.registrationForm.isDisplayed());
    }

    @Step("Заполнить поля другими значениями, нажать Submit, проверить, что в таблице запись поменялась")
    public void checkNameIsDisplayed(List<String> data) {
        fillRegistrationForm(data);
    }
}
