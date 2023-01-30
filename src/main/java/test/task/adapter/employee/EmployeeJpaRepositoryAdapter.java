package test.task.adapter.employee;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.entity.repository.EmployeeEntityRepository;
import test.task.mapper.employee.Employee2EmployeeEntityMapper;
import test.task.security.DefaultAuthenticationProvider;
import test.task.security.jwt.JwtTokenProvider;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeJpaRepositoryAdapter implements EmployeeRepositoryAdapter {

    private final EmployeeEntityRepository employeeEntityRepository;

    private final Employee2EmployeeEntityMapper employee2EmployeeEntityMapper;

    @Override
    public void createEmployee(Employee employee) {
        var employeeEntityOptional =
                employeeEntityRepository.findEmployeeEntitiesByEmail(employee.getEmail());

        if (employeeEntityOptional.isEmpty()) {
            EmployeeEntity employeeEntity = employee2EmployeeEntityMapper.toEmployeeEntity(employee);

            log.info(("Employee {} successfully created."), employee);

            employeeEntityRepository.save(employeeEntity);
        } else {
            log.info(("Employee with email {} already exists."), employee.getEmail());

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
