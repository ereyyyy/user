package user.example.user.model.response;

import lombok.Getter;
import lombok.Setter;
import user.example.user.model.enums.UserType;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private UserType userType;
} 