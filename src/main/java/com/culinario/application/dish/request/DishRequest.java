package com.culinario.application.dish.request;

import com.culinario.infrastructure.enums.DishCategory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class DishRequest {

    @NotBlank
    @Size(max = 255, message = "name must have 255 characters at max")
    private String name;

    @NotNull
    private List<@Valid DishIngredientRequest> ingredients;

    @NotBlank
    @Size(max = 255, message = "name must have 2000 characters at max")
    private String instructions;

    @Valid
    private NutritionFactsRequest nutritionFacts;

    private List<DishCategory> dishCategories;

    @NotNull
    private Integer cookTime;

    @NotNull
    private Integer prepTime;

    private String imageFile;

}
