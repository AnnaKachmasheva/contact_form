package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.facade.EmployeeFacade;
import test.task.mapper.employee.Employee2EmployeeModelMapper;
import test.task.mapper.employee.EmployeeEntityMapper;
import test.task.mapper.employee.EmployeeModel2EmployeeMapper;
import test.task.model.EmployeeModel;
import test.task.security.jwt.JwtAuthenticationResponse;
import test.task.security.model.LoginModel;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter {

    private final EmployeeFacade employeeFacade;
    private final EmployeeModel2EmployeeMapper employeeModel2EmployeeMapper;
    private final Employee2EmployeeModelMapper employee2EmployeeModelMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    public void createEmployee(EmployeeModel employeeModel) {
        Employee employee = employeeModel2EmployeeMapper.toEmployee(employeeModel);
        employeeFacade.createEmployee(employee);
    }

    public JwtAuthenticationResponse login(LoginModel loginModel) {
        return new JwtAuthenticationResponse(employeeFacade.login(loginModel.getEmail(), loginModel.getPassword()));
    }

    public EmployeeModel getCurrentEmployee(EmployeeEntity employeeEntity) {
        return employee2EmployeeModelMapper.toEmployeeModel(employeeEntityMapper.toEmployee(employeeEntity));
    }

    public EmployeeModel getEmployeeById(Long id) {
        return employee2EmployeeModelMapper.toEmployeeModel(employeeFacade.getEmployeeById(id));
    }

    public Set<EmployeeModel> getAllEmployees() {
        return employee2EmployeeModelMapper.toEmployeeModelSet(employeeFacade.getAllEmployees());
    }
}