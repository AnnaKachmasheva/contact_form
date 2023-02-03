package test.task.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import test.task.adapter.employee.EmployeeAdapter;
import test.task.rest.DTO.EmployeeDTO;
import test.task.rest.DTO.validator.AddressDTOValidator;
import test.task.rest.DTO.validator.EmployeeDTOValidator;
import test.task.rest.interfaces.EmployeeController;
import test.task.security.CurrentUser;
import test.task.security.model.LoginDTO;
import test.task.security.model.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeDTOValidator employeeModelValidation;
    private final AddressDTOValidator addressModelValidation;

    private final EmployeeAdapter employeeAdapter;

    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeModelValidation.validate(employeeDTO);
        addressModelValidation.validate(employeeDTO.getAddresses());
        return employeeAdapter.createEmployee(employeeDTO);
    }

    @Override
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginModel) {
        return ResponseEntity.ok(employeeAdapter.login(loginModel));
    }

    @Override
    @GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getCurrentEmployee(@CurrentUser UserDetailsImpl userDetails) {
        if (userDetails == null) {
            log.info("User details is empty.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return employeeAdapter.getCurrentEmployee(userDetails.getEmployee());
    }

    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getEmployeeById(@Valid @PathVariable Long id) {
        return employeeAdapter.getEmployeeById(id);
    }


    //    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<EmployeeDTO> getEmployees() {
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
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody(required = false) EmployeeDTO employeeModel) {
        return ResponseEntity.ok(employeeAdapter.updateEmployee(employeeModel));
    }

}