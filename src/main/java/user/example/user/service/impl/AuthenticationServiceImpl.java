package user.example.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.example.user.model.entitiy.UserEntity;
import user.example.user.model.enums.UserType;
import user.example.user.model.repository.UserRepository;
import user.example.user.model.request.LoginRequest;
import user.example.user.model.response.LoginResponse;
import user.example.user.model.response.UserResponse;
import user.example.user.model.mapper.UserMapper;
import user.example.user.service.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = user.getId() + ":" + user.getUserType();

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUserType(user.getUserType());
        return response;
    }

    @Override
    public UserResponse getUserFromToken(String token) {
        // Basit çözüm: token = userId:userType
        String[] parts = token.split(":");
        Long userId = Long.parseLong(parts[0]);
        UserEntity user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found from token"));
        return UserMapper.INSTANCE.UserEntityToUserResponse(user);
    }
} 