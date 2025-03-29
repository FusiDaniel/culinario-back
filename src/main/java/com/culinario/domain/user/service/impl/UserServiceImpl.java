package com.culinario.domain.user.service.impl;

import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.user.mapper.UserMapper;
import com.culinario.domain.user.service.IUserService;
import com.culinario.infrastructure.entity.User;
import com.culinario.infrastructure.repository.UserRepository;
import com.culinario.infrastructure.security.SecurityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            SecurityService securityService,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.securityService = securityService;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserResponse getLoggedUser() {
        String username = securityService.getUserName();
        User user = userRepository.findByEmailWithCollections(username).orElseThrow();
        return userMapper.entityToResponse(user);
    }
}
