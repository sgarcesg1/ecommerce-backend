package com.alguienconoce.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String username;
}
