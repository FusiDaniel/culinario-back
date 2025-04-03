package com.culinario.infrastructure.repository;

import com.culinario.infrastructure.entity.DietaryRestriction;
import com.culinario.infrastructure.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaryRestrictionRepository extends JpaRepository<DietaryRestriction, Long>  {
}
