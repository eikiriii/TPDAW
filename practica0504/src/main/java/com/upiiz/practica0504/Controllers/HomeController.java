package com.upiiz.practica0504.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

        @GetMapping
        public String home(){
            return "index";
        }
        @GetMapping("/contacto")
        public String registro(){
            return "contacto";
        }
        @GetMapping("/portafolio")
        public String informacion(){
            return "portafolio"; 
        }
}
