package test.task.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Request {

    private Long id;
    private String kindOfRequest;
    private String policyNumber;
    private String name;
    private String surname;
    private String description;

}
