package test.task.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirt;
    private Gender gender;
    private UserRole userRole;
    private String position;
    private String email;
    private String phone;
    private Boolean isRemoved;
    private Set<Address> addresses;
    private String password;

    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

}
