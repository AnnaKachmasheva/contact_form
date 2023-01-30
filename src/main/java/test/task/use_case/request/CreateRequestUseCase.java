package test.task.use_case.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.request.RequestRepositoryAdapter;
import test.task.domain.Request;

@Service
@RequiredArgsConstructor
public class CreateRequestUseCase {

    private final RequestRepositoryAdapter adapter;

    public void execute(Request request) {
        adapter.createRequest(request);
    }

}