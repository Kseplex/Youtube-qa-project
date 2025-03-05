package steps;

import common.enums.Chapter;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Steps extends BaseSteps {

    private final String HEADER = "Select Menu";
    private final List<String> expectedSelectOptions = List.of("Group 1, option 1", "Group 1, option 2",
            "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option");
    private final String EXPECTED_VALUE = "Group 2, option 2";

    @Step("Перейти в раздел Widgets, подраздел Select Menu, проверить, что отобразился заголовок вверху страницы")
    public void checkHeader() {
        goToTab(Chapter.WIDGETS.getValue());
        goToMenuElement("Select Menu");

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                HEADER);
    }

    @Step("Нажать на селектор 'select value', проверить, что отобразился выпадающий список со значениями\n" +
            "'Group1, option1', 'Group1, option2' , 'Group2, option1', 'Group2, option2', 'A root option', 'Another root option'")
    public void checkDropdownMenu () {
        selectMenuPage.selectValue.click();
        assertThat(selectMenuPage.valueCollection.texts())
                .isEqualTo(expectedSelectOptions);
    }

    @Step("Выбрать в выпадающем списке '{value}', проверить, что после нажатия в селекторе будет установлено \n" +
            "это значение")
    public void checkSelectedValue(String value) {
        selectMenuPage.getSingleSelectOption(value).click();

        assertEquals(EXPECTED_VALUE,
                selectMenuPage.selectedValue.getText());
    }
}
