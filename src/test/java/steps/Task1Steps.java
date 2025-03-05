package steps;

import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Steps extends BaseSteps {

    private final String HEADER = "Select Menu";
    private final List<String> expectedSelectOptions = List.of("Group 1, option 1", "Group 1, option 2",
            "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option");
    private final String EXPECTED_VALUE = "Group 2, option 2";

    public void checkHeader() {
        goToTab("Widgets");
        goToMenuElement("Select Menu");

        Assertions.assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                HEADER);
    }

    public void checkDropdownMenu () {
        selectMenuPage.selectValue.click();
        assertThat(selectMenuPage.valueCollection.texts())
                .isEqualTo(expectedSelectOptions);
    }

    public void checkSelectedValue() {
        selectMenuPage.valueCollection.get(3).click();

        Assertions.assertEquals(EXPECTED_VALUE,
                selectMenuPage.selectedValue.getText());

    }
}
