package com.culinario.domain.dish.service;

import com.culinario.application.dish.request.DishRequest;
import com.culinario.application.dish.response.DishResponse;
import com.culinario.domain.commons.BaseService;
import com.culinario.infrastructure.entity.Dish;

public interface IDishService extends BaseService<Long, DishRequest, DishResponse> {
    Dish findById(Long id);
}
