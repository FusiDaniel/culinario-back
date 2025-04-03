package com.culinario.domain.user.service.impl;

import com.culinario.application.commons.exception.BadRequestException;
import com.culinario.application.commons.exception.NotFoundException;
import com.culinario.application.user.request.CreateUserRequest;
import com.culinario.application.user.request.UserRequest;
import com.culinario.application.user.response.UserItemResponse;
import com.culinario.application.user.response.UserResponse;
import com.culinario.domain.dish.service.IDishService;
import com.culinario.domain.ingredient.service.IIngredientService;
import com.culinario.domain.user.mapper.UserMapper;
import com.culinario.domain.user.service.IUserService;
import com.culinario.infrastructure.entity.DietaryRestriction;
import com.culinario.infrastructure.entity.Dish;
import com.culinario.infrastructure.entity.Ingredient;
import com.culinario.infrastructure.entity.RecipeIngredient;
import com.culinario.infrastructure.entity.User;
import com.culinario.infrastructure.repository.DietaryRestrictionRepository;
import com.culinario.infrastructure.repository.RecipeIngredientRepository;
import com.culinario.infrastructure.repository.UserRepository;
import com.culinario.infrastructure.security.SecurityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final DietaryRestrictionRepository dietaryRestrictionRepository;
    private final IDishService dishService;
    private final IIngredientService ingredientService;
    private final SecurityService securityService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            RecipeIngredientRepository recipeIngredientRepository,
            DietaryRestrictionRepository dietaryRestrictionRepository,
            IDishService dishService,
            IIngredientService ingredientService,
            SecurityService securityService,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.dietaryRestrictionRepository = dietaryRestrictionRepository;
        this.dishService = dishService;
        this.ingredientService = ingredientService;
        this.securityService = securityService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponse getLoggedUser() {
        String username = securityService.getUserName();
        User user = userRepository.findByEmailWithCollections(username).orElseThrow();
        return userMapper.entityToResponse(user);
    }

    @Override
    public Page<UserItemResponse> getAllPaged(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::entityToItemResponse);
    }

    @Override
    public UserResponse getById(Long id) {
        User user = findById(id);
        return userMapper.entityToResponse(user);
    }

    @Override
    public Long post(CreateUserRequest request) {
        User newUser = userMapper.createRequestToEntity(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(newUser);
        return savedUser.getId();
    }

    @Override
    public void patch(Long id, UserRequest data) {
        User user = findById(id);

        if (nonNull(data.getPassword())) {
            user.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        if (nonNull(data.getPreferredUnits())) {
            user.setPreferredUnits(data.getPreferredUnits());
        }
        if (nonNull(data.getGroceriesList())) {
            user.getGroceriesList().clear();
            data.getGroceriesList().forEach(recipeIngredientId -> {
                RecipeIngredient recipeIngredient = findRecipeIngredientById(recipeIngredientId);
                user.getGroceriesList().add(recipeIngredient);
            });
        }
        if (nonNull(data.getDietaryRestrictions())) {
            user.getDietaryRestrictions().clear();
            data.getDietaryRestrictions().forEach(dietaryRestrictionId -> {
                DietaryRestriction dietaryRestriction = findDietaryRestrictionById(dietaryRestrictionId);
                user.getDietaryRestrictions().add(dietaryRestriction);
            });
        }
        if (nonNull(data.getSavedDishes())) {
            user.getSavedDishes().clear();
            data.getSavedDishes().forEach(savedDishId -> {
                try {
                    Dish dish = dishService.findById(savedDishId);
                    user.getSavedDishes().add(dish);
                }
                catch (Exception e) {
                    throw new BadRequestException("Dish not found");
                }
            });
        }
        if (nonNull(data.getHomeIngredients())) {
            user.getHomeIngredients().clear();
            data.getHomeIngredients().forEach(ingredientId -> {
                try {
                    Ingredient ingredient = ingredientService.findById(ingredientId);
                    user.getHomeIngredients().add(ingredient);
                }
                catch (Exception e) {
                    throw new BadRequestException("Ingredient not found");
                }
            });
        }
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    private User findById(Long id) {
        return userRepository.findByIdWithCollections(id).orElseThrow(NotFoundException::new);
    }

    private RecipeIngredient findRecipeIngredientById(Long id) {
        return recipeIngredientRepository.findById(id).orElseThrow(() -> new BadRequestException("Recipe ingredient not found"));
    }

    private DietaryRestriction findDietaryRestrictionById(Long id) {
        return dietaryRestrictionRepository.findById(id).orElseThrow(() -> new BadRequestException("Dietary restriction not found"));
    }
}
