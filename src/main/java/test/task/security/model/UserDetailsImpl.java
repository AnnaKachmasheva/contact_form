package test.task.security.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import test.task.entity.EmployeeEntity;

import java.util.*;

@Getter
public class UserDetailsImpl implements UserDetails {

    private EmployeeEntity employee;
    private final Set<GrantedAuthority> authorities;

    public UserDetailsImpl(EmployeeEntity employee) {
        Objects.requireNonNull(employee);
        this.employee = employee;
        this.authorities = new HashSet<>();
        addUserRole();
    }

    public UserDetailsImpl(EmployeeEntity employee, Collection<GrantedAuthority> authorities) {
        Objects.requireNonNull(employee);
        Objects.requireNonNull(authorities);
        this.employee = employee;
        this.authorities = new HashSet<>();
        addUserRole();
        this.authorities.addAll(authorities);
    }

    private void addUserRole() {
        authorities.add(new SimpleGrantedAuthority(employee.getRole().toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.unmodifiableCollection(authorities);
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmail();
    }

    public Long getId() {
        return employee.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<String> getDetails() {
        List<String> list = new ArrayList<>();
        list.add(employee.getEmail());
        list.add(employee.getId().toString());
        list.add(employee.getRole().toString());
        return list;
    }
}

