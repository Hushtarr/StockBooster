package com.stockbooster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBordController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
