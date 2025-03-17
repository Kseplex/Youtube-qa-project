package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarPage {

    public final SelenideElement dateSelector = $x("//div[@id='datePickerContainer']//input[@id='datePickerMonthYearInput']");

    public final SelenideElement dateAndTimeSelector = $x("//div[@id='datePickerContainer']//input[@id='dateAndTimePickerInput']");

    public final SelenideElement dateMonthSelector = $x("//div[@class='react-datepicker']//select[contains(@class,'month')]");

    public final SelenideElement dateYearSelector = $x("//div[@class='react-datepicker']//select[contains(@class,'year')]");

    public final SelenideElement dateTimeMonthSelector = $x("//div[@class='react-datepicker']//div[contains(@class,'month-dropdown')]");

    public final SelenideElement dateTimeYearSelector = $x("//div[@class='react-datepicker']//div[contains(@class,'year-dropdown')]");

    public final ElementsCollection dateTimeYearsVisible = dateTimeYearSelector.$$x(".//div[contains(@class,'option')][text()]");

    public SelenideElement getMonthInDateSelector(int value) {
        return dateMonthSelector.$x(String.format(".//option[%d]", value));
    }

    public SelenideElement getYearInDateSelector(int value) {
        return dateYearSelector.$x(String.format(".//option[@value='%d']", value));
    }

    public SelenideElement getDayInSelectorByMonth(String month, int value) {
        return $x(String.format("//div[@role='listbox']//div[contains(@aria-label,'%s')][text()=%d]", month, value));
    }

    public SelenideElement getYearInDateTimeSelector(String target) {
        while (true) {
            if (dateTimeYearsVisible.texts().contains(target)) {
                return dateTimeYearSelector.$x(String.format(".//div[contains(@class,'option')][text()='%s']", target));
            } else if (Integer.parseInt(dateTimeYearSelector.$x(".//div[contains(@class,'option')][12]").text()) > Integer.parseInt(target)) {
                dateTimeYearSelector.$x(".//div[contains(@class,'option')][13]").click();
            } else {
                dateTimeYearSelector.$x(".//div[contains(@class,'option')][1]").click();
            }
        }
    }

    public SelenideElement getMonthInDateTimeSelector(String name) {
        return dateTimeMonthSelector.$x(String.format(".//div[text()='%s']", name));
    }

    public SelenideElement getTimeInDateTimeSelector(String time) {
        return $x(String.format("//div[contains(@class,'time-container')]//li[text()='%s']", time));
    }
}
