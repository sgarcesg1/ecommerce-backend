package com.alguienconoce.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private UUID id;

    @NotNull
    @CreatedBy
    @JsonIgnore
    private UUID createdBy;

    @CreatedDate
    private LocalDateTime createdOn;

    @LastModifiedBy
    @JsonIgnore
    private UUID updatedBy;

    @LastModifiedDate
    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreation() {
        id = UUID.randomUUID();
    }

}
