package ie.atu.cicdproject.ffmainapp.feignclient;

import ie.atu.cicdproject.ffmainapp.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "login-service",
        url = "${login.service.base-url}"
)
public interface UserClient {

    @GetMapping("/api/users/{id}")
    UserResponseDTO getUserById(@PathVariable("id") String id);
}
