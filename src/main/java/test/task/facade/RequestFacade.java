package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.AcceptedRequest;
import test.task.domain.Request;
import test.task.use_case.request.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestFacade {

    private final CreateRequestUseCase createRequestUseCase;
    private final GetAllKindOfRequestUseCase getAllKindOfRequest;
    private final GetAllOfRequestsUseCase getAllOfRequests;
    public final GetRequestByIdUseCase getRequestByIdUseCase;
    public final AcceptRequestUseCase acceptRequestUseCase;

    public Request createRequest(Request request) {
        return createRequestUseCase.execute(request);
    }

    public List<String> findAllKindOfRequest() {
        return getAllKindOfRequest.execute();
    }

    public List<Request> getRequests() {
        return getAllOfRequests.execute();
    }

    public Request getRequestById(Long id) {
        return getRequestByIdUseCase.execute(id);
    }

    public AcceptedRequest acceptRequest(String email, Long id) {
        return acceptRequestUseCase.execute(email, id);
    }

}
