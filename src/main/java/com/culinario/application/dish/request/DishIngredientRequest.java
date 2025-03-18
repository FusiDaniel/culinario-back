package com.culinario.application.dish.request;

import jakarta.validation.constraints.NotNull;
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
public class DishIngredientRequest {

    @NotNull
    private Long id;

    @NotNull
    private Integer amount;

}
