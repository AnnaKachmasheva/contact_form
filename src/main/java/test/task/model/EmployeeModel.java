package test.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeModel {

    private Long id;
    private String name;
    private String surname;
    private String dateOfBirt;
    private String gender;
    private String position;
    private String userRole;
    private String email;
    private String phone;
    private String password;
    private Set<AddressModel> addresses;

}