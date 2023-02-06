package test.task.adapter.employee;

import test.task.domain.Employee;

import java.util.Set;

public interface EmployeeRepositoryAdapter {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee getEmployeeByEmail(String email);

    Set<Employee> getAllEmployees();

    void deleteEmployee(Long id);

   Employee updateEmployee(Employee employee);
}
