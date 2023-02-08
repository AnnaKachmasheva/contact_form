package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.entity.RequestEntity;

class RequestEntityMapperTest {

    private final RequestEntityMapper requestEntityMapper = new RequestEntityMapper();


    @Test
    void toRequest_RequestEntity_Request() {
        RequestEntity requestEntity = Generator.generateValidRequestEntity();
        Request request = requestEntityMapper.toRequest(requestEntity);

        Assertions.assertEquals(requestEntity.getId(), request.getId());
        Assertions.assertEquals(requestEntity.getName(), request.getName());
        Assertions.assertEquals(requestEntity.getSurname(), request.getSurname());
        Assertions.assertEquals(requestEntity.getPolicyNumber(), request.getPolicyNumber());
        Assertions.assertEquals(requestEntity.getDescription(), request.getDescription());
        Assertions.assertEquals(requestEntity.getKindOfRequestEntity().getName(), request.getKindOfRequest());
        Assertions.assertEquals(requestEntity.getIsRemoved(), request.getIsRemoved());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        Request request = requestEntityMapper.toRequest(null);
        Assertions.assertNull(request);
    }
}