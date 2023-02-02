package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.model.RequestModel;

class RequestModel2RequestMapperTest {

    @Test
    void toRequest_RequestModel_Request() {
        RequestModel2RequestMapper requestModel2RequestMapper = new RequestModel2RequestMapper();

        RequestModel requestModel = Generator.generateValidRequestModel();
        Request request = requestModel2RequestMapper.toRequest(requestModel);

        Assertions.assertEquals(requestModel.getId(), request.getId());
        Assertions.assertEquals(requestModel.getName(), request.getName());
        Assertions.assertEquals(requestModel.getSurname(), request.getSurname());
        Assertions.assertEquals(requestModel.getPolicyNumber(), request.getPolicyNumber());
        Assertions.assertEquals(requestModel.getDescription(), request.getDescription());
        Assertions.assertEquals(requestModel.getKindOfRequest(), request.getKindOfRequest());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        RequestModel2RequestMapper requestModel2RequestMapper = new RequestModel2RequestMapper();

        RequestModel requestModel = null;
        Request request = requestModel2RequestMapper.toRequest(requestModel);

        Assertions.assertEquals(requestModel, request);
    }
}