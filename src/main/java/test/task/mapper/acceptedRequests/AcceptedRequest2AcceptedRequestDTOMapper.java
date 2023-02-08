package test.task.mapper.acceptedRequests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.AcceptedRequest;
import test.task.mapper.employee.Employee2EmployeeDTOMapper;
import test.task.mapper.request.Request2RequestDTOMapper;
import test.task.rest.DTO.AcceptedRequestDTO;

@Component
@RequiredArgsConstructor
public class AcceptedRequest2AcceptedRequestDTOMapper {

    private final Employee2EmployeeDTOMapper employee2EmployeeDTOMapper;
    private final Request2RequestDTOMapper request2RequestDTOMapper;

    public AcceptedRequestDTO toAcceptedRequestDTO(AcceptedRequest acceptedRequest) {
        if (acceptedRequest == null)
            return null;
        AcceptedRequestDTO acceptedRequestDTO = new AcceptedRequestDTO();
        acceptedRequestDTO.setId(acceptedRequest.getId());
        acceptedRequestDTO.setEmployeeDTO(employee2EmployeeDTOMapper.toEmployeeDTO(acceptedRequest.getEmployee()));
        acceptedRequestDTO.setRequestDTO(request2RequestDTOMapper.toRequestDTO(acceptedRequest.getRequest()));
        acceptedRequestDTO.setDateOfAcceptance(acceptedRequest.getDateOfAcceptance().toString());
        acceptedRequestDTO.setDateOfDecision(acceptedRequest.getDateOfDecision().toString());
        acceptedRequestDTO.setIsResolved(acceptedRequest.getIsResolved());
        return acceptedRequestDTO;
    }

}