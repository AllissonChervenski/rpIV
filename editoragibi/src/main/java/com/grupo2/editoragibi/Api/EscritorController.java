package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.EscritorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escritores")
public class EscritorController {

    @Autowired
    EscritorService escritorService;

    @GetMapping("/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<Object> getEscritorById(@PathVariable int id) {

        Escritor escritor = null;

        try {
            escritor = escritorService.getEscritorById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritor, HttpStatus.OK);
=======
    public Escritor getEscritorById(@PathVariable int id) {

        return escritorService.getEscritorById(id);
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public ResponseEntity<Object> getEscritorById(@PathVariable int id) {

        Escritor escritor = null;

        try {
            escritor = escritorService.getEscritorById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritor, HttpStatus.OK);
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
    }

    @GetMapping("/all")
    public List<Escritor> getEscritores() {

        return escritorService.getEscritores();
    }

    @PostMapping("/create")
    public Escritor addEscritor(@RequestBody EscritorRequest escritorRequest) {

        Escritor escritor = new Escritor();

        BeanUtils.copyProperties(escritorRequest, escritor);

        Escritor escritorToReturn = escritorService.addEscritor(escritor);

        return escritorToReturn;
    }

    @DeleteMapping("/delete/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<Object> deleteEscritor(@PathVariable int id) {

        try {
            escritorService.deleteEscritor(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Escritor excluido");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEscritor(@PathVariable int id, @RequestBody EscritorRequest escritorRequest) {
=======
    public boolean addEscritor(@PathVariable int id) {
=======
    public boolean deleteEscritor(@PathVariable int id) {
>>>>>>> b786377 (correção em nome de método)
=======
    public ResponseEntity<Object> deleteEscritor(@PathVariable int id) {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)

        try {
            escritorService.deleteEscritor(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Escritor excluido");
    }

    @PutMapping("/update/{id}")
<<<<<<< HEAD
    public Escritor updateEscritor(@PathVariable int id, @RequestBody EscritorRequest escritorRequest) {
>>>>>>> f2e5813 (crud de escritor e personagem)
=======
    public ResponseEntity<Object> updateEscritor(@PathVariable int id, @RequestBody EscritorRequest escritorRequest) {
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
        Escritor escritor = new Escritor();

        BeanUtils.copyProperties(escritorRequest, escritor);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
        Escritor escritorToReturn = null;
        try {
            escritorToReturn = escritorService.updateEscritor(id, escritor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
<<<<<<< HEAD

        return new ResponseEntity<>(escritorToReturn, HttpStatus.OK);
=======
        Escritor escritorToReturn = escritorService.updateEscritor(id, escritor);

        return escritorToReturn;
>>>>>>> f2e5813 (crud de escritor e personagem)
=======

        return new ResponseEntity<>(escritorToReturn, HttpStatus.OK);
>>>>>>> 0e6e52f (tratamento de exceções apropriado)
    }
}
