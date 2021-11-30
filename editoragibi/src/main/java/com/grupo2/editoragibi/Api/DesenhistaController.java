package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Service.DesenhistaService;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DesenhistaController {

    @Autowired
    DesenhistaService desenhistaService;

    //somente para teste
    @GetMapping("/testando")
    public String testar() {
        return "Está tudo certo";
    }

    @GetMapping("/{id}")
    public Desenhista getDesenhistaById(@PathVariable int id) {

        return desenhistaService.getDesenhistaById(id);
    }

    @GetMapping("/desenhistas")
    public List<Desenhista> getDesenhistas() {

        return desenhistaService.getDesenhistas();
    }

    @PostMapping("/desenhista/create")
    public Desenhista addDesenhista(@RequestBody Desenhista desenhista) {

        return desenhistaService.addDesenhista(desenhista);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDesenhista(@PathVariable Integer id) {

        return desenhistaService.deleteDesenhista(id);
    }

    @PutMapping("/update/{id}")
    public void updateDesenhista(@PathVariable int id, @RequestBody Desenhista desenhista){
        desenhistaService.updateDesenhista(id, desenhista);
    }
}
