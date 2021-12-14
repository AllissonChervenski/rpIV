package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.PersonagemRequest;
import com.grupo2.editoragibi.Service.Domain.Personagem;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import com.grupo2.editoragibi.Service.PersonagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens/")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/{id}")
<<<<<<< HEAD
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
=======
    public ResponseEntity<Object> getPersonagemById(@PathVariable int id) {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

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
<<<<<<< HEAD
    public Personagem addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public ResponseEntity<Object> addPersonagem(@RequestBody PersonagemRequest personagemRequest) throws Exception {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.addPersonagem(personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
<<<<<<< HEAD
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
=======
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
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
<<<<<<< HEAD
    public Personagem updatePersonagem(@PathVariable int id, @RequestBody PersonagemRequest personagemRequest) {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public ResponseEntity<Object> updatePersonagem(@PathVariable int id, @RequestBody PersonagemRequest personagemRequest) {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
        Personagem personagem = new Personagem();

        BeanUtils.copyProperties(personagemRequest, personagem);

        Personagem personagemToReturn = null;
        try {
            personagemToReturn = personagemService.updatePersonagem(id, personagem, personagemRequest.getEscritoresIds());
        } catch (Exception e) {
<<<<<<< HEAD
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
=======
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(personagemToReturn, HttpStatus.OK);
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
    }
}
