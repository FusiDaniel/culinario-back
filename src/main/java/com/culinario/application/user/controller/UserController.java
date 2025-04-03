package com.culinario.application.user.controller;

import com.culinario.application.user.request.CreateUserRequest;
import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.CreateUserResponse;
import com.culinario.application.user.response.UserItemResponse;
import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(
            IUserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserItemResponse>> list(Pageable pageable) {
        return new ResponseEntity<>(userService.getAllPaged(pageable), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        Long newUserId = userService.post(request);
        return new ResponseEntity<>(CreateUserResponse.builder()
                .id(newUserId)
                .build(), CREATED);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Transactional
    public  void patch(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        userService.patch(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Transactional
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
