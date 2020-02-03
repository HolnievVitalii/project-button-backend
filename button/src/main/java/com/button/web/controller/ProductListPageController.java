package com.button.web.controller;

import com.button.model.entity.ProductList;
import com.button.model.entity.User;
import com.button.model.entity.Users_ProductList;
import com.button.model.repo.ProductListRepository;
import com.button.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product_list")
public class ProductListPageController {
    @Autowired
    ProductListRepository productListRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/new")
    public String addNewProductListPage(Model model) {
        model.addAttribute("product_list", new ProductList());
        return "new_product_list";
    }

    @PostMapping("/new")
    public String addNewProductList(@ModelAttribute("product_list") @Valid ProductList productList) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!auth.getName().equals("anonymousUser")) {
            User user = userRepository.findUserByLogin(auth.getName());
            productList.addUser(user);
            productListRepository.save(productList);
        }

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductListPage(@PathVariable Integer id) {
        productListRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/share/{productListId}")
    public String shareProductListPage(Model model, @PathVariable Integer productListId) {
        ProductList productList = productListRepository.findById(productListId).get();
        List<Users_ProductList> users_productListList = productList.getProductListUsers();
        List<User> userList = new ArrayList<>();
        for (Users_ProductList upl: users_productListList) {
            userList.add(upl.getUser());
        }

        model.addAttribute("userList", userList);
        model.addAttribute("productList", productList);

        User user = new User();
        model.addAttribute("user", user);

        return "share";
    }

    @PostMapping("/share/{productListId}")
    public String shareProductList(@ModelAttribute("user") User user, @PathVariable Integer productListId) {
        ProductList productList = productListRepository.findById(productListId).get();

        user = userRepository.findUserByLogin(user.getLogin());
        if (user != null) {
            User user2 = userRepository.findUserByLogin(user.getLogin());
            productList.addUser(user2);
            System.out.println(user2.getId());
            productListRepository.save(productList);
        }

        return "redirect:/product_list/share/" + productListId;
    }
}
