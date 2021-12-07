package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscritorService {

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    public Escritor getEscritorById(int id) {

        Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

        if (escritor.isEmpty())
            return null;

        return escritor.get();
    }

    public List<Escritor> getEscritores() {

        return escritorRepository.getEscritores();
    }

    public Escritor addEscritor(Escritor escritor) {

        return escritorRepository.addEscritor(escritor);
    }

    public boolean deleteEscritor(int id) {

        escritorRepository.deleteEscritor(id);

        return true;
    }

    public Escritor updateEscritor(int id, Escritor escritor) {

        return escritorRepository.updateEscritor(id, escritor);
    }
}
