package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.HistoriaRequest;
import com.grupo2.editoragibi.Service.Domain.Historia;
import com.grupo2.editoragibi.Service.HistoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias/")
public class HistoriaController {

    @Autowired
    HistoriaService historiaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHistoriaById(@PathVariable int id) {

        Historia historia = null;
        try {
            historia = historiaService.getHistoriaById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(historia, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Historia> getHistorias() {

        return historiaService.getHsitorias();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addHistoria(@RequestBody HistoriaRequest historiaRequest) {

        Historia historia = new Historia();

        BeanUtils.copyProperties(historiaRequest, historia);

        Historia historiaToReturn = null;
        try {
            historiaToReturn = historiaService.addHistoria(historia,
                    historiaRequest.getArtefinalizadorId(),
                    historiaRequest.getDesenhistaId(),
                    historiaRequest.getEscritorId(),
                    historiaRequest.getPersonagensIds());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(historiaToReturn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteHistoria(@PathVariable int id) {

        try {
            historiaService.deleteHistoria(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Escritor excluido");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateHistoria(@PathVariable int id, @RequestBody HistoriaRequest historiaRequest) {

        Historia historia = new Historia();

        BeanUtils.copyProperties(historiaRequest, historia);

        Historia historiaToReturn = null;
        try {
            historiaToReturn = historiaService.updateHistoria(id, historia,
                    historiaRequest.getArtefinalizadorId(),
                    historiaRequest.getDesenhistaId(),
                    historiaRequest.getEscritorId(),
                    historiaRequest.getPersonagensIds());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(historiaToReturn, HttpStatus.OK);
    }
}
