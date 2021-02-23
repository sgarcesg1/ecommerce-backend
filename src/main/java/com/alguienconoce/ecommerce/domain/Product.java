package com.alguienconoce.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    private String name;
    private String description;
    private String category;

    @ElementCollection
    @Fetch(FetchMode.SELECT)
    private List<String> tags;

    //relationships:
    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    @MapKey(name = "plan")
    private Map<String, ProductPlan> plans;

    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private List<ProductImage> images;

}
