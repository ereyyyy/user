package user.example.user.model.request;

import lombok.Getter;
import lombok.Setter;
import user.example.user.model.enums.UserType;

@Getter
@Setter
public class NewUserRequest {
    private String name;
    private String email;
    private String addresses;
    private UserType userType;
    private String password;
}
