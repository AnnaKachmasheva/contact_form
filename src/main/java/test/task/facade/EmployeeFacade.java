package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.Employee;
import test.task.use_case.employee.CreateEmployeeUseCase;
import test.task.use_case.employee.GetAllEmployeesUseCase;
import test.task.use_case.employee.GetEmployeeByIdUseCase;
import test.task.use_case.employee.LogInEmployeeUseCase;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final LogInEmployeeUseCase logInEmployeeUseCase;
    private final GetEmployeeByIdUseCase getEmployeeByIdUseCase;
    private final GetAllEmployeesUseCase getAllEmployeesUseCase;

    public void createEmployee(Employee employee) {
        createEmployeeUseCase.execute(employee);
    }

    public String login(String email, String password) {
        return logInEmployeeUseCase.execute(email, password);
    }

    public Employee getEmployeeById(Long id) {
        return getEmployeeByIdUseCase.execute(id);
    }

    public Set<Employee> getAllEmployees() {
        return getAllEmployeesUseCase.execute();
    }

}
