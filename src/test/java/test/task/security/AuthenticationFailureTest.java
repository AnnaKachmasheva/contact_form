package test.task.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import test.task.config.AppConfig;
import test.task.security.model.LoginStatus;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test without any Spring
 */
class AuthenticationFailureTest {

    private final ObjectMapper mapper = new AppConfig().objectMapper();

    private AuthenticationFailure sut;

    @BeforeEach
    public void setUp() {
        this.sut = new AuthenticationFailure(mapper);
    }

    @Test
    void authenticationFailureReturnsLoginStatusWithErrorInfo() throws Exception {
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final MockHttpServletResponse response = new MockHttpServletResponse();
        final String msg = "Username not found";
        final AuthenticationException e = new UsernameNotFoundException(msg);
        sut.onAuthenticationFailure(request, response, e);
        final LoginStatus status = mapper.readValue(response.getContentAsString(), LoginStatus.class);

        assertFalse(status.isSuccess());
        assertFalse(status.isLoggedIn());
        assertNull(status.getEmail());
        assertEquals(msg, status.getErrorMessage());
    }
}
