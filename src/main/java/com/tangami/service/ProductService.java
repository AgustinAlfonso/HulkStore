package com.tangami.service;

import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.dto.ProductListResponse;

import java.util.List;

public interface ProductService {

    public ProductListResponse getAllProducts();

    public ProductResponse addProduct(ProductRequest product);

    public ProductListResponse getSellableProducts();

    public ProductResponse sellProduct(ProductRequest product);

    public ProductResponse setProductAmount (ProductRequest product);
}
