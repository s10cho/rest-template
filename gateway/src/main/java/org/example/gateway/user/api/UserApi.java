package org.example.gateway.user.api;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.gateway.user.domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserApi {

    private final RestTemplate restTemplate;

    @GetMapping
    public List<User> findAll() {
        return restTemplate.exchange(
            "http://localhost:8081/users",
            org.springframework.http.HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<User>>() {
            }
        ).getBody();
    }
}
