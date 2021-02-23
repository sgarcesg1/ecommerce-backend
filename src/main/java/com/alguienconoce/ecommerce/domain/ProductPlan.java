package com.alguienconoce.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductPlan extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Plan plan;
    private Integer price;
    private String description;
    private String deliveryTime;

    @Column(insertable=false, updatable=false)
    private UUID productId;

    public enum Plan {
        BASIC, STANDARD, PREMIUM
    }
}
