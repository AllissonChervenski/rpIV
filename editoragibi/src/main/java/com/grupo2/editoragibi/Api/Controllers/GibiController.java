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

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/gibis/")
public class GibiController {

    private final GibiService gibiService;

    @Autowired
    public GibiController(GibiService gibiService) {
        this.gibiService = gibiService;
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getGibis() throws GibiInvalidoException{
        List<GibiEntity> gibi = null;

        try {
            gibi = gibiService.getGibis();
        } catch (PersonagemInvalidoException | DesenhistaInvalidoException | EscritorInvalidoException |
                 EdicoesGibiInvalidoException | HistoriaInvalidaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> addGibi(@RequestBody GibiRequest gibiRequest){
        Gibi gibi = null;
        try{
            gibi = gibiService.addGibi(gibiRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    /*@PostMapping(path = "{gibiId}&{edicaoId}")
    public void addEdicaoGibi(@PathVariable("gibiId") Long gibiId,@PathVariable("edicaoId") Long edicaoGibiId){
        gibiService.addEdicaoGibi(gibiId, edicaoGibiId);
    }
    */

    @DeleteMapping(path = "deleteGibi/{gibiId}")
    @CrossOrigin( origins = "http://localhost:3000")
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