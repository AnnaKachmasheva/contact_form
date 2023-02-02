package test.task.mapper.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.model.RequestModel;

@Component
@RequiredArgsConstructor
public class RequestModel2RequestMapper {

    public Request toRequest(RequestModel requestModel) {
        if (requestModel == null) return null;
        Request request = new Request();
        request.setId(requestModel.getId());
        request.setName(requestModel.getName());
        request.setSurname(requestModel.getSurname());
        request.setDescription(requestModel.getDescription());
        request.setPolicyNumber(requestModel.getPolicyNumber());
        request.setKindOfRequest(requestModel.getKindOfRequest());
        return request;
    }

}
