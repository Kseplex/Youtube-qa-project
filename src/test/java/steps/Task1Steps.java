package steps;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Selenide.$$x;


public class Task1Steps extends BaseSteps {

    private final String SEARCH_HEADER = "Select Menu";
    private final String[] temp = new String[] {"Group 1, option 1", "Group 1, option 2", "Group 2, option 1",
            "Group 2, option 2", "A root option", "Another root option"};

    public void findHeader() {
        navigationMenu.createXpath("Widgets").click();
        navigationMenu.createXpath("Select Menu").click();

        Assertions.assertEquals(
                selectMenuPage.headerSelectMenu.getText(),
                SEARCH_HEADER);
    }

    public void checkDropdownMenu () {
        selectMenuPage.selectValue.click();
        ElementsCollection collection = $$x("//div[@tabindex='-1']");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            list.add(collection.get(i).getText());
        }

        Assertions.assertArrayEquals(list.toArray(), temp);
    }
}
