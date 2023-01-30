package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.Request;
import test.task.use_case.request.CreateRequestUseCase;
import test.task.use_case.request.GetAllKindOfRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestFacade {

    private final CreateRequestUseCase createRequestUseCase;
    private final GetAllKindOfRequest getAllKindOfRequest;

    public void createRequest(Request request) {
        createRequestUseCase.execute(request);
    }

    public List<String> findAllKindOfRequest() {
        return getAllKindOfRequest.execute();
    }
}
