package com.tangami.service;


import com.tangami.Helper.Helper;
import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.dto.ProductListResponse;
import com.tangami.h2.ProductRepository;
import com.tangami.model.Product;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Component
@Log
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Helper helper;

    public ProductListResponse getAllProducts() {
        log.log(Level.INFO, "Obteniendo todos los productos");
        //Se obtienen todos los productos del tipo modelo y se mapean a una lista del tipo dto
        return ProductListResponse.builder().productList(productRepository.findAll()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.mapping((p) -> helper.modelResponseMapper(p), Collectors.toList())))
                .build();
    }

    public ProductListResponse getSellableProducts(){
        log.log(Level.INFO, "Obteniendo todos los productos vendibles");
        //Se obtienen todos los productos del tipo modelo cuya cantidad sea mayor que 0 y se mapean a una lista del tipo dto
        return ProductListResponse.builder().productList(productRepository.findProductByAmountGreaterThan(0)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.mapping((p) -> helper.modelResponseMapper(p), Collectors.toList())))
                .build();
    }

    public ProductResponse addProduct(ProductRequest product) {
        log.log(Level.INFO, "Guardando modificaciones de adquisicion de producto");
        return helper.saveModifications(product);
    }

    public ProductResponse sellProduct(ProductRequest product) {
        product.setAmount(-product.getAmount());
        log.log(Level.INFO, "Guardando modificaciones de venta de producto");
        return helper.saveModifications(product);
    }

    public ProductResponse setProductAmount(ProductRequest product) {
        log.log(Level.INFO, "Cambiando la cantidad de un producto");
        return helper.saveModifications(product);

    }


}
