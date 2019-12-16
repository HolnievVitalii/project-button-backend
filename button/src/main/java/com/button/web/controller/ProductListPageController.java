package com.button.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/new_product_list")
public class ProductListPageController {
    @GetMapping
    public String newProductListPage() {
        return "new_product_list";
    }
}
