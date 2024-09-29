package com.stockbooster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSignUpController {
    @GetMapping("/login")
    public String DisplayHomePage() {
        return "login";
    }
}
