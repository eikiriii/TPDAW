package com.upiiz.likes_ajax.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.upiiz.likes_ajax.Models.Likes;
import com.upiiz.likes_ajax.Services.LikeService;

@Controller
public class HomeController {

    @Autowired
    private LikeService likeService;

    @GetMapping("/")
    public String home(Model model) {
        Likes datos = likeService.obtenerLikes();
        model.addAttribute("likes", datos);
        return "index";
    }
}
