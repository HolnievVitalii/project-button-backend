package com.button.web.controller;

import com.button.model.entity.ProductList;
import com.button.model.entity.User;
import com.button.model.repo.ProductListRepository;
import com.button.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController {
    @Autowired
    ProductListRepository productListRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String index(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        Iterable<ProductList> productLists = new ArrayList<>();

        if (!auth.getName().equals("anonymousUser")) {
            user = userRepository.findUserByLogin(auth.getName());
            productLists = productListRepository.findProductListByUserId(user.getId());
        }

        model.addAttribute("productLists", productLists);
        model.addAttribute("user", user);

        return "index";
    }
}
