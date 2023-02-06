package test.task.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.task.entity.repository.EmployeeEntityRepository;
import test.task.security.model.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeEntityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var employee = repository.findEmployeeEntityByEmail(email);
        if (employee == null)
            throw new UsernameNotFoundException("User with email " + email + " not found.");
        return new UserDetailsImpl(employee.get());
    }
}