package steps.dropdownsteps;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import steps.BaseSteps;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Steps extends BaseSteps {

    @Step("Нажать на селектор 'Multiselect drop down', проверить, что отобразился выпадающий список со значениями\n" +
            "'{list}'")
    public void checkDropdownMenu(List<String> list) {
        selectMenuPage.multiSelectContainer.click();
        assertThat(selectMenuPage.multiValueCollection.texts())
                .isEqualTo(list);
    }

    @Step("Выбрать в выпадающем списке '{0}', проверить, что после нажатия в селекторе будут установлены\n" +
            "эти значения")
    public void checkSelectedValues(List<String> options) {
        options.forEach(option->selectMenuPage.getMultiSelectOption(option).click());
        assertThat(selectMenuPage.getMultiSelectedOptions().texts()).isEqualTo(options);
    }

    @Step("Нажать на крестик в селекторе, проверить, что поле очистится")
    public void checkCleaning() {
        selectMenuPage.multiSelectCross.click();
        selectMenuPage.getMultiSelectedOptions().should(CollectionCondition.empty, Duration.ofSeconds(5));
    }

    @Step("Выбрать в выпадающем списке все доступные элементы, проверить, что после выбора всех в списке появится надпись\n" +
            "'No options'")
    public void checkSelectAll() {
        selectMenuPage.multiSelectContainer.click();
        selectMenuPage.multiValueCollection.texts().forEach(option->selectMenuPage.getMultiSelectOption(option).click());
        assertTrue(selectMenuPage.noOptionsSelect.isDisplayed());
    }

}
