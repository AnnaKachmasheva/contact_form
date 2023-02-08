package test.task.mapper.acceptedRequests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.AcceptedRequest;
import test.task.mapper.employee.EmployeeDTO2EmployeeMapper;
import test.task.mapper.request.RequestDTO2RequestMapper;
import test.task.rest.DTO.AcceptedRequestDTO;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class AcceptedRequestDTO2AcceptedRequestMapper {

    private final EmployeeDTO2EmployeeMapper employeeDTO2EmployeeMapper;
    private final RequestDTO2RequestMapper requestDTO2RequestMapper;

    public AcceptedRequest toAcceptedRequest(AcceptedRequestDTO acceptedRequestDTO) {
        if (acceptedRequestDTO == null)
            return null;
        AcceptedRequest acceptedRequest = new AcceptedRequest();
        acceptedRequest.setId(acceptedRequestDTO.getId());
        acceptedRequest.setEmployee(employeeDTO2EmployeeMapper.toEmployee(acceptedRequestDTO.getEmployeeDTO()));
        acceptedRequest.setRequest(requestDTO2RequestMapper.toRequest(acceptedRequestDTO.getRequestDTO()));
        acceptedRequest.setDateOfAcceptance(LocalDate.parse(acceptedRequestDTO.getDateOfAcceptance()));
        acceptedRequest.setDateOfDecision(LocalDate.parse(acceptedRequestDTO.getDateOfDecision()));
        acceptedRequest.setIsResolved(acceptedRequestDTO.getIsResolved());
        return acceptedRequest;
    }

}