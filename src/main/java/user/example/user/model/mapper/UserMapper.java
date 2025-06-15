package user.example.user.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import user.example.user.model.entitiy.UserEntity;
import user.example.user.model.request.NewUserRequest;
import user.example.user.model.response.UserResponse;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "addresses", ignore = true)
    UserEntity NewUserRequestToUserEntity(NewUserRequest request);

    UserResponse UserEntityToUserResponse(UserEntity entity);
}
