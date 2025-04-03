package com.culinario.domain.ingredient.service;

import com.culinario.application.ingredient.request.IngredientRequest;
import com.culinario.application.ingredient.response.IngredientResponse;
import com.culinario.domain.commons.BaseService;
import com.culinario.infrastructure.entity.Ingredient;

public interface IIngredientService extends BaseService<Long, IngredientRequest, IngredientResponse> {
    Ingredient findById(Long id);
}
