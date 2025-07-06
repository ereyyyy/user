package user.example.user.service;

import user.example.user.model.request.LoginRequest;
import user.example.user.model.response.LoginResponse;
import user.example.user.model.response.UserResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest request);
    UserResponse getUserFromToken(String token);
} 