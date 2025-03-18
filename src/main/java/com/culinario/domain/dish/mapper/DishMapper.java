package com.culinario.domain.dish.mapper;

import com.culinario.application.dish.request.DishRequest;
import com.culinario.application.dish.response.DishResponse;
import com.culinario.domain.commons.BaseMapper;
import com.culinario.infrastructure.entity.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper extends BaseMapper<Dish, DishRequest, DishResponse> {

    @Override
    @Mapping(source = "dishCategories", target = "categories")
    Dish requestToEntity(DishRequest request);

    @Override
    @Mapping(source = "recipeIngredients", target = "ingredients")
    DishResponse entityToResponse(Dish dish);

}
