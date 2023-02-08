package test.task.use_case.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.request.RequestRepositoryAdapter;
import test.task.domain.Request;

@Service
@RequiredArgsConstructor
public class GetRequestByIdUseCase {

    private final RequestRepositoryAdapter adapter;

    public Request execute(Long id) {
        return adapter.getRequestById(id);
    }

}