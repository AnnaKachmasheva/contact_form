package test.task.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import test.task.entity.EmployeeEntity;
import test.task.security.model.AuthenticationToken;
import test.task.security.model.UserDetailsImpl;

public class SecurityUtils {

    /**
     * Gets the currently authenticated user.
     *
     * @return Current user
     */
    public static EmployeeEntity getCurrentUser() {
        final SecurityContext context = SecurityContextHolder.getContext();
        assert context != null;
        final UserDetailsImpl userDetails = (UserDetailsImpl) context.getAuthentication().getDetails();
        return userDetails.getEmployee();
    }

    /**
     * Gets details of the currently authenticated user.
     *
     * @return Currently authenticated user details or null, if no one is currently authenticated
     */
    public static UserDetailsImpl getCurrentUserDetails() {
        final SecurityContext context = SecurityContextHolder.getContext();
        if (context.getAuthentication() != null && context.getAuthentication().getDetails() instanceof UserDetailsImpl)
            return (UserDetailsImpl) context.getAuthentication().getDetails();
        else return null;
    }

    /**
     * Creates an authentication token based on the specified user details and sets it to the current thread's cz.cvut.fel.ear.lingo.security
     * context.
     *
     * @param userDetails Details of the user to set as current
     * @return The generated authentication token
     */
    public static AuthenticationToken setCurrentUser(UserDetailsImpl userDetails) {
        final AuthenticationToken token = new AuthenticationToken(userDetails.getAuthorities(), userDetails);
        token.setAuthenticated(true);
        final SecurityContext context = new SecurityContextImpl();
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);
        return token;
    }

}