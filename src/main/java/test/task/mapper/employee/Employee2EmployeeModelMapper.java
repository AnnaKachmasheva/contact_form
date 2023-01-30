package test.task.mapper.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.task.domain.Employee;
import test.task.mapper.employee.address.Address2AddressModelMapper;
import test.task.model.AddressModel;
import test.task.model.EmployeeModel;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Employee2EmployeeModelMapper {

    private final Address2AddressModelMapper address2AddressModelMapper;

    public EmployeeModel toEmployeeModel(Employee employee) {
        if (employee == null)
            return null;

        Set<AddressModel> addressModels = address2AddressModelMapper.toAddressModelSet(employee.getAddresses());

        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName(employee.getName());
        employeeModel.setSurname(employee.getSurname());
        employeeModel.setGender(employee.getGender().toString());
        employeeModel.setDateOfBirt(employee.getDateOfBirt().toString());
        employeeModel.setPosition(employee.getPosition());
        employeeModel.setUserRole(employee.getUserRole());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setPhone(employee.getPhone());
        employeeModel.setAddresses(addressModels);
        employeeModel.setPassword(employee.getPassword());

        return employeeModel;
    }

    public Set<EmployeeModel> toEmployeeModelSet(Set<Employee> employees) {
        Set<EmployeeModel> employeeModels = new HashSet<>(employees.size());
        for (Employee employee : employees) {
            employeeModels.add(toEmployeeModel(employee));
        }
        return employeeModels;
    }
}
