package com.upiiz.likes_ajax.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.likes_ajax.Models.Likes;
import com.upiiz.likes_ajax.Services.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeRestController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public Likes obtenerLikes() {
        return likeService.obtenerLikes();
    }

    @PostMapping("/{imagen}")
    public Likes aumentarLike(@PathVariable int imagen) {
        likeService.aumentarLike(imagen);
        return likeService.obtenerLikes();
    }

    @GetMapping("/{imagen}")
    public int obtenerLikePorImagen(@PathVariable int imagen) {
        Likes l = likeService.obtenerLikes();
        return switch (imagen) {
            case 1 -> l.getImagen1();
            case 2 -> l.getImagen2();
            case 3 -> l.getImagen3();
            default -> 0;
        };
    }
}
