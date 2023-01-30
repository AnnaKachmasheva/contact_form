package test.task.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.domain.Employee;
import test.task.use_case.employee.CreateEmployeeUseCase;
import test.task.use_case.employee.LogInEmployeeUseCase;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final CreateEmployeeUseCase createEmployeeUseCase;
    private final LogInEmployeeUseCase logInEmployeeUseCase;

    public void createEmployee(Employee employee) {
        createEmployeeUseCase.execute(employee);
    }

    public String login(String email, String password) {
        return logInEmployeeUseCase.execute(email, password);
    }

}
