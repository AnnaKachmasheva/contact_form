package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.entity.AddressEntity;
import test.task.entity.EmployeeEntity;
import test.task.entity.enums.UserRole;
import test.task.mapper.employee.address.Address2AddressEntityMapper;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Employee2EmployeeEntityMapper {

    private final Address2AddressEntityMapper address2AddressEntityMapper;

    public EmployeeEntity toEmployeeEntity(Employee employee) {
        if (employee == null)
            return null;

        Set<AddressEntity> addressEntitySet = address2AddressEntityMapper.toAddressEntitySet(employee.getAddresses());

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeEntity.setSurname(employee.getSurname());
        employeeEntity.setGender(employee.getGender());
        employeeEntity.setDateOfBirt(employee.getDateOfBirt());
        employeeEntity.setPosition(employee.getPosition());
        employeeEntity.setRole(employee.getUserRole());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setAddresses(addressEntitySet);
        employeeEntity.setPassword(employee.getPassword());
        employeeEntity.setIsRemoved(employee.getIsRemoved());
        return employeeEntity;
    }
}
