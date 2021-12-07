package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens/")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/{id}")
    public Personagem getPersonagemById(@PathVariable int id) {

        return personagemService.getPersonagemById(id);
    }

    @GetMapping("/all")
    public List<Personagem> getPersonagens() {

        return personagemService.getPersonagens();
    }

    @PostMapping("/create")
    public Personagem addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.addPersonagem(personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
            // TODO
        }
        return personagemToReturn;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePersonagem(@PathVariable int id) {

        return personagemService.deletePersonagem(id);
    }

    @PutMapping("/update/{id}")
    public Personagem updatePersonagem(@PathVariable int id, @RequestBody PersonagemRequest personagemRequest) {
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.updatePersonagem(id, personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
            // TODO
            System.out.println(e.toString());
        }
        return personagemToReturn;
    }
}
