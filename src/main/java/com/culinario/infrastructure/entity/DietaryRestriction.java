package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_dietary_restriction")
public class DietaryRestriction extends BaseEntity<Long> {

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "dietaryRestrictions")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "dietaryRestrictions")
    private Set<Ingredient> ingredients = new HashSet<>();

}
