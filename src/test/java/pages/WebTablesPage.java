package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WebTablesPage {

    public final SelenideElement table = $x(
            "//div[@class='web-tables-wrapper']//div[@class='rt-table']");
    public final SelenideElement buttonAdd = $x(
            "//div[@class='web-tables-wrapper']//button[@type='button' and contains(text(),'Add')]");
    public final SelenideElement registrationForm = $x(
            "//body//div[@class='modal-content']");
    public final SelenideElement buttonSubmit = $x(
            "//body//div[@class='modal-content']//button[contains(@type,'submit')]");

    public final SelenideElement getDeleteButtonByName(String name, String surname) {
        return getRowByName(name, surname).get(7).$x("//div[@class='action-buttons']//span[@title='Delete']");
    }
    public final SelenideElement getEditButtonByName(String name, String surname) {
        return getRowByName(name, surname).get(7).$x("//div[@class='action-buttons']//span[@title='Edit']");
    }

    public final ElementsCollection registrationFormFields = $$x(
            "//body//div[@class='modal-content']//input");

    public final ElementsCollection getRowByName(String name, String surname) {
            return $$x(String.format("//div[./div[@role='gridcell' and text()='%s'] and ./div[@role='gridcell' " +
                    "and text()='%s']]", name, surname));
    }


//    public Human getHumanFromRow(SelenideElement row){
//        return new Human(
//                row.$x("xpath для имени"),
//                row.$x(""),
//                row.$x("")
//        );
//    }


}
