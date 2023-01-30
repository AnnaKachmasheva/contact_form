package test.task.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String state;
    private String city;
    private String postal;
    private String street;

}
