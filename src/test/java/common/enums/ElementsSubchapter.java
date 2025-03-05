package common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementsSubchapter implements SubChapter{

    TEXT_BOX("Text Box"),
    CHECK_BOX("Check Box");

    private final String value;
}
