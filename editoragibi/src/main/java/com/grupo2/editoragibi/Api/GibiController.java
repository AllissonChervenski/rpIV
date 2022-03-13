package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Data.Entity.GibiEntity;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.GibiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/gibis")
public class GibiController {

    private final GibiService gibiService;

    @Autowired
    public GibiController(GibiService gibiService) {
        this.gibiService = gibiService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getGibis(){
        List<Gibi> gibis = null;
        try {
            gibis = gibiService.getGibis();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibis, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addGibi(@RequestBody GibiEntity gibi){
        Gibi gibiToReturn = null;
        try {
            gibiToReturn = gibiService.addGibi(gibi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibiToReturn, HttpStatus.OK);
    }

    @PostMapping(path = "atr/{gibiId}&{edicaoId}")
    public void addEdicaoGibi(@PathVariable("gibiId") Long gibiId,@PathVariable("edicaoId") Long edicaoGibiId){
        //gibiService.addEdicaoGibi(gibiId, edicaoGibiId);
    }

    @DeleteMapping(path = "/delete/{gibiId}")
    public ResponseEntity<Object> deleteGibi(@PathVariable("gibiId") int gibiId) {
        try {
            gibiService.deleteGibi(gibiId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O gibi não pode ser deletado");
        }
        return new ResponseEntity<>("Gibi deletado com sucesso!", HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateGibi(@PathVariable("gibiId") int id, @RequestBody GibiEntity gibi){
        Gibi gibiToReturn = null;
        try {
            gibiToReturn = gibiService.updateGibi(id, gibi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibiToReturn, HttpStatus.OK);
    }


}
