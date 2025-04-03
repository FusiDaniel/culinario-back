package com.culinario.domain.user.mapper;

import com.culinario.application.user.request.CreateUserRequest;
import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.UserItemResponse;
import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.commons.BaseMapper;
import com.culinario.infrastructure.entity.DietaryRestriction;
import com.culinario.infrastructure.entity.Dish;
import com.culinario.infrastructure.entity.Ingredient;
import com.culinario.infrastructure.entity.RecipeIngredient;
import com.culinario.infrastructure.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserRequest, UserResponse> {
    User createRequestToEntity(CreateUserRequest userRequest);
    UserItemResponse entityToItemResponse(User user);

    default Set<Dish> map(List<Long> value) {
        return null;
    }

    default Set<DietaryRestriction> mapDR(List<Long> value) {
        return null;
    }

    default Set<Ingredient> mapI(List<Long> value) {
        return null;
    }

    default Set<RecipeIngredient> mapGL(List<Long> value) {
        return null;
    }
}
