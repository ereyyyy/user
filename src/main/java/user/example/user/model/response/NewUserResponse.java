package user.example.user.model.response;

import lombok.Getter;
import lombok.Setter;
import user.example.user.model.enums.ResponseStatus;

@Getter
@Setter
public class NewUserResponse {
    private ResponseStatus responseStatus;

}
