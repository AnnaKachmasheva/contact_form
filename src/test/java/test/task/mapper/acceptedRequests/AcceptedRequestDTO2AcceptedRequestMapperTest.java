package test.task.mapper.acceptedRequests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.AcceptedRequest;
import test.task.mapper.employee.EmployeeDTO2EmployeeMapper;
import test.task.mapper.employee.address.AddressDTO2AddressMapper;
import test.task.mapper.request.RequestDTO2RequestMapper;
import test.task.rest.DTO.AcceptedRequestDTO;

class AcceptedRequestDTO2AcceptedRequestMapperTest {

    private final AddressDTO2AddressMapper addressModel2AddressMapper = new AddressDTO2AddressMapper();
    private final EmployeeDTO2EmployeeMapper employeeDTO2EmployeeMapper = new EmployeeDTO2EmployeeMapper(addressModel2AddressMapper);
    private final RequestDTO2RequestMapper requestDTO2RequestMapper = new RequestDTO2RequestMapper();
    private final AcceptedRequestDTO2AcceptedRequestMapper acceptedRequest2AcceptedRequestDTOMapper =
            new AcceptedRequestDTO2AcceptedRequestMapper(employeeDTO2EmployeeMapper, requestDTO2RequestMapper);

    @Test
    void toAcceptedRequest_AcceptedRequestDTO_AcceptedRequest() {
        AcceptedRequestDTO acceptedRequestDTO = Generator.generateAcceptedRequestDTO();
        AcceptedRequest acceptedRequest = acceptedRequest2AcceptedRequestDTOMapper.toAcceptedRequest(acceptedRequestDTO);

        Assertions.assertEquals(acceptedRequestDTO.getId(), acceptedRequest.getId());
        Assertions.assertEquals(acceptedRequestDTO.getDateOfAcceptance(), acceptedRequest.getDateOfAcceptance().toString());
        Assertions.assertEquals(acceptedRequestDTO.getDateOfDecision(), acceptedRequest.getDateOfDecision().toString());
        Assertions.assertEquals(acceptedRequestDTO.getIsResolved(), acceptedRequest.getIsResolved());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getName(), acceptedRequest.getRequest().getName());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getSurname(), acceptedRequest.getRequest().getSurname());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getPolicyNumber(), acceptedRequest.getRequest().getPolicyNumber());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getKindOfRequest(), acceptedRequest.getRequest().getKindOfRequest());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getDescription(), acceptedRequest.getRequest().getDescription());
        Assertions.assertEquals(acceptedRequestDTO.getRequestDTO().getIsRemoved(), acceptedRequest.getRequest().getIsRemoved());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getName(), acceptedRequest.getEmployee().getName());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getSurname(), acceptedRequest.getEmployee().getSurname());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getDateOfBirt(), acceptedRequest.getEmployee().getDateOfBirt().toString());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getEmail(), acceptedRequest.getEmployee().getEmail());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getPhone(), acceptedRequest.getEmployee().getPhone());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getPosition(), acceptedRequest.getEmployee().getPosition());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getUserRole(), acceptedRequest.getEmployee().getUserRole().name());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getIsRemoved(), acceptedRequest.getEmployee().getIsRemoved());
        Assertions.assertEquals(acceptedRequestDTO.getEmployeeDTO().getGender(), acceptedRequest.getEmployee().getGender().toString());
    }

    @Test
    void toAcceptedRequest_AcceptedRequestDTOIsNull_AcceptedRequestIsNull() {
        AcceptedRequest acceptedRequest = acceptedRequest2AcceptedRequestDTOMapper.toAcceptedRequest(null);
        Assertions.assertNull(acceptedRequest);
    }

}