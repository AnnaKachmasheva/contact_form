package test.task.use_case.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.employee.EmployeeRepositoryAdapter;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeUseCase {

    private final EmployeeRepositoryAdapter adapter;

    public void execute(Long id) {
        adapter.deleteEmployee(id);
    }

}