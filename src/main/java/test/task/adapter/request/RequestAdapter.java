package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.facade.RequestFacade;
import test.task.mapper.request.Request2RequestEntityMapper;
import test.task.mapper.request.Request2RequestModelMapper;
import test.task.mapper.request.RequestModel2RequestMapper;
import test.task.model.RequestModel;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestAdapter {

    private final RequestFacade requestFacade;
    private final RequestModel2RequestMapper requestModel2RequestMapper;
    private final Request2RequestModelMapper request2RequestModelMapper;

    public RequestModel createRequest(RequestModel requestModel) {
        Request request = requestModel2RequestMapper.toRequest(requestModel);
        return request2RequestModelMapper.toRequestModel(requestFacade.createRequest(request));
    }

    public List<String> findAllKindOfRequest() {
        return requestFacade.findAllKindOfRequest();
    }
}