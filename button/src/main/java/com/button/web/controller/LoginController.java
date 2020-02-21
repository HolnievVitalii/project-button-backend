package com.button.web.controller;

import com.button.model.entity.User;
import com.button.model.repo.UserRepository;
import com.button.repr.UserRepr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage(ModelMap model) {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRepr());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") @Valid UserRepr userRepr, BindingResult result) {

        if (userRepository.findUserByLogin(userRepr.getLogin()) != null) {
            result.rejectValue("login", "", "Пользователь с таким логином уже существует");
            return "register";
        }

        if (result.hasErrors()) {
            return "register";
        }

        if (!userRepr.getPass().equals(userRepr.getMatchingPass())) {
            result.rejectValue("pass", "", "Пароли не совпадают");
            return "register";
        }

        User user = new User();
        user.setLogin(userRepr.getLogin());
        user.setPass(userRepr.getPass());
        user.setName(userRepr.getName());
        user.setSurname(userRepr.getSurname());
        user.setDisabled(false);

        userRepository.save(user);

        Authentication authToken = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPass());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        return "redirect:/";
    }
}

