package com.abhimanyutech.photoapp.user.controller;

import com.abhimanyutech.photoapp.user.model.UserDTO;
import com.abhimanyutech.photoapp.user.model.UserTO;
import com.abhimanyutech.photoapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private Environment env;
    private UserService userService;

    @Autowired
    public UserController(Environment env,
                          UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/status/check")
    public String status(){
        return "WORKING on port : " + env.getProperty("local.server.port");
    }

    @PostMapping
    public void createUser(@Valid @RequestBody UserTO userTO) {
        userService.createUser(UserDTO.builder()
                        .email(userTO.getEmail())
                        .firstName(userTO.getFirstName())
                        .lastName(userTO.getLastName())
                        .password(userTO.getPassword())
                        .build());
    }
}
