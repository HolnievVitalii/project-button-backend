package com.button.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping(path="/login")
    public String loginPage(ModelMap model) {
        return "login";
    }
}
