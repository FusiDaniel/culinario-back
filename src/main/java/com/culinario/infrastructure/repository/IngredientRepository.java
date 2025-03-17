package com.culinario.infrastructure.repository;

import com.culinario.infrastructure.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
