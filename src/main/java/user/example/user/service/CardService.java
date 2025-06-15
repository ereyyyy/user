package user.example.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import user.example.user.model.request.UserRequest;

@FeignClient(name = "card-service", url = "http://localhost:8083/api")
public interface CardService {

    @PostMapping("/new-user")
    void createUser(@RequestBody UserRequest request);
}
