package com.button.controller;

import com.button.model.Product;
import com.button.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewProduct(@RequestParam String name) {
        Product product = new Product();
        product.setName(name);
        productRepository.save(product);

        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    void deleteProductFromListById(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }
}
