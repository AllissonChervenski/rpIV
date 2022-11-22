package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.EdicoesGibiRequest;
import com.grupo2.editoragibi.Data.Entity.EdicoesGibiEntity;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEdicoesGibi;
import com.grupo2.editoragibi.Service.Domain.EdicoesGibi;
import com.grupo2.editoragibi.Service.Exceptions.DesenhistaInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EdicoesGibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.GibiInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.HistoriaInvalidaException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import com.grupo2.editoragibi.Service.ServiceObjects.EdicoesGibiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gibis/edicoesgibi")
public class EdicoesGibiController {
    
    @Autowired
    EdicoesGibiService edicoesGibiService;
     
    @GetMapping("/all")
    public ResponseEntity<Object> getEdicoesGibi() throws DesenhistaInvalidoException{
        List<EdicoesGibi> edicoesGibis = null;

        try {
        edicoesGibis = edicoesGibiService.getEdicoesGibis();
        } catch (EdicoesGibiInvalidoException | GibiInvalidoException | HistoriaInvalidaException | PersonagemInvalidoException | EscritorInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        
        return new ResponseEntity<>(edicoesGibis, HttpStatus.OK);
    }
    

    @GetMapping(path = "edicao/{edicoesGibiEdicao}")
    public ResponseEntity<Object> getEdicoesGibiByEdicao(@PathVariable("edicoesGibiEdicao") Integer edicao) throws DesenhistaInvalidoException{
    EdicoesGibi edicoesGibis = null;
    
        try{
            edicoesGibis = edicoesGibiService.getEdicoesGibiByEdicao(edicao);
        }
        catch(EdicoesGibiInvalidoException | GibiInvalidoException | HistoriaInvalidaException | PersonagemInvalidoException | EscritorInvalidoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(edicoesGibis, HttpStatus.OK);

    }
 
    @PostMapping(path = "/create")
    public ResponseEntity<Object> addEdicoesGibi(@RequestBody EdicoesGibiRequest edicoesGibirGibiRequest) throws DesenhistaInvalidoException{
        EdicoesGibi edicoesGibi = null;
        try {
           edicoesGibi = edicoesGibiService.addEdicoesGibi(edicoesGibirGibiRequest);
        } catch (EdicoesGibiInvalidoException | GibiInvalidoException | PersonagemInvalidoException | EscritorInvalidoException | HistoriaInvalidaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } 
        return new ResponseEntity<>(edicoesGibi, HttpStatus.OK);
    }
    
     @DeleteMapping(path = "deleteEdicao/{edicoesGibiId}")
    public ResponseEntity<Object> deleteEdicoesGibi(@PathVariable("edicoesGibiId") Integer edicoesGibiId){
   
        try {
            edicoesGibiService.deleteEdicoesGibi(edicoesGibiId);
        } catch (EdicoesGibiInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(path = "editar/{edicoesGibiId}")
    public ResponseEntity<Object> updateEdicoesGibi(@PathVariable Integer edicoesGibiId,
                                  @RequestParam(required = false) Integer nroEdicao,
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPub,
                                  @RequestParam(required = false)HistoriaEntity historiaEntity) throws HistoriaInvalidaException, DesenhistaInvalidoException{
        EdicoesGibi edicoesGibi = null;
        try {
            edicoesGibi = edicoesGibiService.updateEdicoesGibi(edicoesGibiId, nroEdicao, dataPub, nroEdicao, false, historiaEntity, null, null, null, null);
        } catch (EdicoesGibiInvalidoException | GibiInvalidoException | PersonagemInvalidoException | EscritorInvalidoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(edicoesGibi, HttpStatus.OK);
    }
/* 
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
