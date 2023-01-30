package test.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "REQUEST")
@NoArgsConstructor
public class RequestEntity extends AbstractClassEntity {

    @ManyToOne
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

}