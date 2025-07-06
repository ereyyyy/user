package user.example.user.model.response;

import lombok.Getter;
import lombok.Setter;
import user.example.user.model.enums.ResponseStatus;
import user.example.user.model.enums.UserType;

@Getter
@Setter
public class NewUserResponse {
    private ResponseStatus responseStatus;
    private UserType userType;

}
