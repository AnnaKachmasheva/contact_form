package test.task.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import test.task.adapter.request.EmployeeAdapter;
import test.task.model.EmployeeModel;
import test.task.model.validator.AddressModelValidation;
import test.task.model.validator.EmployeeModelValidation;
import test.task.rest.interfaces.EmployeeController;
import test.task.security.CurrentUser;
import test.task.security.model.LoginModel;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeModelValidation employeeModelValidation;
    private final AddressModelValidation addressModelValidation;

    private final EmployeeAdapter employeeAdapter;

    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel) {
        employeeModelValidation.validation(employeeModel);
        addressModelValidation.validation(employeeModel.getAddresses());
        return employeeAdapter.createEmployee(employeeModel);
    }

    @Override
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        return ResponseEntity.ok(employeeAdapter.login(loginModel));
    }

    @Override
    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel getCurrentEmployee(@CurrentUser UserDetailsImpl userDetails) {
        if (userDetails == null) {
            log.info("User details is empty.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return employeeAdapter.getCurrentEmployee(userDetails.getEmployee());
    }

    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeModel getEmployeeById(@Valid @PathVariable Long id) {
        return employeeAdapter.getEmployeeById(id);
    }


    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<EmployeeModel> getEmployees() {
        return employeeAdapter.getAllEmployees();
    }

    //    @PreAuthorize("hasAuthority('ROLE_ADMIN') || #id == authentication.principal.id")
    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@Valid @PathVariable Long id) {
        employeeAdapter.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    //    @PreAuthorize("hasAuthority('ROLE_ADMIN') || #id == authentication.principal.id")
    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeModel> updateEmployee(@Valid @RequestBody(required = false) EmployeeModel employeeModel) {
        return ResponseEntity.ok(employeeAdapter.updateEmployee(employeeModel));
    }

}