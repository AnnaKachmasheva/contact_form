package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.rest.DTO.RequestDTO;

class Request2RequestModelMapperTest {

    private final Request2RequestDTOMapper request2RequestModelMapper = new Request2RequestDTOMapper();

    @Test
    void toRequestModel_Request_RequestModel() {
        Request request = Generator.generateValidRequest();
        RequestDTO requestDTO = request2RequestModelMapper.toRequestDTO(request);

        Assertions.assertEquals(request.getId(), requestDTO.getId());
        Assertions.assertEquals(request.getName(), requestDTO.getName());
        Assertions.assertEquals(request.getSurname(), requestDTO.getSurname());
        Assertions.assertEquals(request.getPolicyNumber(), requestDTO.getPolicyNumber());
        Assertions.assertEquals(request.getDescription(), requestDTO.getDescription());
        Assertions.assertEquals(request.getKindOfRequest(), requestDTO.getKindOfRequest());
        Assertions.assertEquals(request.getIsRemoved(), requestDTO.getIsRemoved());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        RequestDTO requestModel = request2RequestModelMapper.toRequestDTO(null);
        Assertions.assertNull(requestModel);
    }
}