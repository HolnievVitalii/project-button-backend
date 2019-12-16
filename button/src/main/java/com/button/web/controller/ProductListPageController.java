package com.button.web.controller;

import com.button.model.ProductList;
import com.button.model.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/product_list")
public class ProductListPageController {
    @Autowired
    ProductListRepository productListRepository;

    @GetMapping("/new")
    public String addNewProductListPage() {
        return "new_product_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductListPage(@PathVariable Integer id) {
        productListRepository.deleteById(id);
        return "redirect:/index";
    }
}
