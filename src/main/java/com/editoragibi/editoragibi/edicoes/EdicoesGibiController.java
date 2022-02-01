package com.editoragibi.editoragibi.edicoes;

import com.editoragibi.editoragibi.gibi.Gibi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "edicao/atr/{edicoesGibiEdicao}")
    public void addGibiEdicoesGibi(@RequestBody Gibi gibi, @PathVariable("edicoesGibiEdicao") Long edicaoId){
        edicoesGibiService.addGibiEdicoesGibi(gibi, edicaoId);
    }
}
