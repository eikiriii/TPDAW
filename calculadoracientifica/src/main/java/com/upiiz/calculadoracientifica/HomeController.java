package com.upiiz.calculadoracientifica;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "index"; // This should match the name of your HTML file in the templates directory
    }
}
