package test.task.use_case.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.Employee;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllEmployeesUseCase {

    private final EmployeeRepositoryAdapter adapter;

    public Set<Employee> execute() {
        return adapter.getAllEmployees();
    }

}