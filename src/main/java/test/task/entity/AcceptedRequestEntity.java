package test.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ACCEPT_REQUEST")
public class AcceptedRequestEntity extends AbstractClassEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    private RequestEntity request;

    @Column(nullable = false, name = "date_of_acceptance")
    @Basic(optional = false)
    private LocalDate dateOfAcceptance;

    @Column(name = "date_of_decision")
    @Basic(optional = false)
    private LocalDate dateOfDecision;

    @Basic(optional = false)
    @Column(nullable = false, name = "is_resolved")
    private Boolean isResolved;

    @Override
    public String toString() {
        return "AcceptRequestEntity{" +
                "employee=" + employee +
                ", request=" + request +
                ", dateOfAcceptance=" + dateOfAcceptance +
                ", dateOfDecision=" + dateOfDecision +
                ", isResolved=" + isResolved +
                '}';
    }
}