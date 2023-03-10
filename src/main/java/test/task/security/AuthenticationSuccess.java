package test.task.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;
import test.task.security.model.LoginStatus;
import test.task.security.model.UserDetailsImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service("successHandler")
public class AuthenticationSuccess implements AuthenticationSuccessHandler, LogoutSuccessHandler {

    private final ObjectMapper mapper;

    @Autowired
    public AuthenticationSuccess(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        final String username = getUsername(authentication);
        if (log.isTraceEnabled())
            log.trace("Successfully authenticated user {}", username);

        final LoginStatus loginStatus = new LoginStatus(true, username, null, authentication.isAuthenticated());
        mapper.writeValue(httpServletResponse.getOutputStream(), loginStatus);
    }

    private String getUsername(Authentication authentication) {
        if (authentication == null) return "";
        return ((UserDetailsImpl) authentication.getPrincipal()).getUsername();
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException {
        if (log.isTraceEnabled())
            log.trace("Successfully logged out user {}", getUsername(authentication));

        final LoginStatus loginStatus = new LoginStatus(false, null, null, true);
        mapper.writeValue(httpServletResponse.getOutputStream(), loginStatus);
    }
}