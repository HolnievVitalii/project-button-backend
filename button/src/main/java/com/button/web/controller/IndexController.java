package com.button.web.controller;

import com.button.model.entity.ProductList;
import com.button.model.entity.User;
import com.button.model.repo.ProductListRepository;
import com.button.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController {
    @Autowired
    ProductListRepository productListRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String index(Model model, Principal principal) {
        Iterable<ProductList> productLists;
        User user = new User();

        if (principal != null) {
            user = userRepository.findUserByLogin(principal.getName());
        }

        productLists = productListRepository.findAll();
        model.addAttribute("productLists", productLists);
        model.addAttribute("user", user);

        return "index";
    }
}
