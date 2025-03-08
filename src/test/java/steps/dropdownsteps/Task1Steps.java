package steps.dropdownsteps;

import io.qameta.allure.Step;
import steps.BaseSteps;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Steps extends BaseSteps {

    @Step("Нажать на селектор 'select value', проверить, что отобразился выпадающий список со значениями '{list}'")
    public void checkDropdownMenu (List<String> list) {
        selectMenuPage.singleSelectContainer.click();
        assertThat(selectMenuPage.singleValueCollection.texts())
                .isEqualTo(list);
    }

    @Step("Выбрать в выпадающем списке '{value}', проверить, что после нажатия в селекторе будет установлено \n" +
            "это значение")
    public void checkSelectedValue(String value) {
        selectMenuPage.getSingleSelectOption(value).click();

        assertEquals(value,
                selectMenuPage.selectedSingleValue.getText());
    }
}
