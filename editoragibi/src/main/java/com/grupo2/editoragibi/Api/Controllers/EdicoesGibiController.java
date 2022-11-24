package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.ServiceObjects.EdicoesGibiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gibis/edicoesgibi")
public class EdicoesGibiController {
    
    private final EdicoesGibiService edicoesGibiService;


    @Autowired
    public EdicoesGibiController(EdicoesGibiService edicoesGibiService) {
        this.edicoesGibiService = edicoesGibiService;
    }
     
    @GetMapping("/all")
    public ResponseEntity<Object> getEdicoesGibi(){
        List<EdicoesGibi> edicoesGibis = null;

        try {
        edicoesGibis = edicoesGibiService.getEdicoesGibis();
        } catch (EdicoesGibiInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
        return new ResponseEntity<>(edicoesGibis, HttpStatus.OK);
    }
    

    @GetMapping(path = "edicao/{edicoesGibiEdicao}")
    public ResponseEntity<Object> getEdicoesGibiByEdicao(@PathVariable("edicoesGibiEdicao") Integer edicao){
    EdicoesGibi edicoesGibis = null;
    
        try{
            edicoesGibis = edicoesGibiService.getEdicoesGibiByEdicao(edicao);
        }
        catch(EdicoesGibiInvalidoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(edicoesGibis, HttpStatus.OK);

    }
/* 
    //TODO
    @PostMapping
    public void addEdicoesGibi(@RequestBody EdicoesGibiEntity edicoesGibi){
        edicoesGibiService.addEdicoesGibi(edicoesGibi);//TODO
    
    }
     @DeleteMapping(path = "deleteEdicao/{edicoesGibiId}")
    public void deleteEdicoesGibi(@PathVariable("edicoesGibiId") Integer edicoesGibiId){
        edicoesGibiService.deleteEdicoesGibi(edicoesGibiId);
    }

    @PutMapping(path = "editar/{edicoesGibiId}")
    public void updateEdicoesGibi(@PathVariable Integer edicoesGibiId,
                                  @RequestParam(required = false) Integer nroEdicao,
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPub,
                                  @RequestParam(required = false)HistoriaEntity historiaEntity){
        edicoesGibiService.updateEdicoesGibi(edicoesGibiId, nroEdicao, dataPub, historiaEntity);

    }

    @PostMapping(path = "addGibiHistoria/{historiaId}&{edicaoGibiId}")
    public void addHistoriaEdicao(@PathVariable("historiaId") Integer historiaId,
                                  @PathVariable("edicaoGibiId") Integer edicaoGibiId){
        edicoesGibiService.addHistoriaEdicao(historiaId, edicaoGibiId);
    }

    @DeleteMapping(path = "deleteGibiHistoria/{edicaoGibiId}")
    public void deleteHistoriaEdicao(@PathVariable("edicaoGibiId") Integer edicaoGibiId){
        edicoesGibiService.deleteHistoriaEdicao(edicaoGibiId);
    }
*/
}
