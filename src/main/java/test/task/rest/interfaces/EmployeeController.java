package test.task.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import test.task.rest.DTO.EmployeeDTO;
import test.task.security.CurrentUser;
import test.task.security.model.LoginDTO;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Set;


public interface EmployeeController {

    // POST /registration
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeModel);

    // POST /login
    public ResponseEntity<?> login(@RequestBody LoginDTO loginModel);

    // GET /employee/current
    public EmployeeDTO getCurrentEmployee(@CurrentUser UserDetailsImpl userDetails);

    // GET /employee/{employeeId}
    public EmployeeDTO getEmployeeById(@Valid @PathVariable Long id);

    // GET /employees
    public Set<EmployeeDTO> getEmployees();

    // DELETE /employee/{employeeId}
    public ResponseEntity<Void> deleteEmployee(@Valid @PathVariable Long id);

    // PUT /employee/{employeeId}
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody(required = false) EmployeeDTO employeeModel);

}