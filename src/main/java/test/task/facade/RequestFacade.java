package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.Request;
import test.task.use_case.request.CreateRequestUseCase;
import test.task.use_case.request.GetAllKindOfRequest;
import test.task.use_case.request.GetAllOfRequests;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestFacade {

    private final CreateRequestUseCase createRequestUseCase;
    private final GetAllKindOfRequest getAllKindOfRequest;
    private final GetAllOfRequests getAllOfRequests;

    public Request createRequest(Request request) {
        return createRequestUseCase.execute(request);
    }

    public List<String> findAllKindOfRequest() {
        return getAllKindOfRequest.execute();
    }

    public List<Request> getRequests() {
        return getAllOfRequests.execute();
    }

}
