package com.button.controller;

import com.button.model.ProductProperties;
import com.button.model.ProductPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product_properties")
public class ProductPropertiesController {
    @Autowired
    private ProductPropertiesRepository productPropertiesRepository;


    @GetMapping
    public @ResponseBody
    Iterable<ProductProperties> getAllProducts() {
        return productPropertiesRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Iterable<ProductProperties> getProductInList(@PathVariable Integer id){

        List tempRepo = new ArrayList();

        for (ProductProperties item: productPropertiesRepository.findAll()
             ) {
            if (item.getProduct_list_id() == id){
                tempRepo.add(item);
            }
        }
        return tempRepo;
    }
}