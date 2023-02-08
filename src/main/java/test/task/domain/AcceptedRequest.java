package test.task.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcceptedRequest {

    private Long id;
    private Employee employee;
    private Request request;
    private LocalDate dateOfAcceptance;
    private LocalDate dateOfDecision;
    private Boolean isResolved;

}