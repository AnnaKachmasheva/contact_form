package test.task.mapper.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Employee;
import test.task.entity.EmployeeEntity;
import test.task.mapper.employee.address.Address2AddressEntityMapper;

class Employee2EmployeeEntityMapperTest {

    private final Address2AddressEntityMapper address2AddressEntityMapper = new Address2AddressEntityMapper();
    private final Employee2EmployeeEntityMapper employee2EmployeeEntityMapper = new Employee2EmployeeEntityMapper(address2AddressEntityMapper);

    @Test
    void toEmployeeEntity_EmployeeEntity_Employee() {
        Employee employee = Generator.generateEmployee();
        EmployeeEntity employeeEntity = employee2EmployeeEntityMapper.toEmployeeEntity(employee);

        Assertions.assertEquals(employee.getName(), employeeEntity.getName());
        Assertions.assertEquals(employee.getSurname(), employeeEntity.getSurname());
        Assertions.assertEquals(employee.getPhone(), employeeEntity.getPhone());
        Assertions.assertEquals(employee.getPassword(), employeeEntity.getPassword());
        Assertions.assertEquals(employee.getEmail(), employeeEntity.getEmail());
        Assertions.assertEquals(employee.getGender(), employeeEntity.getGender());
        Assertions.assertEquals(employee.getPosition(), employeeEntity.getPosition());
        Assertions.assertEquals(employee.getDateOfBirt(), employeeEntity.getDateOfBirt());
        Assertions.assertEquals(employee.getUserRole(), employeeEntity.getRole());
        Assertions.assertEquals(employee.getIsRemoved(), employeeEntity.getIsRemoved());
        Assertions.assertEquals(employee.getAddresses(), employeeEntity.getAddresses());
    }

    @Test
    void toEmployeeEntity_EmployeeEntityIsNull_EmployeeIsNull() {
        EmployeeEntity employeeEntity = employee2EmployeeEntityMapper.toEmployeeEntity(null);
        Assertions.assertNull(employeeEntity);
    }
}