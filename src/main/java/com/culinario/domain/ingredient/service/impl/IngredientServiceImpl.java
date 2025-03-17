package com.culinario.domain.ingredient.service.impl;

import com.culinario.application.commons.exception.NotFoundException;
import com.culinario.application.ingredient.request.IngredientRequest;
import com.culinario.application.ingredient.response.IngredientResponse;
import com.culinario.domain.ingredient.service.IIngredientService;
import com.culinario.infrastructure.entity.Ingredient;
import com.culinario.infrastructure.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IIngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(
            IngredientRepository ingredientRepository
    ) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Page<IngredientResponse> getAllPaged(Pageable pageable) {

        return ingredientRepository.findAll(pageable).map(ingredient -> IngredientResponse.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .type(ingredient.getType())
                .build()
        );
    }

    @Override
    public IngredientResponse getById(Long id) {
        Ingredient ingredient = findById(id);
        return IngredientResponse.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .type(ingredient.getType())
                .build();
    }

    @Override
    public Long post(IngredientRequest data) {
        Ingredient newIngredient = Ingredient.builder().name(data.getName()).type(data.getType()).build();
        Ingredient savedIngredient = ingredientRepository.save(newIngredient);
        return savedIngredient.getId();
    }

    @Override
    public void patch(Long id, IngredientRequest data) {
        Ingredient ingredient = findById(id);
        ingredient.setName(data.getName());
        ingredient.setType(data.getType());
    }

    @Override
    public void delete(Long id) {
        Ingredient ingredient = findById(id);
        ingredientRepository.delete(ingredient);
    }

    private Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
