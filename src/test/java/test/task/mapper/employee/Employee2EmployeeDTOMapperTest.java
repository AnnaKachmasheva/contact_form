package test.task.mapper.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.Generator;
import test.task.domain.Employee;
import test.task.mapper.employee.address.Address2AddressDTOMapper;
import test.task.rest.DTO.EmployeeDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

class Employee2EmployeeDTOMapperTest {

    private final Address2AddressDTOMapper address2AddressModelMapper = new Address2AddressDTOMapper();
    private final Employee2EmployeeDTOMapper employee2EmployeeDTOMapper = new Employee2EmployeeDTOMapper(address2AddressModelMapper);


    @Test
    void toEmployeeDTO_Employee_EmployeeDTO() {
        Employee employee = Generator.generateEmployee();
        EmployeeDTO employeeDTO = employee2EmployeeDTOMapper.toEmployeeDTO(employee);

        Assertions.assertEquals(employee.getId(), employeeDTO.getId());
        Assertions.assertEquals(employee.getName(), employeeDTO.getName());
        Assertions.assertEquals(employee.getSurname(), employeeDTO.getSurname());
        Assertions.assertEquals(employee.getPhone(), employeeDTO.getPhone());
        Assertions.assertEquals(employee.getPassword(), employeeDTO.getPassword());
        Assertions.assertEquals(employee.getEmail(), employeeDTO.getEmail());
        Assertions.assertEquals(employee.getGender().toString(), employeeDTO.getGender());
        Assertions.assertEquals(employee.getPosition(), employeeDTO.getPosition());
        Assertions.assertEquals(employee.getDateOfBirt().toString(), employeeDTO.getDateOfBirt());
        Assertions.assertEquals(employee.getUserRole().toString(), employeeDTO.getUserRole());
        Assertions.assertEquals(employee.getIsRemoved(), employeeDTO.getIsRemoved());
        Assertions.assertEquals(employee.getAddresses(), employeeDTO.getAddresses());
    }

    @Test
    void toEmployeeDTO_EmployeeIsNull_EmployeeDTOIsNull() {
        EmployeeDTO employeeDTO = employee2EmployeeDTOMapper.toEmployeeDTO(null);
        Assertions.assertNull(employeeDTO);
    }

    @Test
    void toEmployeeModelSet_EmployeeSet_EmployeeDTOSet() {
        int count = 10;
        Set<Employee> employeeSet = new HashSet<>();
        while (count > 0) {
            employeeSet.add(Generator.generateEmployee());
            count--;
        }

        Set<EmployeeDTO> employeeDTOSet = employee2EmployeeDTOMapper.toEmployeeDTOSet(employeeSet);

        List<Employee> employeeList = employeeSet.stream().toList();
        List<EmployeeDTO> employeeDTOList = employeeDTOSet.stream().toList();

        IntStream.range(0, count).forEach(i -> {
            Assertions.assertEquals(employeeList.get(i).getId(), employeeDTOList.get(i).getId());
            Assertions.assertEquals(employeeList.get(i).getName(), employeeDTOList.get(i).getName());
            Assertions.assertEquals(employeeList.get(i).getSurname(), employeeDTOList.get(i).getSurname());
            Assertions.assertEquals(employeeList.get(i).getPhone(), employeeDTOList.get(i).getPhone());
            Assertions.assertEquals(employeeList.get(i).getPassword(), employeeDTOList.get(i).getPassword());
            Assertions.assertEquals(employeeList.get(i).getEmail(), employeeDTOList.get(i).getEmail());
            Assertions.assertEquals(employeeList.get(i).getGender().toString(), employeeDTOList.get(i).getGender());
            Assertions.assertEquals(employeeList.get(i).getPosition(), employeeDTOList.get(i).getPosition());
            Assertions.assertEquals(employeeList.get(i).getDateOfBirt().toString(), employeeDTOList.get(i).getDateOfBirt());
            Assertions.assertEquals(employeeList.get(i).getUserRole(), employeeDTOList.get(i).getUserRole());
            Assertions.assertEquals(employeeList.get(i).getIsRemoved(), employeeDTOList.get(i).getIsRemoved());
            Assertions.assertEquals(employeeList.get(i).getAddresses(), employeeDTOList.get(i).getAddresses());
        });
    }
}