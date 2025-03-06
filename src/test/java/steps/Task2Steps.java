package steps;

import common.enums.Chapter;
import common.enums.DropdownOptions;
import common.enums.SubChapter;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Steps extends BaseSteps{

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразился заголовок вверху страницы")
    public void checkHeader(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                subChapter.getValue());
    }

    @Step("Нажать на селектор 'Multiselect drop down', проверить, что отобразился выпадающий список \n" +
            "со значениями '{list}'")
    public void checkDropdownMenu(List<String> list) {
        selectMenuPage.multiSelectValue.click();
        assertThat(selectMenuPage.multiValueCollection.texts())
                .isEqualTo(list);
    }

    @Step("Выбрать в выпадающем списке '{0}', '{1}', проверить, что после нажатия в селекторе будут установлены\n" +
            "эти значения")
    public void checkValues(DropdownOptions first, DropdownOptions second) {
        selectMenuPage.selectValues(first.getValue()).click();
        selectMenuPage.selectValues(second.getValue()).click();

    }
}
