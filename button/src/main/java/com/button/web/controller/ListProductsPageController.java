package com.button.web.controller;

import com.button.model.ProductList;
import com.button.model.ProductProperty;
import com.button.model.ProductPropertyRepository;
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

    @GetMapping("/{list_id}")
    public String ListProductsPage(Model model, @PathVariable("list_id") Integer listId) {
//        Iterable<ProductProperty> listProducts = productPropertyRepository.findAllById(Arrays.asList(id));
        Iterable<ProductProperty> listProducts = productPropertyRepository.findProductsByProductListId(listId);
        model.addAttribute("listProducts", listProducts);
        return "list_products";
    }
}
