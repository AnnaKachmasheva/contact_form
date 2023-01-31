package test.task.use_case.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.Employee;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeUseCase {

    private final EmployeeRepositoryAdapter adapter;

    public Employee execute(Employee employee) {
        return adapter.updateEmployee(employee);
    }

}