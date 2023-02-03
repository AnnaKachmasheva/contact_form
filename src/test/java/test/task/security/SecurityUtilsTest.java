package test.task.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import test.Generator;
import test.task.entity.EmployeeEntity;

import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilsTest {

    private EmployeeEntity employeeEntity;

    @BeforeEach
    public void setUp() {
        this.employeeEntity = Generator.generateEmployeeEntity();
    }

    @AfterEach
    public void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void getCurrentUserReturnsCurrentlyLoggedInUser() {
        Environment.setCurrentUser(employeeEntity);
        final EmployeeEntity result = SecurityUtils.getCurrentUser();
        assertEquals(employeeEntity, result);
    }

    @Test
    void getCurrentUserDetailsReturnsUserDetailsOfCurrentlyLoggedInUser() {
        Environment.setCurrentUser(employeeEntity);
        final UserDetails result = SecurityUtils.getCurrentUserDetails();
        assertNotNull(result);
        assertTrue(result.isEnabled());
        assertEquals(employeeEntity.getEmail(), result.getUsername());
    }

    @Test
    void getCurrentUserDetailsReturnsNullIfNoUserIsLoggedIn() {
        assertNull(SecurityUtils.getCurrentUserDetails());
    }
}
