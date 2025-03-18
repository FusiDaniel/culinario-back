package com.culinario.infrastructure.repository;

import com.culinario.infrastructure.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
