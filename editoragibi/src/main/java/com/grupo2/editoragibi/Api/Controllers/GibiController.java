package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.Exceptions.*;
import com.grupo2.editoragibi.Service.ServiceObjects.GibiService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge= 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

@RestController
@RequestMapping(path="/gibis")
public class GibiController {

    private final GibiService gibiService;

    @Autowired
    public GibiController(GibiService gibiService) {
        this.gibiService = gibiService;
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGibiById(@PathVariable int id) {

        GibiEntity gibi = null;
        try {
            gibi = gibiService.getGibiById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(gibi);
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getGibis() {
        List<GibiEntity> gibi = null;

        try {
        gibi = gibiService.getGibis();
        } catch (PersonagemInvalidoException | DesenhistaInvalidoException | EscritorInvalidoException |
                 EdicoesGibiInvalidoException | HistoriaInvalidaException | GibiInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> addGibi(@RequestBody GibiRequest gibiRequest){
        GibiEntity gibi = null;
        try{
            gibi = gibiService.addGibi(gibiRequest);
        } catch (GibiInvalidoException | PersonagemInvalidoException | DesenhistaInvalidoException | EscritorInvalidoException | EdicoesGibiInvalidoException | HistoriaInvalidaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    @PostMapping(path = "{gibiId}&{edicaoId}")
    public void addEdicaoGibi(@PathVariable("gibiId") Integer gibiId,@PathVariable("edicaoId") Integer edicaoGibiId){
        try {
            gibiService.addEdicaoGibi(gibiId, edicaoGibiId);
        } catch (GibiInvalidoException | EdicoesGibiInvalidoException | PersonagemInvalidoException
                | DesenhistaInvalidoException | EscritorInvalidoException | HistoriaInvalidaException e) {
            
            e.getCause();
        }
    }

    @DeleteMapping(path = "deleteGibi/{gibiId}")
    public ResponseEntity<Object> deleteGibi(@PathVariable("gibiId") Integer gibiId){

        try{
            gibiService.deleteGibi(gibiId);
        }catch(GibiInvalidoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(path = "editar/{gibiId}")
    public ResponseEntity<Object> updateGibi(@PathVariable("gibiId") Integer gibiId,
                           @RequestParam(required = false) String titulo,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enc,
                           @RequestParam(required = false) EdicoesGibiEntity edicoes){
        try {
           gibiService.updateGibi(gibiId, titulo, inicio, enc, edicoes);
        } catch (IllegalStateException | GibiInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}

 