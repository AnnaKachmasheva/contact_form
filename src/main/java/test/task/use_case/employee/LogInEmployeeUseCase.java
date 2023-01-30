package test.task.use_case.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.task.security.service.LoginService;

@Service
@RequiredArgsConstructor
public class LogInEmployeeUseCase {

    private final LoginService service;

    public String execute(String email, String password) {
        return service.login(email, password);
    }

}