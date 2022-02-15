package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
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

    public Escritor getEscritorById(int id) throws EscritorInvalidoException {

        Optional<Escritor> escritor = escritorRepository.getEscritorById(id);

        return escritor.get();
    }

    public List<Escritor> getEscritores() {

        return escritorRepository.getEscritores();
    }

    public Escritor addEscritor(Escritor escritor) {

        return escritorRepository.addEscritor(escritor);
    }

    public void deleteEscritor(int id) throws EscritorInvalidoException {

        if (!escritorRepository.deleteEscritor(id))
            throw new EscritorInvalidoException("Escritor não está no sistema");
    }

    public Escritor updateEscritor(int id, Escritor escritor) throws EscritorInvalidoException {

        return escritorRepository.updateEscritor(id, escritor);
    }
}
