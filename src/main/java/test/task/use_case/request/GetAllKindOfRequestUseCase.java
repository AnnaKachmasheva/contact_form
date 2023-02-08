package test.task.use_case.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.request.RequestRepositoryAdapter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllKindOfRequestUseCase {

    private final RequestRepositoryAdapter adapter;

    public List<String> execute() {
       return adapter.getAllKindOfRequest();
    }

}