package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.entity.RequestEntity;

class Request2RequestEntityMapperTest {

    @Test
    void toRequestEntity_Request_RequestEntity() {
        Request2RequestEntityMapper request2RequestEntityMapper = new Request2RequestEntityMapper();

        Request request = Generator.generateValidRequest();
        RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(request);

        Assertions.assertEquals(request.getName(), requestEntity.getName());
        Assertions.assertEquals(request.getSurname(), requestEntity.getSurname());
        Assertions.assertEquals(request.getPolicyNumber(), requestEntity.getPolicyNumber());
        Assertions.assertEquals(request.getDescription(), requestEntity.getDescription());
        Assertions.assertEquals(request.getKindOfRequest(), requestEntity.getKindOfRequestEntity().getName());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        Request2RequestEntityMapper request2RequestEntityMapper = new Request2RequestEntityMapper();

        Request request = null;
        RequestEntity requestEntity = request2RequestEntityMapper.toRequestEntity(request);

        Assertions.assertEquals(request, requestEntity);
    }
}