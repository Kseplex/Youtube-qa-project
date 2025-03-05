package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import common.enums.Chapter;
import common.enums.SubChapter;

import static com.codeborne.selenide.Selenide.$x;

public class NavigationMenu {

    public SelenideElement getTabByText(String text) {
        return $x("//div[@class='card-body']//h5[text()='" + text + "']");
    }

    public void selectSubchapterInChapter(Chapter chapter, SubChapter subChapter){
        if(!$x(String.format("//div[@class='element-group' and .//div[text()='%s']]//ul[@class='menu-list']", chapter.getValue())).is(Condition.visible)){
            $x(String.format("//div[@class='element-group' and .//div[text()='%s']]", chapter.getValue())).click();
        }
        $x(String.format("//div[@class='element-group' and .//div[text()='%s']]//span[@class='text'][text()='%s']", chapter.getValue(), subChapter.getValue())).click();
    }

}
