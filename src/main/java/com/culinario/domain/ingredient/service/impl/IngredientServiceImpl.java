package com.culinario.domain.ingredient.service.impl;

import com.culinario.application.commons.exception.NotFoundException;
import com.culinario.application.ingredient.request.IngredientRequest;
import com.culinario.application.ingredient.response.IngredientResponse;
import com.culinario.domain.ingredient.mapper.IngredientMapper;
import com.culinario.domain.ingredient.service.IIngredientService;
import com.culinario.infrastructure.entity.Ingredient;
import com.culinario.infrastructure.repository.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IIngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(
            IngredientRepository ingredientRepository,
            IngredientMapper ingredientMapper
    ) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public Page<IngredientResponse> getAllPaged(Pageable pageable) {

        return ingredientRepository.findAll(pageable).map(ingredientMapper::entityToResponse);
    }

    @Override
    public IngredientResponse getById(Long id) {
        Ingredient ingredient = findById(id);
        return ingredientMapper.entityToResponse(ingredient);
    }

    @Override
    public Long post(IngredientRequest request) {
        Ingredient newIngredient = ingredientMapper.requestToEntity(request);
        Ingredient savedIngredient = ingredientRepository.save(newIngredient);
        return savedIngredient.getId();
    }

    @Override
    public void patch(Long id, IngredientRequest request) {
        Ingredient ingredient = findById(id);
        ingredient.setName(request.getName());
        ingredient.setType(request.getType());
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
