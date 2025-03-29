package com.culinario.domain.user.service;

import com.culinario.application.user.response.UserResponse;

public interface IUserService {
    public UserResponse getLoggedUser();
}
