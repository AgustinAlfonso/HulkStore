package com.tangami.controller;

import com.tangami.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/nami/tango")
public class TangamiController {

    @Autowired
    private ProductServiceImpl itemService;

    @GetMapping(value = "/getProductAmount/{id}")
    public String getProduct(@PathVariable String id){
        return "";
    }

    @PostMapping(value = "/addProduct/{id}")
    public String createProduct(@PathVariable String id) {
        return "BUENA VIEJO " + id;
    }
}
