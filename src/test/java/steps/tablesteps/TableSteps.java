package steps.tablesteps;

import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;
import steps.BaseSteps;
import common.model.Human;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableSteps extends BaseSteps {

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразилась таблица")
    public void checkTable(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertTrue(webTablesPage.table.isDisplayed());
    }

    @Step("Нажать кнопку '{Add}', проверить, что открылось окно")
    public void checkRegistrationForm() {
        clickButtonByText("Add");
        checkRegistrationFormFields();
    }

    @Step("Проверить отображение окна регистрации")
    public void checkRegistrationFormFields() {
        //TODO:getElementByPlaceholder
        webTablesPage.registrationFormFields.forEach(field->assertTrue(field.isDisplayed()));
        assertTrue(webTablesPage.registrationFormCLose.isDisplayed());
        assertTrue(webTablesPage.registrationFormSubmit.isDisplayed());
        //TODO: проверить отображение всех полей ввода, кнопки submit и крестика для закрытия - Done
    }

    @Step("Нажать кнопку удаления в правой части ряда, проверить, что в таблице была удалена запись")
    public void checkDeleteRow(Human human) {
        webTablesPage.getDeleteButtonByName(human.firstName(), human.lastName()).click();
        checkRowIsNotDisplayed(human);
    }

    @Step("Нажать кнопку редактирования в правой части ряда, проверить, что открылось окно")
    public void checkEditButton() {
        webTablesPage.getEditButtonByName("Cierra", "Vega").click();
        checkRegistrationFormFields();
    }

    @Step("Заполнить поля другими значениями, нажать Submit, проверить, что в таблице запись поменялась")
    public void checkAddRow(Human human) {
        fillRegistrationForm(human);
        clickButtonByText("Submit");
        checkRowIsDisplayed(human);
    }

    @Step("Проверить, что в таблице отобразилась новая запись")
    public void checkRowIsDisplayed(Human human){
        assertThat(human).isEqualTo(webTablesPage.getHumanFromRow(human.firstName(), human.lastName()));
    }

    @Step("Проверить, что в таблице была удалена запись")
    public void checkRowIsNotDisplayed(Human human){
        assertFalse(webTablesPage.getRowByName(human.firstName(), human.lastName()).isDisplayed());
    }

    @Step("Заполняем поля регистрации полями объекта {0}")
    public void fillRegistrationForm(Human human) {
        inputValueByPlaceholder("First Name", human.firstName());
        inputValueByPlaceholder("Last Name", human.lastName());
        inputValueByPlaceholder("name@example.com", human.email());
        inputValueByPlaceholder("Age", String.valueOf(human.age()));
        inputValueByPlaceholder("Salary", String.valueOf(human.salary()));
        inputValueByPlaceholder("Department", human.department());
    }

}
