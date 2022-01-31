package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens/")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonagemById(@PathVariable int id) {

        Personagem personagem = null;

        try {
            personagem = personagemService.getPersonagemById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(personagem, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getPersonagens() {

        List<Personagem> personagens = null;
        try {
            personagens = personagemService.getPersonagens();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(personagens, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
        Personagem personagem = null;

        try {
            personagem = personagemService.addPersonagem(personagemRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(personagem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePersonagem(@PathVariable int id) {

         try {
             personagemService.deletePersonagem(id);
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         }

         return ResponseEntity.status(HttpStatus.OK).body("Escritor excluido");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePersonagem(@PathVariable int id, @RequestBody PersonagemRequest personagemRequest) {
        Personagem personagem = null;
        try {
            personagem = personagemService.updatePersonagem(id, personagemRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(personagem, HttpStatus.OK);
    }
}
