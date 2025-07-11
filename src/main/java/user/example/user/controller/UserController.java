package user.example.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.example.user.model.request.NewUserRequest;
import user.example.user.model.request.UserFindByIdRequest;
import user.example.user.model.response.NewUserResponse;
import user.example.user.model.response.UserResponse;
import user.example.user.service.UserService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create-user")
    public ResponseEntity<NewUserResponse> createUser(@RequestBody NewUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping(path = "find-by-id")
    public ResponseEntity<UserResponse> findById(@RequestBody UserFindByIdRequest request) {
        return ResponseEntity.ok(userService.findById(request));
    }
}
