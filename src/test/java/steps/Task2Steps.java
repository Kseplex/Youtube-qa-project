package steps;

import common.enums.Chapter;
import common.enums.DropdownOptions;
import common.enums.SubChapter;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Steps extends BaseSteps{

    @Step("Перейти в раздел '{0}', подраздел '{1}', проверить, что отобразился заголовок вверху страницы")
    public void checkHeader(Chapter chapter, SubChapter subChapter) {
        goToTab(chapter.getValue());
        goToMenuElement(chapter, subChapter);

        assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                subChapter.getValue());
    }

    @Step("Нажать на селектор 'Multiselect drop down', проверить, что отобразился выпадающий список со значениями\n" +
            "'{list}'")
    public void checkDropdownMenu(List<String> list) {
        selectMenuPage.multiSelectContainer.click();

        assertThat(selectMenuPage.multiValueCollection.texts())
                .isEqualTo(list);
    }

    @Step("Выбрать в выпадающем списке '{0}', '{1}', проверить, что после нажатия в селекторе будут установлены\n" +
            "эти значения")
    public void checkSelectedValues(DropdownOptions first, DropdownOptions second) {
        selectMenuPage.selectMultiValue(first.getValue()).click();
        selectMenuPage.selectMultiValue(second.getValue()).click();

        assertAll(
                () ->
                        assertThat(selectMenuPage.getMultiSelectOption(first.getValue()).getText())
                                .isEqualTo(first.getValue()),
                () ->
                        assertThat(selectMenuPage.getMultiSelectOption(second.getValue()).getText())
                                .isEqualTo(second.getValue())
        );
    }

    @Step("Нажать на крестик в селекторе, проверить, что поле очистится")
    public void checkCleaning() {
        selectMenuPage.crossMultiSelect.click();

        assertThat(selectMenuPage.emptyMultiSelect.getOwnText())
                .isEqualTo(DropdownOptions.EMPTY.getValue());
    }

    @Step("Выбрать в выпадающем списке все доступные элементы, проверить, что после выбора всех в списке появится надпись\n" +
            "'No options'")
    public void checkSelectAll() {

        for (String i : selectMenuPage.multiValueCollection.texts()) {
            selectMenuPage.selectMultiValue(i).click();
        }

        assertTrue(selectMenuPage.noOptionsSelect.isDisplayed());
    }
}
