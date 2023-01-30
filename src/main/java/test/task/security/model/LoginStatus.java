package test.task.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginStatus {

    private boolean loggedIn;
    private String email;
    private String errorMessage;
    private boolean success;

}
