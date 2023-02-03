package test.task.adapter.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.facade.EmployeeFacade;
import test.task.mapper.employee.Employee2EmployeeDTOMapper;
import test.task.mapper.employee.EmployeeDTO2EmployeeMapper;
import test.task.mapper.employee.EmployeeEntityMapper;
import test.task.rest.DTO.EmployeeDTO;
import test.task.security.jwt.JwtAuthenticationResponse;
import test.task.security.model.LoginDTO;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeAdapter {

    private final EmployeeFacade employeeFacade;
    private final EmployeeDTO2EmployeeMapper employeeDTO2EmployeeMapper;
    private final Employee2EmployeeDTOMapper employee2EmployeeDTOMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO2EmployeeMapper.toEmployee(employeeDTO);
        return employee2EmployeeDTOMapper.toEmployeeDTO(employeeFacade.createEmployee(employee));
    }

    public JwtAuthenticationResponse login(LoginDTO loginDTO) {
        return new JwtAuthenticationResponse(employeeFacade.login(loginDTO.getEmail(), loginDTO.getPassword()));
    }

    public EmployeeDTO getCurrentEmployee(EmployeeEntity employeeEntity) {
        return employee2EmployeeDTOMapper.toEmployeeDTO(employeeEntityMapper.toEmployee(employeeEntity));
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employee2EmployeeDTOMapper.toEmployeeDTO(employeeFacade.getEmployeeById(id));
    }

    public Set<EmployeeDTO> getAllEmployees() {
        return employee2EmployeeDTOMapper.toEmployeeDTOSet(employeeFacade.getAllEmployees());
    }

    public void deleteEmployee(Long id) {
        employeeFacade.deleteEmployee(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO2EmployeeMapper.toEmployee(employeeDTO);
        return employee2EmployeeDTOMapper.toEmployeeDTO(employeeFacade.updateEmployee(employee));
    }

}