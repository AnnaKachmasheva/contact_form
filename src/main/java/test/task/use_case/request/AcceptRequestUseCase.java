package test.task.use_case.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.request.RequestRepositoryAdapter;
import test.task.domain.AcceptedRequest;

@Service
@RequiredArgsConstructor
public class AcceptRequestUseCase {

    private final RequestRepositoryAdapter adapter;

    public AcceptedRequest execute(String email, Long id) {
        return adapter.acceptRequest(email, id);
    }

}