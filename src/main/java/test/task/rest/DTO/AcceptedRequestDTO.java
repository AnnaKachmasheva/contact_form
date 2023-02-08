package test.task.rest.DTO;

import lombok.Data;

@Data
public class AcceptedRequestDTO {

    private Long id;
    private EmployeeDTO employeeDTO;
    private RequestDTO requestDTO;
    private String dateOfAcceptance;
    private String dateOfDecision;
    private Boolean isResolved;

}