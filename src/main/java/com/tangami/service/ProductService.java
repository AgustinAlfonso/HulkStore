package com.tangami.service;

import com.tangami.h2.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getItemsById(Long id);


}
