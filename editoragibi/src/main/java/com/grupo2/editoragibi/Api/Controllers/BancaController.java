package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.BancaRequest;
import com.grupo2.editoragibi.Service.Domain.Banca;
import com.grupo2.editoragibi.Service.ServiceObjects.BancaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bancas")
public class BancaController {

    @Autowired
    BancaService bancaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBancaById(@PathVariable int id) {
        Banca banca = null;
        try {
            banca = bancaService.getBancaById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(banca, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getBancas() {
        List<Banca> bancas = null;
        try {
            bancas = bancaService.getBancas();
        } catch (Exception e) {
            //TODO
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(bancas, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addBancas(@RequestBody BancaRequest bancaRequest) {
        Banca banca = null;
        try {
            banca = bancaService.addBanca(bancaRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(banca, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBanca(@PathVariable int id) {
        try {
            bancaService.deleteBanca(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Banca excluída");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBanca(@PathVariable int id, @RequestBody BancaRequest bancaRequest) {
        Banca banca = null;
        try {
            banca = bancaService.updateBanca(id, bancaRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(banca, HttpStatus.OK);
    }
}
