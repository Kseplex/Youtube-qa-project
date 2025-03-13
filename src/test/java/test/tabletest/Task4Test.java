package test.tabletest;

import common.model.Human;
import core.BaseSelenideTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.tablesteps.TableSteps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task4Test extends BaseSelenideTest {

    private final TableSteps steps = new TableSteps();

    @Test
    @DisplayName("Сортировка значений столбцов")
    public void sortColumnsTest() {

        steps.checkColumnsSortingButtons();
    }
//    List<String> arr1 = List.of("bbb","aaa");
//    List<String> arr = new ArrayList<>();
//    arr.add("e");
//    arr.add("e");
//    Collections.reverse(arr);
//    Collections.reverse(arr1);
//    assertThat(arr).isSorted();
//    assertThat(arr).isSortedAccordingTo(Collections.reverseOrder());

}
