package com.button.controller;

import com.button.model.ProductProperty;
import com.button.model.ProductPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product_property")
public class ProductPropertyController {
    @Autowired
    private ProductPropertyRepository productPropertyRepository;

    @PostMapping(path = "/add")
    public ResponseEntity addNewProductProperty(@RequestBody ProductProperty productProperty) {
        //System.out.println(productProperty);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
