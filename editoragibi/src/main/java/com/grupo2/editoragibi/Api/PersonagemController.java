package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Service.Domain.Personagem;
<<<<<<< HEAD
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> f2e5813 (crud de escritor e personagem)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens/")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/{id}")
<<<<<<< HEAD
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

        return new ResponseEntity<>(personagemService.getPersonagens(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
=======
    public Personagem getPersonagemById(@PathVariable int id) {

        return personagemService.getPersonagemById(id);
    }

    @GetMapping("/all")
    public List<Personagem> getPersonagens() {

        return personagemService.getPersonagens();
    }

    @PostMapping("/create")
    public Personagem addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
>>>>>>> f2e5813 (crud de escritor e personagem)
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.addPersonagem(personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
<<<<<<< HEAD
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(personagemToReturn, HttpStatus.OK);
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
=======
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
>>>>>>> f2e5813 (crud de escritor e personagem)
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.updatePersonagem(id, personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
<<<<<<< HEAD
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(personagemToReturn, HttpStatus.OK);
=======
            // TODO
            System.out.println(e.toString());
        }
        return personagemToReturn;
>>>>>>> f2e5813 (crud de escritor e personagem)
    }
}
