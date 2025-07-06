package user.example.user.model.response;

import lombok.Getter;
import lombok.Setter;
import user.example.user.model.enums.UserType;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String email;
    private String addresses;
    private UserType userType;
}
