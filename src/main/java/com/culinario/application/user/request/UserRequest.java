package com.culinario.application.user.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Size(min = 8, max = 100, message = "password must have a minimum of 8 characters and a maximum of 100")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[^\\n]*$", message = "invalid password")
    private String password;

    private List<Long> dietaryRestrictions;

    private List<Long> savedDishes;

    private List<Long> groceriesList;

    private List<Long> homeIngredients;

    private List<@NotEmpty String> preferredUnits;

}
