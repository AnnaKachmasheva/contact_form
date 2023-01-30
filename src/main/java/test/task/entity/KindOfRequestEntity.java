package test.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "KIND_OF_REQUEST")
public class KindOfRequestEntity extends AbstractClassEntity {

    @OneToMany
    @JsonIgnore
    private Set<RequestEntity> requests;

    @Column(nullable = false)
    @Basic(optional = false)
    private String name;

}