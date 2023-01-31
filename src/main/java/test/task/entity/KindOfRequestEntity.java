package test.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.task.entity.abstracts.AbstractClassEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "KIND_OF_REQUEST")
public class KindOfRequestEntity extends AbstractClassEntity {

    @OneToMany
    @JsonIgnore
    private Set<RequestEntity> requests;

    @Column(nullable = false)
    @Basic(optional = false)
    private String name;

    @Override
    public String toString() {
        return "KindOfRequestEntity{" +
                "requests=" + requests +
                ", name='" + name +
                '}';
    }
}