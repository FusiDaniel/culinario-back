package com.culinario.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "tb_role",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_TB_ROLE_AUTHORITY", columnNames = { "authority" })
        }
)
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity<Long> {

    @Column(nullable = false, unique = true)
    private String authority;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
