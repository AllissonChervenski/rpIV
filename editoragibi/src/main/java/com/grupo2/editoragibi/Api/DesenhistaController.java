package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Service.DesenhistaService;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desenhistas/")
public class DesenhistaController {

    @Autowired
    DesenhistaService desenhistaService;

    @GetMapping("/{id}")
    public Desenhista getDesenhistaById(@PathVariable int id) {

        return desenhistaService.getDesenhistaById(id);
    }

    @GetMapping("/all")
    public List<Desenhista> getDesenhistas() {

        return desenhistaService.getDesenhistas();
    }

    @PostMapping("/create")
    public Desenhista addDesenhista(@RequestBody Desenhista desenhista) {

        return desenhistaService.addDesenhista(desenhista);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDesenhista(@PathVariable Integer id) {

        return desenhistaService.deleteDesenhista(id);
    }

    @PutMapping("/update/{id}")
    public Desenhista updateDesenhista(@PathVariable int id, @RequestBody Desenhista desenhista){
        return desenhistaService.updateDesenhista(id, desenhista);
    }
}
