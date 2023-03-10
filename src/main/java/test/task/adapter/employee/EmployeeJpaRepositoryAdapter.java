package test.task.adapter.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.entity.repository.EmployeeEntityRepository;
import test.task.exeption.NotFoundException;
import test.task.mapper.employee.Employee2EmployeeEntityMapper;
import test.task.mapper.employee.EmployeeEntityMapper;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeJpaRepositoryAdapter implements EmployeeRepositoryAdapter {

    private final EmployeeEntityRepository employeeEntityRepository;

    private final Employee2EmployeeEntityMapper employee2EmployeeEntityMapper;
    private final EmployeeEntityMapper employeeEntityMapper;

    @Override
    public Employee createEmployee(Employee employee) {
        var employeeEntityOptional =
                employeeEntityRepository.findEmployeeEntityByEmail(employee.getEmail());

        if (employeeEntityOptional.isEmpty()) {
            EmployeeEntity employeeEntity = employee2EmployeeEntityMapper.toEmployeeEntity(employee);
            // employee entity not removed
            employeeEntity.setIsRemoved(false);

            log.info(("Employee {} successfully created."), employee);
            return employeeEntityMapper.toEmployee(employeeEntityRepository.save(employeeEntity));
        } else {
            log.info(("Employee with email {} already exists."), employee.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        var employeeEntityOptional = employeeEntityRepository.findEmployeeEntityById(id);
        if (employeeEntityOptional.isPresent()) {
            Employee employee = employeeEntityMapper.toEmployee(employeeEntityOptional.get());
            log.info(("Employee with id {} found {}."), id, employee);
            return employee;
        } else {
            log.info(("Employee with id {} not found."), id);
            throw new NotFoundException("Employee not fond.");
        }
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        var employeeEntityOptional = employeeEntityRepository.findEmployeeEntityByEmail(email);
        if (employeeEntityOptional.isPresent()) {
            Employee employee = employeeEntityMapper.toEmployee(employeeEntityOptional.get());
            log.info(("Employee with email {} found {}."), email, employee);
            return employee;
        } else {
            log.info(("Employee with email {} not found."), email);
            throw new NotFoundException("Employee not fond.");
        }
    }

    @Override
    public Set<Employee> getAllEmployees() {
        var employeeEntities = employeeEntityRepository.findAll();
        Set<Employee> employees = employeeEntityMapper.toEmployeesSet(employeeEntities);
        log.info(("Found all employees {}."), employees);
        return employees;
    }

    @Override
    public void deleteEmployee(Long id) {
        var employeeEntityOptional = employeeEntityRepository.findEmployeeEntityById(id);
        if (employeeEntityOptional.isPresent()) {
            var employeeEntity = employeeEntityOptional.get();
            employeeEntity.setIsRemoved(true);
            log.info(("Delete employee {}."), employeeEntity);
            employeeEntityRepository.save(employeeEntity);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        var employeeEntityOptional = employeeEntityRepository.findEmployeeEntityById(employee.getId());
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity updatedEmployee = employeeEntityRepository.save(employee2EmployeeEntityMapper.toEmployeeEntity(employee));
            log.info(("Update employee {} to {}."), employeeEntityOptional.get(), updatedEmployee);
            return employeeEntityMapper.toEmployee(updatedEmployee);
        } else {
            log.info(("Employee with id {} not found."), employee.getId());
            throw new NotFoundException("Employee not fond.");
        }
    }
}
