package com.culinario.domain.user.service;

import com.culinario.application.user.request.CreateUserRequest;
import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.UserItemResponse;
import com.culinario.application.user.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    UserResponse getLoggedUser();
    Page<UserItemResponse> getAllPaged(Pageable pageable);
    UserResponse getById(Long id);
    Long post(CreateUserRequest data);
    void patch(Long id, UserRequest data);
    void delete(Long id);
}
