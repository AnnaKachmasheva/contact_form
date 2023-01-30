package test.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
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

}