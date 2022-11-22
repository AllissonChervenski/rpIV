package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.ServiceObjects.EscritorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escritores")
public class EscritorController {

    @Autowired
    EscritorService escritorService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEscritorById(@PathVariable int id) {

        Escritor escritor = null;

        try {
            escritor = escritorService.getEscritorById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritor, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getEscritores() {

        List<Escritor> escritores = null;

        try {
            escritores = escritorService.getEscritores();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritores, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addEscritor(@RequestBody EscritorRequest escritorRequest) {

        Escritor escritorToReturn = null;
        try {
             escritorToReturn = escritorService.addEscritor(escritorRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(escritorToReturn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
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

        Escritor escritorToReturn;
        try {
            escritorToReturn = escritorService.updateEscritor(id, escritorRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritorToReturn, HttpStatus.OK);
    }
}
