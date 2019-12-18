package com.button.controller;

import com.button.model.Product;
import com.button.model.ProductProperty;
import com.button.model.ProductPropertyRepository;
import com.button.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity addNewProductProperty(@Valid @RequestBody ProductProperty productProperty) {

        if (productProperty.getProduct() == null || productProperty.getProductList() == null) {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        productPropertyRepository.save(productProperty);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
