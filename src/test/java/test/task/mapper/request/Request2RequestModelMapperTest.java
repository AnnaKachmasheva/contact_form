package test.task.mapper.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Request;
import test.task.model.RequestModel;

class Request2RequestModelMapperTest {

    @Test
    void toRequestModel_Request_RequestModel() {
        Request2RequestModelMapper request2RequestModelMapper = new Request2RequestModelMapper();

        Request request = Generator.generateValidRequest();
        RequestModel requestModel = request2RequestModelMapper.toRequestModel(request);

        Assertions.assertEquals(request.getId(), requestModel.getId());
        Assertions.assertEquals(request.getName(), requestModel.getName());
        Assertions.assertEquals(request.getSurname(), requestModel.getSurname());
        Assertions.assertEquals(request.getPolicyNumber(), requestModel.getPolicyNumber());
        Assertions.assertEquals(request.getDescription(), requestModel.getDescription());
        Assertions.assertEquals(request.getKindOfRequest(), requestModel.getKindOfRequest());
    }

    @Test
    void toRequest_RequestModelIsNull_RequestIsNull() {
        Request2RequestModelMapper request2RequestModelMapper = new Request2RequestModelMapper();

        Request request = null;
        RequestModel requestModel = request2RequestModelMapper.toRequestModel(request);

        Assertions.assertEquals(requestModel, request);
    }
}