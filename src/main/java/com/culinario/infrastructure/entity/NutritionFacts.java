package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_dish_nutrition_facts")
public class NutritionFacts extends BaseEntity<Long> {

    @Column(nullable = false)
    private Integer calories;

    @OneToOne(mappedBy = "nutritionFacts", cascade = ALL, orphanRemoval = true)
    private Dish dish;

}
