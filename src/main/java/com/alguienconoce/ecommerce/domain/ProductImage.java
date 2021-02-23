package com.alguienconoce.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage extends BaseEntity {
    private String medium;
    private String large;
    private String original;

    @Column(insertable=false, updatable=false)
    private UUID productId;
}
