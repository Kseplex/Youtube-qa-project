package common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DropdownOptions {

    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    BLACK("Black");

    private final String value;
}
