package test.task.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

    private String state;
    private String city;
    private String postal;
    private String street;

}
