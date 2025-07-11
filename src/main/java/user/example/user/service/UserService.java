package user.example.user.service;

import user.example.user.model.request.NewUserRequest;
import user.example.user.model.request.UserFindByIdRequest;
import user.example.user.model.response.NewUserResponse;
import user.example.user.model.response.UserResponse;
import user.example.user.model.enums.UserType;
import java.util.List;

public interface UserService {

    NewUserResponse createUser(NewUserRequest request);

    UserResponse findById(UserFindByIdRequest request);
}
