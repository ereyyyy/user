package user.example.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import user.example.user.model.request.LoginRequest;
import user.example.user.model.request.TokenRequest;
import user.example.user.model.response.LoginResponse;
import user.example.user.model.response.UserResponse;
import user.example.user.service.AuthenticationService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }

    @PostMapping("/user")
    public UserResponse getUser(@RequestBody TokenRequest tokenRequest) {
        String token = tokenRequest.getToken();
        return authenticationService.getUserFromToken(token);
    }
} 