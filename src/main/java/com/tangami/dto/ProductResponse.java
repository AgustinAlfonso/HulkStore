package com.tangami.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class ProductResponse extends ResponseBase{

    private String productName;

    private String productType;

    private Integer amount;

    @Builder
    public ProductResponse(String productName, String productType, Integer amount, HttpStatus errorcod, String errordes) {
        super(errorcod,errordes);
        this.productName = productName;
        this.productType = productType;
        this.amount = amount;
    }
}
