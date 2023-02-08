package test.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "REQUEST")
@NoArgsConstructor
public class RequestEntity extends AbstractClassEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    private KindOfRequestEntity kindOfRequestEntity;

    @Column(nullable = false, name = "policy_number")
    @Basic(optional = false)
    private String policyNumber;

    @Column(nullable = false)
    @Basic(optional = false)
    private String name;

    @Column(nullable = false)
    @Basic(optional = false)
    private String surname;

    @Column(nullable = false)
    @Basic(optional = false)
    private String description;

    @Basic(optional = false)
    @Column(nullable = false, name = "is_removed")
    private Boolean isRemoved;

    @Override
    public String toString() {
        return "RequestEntity{" +
                "kindOfRequestEntity=" + kindOfRequestEntity +
                ", policyNumber='" + policyNumber +
                ", name='" + name +
                ", surname='" + surname +
                ", description='" + description +
                ", is removed='" + isRemoved +
                '}';
    }
}