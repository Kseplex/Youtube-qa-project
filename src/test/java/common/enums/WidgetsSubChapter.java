package common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WidgetsSubChapter implements SubChapter{

    SELECT_MENU("Select Menu");

    private final String value;
}
