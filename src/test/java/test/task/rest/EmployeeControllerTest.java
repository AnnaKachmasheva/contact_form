package test.task.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.Employee;
import test.task.model.EmployeeModel;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest
//@ContextConfiguration(
//        classes = {TestSecurityConfig.class,
//                EmployeeControllerTest.TestConfig.class,
//                SecurityConfig.class})
public class EmployeeControllerTest extends BaseControllerTestRunner {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepositoryAdapter employeeRepositoryAdapter;

    private EmployeeModel em;

//    @Test
//    void createEmployee_nullModelEmployee_BadRequest() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//    }
}
