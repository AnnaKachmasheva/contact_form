package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.entity.RequestEntity;

class Request2RequestEntityMapperTest {

    private final Request2RequestEntityMapper request2RequestEntityMapper = new Request2RequestEntityMapper();


    @Test
    void toRequestEntity_Request_RequestEntity() {
        Request request = Generator.generateValidRequest();
        RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(request);

        Assertions.assertEquals(request.getName(), requestEntity.getName());
        Assertions.assertEquals(request.getSurname(), requestEntity.getSurname());
        Assertions.assertEquals(request.getPolicyNumber(), requestEntity.getPolicyNumber());
        Assertions.assertEquals(request.getDescription(), requestEntity.getDescription());
        Assertions.assertEquals(request.getKindOfRequest(), requestEntity.getKindOfRequestEntity().getName());
        Assertions.assertEquals(request.getIsRemoved(), requestEntity.getIsRemoved());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(null);
        Assertions.assertNull(requestEntity);
    }
}