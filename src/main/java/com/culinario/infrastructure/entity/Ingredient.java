package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_ingredient")
public class Ingredient extends BaseEntity<Long> {

    @Column
    private String name;

    @Column
    private String type;

    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany
    @JoinTable(
            name = "tb_ingredient_dietary_restriction",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "dietary_restriction_id")
    )
    private List<DietaryRestriction> dietaryRestrictions;

    @ManyToMany(mappedBy = "homeIngredients")
    private List<User> users;

}
