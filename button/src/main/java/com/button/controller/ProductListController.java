package com.button.controller;

import com.button.model.entity.ProductList;
import com.button.model.repo.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/product_lists")
public class ProductListController {
    @Autowired
    ProductListRepository productListRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewProductList(@RequestParam String name) {
        ProductList productList = new ProductList();
        productList.setName(name);
        productListRepository.save(productList);

        return "Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<ProductList> getAllProductList() {
        return productListRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<ProductList> getProductListById(@PathVariable Integer id) {
        return productListRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteProductListById(@PathVariable Integer id) {
        productListRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}/rename")
    public @ResponseBody
    String renameExistingList(@PathVariable Integer id, @RequestParam String name) {
        ProductList productList = productListRepository.findById(id).get();
        productList.setName(name);
        productListRepository.save(productList);

        return "existing list under id = " + id + " renamed with a new name: " + name;
    }
}
