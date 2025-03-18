package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity<Long> {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private List<String> preferredUnits;

    @ManyToMany
    @JoinTable(
            name = "tb_user_dish",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> savedDishes;

    @ManyToMany
    @JoinTable(
            name = "tb_user_dietary_restriction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dietary_restriction_id")
    )
    private List<DietaryRestriction> dietaryRestrictions;

    @ManyToMany
    @JoinTable(
            name = "tb_user_ingredient",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> homeIngredients;

    @ManyToMany
    @JoinTable(
            name = "tb_user_groceries_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_ingredient_id")
    )
    private List<RecipeIngredient> groceriesList;

}
