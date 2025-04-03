package com.culinario.infrastructure.repository;

import com.culinario.infrastructure.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long>  {
}
