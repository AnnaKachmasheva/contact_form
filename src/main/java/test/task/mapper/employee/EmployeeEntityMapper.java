package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.mapper.employee.address.AddressEntityMapper;
import test.task.model.EmployeeModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeEntityMapper {

    private final AddressEntityMapper addressEntityMapper;

    public Employee toEmployee(EmployeeEntity employeeEntity) {
        if (employeeEntity == null)
            return null;

        Set<Address> addresses = addressEntityMapper.toAddressSet(employeeEntity.getAddresses());

        Employee employee = new Employee();
        employee.setName(employeeEntity.getName());
        employee.setSurname(employeeEntity.getSurname());
        employee.setGender(employeeEntity.getGender());
        employee.setDateOfBirt(employeeEntity.getDateOfBirt());
        employee.setPosition(employeeEntity.getPosition());
        employee.setUserRole(employeeEntity.getRole().toString());
        employee.setEmail(employeeEntity.getEmail());
        employee.setPhone(employeeEntity.getPhone());
        employee.setAddresses(addresses);
        employee.setPassword(employeeEntity.getPassword());

        return employee;
    }

    public Set<Employee> toEmployeesSet(List<EmployeeEntity> employeeEntities) {
        Set<Employee> employees = new HashSet<>(employeeEntities.size());
        for (EmployeeEntity employeeEntity : employeeEntities) {
            employees.add(toEmployee(employeeEntity));
        }
        return employees;
    }
}
