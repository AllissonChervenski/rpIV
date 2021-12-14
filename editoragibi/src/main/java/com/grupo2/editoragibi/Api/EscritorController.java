package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.EscritorService;
import org.springframework.beans.BeanUtils;
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
        Escritor escritor = new Escritor();

        BeanUtils.copyProperties(escritorRequest, escritor);

        Escritor escritorToReturn = null;
        try {
            escritorToReturn = escritorService.updateEscritor(id, escritor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(escritorToReturn, HttpStatus.OK);
    }
}