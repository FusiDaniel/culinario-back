package com.culinario.domain.ingredient.mapper;

import com.culinario.application.ingredient.request.IngredientRequest;
import com.culinario.application.ingredient.response.IngredientResponse;
import com.culinario.domain.commons.BaseMapper;
import com.culinario.infrastructure.entity.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper extends BaseMapper<Ingredient, IngredientRequest, IngredientResponse> {
}
