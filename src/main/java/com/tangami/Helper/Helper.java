package com.tangami.Helper;

import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.h2.ProductRepository;
import com.tangami.model.Product;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.logging.Level;


@Component
@Log
public class Helper {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse saveModifications (ProductRequest product){
        //Recibe un producto del tipo request, se fija si existe en la base ese mismo producto y de ser asi, actualiza la cantidad,
        // sino, agrega uno nuevo con dicha cantidad
        ProductResponse response = requestMapper(product);
        try{
            Product p = productRepository.findProductByProductTypeAndProductName(product.getProductType(),product.getProductName());
            if (p !=null){
                p.setAmount(product.getAmount()+p.getAmount());
                productRepository.save(p);
            }else
                productRepository.save(responseMapper(product));
            response.setErrorcod(HttpStatus.OK);
            response.setErrordes("Producto Modificado con Exito");
        }catch (Throwable e){
            log.log(Level.SEVERE, e.getMessage(), e);
            response.setErrorcod(HttpStatus.NOT_MODIFIED);
            response.setErrordes("No se pudieron guardar los cambios");
        }
        return response;
    }

    public Product responseMapper(ProductRequest product){
        //Mapea el tipo request a tipo modelo
        Product p = new Product();
        p.setAmount(product.getAmount());
        p.setProductName(product.getProductName());
        p.setProductType(product.getProductType());
        return p;
    }

    public ProductResponse requestMapper(ProductRequest product){
        //Mapea el tipo request a tipo response
        return ProductResponse.builder().
                productName(product.getProductName()).
                amount(product.getAmount()).
                productType(product.getProductType()).
                build();
    }

    public ProductResponse modelResponseMapper(Product product){
        //Mapea el tipo modelo al tipo response
        return ProductResponse.builder().
                productName(product.getProductName()).
                amount(product.getAmount()).
                productType(product.getProductType()).
                build();
    }

}
