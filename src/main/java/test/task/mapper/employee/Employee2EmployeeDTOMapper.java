package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.entity.enums.UserRole;
import test.task.mapper.employee.address.Address2AddressDTOMapper;
import test.task.rest.DTO.AddressDTO;
import test.task.rest.DTO.EmployeeDTO;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Employee2EmployeeDTOMapper {

    private final Address2AddressDTOMapper address2AddressModelMapper;

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        if (employee == null)
            return null;

        Set<AddressDTO> addressModels = address2AddressModelMapper.toAddressDTOSet(employee.getAddresses());

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setGender(employee.getGender().toString());
        employeeDTO.setDateOfBirt(employee.getDateOfBirt().toString());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setUserRole(employee.getUserRole().toString());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setAddresses(addressModels);
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setIsRemoved(employee.getIsRemoved());
        return employeeDTO;
    }

    public Set<EmployeeDTO> toEmployeeDTOSet(Set<Employee> employees) {
        Set<EmployeeDTO> employeeModels = new HashSet<>(employees.size());
        for (Employee employee : employees) {
            employeeModels.add(toEmployeeDTO(employee));
        }
        return employeeModels;
    }
}
