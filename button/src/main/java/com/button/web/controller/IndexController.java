package com.button.web.controller;

import com.button.model.Product;
import com.button.model.ProductList;
import com.button.model.ProductListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController {
    ProductListRepository productListRepository;

    class ListRecord {
        public Integer id;
        public String name;
    }

    @GetMapping
    public String index(Model model) {
        List<ProductList> productLists = (List<ProductList>) productListRepository.findAll();
        List<ListRecord> lists= new ArrayList<>();

        for (ProductList pl : productLists) {
            ListRecord lr = new ListRecord();
            lr.id = pl.getId();
            lr.name = pl.getName();
        }
        model.addAttribute("lists", lists);

        return "index";
    }
}
