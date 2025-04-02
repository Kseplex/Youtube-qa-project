package uitests.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WidgetsSubChapter implements SubChapter{

    DATE_PICKER("Date Picker"),
    SELECT_MENU("Select Menu");

    private final String value;
}
