package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.model.EmployeeModel;
import test.task.security.CurrentUser;
import test.task.security.model.LoginModel;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Set;


public interface EmployeeController {

    // POST /registration
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel);

    // POST /login
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel);

    // GET /employee/current
    public EmployeeModel getCurrentEmployee(@CurrentUser UserDetailsImpl userDetails);

    // GET /employee/{employeeId}
    public EmployeeModel getEmployeeById(@Valid @PathVariable Long id);

    // GET /employees
    public Set<EmployeeModel> getEmployees();

    // DELETE /employee/{employeeId}
    public ResponseEntity<Void> deleteEmployee(@Valid @PathVariable Long id);

    // PUT /employee/{employeeId}
    public ResponseEntity<EmployeeModel> updateEmployee(@Valid @RequestBody(required = false) EmployeeModel employeeModel);

}