package com.culinario.application.user.response;

import com.culinario.application.dish.response.DishResponse;
import com.culinario.application.dish.response.RecipeIngredientResponse;
import com.culinario.application.ingredient.response.IngredientResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private List<String> preferredUnits;
    private List<DishResponse> savedDishes;
    private List<DietaryRestrictionResponse> dietaryRestrictions;
    private List<IngredientResponse> homeIngredients;
    private List<RecipeIngredientResponse> groceriesList;
}
