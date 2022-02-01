package com.editoragibi.editoragibi.gibi;


import com.editoragibi.editoragibi.edicoes.EdicoesGibi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/gibi")
public class GibiController {

    private final GibiService gibiService;

    @Autowired
    public GibiController(GibiService gibiService) {
        this.gibiService = gibiService;
    }

    @GetMapping
    public List<Gibi> getGibis(){
       return gibiService.getGibis();
    }

    @PostMapping
    public void addGibi(@RequestBody Gibi gibi){
        gibiService.addGibi(gibi);
    }

    @PostMapping(path = "atr/{gibiId}&{edicaoId}")
    public void addEdicaoGibi(@PathVariable("gibiId") Long gibiId,@PathVariable("edicaoId") Long edicaoGibiId){
        gibiService.addEdicaoGibi(gibiId, edicaoGibiId);
    }

    @DeleteMapping(path = "{gibiId}")
    public void deleteGibi(@PathVariable("gibiId") Long gibiId){
        gibiService.deleteGibi(gibiId);
    }

    @PutMapping(path = "{gibiId}")
    public void updateGibi(@PathVariable("gibiId") Long gibiId,
                           @RequestParam(required = false) String titulo,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enc,
                           @RequestParam(required = false) EdicoesGibi edicoes){
        gibiService.updateGibi(gibiId, titulo, inicio, enc, edicoes);
    }


}
