package com.tangami.h2.init;

import com.tangami.h2.dao.ProductDAO;
import com.tangami.h2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {

    private ProductDAO productDAO;

    @Autowired
    public DataInit(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void run(ApplicationArguments args) throws Exception {
        long count = productDAO.count();

        if (count == 0) {
            List<Product> lista = new ArrayList<Product>();
            lista.add(Product.builder().productName("Comic Iron Man").amount(10).productType("Comic").build());
            lista.add(Product.builder().productName("Figura Spiderman").amount(3).productType("Figura de Accion").build());
            lista.add(Product.builder().productName("Disfraz de Thor").amount(4).productType("Disfraz").build());
            lista.add(Product.builder().productName("Comic Capitan Barato").amount(6).productType("Comic").build());
            lista.add(Product.builder().productName("Taza Batman").amount(10).productType("Taza").build());
            lista.add(Product.builder().productName("Trading Card Pokemon").amount(151).productType("Trading Card").build());
            lista.add(Product.builder().productName("Manga Dragon Ball Z").amount(8).productType("Comic").build());
            lista.add(Product.builder().productName("Comic Liga de la Justicia").amount(10).productType("Comic").build());
            lista.add(Product.builder().productName("Comic Aquaman").amount(10).productType("Comic").build());
            lista.add(Product.builder().productName("Comic Hijitus").amount(10).productType("Comic").build());
            lista.add(Product.builder().productName("Disfraz Chapulin Colorado").amount(10).productType("Disfraz").build());
            for(Product p : lista){
                productDAO.save(p);
            }
        }

    }

}
