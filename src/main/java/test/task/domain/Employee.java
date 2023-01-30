package test.task.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import test.task.entity.enums.Gender;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class Employee {

    private String name;
    private String surname;
    private LocalDate dateOfBirt;
    private Gender gender;
    private String userRole;
    private String position;
    private String email;
    private String phone;
    private Set<Address> addresses;
    private String password;

    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

}
