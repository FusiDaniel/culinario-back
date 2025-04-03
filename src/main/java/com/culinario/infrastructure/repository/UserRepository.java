package com.culinario.infrastructure.repository;

import com.culinario.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.savedDishes sd " +
            "LEFT JOIN FETCH sd.recipeIngredients " +
            "LEFT JOIN FETCH u.dietaryRestrictions " +
            "LEFT JOIN FETCH u.homeIngredients " +
            "LEFT JOIN FETCH u.groceriesList " +
            "WHERE u.email = :email")
    Optional<User> findByEmailWithCollections(@Param("email") String email);

    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.savedDishes sd " +
            "LEFT JOIN FETCH sd.recipeIngredients " +
            "LEFT JOIN FETCH u.dietaryRestrictions " +
            "LEFT JOIN FETCH u.homeIngredients " +
            "LEFT JOIN FETCH u.groceriesList " +
            "WHERE u.id = :id")
    Optional<User> findByIdWithCollections(@Param("id") Long id);
}
