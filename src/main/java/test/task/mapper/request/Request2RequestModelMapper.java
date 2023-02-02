package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.model.RequestModel;

@Component
@RequiredArgsConstructor
public class Request2RequestModelMapper {

    public RequestModel toRequestModel(Request request) {
        if (request == null)
            return null;
        RequestModel requestModel = new RequestModel();
        requestModel.setId(request.getId());
        requestModel.setKindOfRequest(request.getKindOfRequest());
        requestModel.setName(request.getName());
        requestModel.setSurname(request.getSurname());
        requestModel.setDescription(request.getDescription());
        requestModel.setPolicyNumber(request.getPolicyNumber());
        return requestModel;
    }

}
