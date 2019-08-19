package com.tangami.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private String productName;

    private String productType;

    private Integer amount;

}
