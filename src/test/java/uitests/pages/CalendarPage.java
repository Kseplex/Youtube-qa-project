package uitests.pages;

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

    public SelenideElement getMonthInDateSelector(int month) {
        return dateMonthSelector.$x(String.format(".//option[%d]", month));
    }

    public SelenideElement getYearInDateSelector(int year) {
        return dateYearSelector.$x(String.format(".//option[@value='%d']", year));
    }

    public SelenideElement getDayInSelectorByMonth(String month, int day) {
        return $x(String.format("//div[@role='listbox']//div[contains(@aria-label,'%s')][text()=%d]", month, day));
    }

    public SelenideElement getYearInDateTimeSelector(String year) {
        SelenideElement direction = null;
        if (Integer.parseInt(dateTimeYearsVisible.texts().get(0)) < Integer.parseInt(year)) {
            direction = dateTimeYearSelector.$x(".//div[contains(@class,'option')][1]");
        } else if (Integer.parseInt(dateTimeYearsVisible.texts().get(10)) > Integer.parseInt(year)) {
            direction = dateTimeYearSelector.$x(".//div[contains(@class,'option')][13]");
        }
        while (direction != null && !dateTimeYearsVisible.texts().contains(year)) {
            direction.click();
        }
        return dateTimeYearSelector.$x(String.format(".//div[contains(@class,'option')][text()='%s']", year));
    }

    public SelenideElement getMonthInDateTimeSelector(String month) {
        return dateTimeMonthSelector.$x(String.format(".//div[text()='%s']", month));
    }

    public SelenideElement getTimeInDateTimeSelector(String time) {
        return $x(String.format("//div[contains(@class,'time-container')]//li[text()='%s']", time));
    }
}
