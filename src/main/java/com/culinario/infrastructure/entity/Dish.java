package com.culinario.infrastructure.entity;

import com.culinario.infrastructure.enums.DishCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "tb_dish")
public class Dish extends BaseEntity<Long>{

    @Column(nullable = false)
    private String name;

    @Column(length = 2000, nullable = false)
    private String instructions;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DishCategory categories;

    @Column
    private String nutritionFacts;

    @Column(nullable = false)
    private Integer cookTime;

    @Column(nullable = false)
    private Integer prepTime;

    @Column
    private String imageFile;

    @OneToMany(mappedBy = "dish")
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany(mappedBy = "savedDishes")
    private List<User> users;

}
