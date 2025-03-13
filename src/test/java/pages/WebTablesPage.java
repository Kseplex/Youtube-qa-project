package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import common.model.Human;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WebTablesPage {

    public final SelenideElement table = $x("//div[@class='web-tables-wrapper']//div[@class='rt-table']");

    public final SelenideElement registrationFormCLose = $x("//body//div[@class='modal-content']//button[@class='close']");

    public final SelenideElement registrationFormSubmit = $x("//body//div[@class='modal-content']//button[@id='submit']");

    public final ElementsCollection columnHeaders = $$x("//div[@class='rt-table']//div[@role='row']//div[@role='columnheader']/div[1]");

    public SelenideElement getDeleteButtonByName(String name, String surname) {
        return getRowByName(name, surname).$x(".//div[@class='action-buttons']/span[contains(@id,'delete')]");
    }

    public SelenideElement getEditButtonByName(String name, String surname) {
        return getRowByName(name, surname).$x(".//div[@class='action-buttons']/span[contains(@id,'edit')]");
    }

    public SelenideElement getRowByName(String name, String surname) {
        return $x(String.format("//div[./div[@role='gridcell' and text()='%s'] and ./div[@role='gridcell' " +
                "and text()='%s']]", name, surname));
    }

    public SelenideElement getCellInRow(SelenideElement row, int cellIndex) {
        return row.$$x(".//div[@role='gridcell']").get(cellIndex);
    }

    public Human getHumanFromRow(String name, String surname) {
        SelenideElement row = getRowByName(name, surname);

        return new Human()
                .firstName(getCellInRow(row, 0).text())
                .lastName(getCellInRow(row, 1).text())
                .age(Integer.parseInt(getCellInRow(row, 2).text()))
                .email(getCellInRow(row, 3).text())
                .salary(Integer.parseInt(getCellInRow(row, 4).text()))
                .department(getCellInRow(row, 5).text());
    }

    public SelenideElement getElementByPlaceholder(String placeholder) {
        return $x(String.format("//body//div[@class='modal-content']//input[@placeholder='%s']", placeholder));
    }

    public final ElementsCollection getColumnByIndex(int index) {
        return $$x(String.format("//div[@class='rt-table']//div[@role='rowgroup']//div[@role='gridcell' " +
                "and text()][%d]", index + 1));
    }

    public List<Integer> ageColumn = $$x("").texts().stream().map(Integer::parseInt).toList();

    //TODO:хардкодить вот так ->
    public List<Integer> salaryColumn = $$x("").texts().stream().map(Integer::parseInt).toList();





}
