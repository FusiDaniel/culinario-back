package com.culinario.application.dish.response;

import com.culinario.infrastructure.enums.DishCategory;
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
public class DishResponse {
    private Long id;
    private String name;
    private String instructions;
    private List<RecipeIngredientResponse> ingredients;
    private NutritionFactsResponse nutritionFacts;
    private List<DishCategory> categories;
    private Integer cookTime;
    private Integer prepTime;
    private String imageFile;
}
