package com.grupo2.editoragibi.edicoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/gibi/edicoesGibi")
public class EdicoesGibiController {
    
    private final EdicoesGibiService edicoesGibiService;

    @Autowired
    public EdicoesGibiController(EdicoesGibiService edicoesGibiService) {
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
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPub){
        edicoesGibiService.updateEdicoesGibi(edicoesGibiId, nroEdicao, dataPub);

    }
}
