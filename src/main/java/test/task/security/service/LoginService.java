package test.task.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.security.DefaultAuthenticationProvider;
import test.task.security.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final DefaultAuthenticationProvider provider;
    private final JwtTokenProvider tokenProvider;

    @Transactional(readOnly = true)
    public String login(String email, String password) {
        var auth = new UsernamePasswordAuthenticationToken(email, password);
        var authentication = provider.authenticate(auth);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }
}

