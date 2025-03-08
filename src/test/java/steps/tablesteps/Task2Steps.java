package steps.tablesteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.util.List;

public class Task2Steps extends BaseSteps {

    @Step("Нажать кнопку удаления в правой части ряда, проверить, что в таблице была удалена запись")
    public void checkNameIsNotDisplayed(List<String> data) {
        webTablesPage.getDeleteButtonByName(data.get(0), data.get(1)).click();

    }

}
