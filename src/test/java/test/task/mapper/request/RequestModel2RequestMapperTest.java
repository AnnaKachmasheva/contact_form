package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.rest.DTO.RequestDTO;

class RequestModel2RequestMapperTest {

    private final RequestDTO2RequestMapper requestModel2RequestMapper = new RequestDTO2RequestMapper();


    @Test
    void toRequest_RequestModel_Request() {
        RequestDTO requestDTO = Generator.generateValidRequestDTO();
        Request request = requestModel2RequestMapper.toRequest(requestDTO);

        Assertions.assertEquals(requestDTO.getId(), request.getId());
        Assertions.assertEquals(requestDTO.getName(), request.getName());
        Assertions.assertEquals(requestDTO.getSurname(), request.getSurname());
        Assertions.assertEquals(requestDTO.getPolicyNumber(), request.getPolicyNumber());
        Assertions.assertEquals(requestDTO.getDescription(), request.getDescription());
        Assertions.assertEquals(requestDTO.getKindOfRequest(), request.getKindOfRequest());
        Assertions.assertEquals(requestDTO.getIsRemoved(), request.getIsRemoved());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        Request request = requestModel2RequestMapper.toRequest(null);
        Assertions.assertNull(request);
    }
}