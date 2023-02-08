package test.task.mapper.acceptedRequests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.AcceptedRequest;
import test.task.entity.AcceptedRequestEntity;
import test.task.mapper.employee.EmployeeEntityMapper;
import test.task.mapper.employee.address.AddressEntityMapper;
import test.task.mapper.request.RequestEntityMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptedRequestEntityMapperTest {

    private final AddressEntityMapper addressEntityMapper = new AddressEntityMapper();

    private final EmployeeEntityMapper employeeEntityMapper = new EmployeeEntityMapper(addressEntityMapper);
    private final RequestEntityMapper requestEntityMapper = new RequestEntityMapper();

    private final AcceptedRequestEntityMapper acceptedRequestEntityMapper =
            new AcceptedRequestEntityMapper(employeeEntityMapper, requestEntityMapper);


    @Test
    void toAcceptedRequest_AcceptedRequestEntity_AcceptedRequest() {
        AcceptedRequestEntity acceptedRequestEntity = Generator.generateAcceptedRequestEntity();
        AcceptedRequest acceptedRequest = acceptedRequestEntityMapper.toAcceptedRequest(acceptedRequestEntity);

        assertEquals(acceptedRequestEntity.getId(), acceptedRequest.getId());
        assertEquals(acceptedRequestEntity.getDateOfAcceptance().toString(), acceptedRequest.getDateOfAcceptance().toString());
        assertEquals(acceptedRequestEntity.getDateOfDecision().toString(), acceptedRequest.getDateOfDecision().toString());
        assertEquals(acceptedRequestEntity.getIsResolved(), acceptedRequest.getIsResolved());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getName(), acceptedRequest.getRequest().getName());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getSurname(), acceptedRequest.getRequest().getSurname());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getPolicyNumber(), acceptedRequest.getRequest().getPolicyNumber());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getKindOfRequestEntity().getName(), acceptedRequest.getRequest().getKindOfRequest());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getDescription(), acceptedRequest.getRequest().getDescription());
        Assertions.assertEquals(acceptedRequestEntity.getRequest().getIsRemoved(), acceptedRequest.getRequest().getIsRemoved());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getName(), acceptedRequest.getEmployee().getName());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getSurname(), acceptedRequest.getEmployee().getSurname());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getDateOfBirt().toString(), acceptedRequest.getEmployee().getDateOfBirt().toString());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getEmail(), acceptedRequest.getEmployee().getEmail());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getPhone(), acceptedRequest.getEmployee().getPhone());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getPosition(), acceptedRequest.getEmployee().getPosition());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getRole().name(), acceptedRequest.getEmployee().getUserRole().name());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getIsRemoved(), acceptedRequest.getEmployee().getIsRemoved());
        Assertions.assertEquals(acceptedRequestEntity.getEmployee().getGender().toString(), acceptedRequest.getEmployee().getGender().toString());
    }

    @Test
    void toAcceptedRequest_AcceptedRequestEntityIsNull_AcceptedRequestIsNull() {
        AcceptedRequest acceptedRequest = acceptedRequestEntityMapper.toAcceptedRequest(null);
        Assertions.assertNull(acceptedRequest);
    }

}