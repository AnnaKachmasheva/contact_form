package test.task.mapper.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.AddressEntity;
import test.task.entity.EmployeeEntity;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.mapper.employee.address.AddressDTO2AddressMapper;
import test.task.mapper.employee.address.AddressEntityMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeEntityMapperTest {

    private final AddressEntityMapper addressEntityMapper = new AddressEntityMapper();
    private final EmployeeEntityMapper employeeEntityMapper = new EmployeeEntityMapper(addressEntityMapper);


    @Test
    void toEmployee_EmployeeEntity_Employee() {
        EmployeeEntity employeeEntity = Generator.generateEmployeeEntity();
        Employee employee = employeeEntityMapper.toEmployee(employeeEntity);

        Assertions.assertEquals(employeeEntity.getName(), employee.getName());
        Assertions.assertEquals(employeeEntity.getSurname(), employee.getSurname());
        Assertions.assertEquals(employeeEntity.getPhone(), employee.getPhone());
        Assertions.assertEquals(employeeEntity.getPassword(), employee.getPassword());
        Assertions.assertEquals(employeeEntity.getEmail(), employee.getEmail());
        Assertions.assertEquals(employeeEntity.getGender(), employee.getGender());
        Assertions.assertEquals(employeeEntity.getPosition(), employee.getPosition());
        Assertions.assertEquals(employeeEntity.getDateOfBirt(), employee.getDateOfBirt());
        Assertions.assertEquals(employeeEntity.getRole(), employee.getUserRole());
        Assertions.assertEquals(employeeEntity.getIsRemoved(), employee.getIsRemoved());
    }


    @Test
    void toEmployee_EmployeeEntityIsNull_EmployeeIsNull() {
        Employee employee = employeeEntityMapper.toEmployee(null);
        Assertions.assertNull(employee);
    }

    @Test
    void toEmployeesSet_EmployeeEntitySet_EmployeeSet() {
        int count = 10;
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        while (count > 0) {
            employeeEntityList.add(Generator.generateEmployeeEntity());
            count--;
        }

        Set<Employee> employeeSet = employeeEntityMapper.toEmployeesSet(employeeEntityList);
        List<Employee> employeeList = employeeSet.stream().toList();

        IntStream.range(0, count).forEach(i -> {
            assertEquals(employeeEntityList.get(i).getName(), employeeList.get(i).getName());
            Assertions.assertEquals(employeeEntityList.get(i).getSurname(), employeeList.get(i).getSurname());
            Assertions.assertEquals(employeeEntityList.get(i).getPhone(), employeeList.get(i).getPhone());
            Assertions.assertEquals(employeeEntityList.get(i).getPassword(), employeeList.get(i).getPassword());
            Assertions.assertEquals(employeeEntityList.get(i).getEmail(), employeeList.get(i).getEmail());
            Assertions.assertEquals(employeeEntityList.get(i).getGender(), employeeList.get(i).getGender());
            Assertions.assertEquals(employeeEntityList.get(i).getPosition(), employeeList.get(i).getPosition());
            Assertions.assertEquals(employeeEntityList.get(i).getDateOfBirt(), employeeList.get(i).getDateOfBirt());
            Assertions.assertEquals(employeeEntityList.get(i).getRole(), employeeList.get(i).getUserRole());
            Assertions.assertEquals(employeeEntityList.get(i).getIsRemoved(), employeeList.get(i).getIsRemoved());
        });
    }
}