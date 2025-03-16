package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarPage {

    public final SelenideElement dateSelector = $x("//div[@id='datePickerContainer']//input[@id='datePickerMonthYearInput']");

//    public final SelenideElement dateAndTimeSelector = $x("//div[@id='datePickerContainer']//input[@id='dateAndTimePickerInput']");

    public final SelenideElement monthSelector = $x("//div[@class='react-datepicker']//select[contains(@class,'month')]");

    public final SelenideElement yearSelector = $x("//div[@class='react-datepicker']//select[contains(@class,'year')]");

    public SelenideElement getMonthToSelectByValue(int value) {
        return monthSelector.$x(String.format(".//option[%d]", value));
    }

    public SelenideElement getYearToSelectByValue(int value) {
        return yearSelector.$x(String.format(".//option[@value='%d']", value));
    }

    public SelenideElement getDayToSelectByMonthAndValue(String month, int value) {
        return $x(String.format("//div[@role='listbox']//div[contains(@aria-label,'%s')][text()=%d]", month, value));
    }
}
