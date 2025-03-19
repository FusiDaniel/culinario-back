package com.culinario.application.dish.response;

import com.culinario.application.ingredient.response.IngredientResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientResponse {
    private Long id;
    private Integer amount;
    private IngredientResponse ingredient;
}
