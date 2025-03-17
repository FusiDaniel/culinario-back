package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
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
    @Builder.Default
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tb_ingredient_dietary_restriction",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "dietary_restriction_id")
    )

    @Builder.Default
    private List<DietaryRestriction> dietaryRestrictions = new ArrayList<>();

    @ManyToMany(mappedBy = "homeIngredients")
    @Builder.Default
    private List<User> users = new ArrayList<>();

}
