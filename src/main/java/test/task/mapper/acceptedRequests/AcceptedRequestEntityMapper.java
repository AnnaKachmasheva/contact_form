package test.task.mapper.acceptedRequests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.AcceptedRequest;
import test.task.entity.AcceptedRequestEntity;
import test.task.mapper.employee.EmployeeEntityMapper;
import test.task.mapper.request.RequestEntityMapper;

@Component
@RequiredArgsConstructor
public class AcceptedRequestEntityMapper {

    private final EmployeeEntityMapper employeeEntityMapper;
    private final RequestEntityMapper requestEntityMapper;

    public AcceptedRequest toAcceptedRequest(AcceptedRequestEntity acceptedRequestEntity) {
        if (acceptedRequestEntity == null)
            return null;
        AcceptedRequest acceptedRequest = new AcceptedRequest();
        acceptedRequest.setId(acceptedRequestEntity.getId());
        acceptedRequest.setEmployee(employeeEntityMapper.toEmployee(acceptedRequestEntity.getEmployee()));
        acceptedRequest.setRequest(requestEntityMapper.toRequest(acceptedRequestEntity.getRequest()));
        acceptedRequest.setDateOfAcceptance(acceptedRequestEntity.getDateOfAcceptance());
        acceptedRequest.setDateOfDecision(acceptedRequestEntity.getDateOfDecision());
        acceptedRequest.setIsResolved(acceptedRequestEntity.getIsResolved());
        return acceptedRequest;
    }

}