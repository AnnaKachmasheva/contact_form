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
        return Request.builder()
                .kindOfRequest(requestModel.getKindOfRequest())
                .policyNumber(requestModel.getPolicyNumber())
                .name(requestModel.getName())
                .surname(requestModel.getSurname())
                .description(requestModel.getDescription())
                .build();
    }

}
