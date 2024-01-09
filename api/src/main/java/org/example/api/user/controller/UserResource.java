package org.example.api.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import org.example.api.user.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserResource {

    @GetMapping
    public List<User> findAll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        return Arrays.asList(
            new User("hong", "홍길동"),
            new User("kim", UUID.randomUUID().toString())
        );
    }
}
