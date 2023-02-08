package test.task.mapper.acceptedRequests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.AcceptedRequest;
import test.task.mapper.employee.Employee2EmployeeDTOMapper;
import test.task.mapper.employee.address.Address2AddressDTOMapper;
import test.task.mapper.request.Request2RequestDTOMapper;
import test.task.rest.DTO.AcceptedRequestDTO;

class AcceptedRequest2AcceptedRequestDTOMapperTest {

    private final Address2AddressDTOMapper address2AddressModelMapper = new Address2AddressDTOMapper();
    private final Employee2EmployeeDTOMapper employee2EmployeeDTOMapper = new Employee2EmployeeDTOMapper(address2AddressModelMapper);
    private final Request2RequestDTOMapper request2RequestDTOMapper = new Request2RequestDTOMapper();
    private final AcceptedRequest2AcceptedRequestDTOMapper acceptedRequest2AcceptedRequestDTOMapper =
            new AcceptedRequest2AcceptedRequestDTOMapper(employee2EmployeeDTOMapper, request2RequestDTOMapper);


    @Test
    void toAcceptedRequestDTO_AcceptedRequest_AcceptedRequestDTO() {
        AcceptedRequest acceptedRequest = Generator.generateAcceptedRequest();
        AcceptedRequestDTO acceptedRequestDTO = acceptedRequest2AcceptedRequestDTOMapper.toAcceptedRequestDTO(acceptedRequest);

        Assertions.assertEquals(acceptedRequest.getId(), acceptedRequestDTO.getId());
        Assertions.assertEquals(acceptedRequest.getDateOfAcceptance().toString(), acceptedRequestDTO.getDateOfAcceptance());
        Assertions.assertEquals(acceptedRequest.getDateOfDecision().toString(), acceptedRequestDTO.getDateOfDecision());
        Assertions.assertEquals(acceptedRequest.getIsResolved(), acceptedRequestDTO.getIsResolved());
        Assertions.assertEquals(acceptedRequest.getRequest().getName(), acceptedRequestDTO.getRequestDTO().getName());
        Assertions.assertEquals(acceptedRequest.getRequest().getSurname(), acceptedRequestDTO.getRequestDTO().getSurname());
        Assertions.assertEquals(acceptedRequest.getRequest().getPolicyNumber(), acceptedRequestDTO.getRequestDTO().getPolicyNumber());
        Assertions.assertEquals(acceptedRequest.getRequest().getKindOfRequest(), acceptedRequestDTO.getRequestDTO().getKindOfRequest());
        Assertions.assertEquals(acceptedRequest.getRequest().getDescription(), acceptedRequestDTO.getRequestDTO().getDescription());
        Assertions.assertEquals(acceptedRequest.getRequest().getIsRemoved(), acceptedRequestDTO.getRequestDTO().getIsRemoved());
        Assertions.assertEquals(acceptedRequest.getEmployee().getName(), acceptedRequestDTO.getEmployeeDTO().getName());
        Assertions.assertEquals(acceptedRequest.getEmployee().getSurname(), acceptedRequestDTO.getEmployeeDTO().getSurname());
        Assertions.assertEquals(acceptedRequest.getEmployee().getDateOfBirt().toString(), acceptedRequestDTO.getEmployeeDTO().getDateOfBirt().toString());
        Assertions.assertEquals(acceptedRequest.getEmployee().getEmail(), acceptedRequestDTO.getEmployeeDTO().getEmail());
        Assertions.assertEquals(acceptedRequest.getEmployee().getPhone(), acceptedRequestDTO.getEmployeeDTO().getPhone());
        Assertions.assertEquals(acceptedRequest.getEmployee().getPosition(), acceptedRequestDTO.getEmployeeDTO().getPosition());
        Assertions.assertEquals(acceptedRequest.getEmployee().getUserRole().toString(), acceptedRequestDTO.getEmployeeDTO().getUserRole());
        Assertions.assertEquals(acceptedRequest.getEmployee().getIsRemoved(), acceptedRequestDTO.getEmployeeDTO().getIsRemoved());
        Assertions.assertEquals(acceptedRequest.getEmployee().getGender().toString(), acceptedRequestDTO.getEmployeeDTO().getGender());
    }

    @Test
    void toAcceptedRequestDTO_AcceptedRequestIsNull_AcceptedRequestDTOIsNull() {
        AcceptedRequestDTO acceptedRequestDTO = acceptedRequest2AcceptedRequestDTOMapper.toAcceptedRequestDTO(null);
        Assertions.assertNull(acceptedRequestDTO);
    }
}