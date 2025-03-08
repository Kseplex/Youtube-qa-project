package steps.tablesteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Steps extends BaseSteps {

    @Step("Нажать кнопку '{Add}', проверить, что открылось окно")
    public void checkRegistrationForm() {
        webTablesPage.buttonAdd.click();

        assertTrue(webTablesPage.registrationForm.isDisplayed());
    }

    @Step("Заполнить поля, нажать Submit, проверить, что в таблице отобразилась новая запись")
    public void checkNameIsDisplayed(List<String> data) {
        fillRegistrationForm(data);

    }
}
