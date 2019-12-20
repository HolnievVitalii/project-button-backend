package com.button.web.controller;

import com.button.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/list_products")
public class ListProductsPageController {
    @Autowired
    private ProductPropertyRepository productPropertyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductListRepository productListRepository;

    @GetMapping("/{list_id}")
    public String listProductsPage(Model model, @PathVariable("list_id") Integer listId) {
        Iterable<ProductProperty> listProducts = productPropertyRepository.findProductsByProductListId(listId);
        model.addAttribute("list_id", listId);
        model.addAttribute("listProducts", listProducts);
        return "list_products";
    }

    @GetMapping("/{list_id}/add_product")
    public String addProductPage(Model model, @PathVariable("list_id") Integer listId) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("new_product", new Product());
        model.addAttribute("list", listId);
        return "add_product";
    }
}
