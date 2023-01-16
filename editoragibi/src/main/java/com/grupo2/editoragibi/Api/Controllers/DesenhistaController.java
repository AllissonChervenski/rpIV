package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.DesenhistaRequest;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.ServiceObjects.DesenhistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/desenhistas/")
public class DesenhistaController {

    @Autowired
    DesenhistaService desenhistaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDesenhistaById(@PathVariable int id) {

        Desenhista desenhista = null;
        try {
            desenhista = desenhistaService.getDesenhistaById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(desenhista, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getDesenhistas() {

        List<Desenhista> desenhistas = null;
        try {
            desenhistas = desenhistaService.getDesenhistas();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(desenhistas, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addDesenhista(@RequestBody DesenhistaRequest desenhistaRequest) {

        Desenhista desenhista = null;
        try {
            desenhista = desenhistaService.addDesenhista(desenhistaRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(desenhista, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin( origins = "http://localhost:3000")
    public ResponseEntity<Object> deleteDesenhista(@PathVariable Integer id) {
        try {
            desenhistaService.deleteDesenhista(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Desenhista excluido");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDesenhista(@PathVariable int id, @RequestBody DesenhistaRequest desenhistaRequest){
        Desenhista desenhista = null;
        try {
            desenhista = desenhistaService.updateDesenhista(id, desenhistaRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(desenhista, HttpStatus.OK);
    }
}
