package common.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class Human {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int salary;
    private String department;

}
