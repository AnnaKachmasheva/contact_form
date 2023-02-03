package test.task.security;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import test.Generator;
import test.task.adapter.employee.EmployeeRepositoryAdapter;
import test.task.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class DefaultAuthenticationProviderTest {

    @Autowired
    private EmployeeRepositoryAdapter employeeRepositoryAdapter;

    @Autowired
    private DefaultAuthenticationProvider provider;

    private final Employee employee = Generator.generateEmployee();
    private final String rawPassword = employee.getPassword();

    @BeforeEach
    public void setUp() {
        employeeRepositoryAdapter.createEmployee(employee);
        SecurityContextHolder.setContext(new SecurityContextImpl());
    }

    @AfterEach
    public void tearDown() {
        SecurityContextHolder.setContext(new SecurityContextImpl());
    }

    //todo fix provider.auth...
//    @Test
//    void successfulAuthenticationSetsSecurityContext() {
//        final Authentication auth = new UsernamePasswordAuthenticationToken(employee.getPassword(), rawPassword);
//        final SecurityContext context = SecurityContextHolder.getContext();
//        assertNull(context.getAuthentication());
//        final Authentication result = provider.authenticate(auth);
//        assertNotNull(result);
//        assertTrue(result.isAuthenticated());
//        assertNotNull(SecurityContextHolder.getContext());
//        final UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        assertEquals(employee.getEmail(), details.getUsername());
//        assertTrue(result.isAuthenticated());
//    }

    @Test
    void authenticateThrowsUserNotFoundExceptionForUnknownUsername() {
        final Authentication auth = new UsernamePasswordAuthenticationToken("unknownUsername", rawPassword);
        try {
            assertThrows(UsernameNotFoundException.class, () -> provider.authenticate(auth));
        } finally {
            final SecurityContext context = SecurityContextHolder.getContext();
            assertNull(context.getAuthentication());
        }
    }

    @Test
    void authenticateThrowsBadCredentialsForInvalidPassword() {
        final Authentication auth = new UsernamePasswordAuthenticationToken(employee.getEmail(), "unknownPassword");
        try {
            assertThrows(BadCredentialsException.class, () -> provider.authenticate(auth));
        } finally {
            final SecurityContext context = SecurityContextHolder.getContext();
            assertNull(context.getAuthentication());
        }
    }

    @Test
    void supportsUsernameAndPasswordAuthentication() {
        assertTrue(provider.supports(UsernamePasswordAuthenticationToken.class));
    }

    //todo fix provider.auth...
//    @Test
//    void successfulLoginErasesPasswordInSecurityContextUser() {
//        final Authentication auth = new UsernamePasswordAuthenticationToken(employee.getEmail(), rawPassword);
//        provider.authenticate(auth);
//        assertNotNull(SecurityContextHolder.getContext());
//        final UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        assertNull(details.getPassword());
//    }
}
