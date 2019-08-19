package com.tangami.h2;

import java.util.List;

import com.tangami.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findAll();

    public Product findProductByProductTypeAndProductName(String productType, String productName);

    public List<Product> findProductByAmountGreaterThan(int amount);
}
