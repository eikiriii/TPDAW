package com.upiiz.segundoparcial.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.upiiz.segundoparcial.Models.PublicacionesModel;
import com.upiiz.segundoparcial.Services.PublicacionesService;

@Controller
public class PublicacionesController {

    @Autowired
    private PublicacionesService publicacionesService;  
    
    @GetMapping("/")
    public String index() {
        return "listado-publicaciones"; 
    }

    @GetMapping("/publicaciones")
    public String publicaciones(Model model) {
        List<PublicacionesModel> publicaciones = publicacionesService.findAll();
        model.addAttribute("publicaciones", publicaciones);
        return "listado-publicaciones";
    }

    @GetMapping("/publicaciones/agregar")
    public String agregarPublicacion(Model model) {
        PublicacionesModel publicaciones = new PublicacionesModel();
        model.addAttribute("publicaciones", publicaciones);
        return "Agregar"; 
    }
    @PostMapping("/publicaciones/guardar")
    public String guardarPublicacion(PublicacionesModel publicaciones) {
        publicacionesService.save(publicaciones);
        return "redirect:/publicaciones"; 
    }
    @GetMapping("/publicaciones/editar/{id}")
    public String editarPublicacion(@PathVariable("id") int id, Model model) {
        PublicacionesModel publicaciones = publicacionesService.findById(id);
        model.addAttribute("publicaciones", publicaciones);
        return "editar";
    }

    @PostMapping("/publicaciones/actualizar")
    public String actualizarPublicacion(PublicacionesModel publicaciones) {
        publicacionesService.update(publicaciones);
        return "redirect:/publicaciones"; 
    }

    @GetMapping("/publicaciones/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable("id") int id) {
        publicacionesService.deleteById(id);
        return "redirect:/publicaciones"; 
    }

}
