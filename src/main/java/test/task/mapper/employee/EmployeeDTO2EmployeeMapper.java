package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.mapper.employee.address.AddressDTO2AddressMapper;
import test.task.rest.DTO.EmployeeDTO;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeDTO2EmployeeMapper {

    private final AddressDTO2AddressMapper addressModel2AddressMapper;

    public Employee toEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null)
            return null;

        Set<Address> addresses = addressModel2AddressMapper.toAddressSet(employeeDTO.getAddresses());

        var employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setGender(Gender.valueOf(employeeDTO.getGender()));
        employee.setUserRole(UserRole.valueOf(employeeDTO.getUserRole()));
        employee.setPosition(employeeDTO.getPosition());
        employee.setDateOfBirt(LocalDate.parse(employeeDTO.getDateOfBirt()));
        employee.setPassword(employeeDTO.getPassword());
        employee.setAddresses(addresses);
        employee.setIsRemoved(employeeDTO.getIsRemoved());
        return employee;
    }

}