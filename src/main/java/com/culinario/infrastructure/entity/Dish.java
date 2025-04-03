package com.culinario.infrastructure.entity;

import com.culinario.infrastructure.converter.DishCategoryListConverter;
import com.culinario.infrastructure.enums.DishCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_dish")
public class Dish extends BaseEntity<Long> {

    @Column(nullable = false)
    private String name;

    @Column(length = 2000, nullable = false)
    private String instructions;

    @Convert(converter = DishCategoryListConverter.class)
    @Column(length = 1000)
    private List<DishCategory> categories;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "nutrition_facts_id")
    private NutritionFacts nutritionFacts;

    @Column(nullable = false)
    private Integer cookTime;

    @Column(nullable = false)
    private Integer prepTime;

    @Column
    private String imageFile;

    @OneToMany(mappedBy = "dish", cascade = ALL, fetch = EAGER, orphanRemoval = true)
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    @ManyToMany(mappedBy = "savedDishes")
    private List<User> users;

}
