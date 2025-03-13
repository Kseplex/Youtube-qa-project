package steps.tablesteps;

import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;
import steps.BaseSteps;
import common.model.Human;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TableSteps extends BaseSteps {

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразилась таблица")
    public void checkTable(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertTrue(webTablesPage.table.isDisplayed());
    }

    @Step("Нажать кнопку '{Add}', проверить, что открылось окно")
    public void checkRegistrationForm(List<String> placeholders) {
        clickButtonByText("Add");
        checkRegistrationFormFields(placeholders);
    }

    @Step("Проверить отображение окна регистрации")
    public void checkRegistrationFormFields(List<String> placeholders) {
        assertAll(
                () -> placeholders.forEach(placeholder->assertTrue(webTablesPage.getElementByPlaceholder(placeholder).isDisplayed())),
                () -> assertTrue(webTablesPage.registrationFormCLose.isDisplayed()),
                () -> assertTrue(webTablesPage.registrationFormSubmit.isDisplayed())
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

    /*@Step("Нажать на наименование столбца таблицы, проверить, что данные в таблице отсортированы")
    public void checkColumnsSortingButtons(Map<String, Class<T> class> headersTypes) {
        for(Map.Entry<String, Object> headerType: headersTypes.entrySet()){
           String header = headerType.getKey();
           //клик по хедеру по тексту
           assertThat(parseByHeaderType(webTablesPage.getColumnByIndex(
                           webTablesPage.columnHeaders.texts().indexOf(header))
                   .texts(), headerType.getValue())).isSorted();
            //клик по хедеру по тексту
            assertThat(parseByHeaderType(webTablesPage.getColumnByIndex(
                            webTablesPage.columnHeaders.texts().indexOf(header))
                    .texts(), headerType.getValue())).isSortedAccordingTo(Collections.reverseOrder());
        }
    }

    public List<T> parseByHeaderType(List<String> list, Class<T> type){
        switch (type){
            case Integer.class:{
                return list.stream().map(Integer::parseInt).toList();
                break;
            }
            case String.class:{
                return list;
                break;
            }
        }
    }
*/

}
