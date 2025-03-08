package test.tabletest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class Human {

    private String firstName;
    private String secondName;
    private String email;
    private String age;
    private String salary;
    private String department;

}
