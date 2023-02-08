package test.task.use_case.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.request.RequestRepositoryAdapter;
import test.task.domain.Request;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllOfRequestsUseCase {

    private final RequestRepositoryAdapter adapter;

    public List<Request> execute() {
        return adapter.getAllRequests();
    }

}