package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Api.Requests.EscritorRequest;
import com.grupo2.editoragibi.Data.EscritorRepository;
import com.grupo2.editoragibi.Data.PersonagemRepository;
import com.grupo2.editoragibi.Service.BaseObjects.BaseEscritor;
import com.grupo2.editoragibi.Service.Builders.EscritorBuilder;
import com.grupo2.editoragibi.Service.Builders.IBaseEscritorBuilder;
import com.grupo2.editoragibi.Service.Directors.Director;
import com.grupo2.editoragibi.Service.Domain.Escritor;
import com.grupo2.editoragibi.Service.Domain.Personagem;
import com.grupo2.editoragibi.Service.Exceptions.EscritorInvalidoException;
import com.grupo2.editoragibi.Service.Exceptions.PersonagemInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscritorService {

    private IBaseEscritorBuilder builder = new EscritorBuilder();
    private Director director = new Director(builder);

    @Autowired
    EscritorRepository escritorRepository;

    @Autowired
    PersonagemRepository personagemRepository;

    public Escritor getEscritorById(int id) throws EscritorInvalidoException, PersonagemInvalidoException {

        return escritorRepository.getEscritorById(id);
    }

    public List<Escritor> getEscritores() throws PersonagemInvalidoException, EscritorInvalidoException {

        return escritorRepository.getEscritores();
    }

    public Escritor addEscritor(EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        Escritor escritor = (Escritor) director.buildFromEscritorRequest(escritorRequest);
        return escritorRepository.addEscritor(escritor);
    }

    public void deleteEscritor(int id) throws EscritorInvalidoException {

        if (!escritorRepository.deleteEscritor(id))
            throw new EscritorInvalidoException("Escritor não está no sistema");
    }

    public Escritor updateEscritor(int id, EscritorRequest escritorRequest) throws EscritorInvalidoException, PersonagemInvalidoException {

        Escritor escritor = (Escritor) director.buildFromEscritorRequest(escritorRequest);
        return escritorRepository.updateEscritor(id, escritor);
    }
}
