package test.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.task.entity.abstracts.AbstractClassEntity;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends AbstractClassEntity {

    @Column(nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(nullable = false)
    @Basic(optional = false)
    private String surname;

    @Column(nullable = false, name = "date_of_birth")
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

    @Basic(optional = false)
    @Column(nullable = false, name = "is_removed")
    private Boolean isRemoved;

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "name='" + name +
                ", surname='" + surname +
                ", dateOfBirt=" + dateOfBirt +
                ", gender=" + gender +
                ", role=" + role +
                ", position='" + position +
                ", email='" + email +
                ", phone='" + phone +
                ", password='" + password +
                ", addresses=" + addresses +
                ", isRemoved=" + isRemoved +
                '}';
    }
}