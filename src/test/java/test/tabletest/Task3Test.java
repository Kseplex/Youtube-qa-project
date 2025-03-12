package test.tabletest;

import com.codeborne.selenide.CollectionCondition;
import common.enums.Chapter;
import common.enums.ElementsSubchapter;
import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class Task3Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Редактирование ряда")
    public void editRowTest() {
        Human humanToEdit = new Human()
                .age(28)
                .salary(0)
                .department("GMs")
                .email("valentin@example.com")
                .firstName("Valentin")
                .lastName("Dyagilev");

        List<String> arr1 = List.of("bbb","aaa");
        List<String> arr = new ArrayList<>();
        arr.add("e");
        arr.add("e");
        Collections.reverse(arr);
        Collections.reverse(arr1);

        assertThat(arr).isSorted();
        assertThat(arr).isSortedAccordingTo(Collections.reverseOrder());

        steps.checkTable(Chapter.ELEMENTS, ElementsSubchapter.WEB_TABLES);
        steps.checkEditButton();
        steps.checkAddRow(humanToEdit);

    }
}
