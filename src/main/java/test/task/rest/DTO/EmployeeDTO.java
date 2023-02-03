package test.task.rest.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private String dateOfBirt; //2023-02-03
    private String gender;
    private String position;
    private String userRole;
    private String email;
    private String phone;
    private String password;
    private Boolean isRemoved;
    private Set<AddressDTO> addresses;

}