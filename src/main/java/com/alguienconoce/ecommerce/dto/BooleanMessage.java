package com.alguienconoce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BooleanMessage implements Serializable {

    private final static BooleanMessage ok = BooleanMessage.builder().success(true).build();

    private final static BooleanMessage fail = BooleanMessage.builder().success(false).build();

    private static final long serialVersionUID = 8408449391756178249L;

    private boolean success;

    public static BooleanMessage ok() {
        return ok;
    }

    public static BooleanMessage fail() {
        return fail;
    }
}
