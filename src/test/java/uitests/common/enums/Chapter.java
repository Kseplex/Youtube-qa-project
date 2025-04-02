package uitests.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Chapter {

    ELEMENTS("Elements"),
    WIDGETS("Widgets");

    private final String value;
}
