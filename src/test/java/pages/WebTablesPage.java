package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import common.model.Human;

import static com.codeborne.selenide.Selenide.$x;

public class WebTablesPage {

    public final SelenideElement table = $x("//div[@class='web-tables-wrapper']//div[@class='rt-table']");

    public final SelenideElement registrationForm = $x("//body//div[@class='modal-content']");

    public SelenideElement getDeleteButtonByName(String name, String surname) {
        return getRowByName(name, surname).$x(".//div[@class='action-buttons']/span[contains(@id,'delete')]");
    }

    public SelenideElement getEditButtonByName(String name, String surname) {
        return getRowByName(name, surname).$x(".//div[@class='action-buttons']/span[contains(@id,'edit')]");
    }

    @Step("")//todo:допиши текст
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


}
