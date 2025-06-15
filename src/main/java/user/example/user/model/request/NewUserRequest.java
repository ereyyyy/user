package user.example.user.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewUserRequest {
    private String name;
    private String email;
    private List<String> addresses;
}
