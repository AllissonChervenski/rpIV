package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Data.Entity.EdicoesGibi;
import com.grupo2.editoragibi.Data.Entity.HistoriaEntity;
import com.grupo2.editoragibi.Service.EdicoesGibiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/gibi/edicoesGibi")
public class EdicoesController {
    
    private final EdicoesGibiService edicoesGibiService;

    @Autowired
    public EdicoesController(EdicoesGibiService edicoesGibiService) {
        this.edicoesGibiService = edicoesGibiService;
    }
    
    @GetMapping
    public List<EdicoesGibi> getEdicoesGibi(){
        return  edicoesGibiService.getEdicoesGibis();
    }

    @GetMapping(path = "edicao/{edicoesGibiEdicao}")
    public List<EdicoesGibi> getEdicoesGibiByEdicao(@PathVariable("edicoesGibiEdicao") Integer edicao){
        return edicoesGibiService.getEdicoesGibiByEdicao(edicao);
    }

    @PostMapping
    public void addEdicoesGibi(@RequestBody EdicoesGibi edicoesGibi){
        edicoesGibiService.addEdicoesGibi(edicoesGibi);
    }

    @DeleteMapping(path = "deleteEdicao/{edicoesGibiId}")
    public void deleteEdicoesGibi(@PathVariable("edicoesGibiId") Long edicoesGibiId){
        edicoesGibiService.deleteEdicoesGibi(edicoesGibiId);
    }

    @PutMapping(path = "editar/{edicoesGibiId}")
    public void updateEdicoesGibi(@PathVariable Long edicoesGibiId,
                                  @RequestParam(required = false) Integer nroEdicao,
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPub,
                                  @RequestParam(required = false)HistoriaEntity historiaEntity){
        edicoesGibiService.updateEdicoesGibi(edicoesGibiId, nroEdicao, dataPub, historiaEntity);

    }

    @PostMapping(path = "addGibiHistoria/{historiaId}&{edicaoGibiId}")
    public void addHistoriaEdicao(@PathVariable("historiaId") Integer historiaId,
                                  @PathVariable("edicaoGibiId") Long edicaoGibiId){
        edicoesGibiService.addHistoriaEdicao(historiaId, edicaoGibiId);
    }

    @DeleteMapping(path = "deleteGibiHistoria/{edicaoGibiId}")
    public void deleteHistoriaEdicao(@PathVariable("edicaoGibiId") Long edicaoGibiId){
        edicoesGibiService.deleteHistoriaEdicao(edicaoGibiId);
    }
}
