package user.example.user.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import user.example.user.model.entitiy.UserEntity;
import user.example.user.model.request.NewUserRequest;
import user.example.user.model.request.UserRequest;
import user.example.user.model.response.NewUserResponse;
import user.example.user.model.response.UserResponse;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "addresses", ignore = true)
    UserEntity NewUserRequestToUserEntity(NewUserRequest request);

    UserEntity UserRequestToUserEntity(UserRequest request);

    UserResponse UserEntityToUserResponse(UserEntity entity);

    NewUserResponse UserEntityToNewUserResponse(UserEntity entity);
}
