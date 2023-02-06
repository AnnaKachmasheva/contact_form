package test.task.adapter.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import test.Generator;
import test.task.domain.Address;
import test.task.domain.Employee;
import test.task.entity.enums.Gender;
import test.task.entity.enums.UserRole;
import test.task.entity.repository.EmployeeEntityRepository;
import test.task.exeption.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class EmployeeJpaRepositoryAdapterTest {

    @Autowired
    EmployeeEntityRepository employeeEntityRepository;

    @Autowired
    EmployeeJpaRepositoryAdapter employeeJpaRepositoryAdapter;

    private Employee employee;

    @BeforeEach
    public void init() {
        employee = Generator.generateEmployee();
    }

    @Test
    void createEmployee_Employee_success() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);
        List<Address> addresses = employee.getAddresses().stream().toList();
        List<Address> addressesSaved = savedEmployee.getAddresses().stream().toList();

        Assertions.assertEquals(employee.getName(), savedEmployee.getName());
        Assertions.assertEquals(employee.getSurname(), savedEmployee.getSurname());
        Assertions.assertEquals(employee.getPhone(), savedEmployee.getPhone());
        Assertions.assertEquals(employee.getDateOfBirt(), savedEmployee.getDateOfBirt());
        Assertions.assertEquals(employee.getIsRemoved(), savedEmployee.getIsRemoved());
        Assertions.assertEquals(employee.getPassword(), savedEmployee.getPassword());
        Assertions.assertEquals(employee.getUserRole(), savedEmployee.getUserRole());
        Assertions.assertEquals(employee.getPosition(), savedEmployee.getPosition());
        Assertions.assertEquals(employee.getGender(), savedEmployee.getGender());
        Assertions.assertEquals(employee.getEmail(), savedEmployee.getEmail());

        for (int i = 0; i < addresses.size(); i++) {
            Assertions.assertEquals(addresses.get(i).getState(), addressesSaved.get(i).getState());
            Assertions.assertEquals(addresses.get(i).getCity(), addressesSaved.get(i).getCity());
            Assertions.assertEquals(addresses.get(i).getStreet(), addressesSaved.get(i).getStreet());
            Assertions.assertEquals(addresses.get(i).getPostal(), addressesSaved.get(i).getPostal());
        }
    }

    @Test
    void createEmployee_EmployeeWithExistingEmail_BadRequestException() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);

        assertThatThrownBy(() -> employeeJpaRepositoryAdapter.createEmployee(savedEmployee))
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void getEmployeeById_existingId_EmployeeEntity() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);
        Employee gettingEmployee = employeeJpaRepositoryAdapter.getEmployeeById(savedEmployee.getId());

        Assertions.assertEquals(savedEmployee.getSurname(), gettingEmployee.getSurname());
        Assertions.assertEquals(savedEmployee.getPhone(), gettingEmployee.getPhone());
        Assertions.assertEquals(savedEmployee.getDateOfBirt(), gettingEmployee.getDateOfBirt());
        Assertions.assertEquals(savedEmployee.getIsRemoved(), gettingEmployee.getIsRemoved());
        Assertions.assertEquals(savedEmployee.getPassword(), gettingEmployee.getPassword());
        Assertions.assertEquals(savedEmployee.getUserRole(), gettingEmployee.getUserRole());
        Assertions.assertEquals(savedEmployee.getPosition(), gettingEmployee.getPosition());
        Assertions.assertEquals(savedEmployee.getGender(), gettingEmployee.getGender());
        Assertions.assertEquals(savedEmployee.getEmail(), gettingEmployee.getEmail());
    }

    @Test
    void createEmployee_notExistingId_EmployeeNotFoundException() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);

        assertThatThrownBy(() -> employeeJpaRepositoryAdapter.getEmployeeById(savedEmployee.getId() + 1))
                .isInstanceOf(EmployeeNotFoundException.class);
    }

    @Test
    void getEmployeeByEmail_existingEmail_EmployeeEntity() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);
        Employee gettingEmployee = employeeJpaRepositoryAdapter.getEmployeeByEmail(savedEmployee.getEmail());

        Assertions.assertEquals(savedEmployee.getSurname(), gettingEmployee.getSurname());
        Assertions.assertEquals(savedEmployee.getPhone(), gettingEmployee.getPhone());
        Assertions.assertEquals(savedEmployee.getDateOfBirt(), gettingEmployee.getDateOfBirt());
        Assertions.assertEquals(savedEmployee.getIsRemoved(), gettingEmployee.getIsRemoved());
        Assertions.assertEquals(savedEmployee.getPassword(), gettingEmployee.getPassword());
        Assertions.assertEquals(savedEmployee.getUserRole(), gettingEmployee.getUserRole());
        Assertions.assertEquals(savedEmployee.getPosition(), gettingEmployee.getPosition());
        Assertions.assertEquals(savedEmployee.getGender(), gettingEmployee.getGender());
        Assertions.assertEquals(savedEmployee.getEmail(), gettingEmployee.getEmail());
    }

    @Test
    void createEmployee_NotExistingEmail_EmployeeNotFoundException() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);

        assertThatThrownBy(() -> employeeJpaRepositoryAdapter.getEmployeeByEmail(savedEmployee.getEmail() + "email"))
                .isInstanceOf(EmployeeNotFoundException.class);
    }

    @Test
    void getAllEmployees_get10Employees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeJpaRepositoryAdapter.createEmployee(employee));
        int countEmployee = 9;
        for (int i = 0; i < countEmployee; i++) {
            employees.add(employeeJpaRepositoryAdapter.createEmployee(Generator.generateEmployee()));
        }

        List<Employee> employeeList = employeeJpaRepositoryAdapter.getAllEmployees().stream().toList();

        Assertions.assertEquals(employees.size(), employeeList.size());
    }

    @Test
    void deleteEmployee_success() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);

        Assertions.assertFalse(savedEmployee.getIsRemoved());

        employeeJpaRepositoryAdapter.deleteEmployee(savedEmployee.getId());
        Employee gettingEmployee = employeeJpaRepositoryAdapter.getEmployeeById(savedEmployee.getId());

        Assertions.assertTrue(gettingEmployee.getIsRemoved());
    }

    @Test
    void updateEmployee_success() {
        Employee savedEmployee = employeeJpaRepositoryAdapter.createEmployee(employee);

        savedEmployee.setName(savedEmployee.getName() + "update");
        savedEmployee.setSurname(savedEmployee.getSurname() + "update");
        savedEmployee.setPassword(savedEmployee.getPassword() + "update");
        savedEmployee.setPosition(savedEmployee.getPosition() + "update");
        savedEmployee.setDateOfBirt(savedEmployee.getDateOfBirt().plusDays(10));
        savedEmployee.setPhone("123456789");
        savedEmployee.setEmail(savedEmployee.getEmail() + "update");
        savedEmployee.setUserRole(UserRole.USER);
        savedEmployee.setGender(Gender.PREFER_NOT_THE_ANSWER);
        savedEmployee.setIsRemoved(!savedEmployee.getIsRemoved());

        Employee updatedEmployee = employeeJpaRepositoryAdapter.updateEmployee(savedEmployee);

        Assertions.assertEquals(savedEmployee.getName(), updatedEmployee.getName());
        Assertions.assertEquals(savedEmployee.getSurname(), updatedEmployee.getSurname());
        Assertions.assertEquals(savedEmployee.getPhone(), updatedEmployee.getPhone());
        Assertions.assertEquals(savedEmployee.getDateOfBirt(), updatedEmployee.getDateOfBirt());
        Assertions.assertEquals(savedEmployee.getIsRemoved(), updatedEmployee.getIsRemoved());
        Assertions.assertEquals(savedEmployee.getPassword(), updatedEmployee.getPassword());
        Assertions.assertEquals(savedEmployee.getUserRole(), updatedEmployee.getUserRole());
        Assertions.assertEquals(savedEmployee.getPosition(), updatedEmployee.getPosition());
        Assertions.assertEquals(savedEmployee.getGender(), updatedEmployee.getGender());
        Assertions.assertEquals(savedEmployee.getEmail(), updatedEmployee.getEmail());
    }
}