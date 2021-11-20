package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Service.DesenhistaService;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DesenhistaController {

    @Autowired
    DesenhistaService desenhistaService;

    @GetMapping("/{id}")
    public Desenhista getDesenhistaById(@PathVariable int id) {

        return desenhistaService.getDesenhistaById(id);
    }

    @PostMapping
    public Desenhista addDesenhista(@RequestBody Desenhista desenhista) {

        return desenhistaService.addDesenhista(desenhista);
    }
}
