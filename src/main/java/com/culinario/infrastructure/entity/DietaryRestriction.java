package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tb_dietary_restriction")
public class DietaryRestriction extends BaseEntity<Long> {

    @Column
    private String name;

    @ManyToMany(mappedBy = "dietaryRestrictions")
    private List<User> users;

    @ManyToMany(mappedBy = "dietaryRestrictions")
    private List<Ingredient> ingredients;

}
