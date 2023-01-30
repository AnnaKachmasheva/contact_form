package test.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import test.task.entity.abstracts.AbstractClassEntity;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends AbstractClassEntity {

    @Column(nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(nullable = false)
    @Basic(optional = false)
    private String surname;

    @Column(nullable = false)
    @Basic(optional = false)
    private LocalDate dateOfBirt;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    @Basic(optional = false)
    private String position;

    @Column(nullable = false)
    @Basic(optional = false)
    private String email;

    @Column(nullable = false)
    @Basic(optional = false)
    private String phone;

    @Column(nullable = false)
    @Basic(optional = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AddressEntity> addresses;

}