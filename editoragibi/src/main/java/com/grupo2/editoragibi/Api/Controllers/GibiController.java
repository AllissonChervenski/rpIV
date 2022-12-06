package com.grupo2.editoragibi.Api.Controllers;

import com.grupo2.editoragibi.Api.Requests.GibiRequest;
import com.grupo2.editoragibi.Service.Domain.Desenhista;
import com.grupo2.editoragibi.Service.Domain.Gibi;
import com.grupo2.editoragibi.Service.ServiceObjects.GibiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path="/gibis")
public class GibiController {

    private final GibiService gibiService;

    @Autowired
    public GibiController(GibiService gibiService) {
        this.gibiService = gibiService;
    }
//
//    @GetMapping(path="view")
//    public List<GibiEntity> getGibis(){
//       return gibiService.getGibis();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGibiById(@PathVariable int id) {

        Gibi gibi = null;
        try {
            gibi = gibiService.getGibiById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getGibis() {

        List<Gibi> gibis = null;
        try {
            gibis = gibiService.getGibis();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return new ResponseEntity<>(gibis, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> addGibi(@RequestBody GibiRequest gibiRequest) {

        Gibi gibi = null;
        try {
            gibi = gibiService.addGibi(gibiRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin( origins = "http://localhost:3000")
    public ResponseEntity<Object> deleteGibi(@PathVariable Integer id) {
        try {
            gibiService.deleteGibi(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Gibi excluido");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateGibi(@PathVariable int id, @RequestBody GibiRequest gibiRequest){
        Gibi gibi = null;
        try {
            gibi = gibiService.updateGibi(id, gibiRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return new ResponseEntity<>(gibi, HttpStatus.OK);
    }

}
