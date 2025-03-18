package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_recipe_ingredient")
public class RecipeIngredient extends BaseEntity<Long> {

    @Column(nullable = false)
    Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @ManyToMany(mappedBy = "groceriesList")
    private List<User> users;

}
