package com.tangami.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ProductListResponse extends ResponseBase {

    private List<ProductResponse> productList;

    @Builder
    public ProductListResponse(HttpStatus statusCod, String statusDescription, List<ProductResponse> productList) {
        super(statusCod, statusDescription);
        this.productList = productList;
    }

}