package com.culinario.domain.user.mapper;

import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.commons.BaseMapper;
import com.culinario.infrastructure.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserRequest, UserResponse> {
}
