package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Request;
import test.task.facade.RequestFacade;
import test.task.mapper.request.RequestModel2RequestMapper;
import test.task.model.RequestModel;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestAdapter {

    private final RequestFacade requestFacade;
    private final RequestModel2RequestMapper requestModel2RequestMapper;

    public void createRequest(RequestModel requestModel) {
        Request request = requestModel2RequestMapper.toRequest(requestModel);
        requestFacade.createRequest(request);
    }

    public List<String> findAllKindOfRequest() {
        return requestFacade.findAllKindOfRequest();
    }
}