package com.culinario.application.ingredient.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class IngredientRequest {

    @NotBlank
    @Size(max = 255, message = "name must have 255 characters at max")
    private String name;

    @NotBlank
    @Size(max = 255, message = "type must have 255 characters at max")
    private String type;

}
