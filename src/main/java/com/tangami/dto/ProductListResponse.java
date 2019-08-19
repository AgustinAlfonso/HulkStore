package com.tangami.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ProductListResponse extends ResponseBase {

    private List<ProductResponse> productList;

    @Builder
    public ProductListResponse(HttpStatus errorcod, String errordes, List<ProductResponse> productList) {
        super(errorcod, errordes);
        this.productList = productList;
    }

}