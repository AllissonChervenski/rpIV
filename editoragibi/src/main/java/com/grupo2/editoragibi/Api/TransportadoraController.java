package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.TransportadoraRequest;
import com.grupo2.editoragibi.Service.Domain.Transportadora;
import com.grupo2.editoragibi.Service.TransportadoraService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {

    @Autowired
    TransportadoraService transportadoraService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTransportadoraById(@PathVariable int id) {
        Transportadora transportadora = null;
        try {
            transportadora = transportadoraService.getTransportadoraById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(transportadora, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getTransportadoras() {
        List<Transportadora> transportadoras = null;
        try {
            transportadoras = transportadoraService.getTransportadoras();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(transportadoras, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addTrasportadora(@RequestBody TransportadoraRequest transportadoraRequest) {
        Transportadora transportadora = null;
        try {
            transportadora = transportadoraService.addTransportadora(transportadoraRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(transportadora, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTransportadora(@PathVariable int id) {
        try {
            transportadoraService.deleteTransportadora(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
        return new ResponseEntity("Transportadora deletada", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTransportadora(@PathVariable int id, @RequestBody TransportadoraRequest transportadoraRequest) {
        Transportadora transportadora = null;
        try {
            transportadora = transportadoraService.updateTransportadora(id, transportadoraRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(transportadora, HttpStatus.OK);
    }
}
