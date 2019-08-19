package com.tangami.controller;

import com.tangami.dto.ProductListResponse;
import com.tangami.dto.ProductRequest;
import com.tangami.dto.ProductResponse;
import com.tangami.exception.InsufficientAmountException;
import com.tangami.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/nami/tango")
public class TangamiController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addProduct")
    //Recibe un producto y lo agrega a la base, el control de los productos repetidos estara en la ui
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest product) {
        ProductResponse response = productService.addProduct(product);
        ResponseEntity<ProductResponse> productResponseResponseEntity = new ResponseEntity<>(response, response.getStatusCod());
        return productResponseResponseEntity;
    }

    @PostMapping("/sellProduct")
    //Recibe un producto y le resta a la cantidad existente, la cantidad vendida. El control para no vender un producto que no se tiene
    //va a estar controlado por la pantalla Venta, que va a recuperar los items disponibles para la venta desde un metodo que solo trae
    // los items vendibles y te va a permitir vender como maximo la cantidad recuperada
    public ResponseEntity<ProductResponse> sellProduct(@RequestBody ProductRequest product) {
        try{
            ProductResponse response = productService.sellProduct(product);
            return new ResponseEntity<ProductResponse>(response, response.getStatusCod());
        }catch (InsufficientAmountException e){
            throw e;
        }
    }

    @GetMapping("/getAllProducts")
    //Obtiene todos los productos, este metodo se penso para popular los dataLists del frontend
    public ResponseEntity<ProductListResponse> getAllProducts() {
        ProductListResponse response = productService.getAllProducts();
        return new ResponseEntity<ProductListResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/getSellableProducts")
    //Obtiene todos los productos que se pueden vender, es decir, los que tienen stock
    public ResponseEntity<ProductListResponse> getSellableProducts() {
        ProductListResponse response = productService.getSellableProducts();
        return new ResponseEntity<ProductListResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/setProductAmount")
    //Este metodo se penso para agregar una cantdad determinada de productos, pensando en una compra grande a un mayorista por ejemplo
    public ResponseEntity<ProductResponse> setProductAmount(@RequestBody ProductRequest product) {
        ProductResponse response = productService.setProductAmount(product);
        return new ResponseEntity<ProductResponse>(response, response.getStatusCod());
    }

}
