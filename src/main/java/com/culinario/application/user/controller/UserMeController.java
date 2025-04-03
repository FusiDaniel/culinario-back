package com.culinario.application.user.controller;

import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;
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

    @PatchMapping
    @ResponseStatus(NO_CONTENT)
    @Transactional
    public  void patch(@Valid @RequestBody UserRequest request) {
        userService.patch(userService.getLoggedUser().getId(), request);
    }

}
