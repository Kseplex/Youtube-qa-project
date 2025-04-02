package uitests.steps.tablesteps;

import uitests.common.enums.Chapter;
import uitests.common.enums.SubChapter;
import io.qameta.allure.Step;
import uitests.steps.BaseSteps;
import uitests.common.model.Human;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TableSteps extends BaseSteps {

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразилась таблица")
    public void checkTable(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        webTablesPage.table.should(visible, Duration.ofSeconds(4000));
    }

    @Step("Нажать кнопку '{Add}', проверить, что открылось окно")
    public void checkRegistrationForm(List<String> placeholders) {
        clickButtonByText("Add");
        checkRegistrationFormFields(placeholders);
    }

    @Step("Проверить отображение окна регистрации")
    public void checkRegistrationFormFields(List<String> placeholders) {
        assertAll(
                () -> placeholders.forEach(placeholder->webTablesPage.getElementByPlaceholder(placeholder).should(visible, Duration.ofSeconds(4000))),
                () -> webTablesPage.registrationFormCLose.should(visible, Duration.ofSeconds(4000)),
                () -> webTablesPage.registrationFormSubmit.should(visible, Duration.ofSeconds(4000))
        );
    }

    @Step("Нажать кнопку удаления в правой части ряда, проверить, что в таблице была удалена запись")
    public void checkDeleteRow(Human human) {
        webTablesPage.getDeleteButtonByName(human.firstName(), human.lastName()).click();
        checkRowIsNotDisplayed(human);
    }

    @Step("Нажать кнопку редактирования в правой части ряда, проверить, что открылось окно")
    public void checkEditButton(Human human, List<String> placeholders) {
        webTablesPage.getEditButtonByName(human.firstName(), human.lastName()).click();
        checkRegistrationFormFields(placeholders);
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

    @Step("Нажать на наименование столбца таблицы, проверить, что данные в таблице отсортированы")
    public void checkColumnsSortingButtons() {
        webTablesPage.columnHeaders.forEach(header->{
            header.click();
            checkSortingAscendingOrder(header.getText());
            header.click();
            checkSortingDescendingOrder(header.getText());
        });
    }

    @Step("Проверяем сортировку столбцов в порядке возрастания, в зависимости от типа данных")
    public void checkSortingAscendingOrder(String name) {
        switch (name) {
            case "Age", "Salary" -> assertThat(webTablesPage.getColumnByIndex(
                            webTablesPage.columnHeaders.texts().indexOf(name))
                    .texts().stream().map(Integer::parseInt).toList()).isSorted();
            default -> assertThat(webTablesPage.getColumnByIndex(
                            webTablesPage.columnHeaders.texts().indexOf(name))
                    .texts()).isSorted();
        }
    }

    @Step("Проверяем сортировку столбцов в порядке убывания, в зависимости от типа данных")
    public void checkSortingDescendingOrder(String name) {
        switch (name) {
            case "Age", "Salary" -> assertThat(webTablesPage.getColumnByIndex(
                            webTablesPage.columnHeaders.texts().indexOf(name))
                    .texts().stream().map(Integer::parseInt).toList()).isSortedAccordingTo(Comparator.reverseOrder());
            default -> assertThat(webTablesPage.getColumnByIndex(
                            webTablesPage.columnHeaders.texts().indexOf(name))
                    .texts()).isSortedAccordingTo(Comparator.reverseOrder());
        }
    }

}
