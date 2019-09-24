package com.tangami.controller;

import com.tangami.dto.ProductListResponse;
import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.exception.InsufficientAmountException;
import com.tangami.service.ProductServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;


@RestController
@RequestMapping(value = "/nami/tango")
@Log
public class TangamiController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addProduct")
    //Recibe un producto y lo agrega a la base, el control de los productos repetidos estara en la ui
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest product) {
        ProductResponse response = productService.addProduct(product);
        return new ResponseEntity<>(response, response.getStatusCod());
    }

    @PostMapping("/sellProduct")
    //Recibe un producto y le resta a la cantidad existente, la cantidad vendida. El control para no vender un producto que no se tiene
    //va a estar controlado por la pantalla Venta, que va a recuperar los items disponibles para la venta desde un metodo que solo trae
    // los items vendibles y te va a permitir vender como maximo la cantidad recuperada
    public ResponseEntity<ProductResponse> sellProduct(@RequestBody ProductRequest product) {
        try{
            ProductResponse response = productService.sellProduct(product);
            return new ResponseEntity<>(response, response.getStatusCod());
        }catch (InsufficientAmountException e){
            log.log(Level.SEVERE, e.getMessage());
            throw e;
        }
    }

    @GetMapping("/allProducts")
    //Obtiene todos los productos, este metodo se penso para popular los dataLists del frontend
    public ResponseEntity<ProductListResponse> allProducts() {
        ProductListResponse response = productService.getAllProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/sellableProducts")
    //Obtiene todos los productos que se pueden vender, es decir, los que tienen stock
    public ResponseEntity<ProductListResponse> sellableProducts() {
        ProductListResponse response = productService.getSellableProducts();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/productAmount")
    //Este metodo se penso para agregar una cantdad determinada de productos, pensando en una compra grande a un mayorista por ejemplo
    public ResponseEntity<ProductResponse> productAmount(@RequestBody ProductRequest product) {
        ProductResponse response = productService.setProductAmount(product);
        return new ResponseEntity<>(response, response.getStatusCod());
    }

}
