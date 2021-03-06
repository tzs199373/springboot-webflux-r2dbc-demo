package com.example.webflux.controller;

import com.example.webflux.model.User;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class GrettingController {
    @Resource
    private DatabaseClient databaseClient;

    @GetMapping("/get")
    public Flux<User> clientUserFlux() {
        return databaseClient.execute("select * from user").as(User.class)
                .fetch()
                .all();
    }
}
