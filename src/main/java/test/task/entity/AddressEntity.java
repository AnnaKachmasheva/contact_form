package test.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ADDRESS")
public class AddressEntity extends AbstractClassEntity {

    @Column(nullable = false)
    @Basic(optional = false)
    private String state;

    @Column(nullable = false)
    @Basic(optional = false)
    private String city;

    @Column(nullable = false)
    @Basic(optional = false)
    private String postal;

    @Column(nullable = false)
    @Basic(optional = false)
    private String street;

    @Override
    public String toString() {
        return "AddressEntity{" +
                "state='" + state +
                ", city='" + city +
                ", postal='" + postal +
                ", street='" + street +
                '}';
    }
}