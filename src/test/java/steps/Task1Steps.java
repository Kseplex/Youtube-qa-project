package steps;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Steps extends BaseSteps {

    private final String SEARCH_HEADER = "Select Menu";
    private final List<String> expectedSelectOptions = List.of("Group 1, option 1", "Group 1, option 2",
            "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option");
    private final ElementsCollection collection = selectMenuPage.valueCollection;

    public void checkHeader() {
        navigationMenu.createXpath("Widgets").click();
        navigationMenu.createXpath("Select Menu").click();

        Assertions.assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                SEARCH_HEADER);
    }

    public void checkDropdownMenu () {
        selectMenuPage.selectValue.click();
        assertThat(collection.texts()).isEqualTo(expectedSelectOptions);
    }
}
