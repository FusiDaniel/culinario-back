package com.culinario.domain.dish.service.impl;

import com.culinario.application.commons.exception.BadRequestException;
import com.culinario.application.commons.exception.NotFoundException;
import com.culinario.application.dish.request.DishIngredientRequest;
import com.culinario.application.dish.request.DishRequest;
import com.culinario.application.dish.response.DishResponse;
import com.culinario.domain.dish.mapper.DishMapper;
import com.culinario.domain.dish.service.IDishService;
import com.culinario.infrastructure.entity.Dish;
import com.culinario.infrastructure.entity.Ingredient;
import com.culinario.infrastructure.entity.RecipeIngredient;
import com.culinario.infrastructure.repository.DishRepository;
import com.culinario.infrastructure.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import static java.util.Objects.nonNull;

@Service
public class DishServiceImpl implements IDishService {

    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;
    private final DishMapper dishMapper;

    public DishServiceImpl(
            DishRepository dishRepository,
            IngredientRepository ingredientRepository,
            DishMapper dishMapper
    ) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public Page<DishResponse> getAllPaged(Pageable pageable) {
        return dishRepository.findAll(pageable).map(dishMapper::entityToResponse);
    }

    @Override
    public DishResponse getById(Long id) {
        Dish dish = findById(id);
        return dishMapper.entityToResponse(dish);
    }

    @Override
    public Long post(DishRequest request) {
        Dish newDish = dishMapper.requestToEntity(request);

        for (DishIngredientRequest ingredientRequest : request.getIngredients()) {
            Ingredient ingredient = findIngredientById(ingredientRequest.getId());

            newDish.getRecipeIngredients().add(buildRecipeIngredient(
                    newDish,
                    ingredientRequest.getAmount(),
                    ingredient
            ));
        }

        Dish savedDish = dishRepository.save(newDish);
        return savedDish.getId();
    }

    @Override
    public void patch(Long id, DishRequest request) {
        Dish existingDish = findById(id);
        Dish update = dishMapper.requestToEntity(request);

        for (Field field : update.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                boolean isAllowedClass = String.class == field.getType()
                        || Integer.class == field.getType()
                        || Long.class == field.getType();

                if (isAllowedClass && field.get(update) != null && !field.get(update).equals(field.get(existingDish))) {
                    field.set(existingDish, field.get(update));
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        if (nonNull(request.getDishCategories())) {
            existingDish.setCategories(request.getDishCategories());
        }
        if (nonNull(request.getNutritionFacts()) && !request.getNutritionFacts().getCalories().equals(existingDish.getNutritionFacts().getCalories())) {
            existingDish.getNutritionFacts().setCalories(request.getNutritionFacts().getCalories());
        }
        if (nonNull(request.getIngredients()) && !request.getIngredients().isEmpty()) {
            existingDish.getRecipeIngredients().clear();
            request.getIngredients().forEach(requestIngredient -> {
                Ingredient ingredient = findIngredientById(requestIngredient.getId());

                existingDish.getRecipeIngredients().add(buildRecipeIngredient(
                        existingDish,
                        requestIngredient.getAmount(),
                        ingredient
                ));
            });
        }
    }

    @Override
    public void delete(Long id) {
        Dish dish = findById(id);
        dishRepository.delete(dish);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private Ingredient findIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Ingredient not found"));
    }

    private RecipeIngredient buildRecipeIngredient(Dish dish, Integer amount, Ingredient ingredient) {
        return RecipeIngredient.builder()
                .dish(dish)
                .amount(amount)
                .ingredient(ingredient)
                .build();
    }
}
