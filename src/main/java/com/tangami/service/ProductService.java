package com.tangami.service;

import com.tangami.dto.ProductListResponse;
import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;

public interface ProductService {

    public ProductListResponse getAllProducts();

    public ProductResponse addProduct(ProductRequest product);

    public ProductListResponse getSellableProducts();

    public ProductResponse sellProduct(ProductRequest product);

    public ProductResponse setProductAmount (ProductRequest product);
}
