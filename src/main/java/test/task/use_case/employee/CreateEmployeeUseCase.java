package test.task.use_case.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.Employee;

@Service
@RequiredArgsConstructor
public class CreateEmployeeUseCase {

    private final EmployeeRepositoryAdapter adapter;

    public void execute(Employee employee) {
        adapter.createEmployee(employee);
    }

}