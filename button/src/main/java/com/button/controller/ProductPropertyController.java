package com.button.controller;

import com.button.model.Product;
import com.button.model.ProductProperty;
import com.button.model.ProductPropertyRepository;
import com.button.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/product_property")
public class ProductPropertyController {
    @Autowired
    private ProductPropertyRepository productPropertyRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    public ResponseEntity addNewProductProperty(@RequestBody ProductProperty productProperty) {
        if (productProperty.getProduct() == null || productProperty.getProductList() == null) {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

//        try {
//        Integer productId = productProperty.getProduct().getId();
//        if (productRepository.findById(productId).get() == null) {
//            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
//        }


        System.out.println(productProperty);

        productPropertyRepository.save(productProperty);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
