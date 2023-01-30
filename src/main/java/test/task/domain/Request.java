package test.task.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private String kindOfRequest;
    private String policyNumber;
    private String name;
    private String surname;
    private String description;

}
