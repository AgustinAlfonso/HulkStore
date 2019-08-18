package com.tangami.h2.dao;

import java.util.List;

import com.tangami.h2.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

    public List<Product> findProductById(Long id);

}
