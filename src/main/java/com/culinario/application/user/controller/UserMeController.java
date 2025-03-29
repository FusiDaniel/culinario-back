package com.culinario.application.user.controller;

import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.user.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users/me")
public class UserMeController {

    private final IUserService userService;

    public UserMeController(
            IUserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserResponse> get() {
        return new ResponseEntity<>(userService.getLoggedUser(), OK);
    }

}
