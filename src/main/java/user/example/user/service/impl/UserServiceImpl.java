package user.example.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.example.user.model.entitiy.UserEntity;
import user.example.user.model.enums.ResponseStatus;
import user.example.user.model.mapper.UserMapper;
import user.example.user.model.repository.UserRepository;
import user.example.user.model.request.NewUserRequest;
import user.example.user.model.request.UserFindByIdRequest;
import user.example.user.model.request.UserRequest;
import user.example.user.model.response.NewUserResponse;
import user.example.user.model.response.UserResponse;
import user.example.user.service.CardService;
import user.example.user.service.UserService;
import user.example.user.service.exception.UserNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CardService cardService;

    @Override
    public NewUserResponse createUser(NewUserRequest request) {

        NewUserResponse response = new NewUserResponse();
        try {
            UserEntity entity = UserMapper.INSTANCE.NewUserRequestToUserEntity(request);

            if (!request.getAddresses().isEmpty()) {

                String addressesForEntity = request.getAddresses().getFirst();

                for (int i = 1; i < request.getAddresses().size(); i++) {
                    addressesForEntity += "#" + request.getAddresses().get(i);
                }

                repository.save(entity);
                response.setResponseStatus(ResponseStatus.SUCCESS);
                entity.setAddresses(addressesForEntity);
                UserRequest userRequest = new UserRequest();
                userRequest.setAddresses(addressesForEntity);
                userRequest.setName(request.getName());
                userRequest.setEmail(request.getEmail());
                cardService.createUser(userRequest);
            }

            return response;
    } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }

    @Override
    public UserResponse findById(UserFindByIdRequest request) {
        Optional<UserEntity> entity = repository.findById(request.getId());

        if (entity.isPresent()) {
            return UserMapper.INSTANCE.UserEntityToUserResponse(entity.get());
        }
        else {
            throw new UserNotFoundException("User not found") ;
        }
    }
}
