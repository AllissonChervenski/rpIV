package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Service.GibiService;
import com.grupo2.editoragibi.Service.Domain.Gibi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GibiController {
    
    @Autowired
    GibiService gibiService;

    @PostMapping("/gibi/{id}")
    public Gibi getGibiById(@PathVariable int id) {

        return gibiService.getGibiById(id);
    }

    @PostMapping("/gibi/create")
    public  Gibi addGibi(@RequestBody Gibi gibi) {

        return gibiService.addGibi(gibi);
    }

    @DeleteMapping("/gibi/delete/{id}")
    public boolean deleteGibi(@PathVariable Integer id) {

        return gibiService.deleteGibi(id);
    }

    @PutMapping("/gibi/update/{id}")
    public void updateGibi(@PathVariable int id, @RequestBody Gibi gibi){
        gibiService.updateGibi(id, gibi);
    }
}
