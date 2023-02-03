package test.task.mapper.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Employee;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.mapper.employee.address.AddressDTO2AddressMapper;
import test.task.rest.DTO.EmployeeDTO;

class EmployeeDTO2EmployeeMapperTest {

    private final AddressDTO2AddressMapper addressModel2AddressMapper = new AddressDTO2AddressMapper();
    private final EmployeeDTO2EmployeeMapper employeeDTO2EmployeeMapper = new EmployeeDTO2EmployeeMapper(addressModel2AddressMapper);

    @Test
    void toEmployee_EmployeeDTO_Employee() {
        EmployeeDTO employeeDTO = Generator.generateEmployeeDTO();
        Employee employee = employeeDTO2EmployeeMapper.toEmployee(employeeDTO);

        Assertions.assertEquals(employeeDTO.getName(), employee.getName());
        Assertions.assertEquals(employeeDTO.getSurname(), employee.getSurname());
        Assertions.assertEquals(employeeDTO.getPhone(), employee.getPhone());
        Assertions.assertEquals(employeeDTO.getPassword(), employee.getPassword());
        Assertions.assertEquals(employeeDTO.getEmail(), employee.getEmail());
        Assertions.assertEquals(Gender.valueOf(employeeDTO.getGender()), employee.getGender());
        Assertions.assertEquals(employeeDTO.getPosition(), employee.getPosition());
        Assertions.assertEquals(employeeDTO.getDateOfBirt(), employee.getDateOfBirt().toString());
        Assertions.assertEquals(UserRole.valueOf(employeeDTO.getUserRole()), employee.getUserRole());
        Assertions.assertEquals(employeeDTO.getIsRemoved(), employee.getIsRemoved());
    }

    @Test
    void toEmployee_EmployeeDTOIsNull_EmployeeIsNull() {
        Employee employee = employeeDTO2EmployeeMapper.toEmployee(null);
        Assertions.assertNull(employee);
    }
}