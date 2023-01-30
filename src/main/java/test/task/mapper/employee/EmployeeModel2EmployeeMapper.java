package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.model.EmployeeModel;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeModel2EmployeeMapper {

    private final AddressModel2AddressMapper addressModel2AddressMapper;
    private final PasswordEncoder passwordEncoder;

    public Employee toEmployee(EmployeeModel employeeModel) {
        if (employeeModel == null)
            return null;

        Set<Address> addresses = addressModel2AddressMapper.toAddressSet(employeeModel.getAddresses());

        var employee =  Employee.builder()
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .phone(employeeModel.getPhone())
                .email(employeeModel.getEmail())
                .gender(Gender.valueOf(employeeModel.getGender()))
                .userRole(employeeModel.getUserRole())
                .position(employeeModel.getPosition())
                .dateOfBirt(LocalDate.parse(employeeModel.getDateOfBirt()))
                .addresses(addresses)
                .password(employeeModel.getPassword())
                .build();
        employee.encodePassword(passwordEncoder);

        return employee;
    }

}
