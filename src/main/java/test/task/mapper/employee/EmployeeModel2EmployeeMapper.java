package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.enums.Gender;
import test.task.mapper.employee.address.AddressModel2AddressMapper;
import test.task.model.EmployeeModel;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeModel2EmployeeMapper {

    private final AddressModel2AddressMapper addressModel2AddressMapper;

    public Employee toEmployee(EmployeeModel employeeModel) {
        if (employeeModel == null)
            return null;

        Set<Address> addresses = addressModel2AddressMapper.toAddressSet(employeeModel.getAddresses());

        var employee = new Employee();
        employee.setId(employeeModel.getId());
        employee.setName(employeeModel.getName());
        employee.setSurname(employeeModel.getSurname());
        employee.setPhone(employeeModel.getPhone());
        employee.setEmail(employeeModel.getEmail());
        employee.setGender(Gender.valueOf(employeeModel.getGender()));
        employee.setUserRole(employeeModel.getUserRole());
        employee.setPosition(employeeModel.getPosition());
        employee.setDateOfBirt(LocalDate.parse(employeeModel.getDateOfBirt()));
        employee.setPassword(employeeModel.getPassword());
        employee.setAddresses(addresses);

        return employee;
    }

}
