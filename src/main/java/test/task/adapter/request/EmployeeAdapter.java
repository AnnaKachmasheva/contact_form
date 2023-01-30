package test.task.adapter.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.facade.EmployeeFacade;
import test.task.mapper.employee.EmployeeModel2EmployeeMapper;
import test.task.model.EmployeeModel;
import test.task.security.jwt.JwtAuthenticationResponse;
import test.task.security.model.LoginModel;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter {

    private final EmployeeFacade employeeFacade;
    private final EmployeeModel2EmployeeMapper employeeModel2EmployeeMapper;

    public void createEmployee(EmployeeModel employeeModel) {
        Employee employee = employeeModel2EmployeeMapper.toEmployee(employeeModel);
        employeeFacade.createEmployee(employee);
    }

    public JwtAuthenticationResponse login(LoginModel loginModel) {
        return new JwtAuthenticationResponse(employeeFacade.login(loginModel.getEmail(), loginModel.getPassword()));
    }

    public EmployeeModel getEmployeeById(Long id) {
//        return requestFacade.findAllKindOfRequest();
        return null;
    }
}