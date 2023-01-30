package test.task.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import test.task.adapter.request.EmployeeAdapter;
import test.task.mapper.employee.EmployeeEntityMapper;
import test.task.model.EmployeeModel;
import test.task.model.validator.AddressModelValidation;
import test.task.model.validator.EmployeeModelValidation;
import test.task.security.CurrentUser;
import test.task.security.model.LoginModel;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeModelValidation employeeModelValidation;
    private final AddressModelValidation addressModelValidation;

    private final EmployeeAdapter employeeAdapter;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeModel employeeModel) {
        employeeModelValidation.validation(employeeModel);
        addressModelValidation.validation(employeeModel.getAddresses());

        employeeAdapter.createEmployee(employeeModel);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        return ResponseEntity.ok(employeeAdapter.login(loginModel));
    }

    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel getCurrentEmployee(@CurrentUser UserDetailsImpl userDetails) {
        return employeeAdapter.getCurrentEmployee(userDetails.getEmployee());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel getEmployeeById(@Valid @PathVariable Long id) {
        return employeeAdapter.getEmployeeById(id);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<EmployeeModel> getEmployeeById() {
        return employeeAdapter.getAllEmployees();
    }

}