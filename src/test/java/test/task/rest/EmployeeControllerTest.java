package test.task.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.model.EmployeeModel;

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

}
