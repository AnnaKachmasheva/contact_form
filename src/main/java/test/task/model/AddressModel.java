package test.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressModel {

    private String state;
    private String city;
    private String postal;
    private String street;

}