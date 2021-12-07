package com.grupo2.editoragibi.Api;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.EscritorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escritores")
public class EscritorController {

    @Autowired
    EscritorService escritorService;

    @GetMapping("/{id}")
    public Escritor getEscritorById(@PathVariable int id) {

        return escritorService.getEscritorById(id);
    }

    @GetMapping("/all")
    public List<Escritor> getEscritores() {

        return escritorService.getEscritores();
    }

    @PostMapping("/create")
    public Escritor addEscritor(@RequestBody EscritorRequest escritorRequest) {

        Escritor escritor = new Escritor();

        BeanUtils.copyProperties(escritorRequest, escritor);

        Escritor escritorToReturn = escritorService.addEscritor(escritor);

        return escritorToReturn;
    }

    @DeleteMapping("/delete/{id}")
    public boolean addEscritor(@PathVariable int id) {

        return escritorService.deleteEscritor(id);
    }

    @PutMapping("/update/{id}")
    public Escritor updateEscritor(@PathVariable int id, @RequestBody EscritorRequest escritorRequest) {
        Escritor escritor = new Escritor();

        BeanUtils.copyProperties(escritorRequest, escritor);

        Escritor escritorToReturn = escritorService.updateEscritor(id, escritor);

        return escritorToReturn;
    }
}
