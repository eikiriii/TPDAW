package com.upiiz.buscador.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upiiz.buscador.models.BuscarModel;
import com.upiiz.buscador.services.BuscarService;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "*") 

public class BuscarController {
    
    @Autowired
    private BuscarService buscarService;

    @GetMapping("/suggestions")
    public List<BuscarModel> sugerencias(@RequestParam String query) {
        if (query.length() < 3) return List.of(); 
        return buscarService.buscarPorNombre(query);
}
}

