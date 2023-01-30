package test.task.adapter.employee;

import test.task.domain.Employee;

import java.util.Set;

public interface EmployeeRepositoryAdapter {

    void createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Set<Employee> getAllEmployees();
}
