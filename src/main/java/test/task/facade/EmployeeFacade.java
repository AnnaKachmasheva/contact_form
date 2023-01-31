package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.Employee;
import test.task.use_case.employee.*;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final LogInEmployeeUseCase logInEmployeeUseCase;
    private final GetEmployeeByIdUseCase getEmployeeByIdUseCase;
    private final GetAllEmployeesUseCase getAllEmployeesUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;
    private final UpdateEmployeeUseCase updateEmployeeUseCase;

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

    public void deleteEmployee(Long id) {
        deleteEmployeeUseCase.execute(id);
    }

    public Employee updateEmployee(Employee employee) {
        return updateEmployeeUseCase.execute(employee);
    }

}
