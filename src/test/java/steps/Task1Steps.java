package steps;

import common.enums.Chapter;
import common.enums.SubChapter;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Steps extends BaseSteps {

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразился заголовок вверху страницы")
    public void checkHeader(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                subChapter.getValue());
    }

    @Step("Нажать на селектор 'select value', проверить, что отобразился выпадающий список со значениями '{list}'")
    public void checkDropdownMenu (List<String> list) {
        selectMenuPage.selectValue.click();
        assertThat(selectMenuPage.valueCollection.texts())
                .isEqualTo(list);
    }

    @Step("Выбрать в выпадающем списке '{value}', проверить, что после нажатия в селекторе будет установлено \n" +
            "это значение")
    public void checkSelectedValue(String value) {
        selectMenuPage.getSingleSelectOption(value).click();

        assertEquals(value,
                selectMenuPage.selectedValue.getText());
    }
}
