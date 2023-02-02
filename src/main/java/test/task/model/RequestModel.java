package test.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestModel {

    private Long id;
    private String description;
    private String kindOfRequest;
    private String name;
    private String surname;
    private String policyNumber;

}